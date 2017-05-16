AUI().add(
	'music',
	function(A) {
		var Music = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'music',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var button = instance.byId('search');

						if (button) {
							button.on('click', A.bind('_getMusic', instance));

							instance._button = button;
						}

						var input = instance.byId('music-input');

						if (input) {
							input.on('key', A.bind('_getMusic', instance), 'enter');

							instance._input = input;
						}
					},

					_getMusic: function(event) {
						var instance = this;

						var button = instance._button;

						var input = instance._input;

						var music = input.val();

						var resourceURL = button.attr('data-resourceURL');

						var front_page_content = A.one('.front-page-content-show');

						front_page_content.addClass('front-page-content-hide');

						var search_result = A.one('.search-result-hide');

						search_result.addClass('search-result-show');

						var search_result_artist = A.one('.search-result-artist');

						var search_result_title = A.one('.search-result-title');

						if (music && resourceURL) {
							A.io.request(
								resourceURL,
								{
									data: instance.ns(
										{
										music: music
										}
									),
									dataType: 'json',
									method: 'post',
									on: {
										success: function() {
											var object = this.get('responseData');

											var count = Object.keys(object).length;

											if (count > 1) {
												search_result_title.html(object._name);

												search_result_artist.removeClass('search-result-hide');

												search_result_artist.html('');

												for (var i = 0; i < object._albums.length; i++) {

													var album_picture = '<img src=' + '/music-portlet' + object._albums[i]._image + ' />';

													var album_text = '<p><br>Album: ' + object._albums[i]._name + '<br>';

													album_text += 'Year: ' + object._albums[i]._year + '<br>';

													for (var j = 0; j < object._albums[i]._songs.length; j++) {
														album_text += 'Song: ' + object._albums[i]._songs[j]._name + '<br>';
													}

													album_text += '</p>';

													search_result_artist.append(album_picture);

													search_result_artist.append(album_text);
												}
											}

											else {
												search_result_title.html(object.not_found);

												search_result_artist.addClass('search-result-hide');
											}
										}
									}
								}
							);
						}

						input.val('');
					}
				}
			}
		);

		Liferay.Portlet.Music = Music;
	},

	'',
	{
		requires: ['aui-base', 'aui-event', 'aui-io-request', 'aui-node', 'event-key', 'liferay-portlet-base']
	}
);
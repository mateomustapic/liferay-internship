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

						var frontPageContent = A.one('.front-page-content-show');

						frontPageContent.addClass('front-page-content-hide');

						var searchResult = A.one('.search-result-hide');

						searchResult.addClass('search-result-show');

						var searchResultArtist = A.one('.search-result-artist');

						var searchResultTitle = A.one('.search-result-title');

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
												searchResultTitle.html(object._name);

												searchResultArtist.removeClass('search-result-hide');

												searchResultArtist.empty();

												for (var i = 0; i < object._albums.length; i++) {
													var albumPicture = '<img src=' + '/music-portlet' + object._albums[i]._image + ' />';

													var albumText = '<p><br>Album: ' + object._albums[i]._name + '<br>';

													albumText += 'Year: ' + object._albums[i]._year + '<br>';

													for (var j = 0; j < object._albums[i]._songs.length; j++) {
														albumText += 'Song: ' + object._albums[i]._songs[j]._name + '<br>';
													}

													albumText += '</p>';

													searchResultArtist.append(albumPicture);

													searchResultArtist.append(albumText);
												}
											}
											else {
												searchResultTitle.html(object.not_found);

												searchResultArtist.addClass('search-result-hide');
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
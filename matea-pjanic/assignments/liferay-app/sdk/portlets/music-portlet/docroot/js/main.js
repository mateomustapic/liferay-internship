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

						var searchButton = instance.byId('search');

						if (searchButton) {
							searchButton.on('click', A.bind('_getMusic', instance));

							instance._searchButton = searchButton;
						}

						var searchInput = instance.byId('music-input');

						if (searchInput) {
							searchInput.on('key', A.bind('_getMusic', instance), 'enter');

							instance._searchInput = searchInput;
						}
					},

					_getMusic: function(event) {
						var instance = this;

						var searchButton = instance._searchButton;
						var searchInput = instance._searchInput;

						var music = searchInput.val();

						var resourceURL = searchButton.attr('data-resourceURL');

						var frontPageContentContainer = A.one('.front-page-content-show');

						if (frontPageContentContainer) {
							frontPageContentContainer.addClass('front-page-content-hide');
						}

						var searchResultContainer = A.one('.search-result-hide');

						if (searchResultContainer) {
							searchResultContainer.addClass('search-result-show');
						}

						var searchResultArtistContainer = A.one('.search-result-artist');
						var searchResultTitleContainer = A.one('.search-result-title');

						if (music && resourceURL && searchResultArtistContainer && searchResultTitleContainer) {
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
												searchResultTitleContainer.html(object._name);

												searchResultArtistContainer.removeClass('search-result-hide');

												searchResultArtistContainer.empty();

												for (var i = 0; i < object._albums.length; i++) {
													var albumPicture = '<img src=' + '/music-portlet' + object._albums[i]._image + ' />';

													var albumText = '<p><br>Album: ' + object._albums[i]._name + '<br>';

													albumText += 'Year: ' + object._albums[i]._year + '<br>';

													for (var j = 0; j < object._albums[i]._songs.length; j++) {
														albumText += 'Song: ' + object._albums[i]._songs[j]._name + '<br>';
													}

													albumText += '</p>';

													searchResultArtistContainer.append(albumPicture);

													searchResultArtistContainer.append(albumText);
												}
											}
											else {
												searchResultTitleContainer.html(object.not_found);

												searchResultArtistContainer.addClass('search-result-hide');
											}
										}
									}
								}
							);
						}

						searchInput.val('');
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
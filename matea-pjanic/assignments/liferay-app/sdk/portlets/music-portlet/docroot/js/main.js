AUI().add(
	'music',
	function(A) {
		var Lang = A.Lang;

		var STR_BLANK = '';

		var TPL_ALBUM = '<img class="search-result-picture" src="/music-portlet{picture}" />' +
			'<div class="search-result-album-name">{album}</div>';

		var TPL_ARTIST = '<div class="search-result-artist-name">{name}</div>';

		var TPL_SONG = '<div class="search-result-song">{song}</div>';

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

						var homePageContentContainer = instance.byId('home-page-content');

						if (homePageContentContainer) {
							homePageContentContainer.hide();
						}

						var homeSearchResultContainer = instance.byId('home-search-result');

						if (homeSearchResultContainer) {
							homeSearchResultContainer.show();
						}

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
												var html = [];

												var artistHtml = Lang.sub(
													TPL_ARTIST,
													{
														name: object.name
													}
												);

												html.push(artistHtml);

												var albums = [];

												for (var i = 0; i < object.albums.length; i++) {
													var albumHtml = Lang.sub(
														TPL_ALBUM,
														{
															album: object.albums[i].name,
															picture: object.albums[i].image
														}
													);

													albums.push(albumHtml);

													var songs = [];

													for (var j = 0; j < object.albums[i].songs.length; j++) {
														var songHtml = Lang.sub(
															TPL_SONG,
															{
																song: object.albums[i].songs[j].name
															}
														);

														songs.push(songHtml);

													}

													albums.push(songs.join(STR_BLANK));
												}

												html.push(albums.join(STR_BLANK));

												homeSearchResultContainer.html(html);

											}
											else {
												homeSearchResultContainer.html(object.not_found);
											}
										}
									}
								}
							);
						}

						searchInput.val(STR_BLANK);
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
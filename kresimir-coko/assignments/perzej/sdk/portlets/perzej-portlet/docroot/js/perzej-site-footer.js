/* global google */

AUI.add(
	'perzej-site-footer',
	function(A) {
		var PerzejSiteFooter = A.Component.create(
				{
					AUGMENTS: [Liferay.PortletBase],

					EXTENDS: A.Base,

					NAME: 'perzej-site-footer',

					prototype: {
						initializer: function(config) {
							var instance = this;
							var latitude;
							var longitude;
							var markers = [];
							var shortAddress;

							instance._headquartersAddressShort = config.headquartersAddressShort;
							instance._headquartersLat = config.headquartersLat;
							instance._headquartersLng = config.headquartersLng;

							instance._officeAddressShort = config.officeAddressShort;
							instance._officeLat = config.officeLat;
							instance._officeLng = config.officeLng;

							instance._officeLink = A.one('.footer-info .office');
							instance._headquartersLink = A.one('.footer-info .headquarters');

							var GoogleMaps = new Liferay.Portlet.GoogleMaps(
								{
									googleMapsURL: config.googleMapsURL,
									languageId: config.languageId,
									mapAddress: config.mapAddress,
									namespace: config.namespace,
									portletId: config.portletId
								}
							).render();

							GoogleMaps.set('mapParams.zoom', 14);

							function _changeAddress() {
								var googleMaps = google.maps;

								var map = GoogleMaps._map;

								if (this.hasClass('headquarters')) {
									latitude = instance._headquartersLat;
									longitude = instance._headquartersLng;
									shortAddress = instance._headquartersAddressShort;
								}
								else {
									latitude = instance._officeLat;
									longitude = instance._officeLng;
									shortAddress = instance._officeAddressShort;
								}

								GoogleMaps._infoWindow = new googleMaps.InfoWindow();

								var infoWindow = GoogleMaps._infoWindow;

								if (!infoWindow) {
									infoWindow = new googleMaps.InfoWindow(
										{
											content: shortAddress
										}
									);
								}
								else {
									infoWindow.setContent(shortAddress);
								}

								for (var i = 0; i < markers.length; i++) {
									markers[i].setMap(null);
								}

								if (GoogleMaps._marker) {
									GoogleMaps._marker.setMap(null);
								}

								var marker = new googleMaps.Marker(
									{
										map: map,
										position: new googleMaps.LatLng(latitude, longitude),
										title: shortAddress
									}
								);

								markers.push(marker);

								infoWindow.open(map, marker);

								instance._replaceInfoWindowContent(GoogleMaps);

								setMapOnAll(GoogleMaps);

								map.panTo(marker.getPosition());
							}

							function setMapOnAll(map) {
								var markers = [];

								for (var i = 0; i < markers.length; i++) {
									markers[i].setMap(map);
								}
							}

							instance._officeLink.on('click', _changeAddress);
							instance._headquartersLink.on('click', _changeAddress);
						},

						_replaceInfoWindowContent: function(GoogleMaps) {
							var instance = this;

							var infoWindow = GoogleMaps._infoWindow;

							var infoWindowContent = infoWindow.getContent();

							infoWindowContent = infoWindowContent.replace(',', ', ');

							infoWindow.setContent(infoWindowContent);
						}
					}
				}
		);

		Liferay.Portlet.PerzejSiteFooter = PerzejSiteFooter;
	},
	'',
	{
		requires: ['aui-event', 'aui-node', 'liferay-google-maps', 'liferay-portlet-base']
	}
);
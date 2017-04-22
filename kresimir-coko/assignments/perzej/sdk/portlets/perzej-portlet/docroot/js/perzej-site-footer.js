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

							instance._headquartersAddressShort = config.headquartersAddressShort;
							instance._headquartersLat = config.headquartersLat;
							instance._headquartersLng = config.headquartersLng;

							instance._officeAddressShort = config.officeAddressShort;
							instance._officeLat = config.officeLat;
							instance._officeLng = config.officeLng;

							instance._officeLink = A.one('.footer-info .office');
							instance._headquartersLink = A.one('.footer-info .headquarters');

							var googleMapsWidget = new Liferay.Portlet.GoogleMaps(
								{
									googleMapsURL: config.googleMapsURL,
									languageId: config.languageId,
									mapAddress: config.mapAddress,
									namespace: config.namespace,
									portletId: config.portletId
								}
							).render();

							googleMapsWidget.set('mapParams.zoom', 14);

							instance._googleMapsWidget = googleMapsWidget;

							instance._officeLink.on('click', A.bind('_changeAddress', instance));
							instance._headquartersLink.on('click', A.bind('_changeAddress', instance));
						},

						_changeAddress: function(event) {
							var instance = this;

							var googleMaps = google.maps;

							var googleMapsWidget = instance._googleMapsWidget;

							var map = googleMapsWidget._map;

							var latitude = instance._officeLat;
							var longitude = instance._officeLng;
							var shortAddress = instance._officeAddressShort;

							if (event.currentTarget.hasClass('headquarters')) {
								latitude = instance._headquartersLat;
								longitude = instance._headquartersLng;
								shortAddress = instance._headquartersAddressShort;
							}

							var infoWindow = new googleMaps.InfoWindow();

							googleMapsWidget._infoWindow = infoWindow;

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

							var marker = googleMapsWidget._marker;

							if (marker) {
								marker.setMap(null);
							}

							marker = new googleMaps.Marker(
								{
									map: map,
									position: new googleMaps.LatLng(latitude, longitude),
									title: shortAddress
								}
							);

							marker.setMap(googleMapsWidget);

							infoWindow.open(map, marker);

							googleMapsWidget._marker = marker;

							instance._replaceInfoWindowContent();

							map.panTo(marker.getPosition());
						},

						_replaceInfoWindowContent: function() {
							var instance = this;

							var infoWindow = instance._googleMapsWidget._infoWindow;

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
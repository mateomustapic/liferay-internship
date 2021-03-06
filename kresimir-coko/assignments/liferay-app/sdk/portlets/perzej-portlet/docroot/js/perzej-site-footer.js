/* global google */

AUI.add(
	'perzej-site-footer',
	function(A) {
		var EVENT_CLICK = 'click';

		var HEADQUARTERS = 'headquarters';

		var PerzejSiteFooter = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'perzej-site-footer',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var officeAddressShort = config.officeAddressShort;

						instance._headquartersAddressShort = config.headquartersAddressShort;
						instance._headquartersLat = config.headquartersLat;
						instance._headquartersLng = config.headquartersLng;
						instance._officeAddressShort = officeAddressShort;
						instance._officeLat = config.officeLat;
						instance._officeLng = config.officeLng;

						var googleMapsWidget = new Liferay.Portlet.GoogleMaps(
							{
								googleMapsApiKey: config.googleMapsApiKey,
								languageId: config.languageId,
								mapAddress: officeAddressShort,
								namespace: config.namespace,
								portletId: config.portletId
							}
						);

						instance._googleMapsWidget = googleMapsWidget;

						googleMapsWidget.set('mapParams.zoom', 14);

						googleMapsWidget.render();

						var headquartersLink = instance.byId(HEADQUARTERS);

						if (headquartersLink) {
							headquartersLink.on(EVENT_CLICK, A.bind('_changeAddress', instance));
						}

						var officeLink = instance.byId('office');

						if (officeLink) {
							officeLink.on(EVENT_CLICK, A.bind('_changeAddress', instance));
						}
					},

					_changeAddress: function(event) {
						var instance = this;

						var latitude = instance._officeLat;
						var longitude = instance._officeLng;
						var shortAddress = instance._officeAddressShort;

						if (event.currentTarget === instance.byId(HEADQUARTERS)) {
							latitude = instance._headquartersLat;
							longitude = instance._headquartersLng;
							shortAddress = instance._headquartersAddressShort;
						}

						var googleMaps = google.maps;

						var infoWindow = new googleMaps.InfoWindow();

						var googleMapsWidget = instance._googleMapsWidget;

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

						var map = googleMapsWidget._map;

						marker = new googleMaps.Marker(
							{
								map: map,
								position: new googleMaps.LatLng(latitude, longitude),
								title: shortAddress
							}
						);

						infoWindow.open(map, marker);

						googleMapsWidget._marker = marker;

						instance._replaceInfoWindowContent();

						map.panTo(marker.getPosition());
					},

					_replaceInfoWindowContent: function() {
						var instance = this;

						var infoWindow = instance._googleMapsWidget._infoWindow;

						var infoWindowContent = infoWindow.getContent();

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
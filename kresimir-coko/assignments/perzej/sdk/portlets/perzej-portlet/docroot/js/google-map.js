/* global google */

AUI.add(
	'liferay-google-maps',
	function(A) {
		var Lang = A.Lang;

		var KEY_DOWN_ENTER = 'down:13';

		var MAP_TYPE_HYBRID = 2;

		var MAP_TYPE_ROADMAP = 0;

		var MAP_TYPE_SATELLITE = 1;

		var MAP_TYPE_TERRAIN = 3;

		var STR_CLICK = 'click';

		var STR_DIRECTION_ADDRESS = 'directionsAddress';

		var STR_KEY = 'key';

		var STR_MAP_ADDRESS = 'mapAddress';

		var STR_TRAVELING_MODE = 'travelingMode';

		var GoogleMaps = A.Component.create(
			{
				ATTRS: {
					googleMapsURL: {
						validator: Lang.isString,
						value: 'http://maps.google.com/maps/api/js'
					},

					languageId: {
						validator: Lang.isString
					},

					mapAddress: {
						getter: '_getMapAddress',
						validator: Lang.isString
					},

					mapParams: {
						validator: Lang.isObject,
						value: {
							mapTypeId: MAP_TYPE_ROADMAP,
							zoom: 14
						}
					},

					namespace: {
						validator: Lang.isString
					},

					portletId: {
						validator: Lang.isNumber
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Widget,

				NAME: 'googlemaps',

				prototype: {
					initializer: function(config) {
						var instance = this;

						instance._markersArray = [];
					},

					renderUI: function() {
						var instance = this;

						if (instance._isGoogleMapLoaded()) {
							instance._renderMap();
						}
						else {
							instance._initGoogleMaps();
						}
					},

					bindUI: function() {
						var instance = this;

						var eventHandles = [];

						var getDirectionsButtonNode = instance.byId('getDirectionsButton');

						if (getDirectionsButtonNode) {
							eventHandles.push(
								getDirectionsButtonNode.on(STR_CLICK, instance._getDirections, instance)
							);
						}

						var travelingModeNode = instance.byId(STR_TRAVELING_MODE);

						if (travelingModeNode) {
							eventHandles.push(
								travelingModeNode.on('change', instance._getDirections, instance)
							);
						}

						var getMapButtonNode = instance.byId('getMapButton');

						if (getMapButtonNode) {
							eventHandles.push(
								getMapButtonNode.on(STR_CLICK, instance._getMap, instance)
							);
						}

						var directionsAddressNode = instance.byId(STR_DIRECTION_ADDRESS);

						if (directionsAddressNode) {
							eventHandles.push(
								directionsAddressNode.on(STR_KEY, A.bind(instance._onDirectionsAddressKeyDown, instance), KEY_DOWN_ENTER)
							);
						}

						var mapAddressNode = instance.byId(STR_MAP_ADDRESS);

						if (mapAddressNode) {
							eventHandles.push(
								mapAddressNode.on(STR_KEY, A.bind(instance._onMapAddressKeyDown, instance), KEY_DOWN_ENTER)
							);
						}

						var openLinkNode = instance.byId('openInGoogleMapsLink');

						if (openLinkNode) {
							eventHandles.push(
								openLinkNode.on(STR_CLICK, instance._onOpenInGoogleMapsClick, instance)
							);
						}

						eventHandles.push(Liferay.on(instance.get('portletId') + ':portletRefreshed', A.bind(instance.destructor, instance)));

						instance._eventHandles = eventHandles;
					},

					destructor: function() {
						var instance = this;

						A.Array.invoke(instance._eventHandles, 'detach');
					},

					initializePage: function(config) {
						var instance = this;

						instance._headquartersAddressShort = config.headquartersAddressShort;
						instance._headquartersLat = config.headquartersLat;
						instance._headquartersLng = config.headquartersLng;

						instance._officeAddressShort = config.officeAddressShort;
						instance._officeLat = config.officeLat;
						instance._officeLng = config.officeLng;
					},

					_attachInstructionText: function(marker, text) {
						var instance = this;

						google.maps.event.addListener(marker, STR_CLICK, A.rbind(instance._onMarkerClick, instance, marker, text));
					},

					_getAddress: function(address) {
						var instance = this;

						instance._geocoder.geocode(
							{
								address: address
							},
							A.rbind(instance._onAddressGeocoded, instance, address)
						);
					},

					_getGoogleMapType: function(type) {
						var mapType = google.maps.MapTypeId;

						var googleMapsType = mapType.ROADMAP;

						if (type == MAP_TYPE_SATELLITE) {
							googleMapsType = mapType.SATELLITE;
						}
						else if (type == MAP_TYPE_HYBRID) {
							googleMapsType = mapType.HYBRID;
						}
						else if (type == MAP_TYPE_TERRAIN) {
							googleMapsType = mapType.TERRAIN;
						}

						return googleMapsType;
					},

					_getMap: function() {
						var instance = this;

						var mapAddress = instance.get(STR_MAP_ADDRESS);

						instance._removeMarkers();

						instance._getAddress(mapAddress);

						return mapAddress;
					},

					_getMapAddress: function(value) {
						var instance = this;

						if (instance.get('mapInputEnabled')) {
							var mapAddressNode = instance.byId(STR_MAP_ADDRESS);

							var mapAddress = mapAddressNode.val();

							if (mapAddress) {
								value = mapAddress;
							}
						}

						return value;
					},

					_initGoogleMaps: function() {
						var instance = this;

						Liferay.namespace('GOOGLE_MAPS').onGoogleMapsLoaded = A.bind(instance._renderMap, instance);

						var googleMapsURL = instance.get('googleMapsURL');

						googleMapsURL = googleMapsURL + '?sensor=true&language=' + instance.get('languageId') + '&callback=Liferay.GOOGLE_MAPS.onGoogleMapsLoaded';

						A.Get.script(googleMapsURL);
					},

					_isDirectionFilled: function() {
						var instance = this;

						var directionFilled = false;

						if (instance.get(STR_DIRECTION_ADDRESS)) {
							if (instance.byId(STR_DIRECTION_ADDRESS).val()) {
								directionFilled = true;
							}
						}

						return directionFilled;
					},

					_isGoogleMapLoaded: function() {
						return (typeof google !== 'undefined' && A.Lang.isObject(google.maps));
					},

					_onAddressGeocoded: function(results, status, address) {
						var instance = this;

						var googleMaps = google.maps;

						if (status == googleMaps.GeocoderStatus.OK) {
							var location = results[0].geometry.location;

							instance._map.setCenter(location);

							if (!instance._marker) {
								instance._marker = new googleMaps.Marker(
									{
										map: instance._map,
										position: location
									}
								);
							}
							else {
								instance._marker.setMap(instance._map);

								instance._marker.setPosition(location);
							}

							if (!instance._infoWindow) {
								instance._infoWindow = new googleMaps.InfoWindow(
									{
										content: address
									}
								);
							}
							else {
								instance._infoWindow.setContent(address);
							}

							instance._replaceInfoWindowContent();

							instance._infoWindow.setPosition(location);

							instance._infoWindow.open(instance._map, instance._marker);
						}
					},

					_removeMarkers: function() {
						var instance = this;

						var markersArray = instance._markersArray;

						var length = markersArray.length;

						for (var i = 0; i < length; i++) {
							markersArray[i].setMap(null);
						}

						if (instance._marker) {
							instance._marker.setMap(null);
						}
					},

					_renderMap: function() {
						var instance = this;

						var mapParams = instance.get('mapParams');

						mapParams = A.merge(
							mapParams,
							{
								mapTypeId: instance._getGoogleMapType(mapParams.mapTypeId)
							}
						);

						var googleMaps = google.maps;

						instance._map = new googleMaps.Map(instance.byId('map').getDOMNode(), mapParams);

						instance._geocoder = new googleMaps.Geocoder();

						instance._directionsService = new googleMaps.DirectionsService();

						instance._directionsDisplay = new googleMaps.DirectionsRenderer(
							{
								map: instance._map
							}
						);

						instance._infoWindow = new googleMaps.InfoWindow();

						var infoWindow = instance._infoWindow;

						if (instance._isDirectionFilled()) {
							instance._getDirections();
						}
						else {
							instance._getAddress(instance.get(STR_MAP_ADDRESS));
						}

						var instancedMap = instance._map;

						var officeLink = A.one('.footer-info .office');

						var headquartersLink = A.one('.footer-info .headquarters');

						var markers = instance._markersArray;

						function setMapOnAll(instancedMap) {
							for (var i = 0; i < markers.length; i++) {
								markers[i].setMap(instancedMap);
							}
						}

						function _changeAddress() {
							var latitude;
							var longitude;
							var shortAddress;

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

							instance._removeMarkers();

							var marker = new googleMaps.Marker(
								{
									map: instancedMap,
									position: new googleMaps.LatLng(latitude, longitude),
									title: shortAddress
								}
							);

							infoWindow.open(instancedMap, marker);

							instance._replaceInfoWindowContent();

							markers.push(marker);

							instancedMap.panTo(marker.getPosition());
						}

						setMapOnAll(instancedMap);

						officeLink.on('click', _changeAddress);
						headquartersLink.on('click', _changeAddress);
					},

					_replaceInfoWindowContent: function() {
						var instance = this;

						var infoWindow = instance._infoWindow;

						var infoWindowContent = infoWindow.getContent();

						infoWindowContent = infoWindowContent.replace(',', ', ');

						infoWindow.setContent(infoWindowContent);
					}
				}
			}
		);

		GoogleMaps.MAP_TYPE_HYBRID = MAP_TYPE_HYBRID;
		GoogleMaps.MAP_TYPE_ROADMAP = MAP_TYPE_ROADMAP;
		GoogleMaps.MAP_TYPE_SATELLITE = MAP_TYPE_SATELLITE;
		GoogleMaps.MAP_TYPE_TERRAIN = MAP_TYPE_TERRAIN;

		Liferay.Portlet.GoogleMaps = GoogleMaps;
	},
	'',
	{
		requires: ['get', 'liferay-portlet-base']
	}
);
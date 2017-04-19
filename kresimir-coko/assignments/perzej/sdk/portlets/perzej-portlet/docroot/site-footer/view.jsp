<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<footer id="footer">
	<div class="google-map">
		<div class="maps-content" id="<portlet:namespace />map" style="height: <%= height %>px; width: 100%;"></div>

		<aui:script use="liferay-google-maps">
			var googleMaps = new Liferay.Portlet.GoogleMaps(
				{
					<c:if test="<%= PortalUtil.isSecure(request) %>">
						googleMapsURL: 'https://maps-api-ssl.google.com/maps/api/js',
					</c:if>

					languageId: '<%= themeDisplay.getLanguageId() %>',
					mapAddress: '<%= PortletProps.get("perzej.office.address.short") %>',
					namespace: '<portlet:namespace />',
					portletId: '<%= portletDisplay.getId() %>'
				}
			).render();

			googleMaps.initializePage(
				{
					headquartersAddressShort: '<%= PortletProps.get("perzej.headquarters.address.short") %>',
					headquartersLat: '<%= PortletProps.get("perzej.headquarters.lat") %>',
					headquartersLng: '<%= PortletProps.get("perzej.headquarters.lng") %>',
					officeAddressShort: '<%= PortletProps.get("perzej.office.address.short") %>',
					officeLat: '<%= PortletProps.get("perzej.office.lat") %>',
					officeLng: '<%= PortletProps.get("perzej.office.lng") %>'
				}
			);
		</aui:script>
	</div>

	<div class="footer-info">
		<span class="headquarters location">
			<span class="bold">
				<i aria-hidden="true" class="icon-map-marker"></i>

				<liferay-ui:message key="headquarters" />
			</span>

			<%= PortletProps.get("perzej.headquarters.address") %>

		</span>

		<span class="location office">
			<span class="bold">
				<i aria-hidden="true" class="icon-map-marker"></i>

				<liferay-ui:message key="office" />
			</span>

			<%= PortletProps.get("perzej.office.address") %>
		</span>

		<span class="oib">
			<span class="bold">
				<i aria-hidden="true" class="icon-book"></i>

				OIB:
			</span>

			<%= PortletProps.get("perzej.oib") %>
		</span>

		<span class="phone">
			<i aria-hidden="true" class="icon-phone"></i>

			<%= PortletProps.get("perzej.phone") %>
		</span>

		<span class="powered-by">
			<i aria-hidden="true" class="icon-rocket"></i>

			<liferay-ui:message key="powered-by" />

			<aui:a href="http://www.liferay.com" target="_blank">
				<span class="bold"> Liferay</span>
			</aui:a>
		</span>
	</div>
</footer>
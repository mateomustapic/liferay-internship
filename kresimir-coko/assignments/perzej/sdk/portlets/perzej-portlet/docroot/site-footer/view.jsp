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
	<div class="container">
		<span class="location">
			<b>
				<i aria-hidden="true" class="icon-map-marker"></i>

				<liferay-ui:message key="headquarters" />
			</b>

			<%= PortletProps.get("perzej.headquarters.address") %>

		</span>

		<span class="location">
			<b>
				<i aria-hidden="true" class="icon-map-marker"></i>

				<liferay-ui:message key="office" />
			</b>

			<%= PortletProps.get("perzej.office.address") %>
		</span>

		<span class="oib">
			<b>
				<i aria-hidden="true" class="icon-book"></i>

				OIB:
			</b>

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
				<b> Liferay</b>
			</aui:a>
		</span>
	</div>
</footer>
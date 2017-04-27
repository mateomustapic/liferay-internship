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

<section class="section about-lcs" id="<portlet:namespace />about-lcs">
	<div class="container">
		<img alt="Liferay Connected Services" src="<%= PortalUtil.getPathContext(request) %>/images/lcs-logo.svg" />

		<div class="section_column">
			<h3 class="section-heading">
				<liferay-ui:message key="about-liferay-connected-services" />
			</h3>

			<p>
				<liferay-ui:message key="liferay-connected-services-is-a-new-online-platform-that-offers-a-set-of-tools-and-services-that-will-help-our-customers-succeed-on-their-liferay-projects" />
			</p>

			<aui:a href="https://www.liferay.com/supporting-products/liferay-connected-services" label="Liferay Connected Services" target="_blank">
				<i aria-hidden="true" class="icon-angle-right"></i>
			</aui:a>
		</div>
	</div>
</section>
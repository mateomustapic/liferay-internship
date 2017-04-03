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

<section class="section" id="about-liferay">
	<div class="container">
		<div class="section_column">
			<h3 class="section-heading">
				<liferay-ui:message key="about-liferay" />
			</h3>

			<p>
				<liferay-ui:message key="liferay-is-an-open-source-enterprise-portal-project-written-in-java-for-building-business-solutions-that-in-turn-deliver-immediate-results-and-long-term-value" />
			</p>

			<aui:a href="https://www.liferay.com/" label="Liferay" target="_blank">
				<i aria-hidden="true" class="icon-angle-right"></i>
			</aui:a>
		</div>

		<img alt="Liferay" src="<%= PortalUtil.getPathContext(request) %>/images/liferay-logo.svg">
	</div>
</section>
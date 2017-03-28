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

<liferay-portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="search" var="searchURL"></liferay-portlet:actionURL>

<aui:form action="<%= searchURL %>" name="<portlet:namespace />fm">
	<aui:fieldset>
		<liferay-ui:header
			backURL="<%= viewURL.toString() %>"
			title="search"
		/>
		<aui:input label="" name="bend" placeholder="Search for bends" type="text"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button icon="icon-search" type="submit" value="search"></aui:button>
	</aui:button-row>
</aui:form>
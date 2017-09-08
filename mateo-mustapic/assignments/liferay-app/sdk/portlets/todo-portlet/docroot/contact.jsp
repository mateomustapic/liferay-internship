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

<%@ include file="/header.jspf" %>

<div class="form-container">
	<h3>
		<liferay-ui:message key="contact-us" />

		<i class="icon-envelope"></i>
	</h3>

	<liferay-ui:success key="formSuccessfullySubmitted" message="form-successfully-submitted" />

	<liferay-ui:error key="formSubmissionFailed" message="form-submission-failed" />
</div>

<portlet:actionURL name="contact" var="contactURL">
	<portlet:param name="redirect" value="/contact.jsp"></portlet:param>
</portlet:actionURL>

<aui:form action="<%= contactURL %>" cssClass="contact-form" method="post" name="contact">
	<aui:input name="name" required="<%= true %>" size="20" type="text" value="" />

	<aui:input name="last-name" required="<%= true %>" size="20" type="text" value="" />

	<aui:input name="email" required="<%= true %>" size="20" type="text"  value="" />

	<aui:select name="gender" showEmptyOption="<%= true %>">
		<aui:option key="male" label="male" />
		<aui:option key="female" label="female" />
	</aui:select>

	<aui:input name="birthday" type="date" />

	<aui:select name="problem" required="<%= true %>">
		<aui:option label="please-select-a-topic" selected="<%= true %>" value="1" />
		<aui:option key="cannot-add-tasks-to-list" label="cannot-add-tasks-to-list" value="2" />
		<aui:option key="cannot-remove-tasks-from-the-list" label="cannot-remove-tasks-from-the-list" value="3" />
		<aui:option key="deleted-tasks-do-not-appear-in-history" label="deleted-tasks-do-not-appear-in-history" value="4" />
		<aui:option key="profile-page-is-not-updated" label="profile-page-is-not-updated" value="5" />
		<aui:option key="cannot-logout" label="cannot-logout" value="6" />
		<aui:option key="other" label="other" value="7" />
	</aui:select>

	<aui:input cols="50" name="comment" required="<%= true %>" rows="6" type="textarea" />

	<div class="form-buttons">
		<aui:button-row>
			<aui:button cssClass="reset-form" name="reset" type="reset" value="clear" />

			<aui:button cssClass="submit-form" name="submit" type="submit" value="submit" />
		</aui:button-row>
	</div>
</aui:form>
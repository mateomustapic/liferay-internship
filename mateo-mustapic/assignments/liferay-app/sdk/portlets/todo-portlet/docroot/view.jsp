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

<div class="list-container">
	<div class="header">
		<h2>
			<liferay-ui:message key="to-do-list" />

			<i class="icon-check"></i>
		</h2>
	</div>

	<div class="welcome-message">
		<liferay-ui:message key="welcome" />

		<%= user.getFirstName() %>

		<img alt="<%= user.getFullName() %>" src="<%=user.getPortraitURL(themeDisplay) %>">
	</div>

	<liferay-ui:tabs names="task-list-tab,task-history-tab,profile-tab,contact-tab" refresh="false">
		<liferay-ui:section>
			<div class="task-container">
				<aui:form>
					<aui:input cssClass="input-item" name="task" placeholder="enter-task">
						<aui:validator name="required" />
					</aui:input>

					<aui:button cssClass="add-task" name="add" value="add" />
				</aui:form>

				<span class="counter">
					35
				</span>

				<liferay-ui:message key="characters-remaining" />

				<h3>
					<liferay-ui:message key="tasks" />
				</h3>

				<ul class="task-list" id="<portlet:namespace />todo-list">
					<li>

						<liferay-ui:message key="sample-task" />

						<aui:button cssClass="delete-task" icon="icon-remove" size="large" />
					</li>
				</ul>

				<div class="remaining-tasks-container">
					<div class="remaining-tasks-count" id="<portlet:namespace />remaining-tasks-count">
						1
					</div>

					<div class="remaining-tasks">

						<liferay-ui:message key="tasks-left" />
					</div>
				</div>

				<div class="finished-task" id="<portlet:namespace />finished-task">
					<ul class="finished-task-list"></ul>
				</div>
			</div>
		</liferay-ui:section>

		<liferay-ui:section>
			<div class="task-history">
				<h3>
					<liferay-ui:message key="task-history" />

					<i class="icon-book"></i>
				</h3>

				<div class="empty-task-history" id="<portlet:namespace />empty-task-history">
					<liferay-ui:message key="no-tasks" />
				</div>

				<ul class="history-list" id="<portlet:namespace />history-list"></ul>
			</div>
		</liferay-ui:section>

		<liferay-ui:section>
			<div class="profile-page"></div>
		</liferay-ui:section>

		<liferay-ui:section>
			<div class="contact-form"></div>
		</liferay-ui:section>
	</liferay-ui:tabs>
</div>

<aui:script use="todo">
	new Liferay.Portlet.Todo(
		{
			namespace: '<portlet:namespace />',
			taskFinished: '<%= UnicodeLanguageUtil.get(pageContext, "task-finished") %>'
		}
	);
</aui:script>
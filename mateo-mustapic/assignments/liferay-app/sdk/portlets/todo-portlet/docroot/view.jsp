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
	<div class="task-container">
		<aui:input cssClass="input-item" name="task" placeholder="Enter your task.." />

		<aui:button cssClass="add-task" name="add" value="add" />

		<span class="counter">35</span>

		<liferay-ui:message key="characters-remaining" />

		<ul class="task-list">
			<li>
				<liferay-ui:message key="sample-task" />
				<aui:button cssClass="delete-task" icon="icon-remove" size="large" />
			</li>
		</ul>
		<div class="remaining-tasks-count">
		</div>
		<div class="finished-task">
			<ul class="finished-task-list">
			</ul>
		</div>
	</div>
</div>

<aui:script use="todo">
	new Liferay.Portlet.Todo(
		{
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>
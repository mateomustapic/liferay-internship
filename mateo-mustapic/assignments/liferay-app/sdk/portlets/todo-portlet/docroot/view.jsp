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
	<h2>
		<liferay-ui:message key="to-do-list" />

		<i class="icon-check"></i>
	</h2>

	<div class="task-container">
		<aui:input class="input-item" cssClass="input-item" name="task" />

		<aui:button cssClass="add-task" name="add" type="button" />

		<span class="counter">30</span>

		<liferay-ui:message key="characters-remaining" />

		<ul class="task-list">
			<li>
				Task 1
				<button class="delete-todo">X</button>
			</li>
		</ul>
	</div>
</div>

<aui:script use="todo">
	new Liferay.Portlet.Todo(
		{
			namespace: '<portlet:namespace />',
		}
	);
</aui:script>
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

<div class="myDiv">
	<h2>
		<liferay-ui:message key="to-do-list" />

		<i class="icon-check"></i>
	</h2>

	<div class="inputDiv">
		<input class="myInput" name="new-task" placeholder="title-of-the-new-task" type="text" />
		<span class="addItem">
			<liferay-ui:message key="add" />
		</span>
	</div>
</div>

<span class="myCounter"></span> character(s) remaining

<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>
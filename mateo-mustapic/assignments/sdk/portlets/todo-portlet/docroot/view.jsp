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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/init.jsp" %>

<portlet:defineObjects />

<div id="myDIV">
	<h2>TO DO LIST <span class="icon-check" aria-hidden="true"></span></h2>
	<div id="inputDiv">
		<input id="myInput" placeholder="Title of new task..." type="text">
		<span class="addBtn" id="addItem">Add</span>
	</div>
	<span id="myCounter"></span> character(s) remaining
</div>

<ul id="myUL">
	<li>Task 1</li>
	<li>Task 2</li>
</ul>

<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>
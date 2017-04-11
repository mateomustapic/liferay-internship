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

<portlet:defineObjects/>

<div id="myDIV">
	<h2>TO DO LIST <span aria-hidden="true" class="icon-check"></span></h2>
	<div id="inputDiv">
		<input id="myInput" placeholder="Title of new task..." type="text">
		<span class="addBtn" id="addItem">Add</span>
	</div>
	<span id="myCounter"></span> character(s) remaining
</div>

<ul id="myUL">
	<li>Monday 17/April - Meeting at 1pm</li>
	<li>Saturday 9am - Football practice</li>
	<li>Thursday 9 pm - Dinner with friends</li>
</ul>

<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>

<br>
<h2>TASK SUMMARY</h2>
<a class="button" href="#" id="addList">SHOW ALL DATA</a>
<br><br>
<div id="tasksTable">
	<table class="center" id="toDoTable">
		<thead>
		<tr>
			<th>ID</th>
			<th>Task</th>
			<th>Description</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
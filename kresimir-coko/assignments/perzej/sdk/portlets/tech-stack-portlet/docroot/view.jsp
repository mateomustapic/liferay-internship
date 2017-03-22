<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<section class="section" id="tech-stack">
	<div class="container">
		<img alt="Image" src="<%= request.getContextPath()%>/images/sass-logo.png" />
		<img alt="Image" src="<%= request.getContextPath()%>/images/freemarker-logo.png" />
		<img alt="Image" src="<%= request.getContextPath()%>/images/java-logo.png" />
		<img alt="Image" src="<%= request.getContextPath()%>/images/metal-logo.png" />
		<img alt="Image" src="<%= request.getContextPath()%>/images/gradle-logo.png" />
	</div>
</section>
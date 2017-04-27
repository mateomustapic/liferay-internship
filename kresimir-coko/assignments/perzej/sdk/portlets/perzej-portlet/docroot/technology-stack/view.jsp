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

<section class="section" id="<portlet:namespace />tech-stack">
	<div class="container">
		<div class="tech-stack-column">
			<h3 class="tech-stack-heading">
				Front End
			</h3>

			<div class="tech-stack-column-container">
				<div class="technology">
					<div class="technology-image">
						<img alt="Sass" src="<%= PortalUtil.getPathContext(request) %>/images/sass-logo.png" />
					</div>

					<span class="technology-name">
						Sass
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Bourbon" src="<%= PortalUtil.getPathContext(request) %>/images/bourbon-logo.png" />
					</div>

					<span class="technology-name">
						Bourbon
					</span>
				</div>

				<div class="technology" id="freemarker">
					<div class="technology-image">
						<img alt="Freemarker" src="<%= PortalUtil.getPathContext(request) %>/images/freemarker-logo.png" />
					</div>

					<span class="technology-name">Freemarker</span>
				</div>

				<div class="technology" id="npm">
					<div class="technology-image">
						<img alt="npm" src="<%= PortalUtil.getPathContext(request) %>/images/npm.png" />
					</div>

					<span class="technology-name">npm</span>
				</div>

				<div class="technology" id="gulp">
					<div class="technology-image">
						<img alt="Gulp" src="<%= PortalUtil.getPathContext(request) %>/images/gulp.svg" />
					</div>

					<span class="technology-name">
						Gulp
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Metal" src="<%= PortalUtil.getPathContext(request) %>/images/metal-logo.png" />
					</div>

					<span class="technology-name">
						metal.js
					</span>
				</div>
			</div>
		</div>

		<div class="tech-stack-column">
			<h3 class="tech-stack-heading">
				Back End
			</h3>

			<div class="tech-stack-column-container">
				<div class="technology">
					<div class="technology-image">
						<img alt="Java" src="<%= PortalUtil.getPathContext(request) %>/images/java-logo.png" />
					</div>

					<span class="technology-name">
						Java
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Gradle" src="<%= PortalUtil.getPathContext(request) %>/images/gradle-logo.png" />
					</div>

					<span class="technology-name">
						Gradle
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Jenkins" src="<%= PortalUtil.getPathContext(request) %>/images/jenkins.png" />
					</div>

					<span class="technology-name">
						Jenkins
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="MySQL" src="<%= PortalUtil.getPathContext(request) %>/images/mysql.svg" />
					</div>

					<span class="technology-name">
						MySQL
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Spark" src="<%= PortalUtil.getPathContext(request) %>/images/spark.png" />
					</div>

					<span class="technology-name">
						Apache Spark
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Cassandra" src="<%= PortalUtil.getPathContext(request) %>/images/cassandra.svg" />
					</div>

					<span class="technology-name">
						Cassandra
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Docker" src="<%= PortalUtil.getPathContext(request) %>/images/docker.svg" />
					</div>

					<span class="technology-name">
						Docker
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt='<%= "Amazon Web Services" %>' src="<%= PortalUtil.getPathContext(request) %>/images/aws.svg" />
					</div>

					<span class="technology-name">
						AWS
					</span>
				</div>
			</div>
		</div>

		<div class="tech-stack-column">
			<h3 class="tech-stack-heading">
				<liferay-ui:message key="tools" />
			</h3>

			<div class="tech-stack-column-container">
				<div class="technology">
					<div class="technology-image">
						<img alt="SmartGit" src="<%= PortalUtil.getPathContext(request) %>/images/smartgit.png" />
					</div>

					<span class="technology-name">
						SmartGit
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="Jira" src="<%= PortalUtil.getPathContext(request) %>/images/jira.png" />
					</div>

					<span class="technology-name">
						Jira
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="GitHub" src="<%= PortalUtil.getPathContext(request) %>/images/github.png" />
					</div>

					<span class="technology-name">
						GitHub
					</span>
				</div>

				<div class="technology">
					<div class="technology-image">
						<img alt="ELK Stack" src="<%= PortalUtil.getPathContext(request) %>/images/elk-stack.png" />
					</div>

					<span class="technology-name">
						ELK Stack
					</span>
				</div>
			</div>
		</div>
	</div>
</section>

<aui:script use="perzej-technology-stack">
	new Liferay.Portlet.PerzejTechnologyStack(
		{
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>
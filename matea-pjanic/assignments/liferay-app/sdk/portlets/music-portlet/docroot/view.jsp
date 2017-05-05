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

<div class="account-div">
	<div class="account-wrapper">
		<aui:a cssClass="account-link" href="javascript:;">
			<%= themeDisplay.getUser().getFirstName() %>
		</aui:a>
	</div>
</div>

<h2>
	<liferay-ui:message key="discovers-stream-and-share-music" />
</h2>

<liferay-portlet:actionURL name="search" var="searchURL" />

<aui:form action="<%= searchURL %>" name="fm">
	<aui:fieldset>
		<aui:input label="" name="music" placeholder="search-for-music" type="text" />
	</aui:fieldset>

	<aui:button type="submit" value="search" />
</aui:form>

<div class="front-page-content">
	<div class="block tracks">
		<h3>
			<liferay-ui:message key="what-is-new-on-soundsgood" />
		</h3>

		<div class="tracks-inner">
			<div class="artist">
				<div class="adele artist-photo">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="adele" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="send-my-love" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo chainsmokers">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="chainsmokers" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="something-just-like-this" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo deadmausphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="deadmaus" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="saved" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo kodakblackphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="kodak-black" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="tunnel-vision" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo chrisphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="chris-stapleton" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="broken-halos" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo sturgillphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="sturgill-simpson" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="in-bloom" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo leraphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="lera-lynn" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="my-least-favorite-life" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo omamphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="of-monsters-and-man" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="crystals" />
				</div>
			</div>

			<div class="artist">
				<div class="artist-photo josephoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="jose-gonzales" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="every-age" />
				</div>
			</div>

			<div class="artist">
				<div class="alicephoebephoto artist-photo">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artist-name">
					<liferay-ui:message key="alice-phoebe-lou" />
				</div>

				<div class="artist-song">
					<liferay-ui:message key="orbit" />
				</div>
			</div>
		</div>
	</div>

	<div class="block events">
		<h3>
			<liferay-ui:message key="events-and-tickets" />
		</h3>

		<div class="events-inner">
			<table>
				<tr>
					<td>
						<liferay-ui:message key="jason-isbell-and-the-400-unit" />
					</td>

					<td>
						<div class="more-info-wrapper">
							<aui:a cssClass="more-info" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<liferay-ui:message key="janet-jackson-state-of-the-world-tour" />
					</td>

					<td>
						<div class="more-info-wrapper">
							<aui:a cssClass="more-info" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<liferay-ui:message key="the-cramberries-something-else-tour" />
					</td>

					<td>
						<div class="more-info-wrapper">
							<aui:a cssClass="more-info" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="block footer">
		<liferay-ui:message key="soundsgood" />

		<liferay-ui:message key="contact" />
	</div>
</div>
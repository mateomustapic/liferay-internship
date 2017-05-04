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

<div class="accountdiv">
	<div class="accountwrapper">
		<aui:a class="accountlink" href="javascript:;">
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

<div class="frontpagecontent">

	<div class="block tracks">
		<h3>
			<liferay-ui:message key="what-is-new-on-soundsgood" />
		</h3>

		<div class="tracksinner">
			<div class="artist">
				<div class="adelephoto artistphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="adele" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="send-my-love" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto chainsmokersphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="chainsmokers" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="something-just-like-this" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto deadmausphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="deadmaus" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="saved" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto kodakblackphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="kodak-black" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="tunnel-vision" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto chrisphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="chris-stapleton" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="broken-halos" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto sturgillphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="sturgill-simpson" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="in-bloom" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto leraphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="lera-lynn" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="my-least-favorite-life" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto omamphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="of-monsters-and-man" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="crystals" />
				</div>
			</div>

			<div class="artist">
				<div class="artistphoto josephoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="jose-gonzales" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="every-age" />
				</div>
			</div>

			<div class="artist">
				<div class="alicephoebephoto artistphoto">
					<img class="playbutton" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
				</div>

				<div class="artistname">
					<liferay-ui:message key="alice-phoebe-lou" />
				</div>

				<div class="artistsong">
					<liferay-ui:message key="orbit" />
				</div>
			</div>
		</div>
	</div>

	<div class="block events">
		<h3>
			<liferay-ui:message key="events-and-tickets" />
		</h3>

		<div class="eventsinner">
			<table>
				<tr>
					<td>
						<liferay-ui:message key="jason-isbell-and-the-400-unit" />
					</td>

					<td class="date">
						<liferay-ui:message key="fri-05-05-2017" />
					</td>

					<td>
						<div class="moreinfowrapper">
							<aui:a class="moreinfo" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<liferay-ui:message key="janet-jackson-state-of-the-world-tour" />
					</td>

					<td class="date">
						<liferay-ui:message key="fri-05-05-2017" />
					</td>

					<td>
						<div class="moreinfowrapper">
							<aui:a class="moreinfo" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<liferay-ui:message key="the-cramberries-something-else-tour" />
					</td>

					<td class="date">
						<liferay-ui:message key="fri-05-05-2017" />
					</td>

					<td>
						<div class="moreinfowrapper">
							<aui:a class="moreinfo" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="block footer">
		<liferay-ui:message key="sounsgood" />
		<liferay-ui:message key="contact" />
	</div>
</div>
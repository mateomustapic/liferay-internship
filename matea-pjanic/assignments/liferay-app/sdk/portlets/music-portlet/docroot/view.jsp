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

<portlet:resourceURL id="search-resource" var="resourceURL" />

<div class="search-container">
	<aui:fieldset>
		<aui:input label="" name="music-input" placeholder="search-for-music" type="text" />
	</aui:fieldset>

	<aui:input cssClass="search-button" data-resourceURL="<%= resourceURL.toString() %>" label="" name="search" type="button" value="Search" />
</div>

<div class="front-div front-page-content-show">
	<div class="block tracks">
		<h3>
			<liferay-ui:message key="what-is-new-on-soundsgood" />
		</h3>

		<div class="tracks-inner">

			<%
			List<Bend> bends = MusicUtil.getBends();

			for (Bend bend : bends) {
				for (Album album : bend.getAlbums()) {
					if (album.getYear() == new DateTime().getYear()) {
			%>

				<div class="artist">
					<div class="artist-picture" style="background-image: url(<%= PortalUtil.getPathContext(request) %>/<%= album.getImage() %>)">
						<img class="play-button" src="<%= PortalUtil.getPathContext(request) %>/images/play.png">
					</div>

					<div class="artist-name">
						<%= bend.getName() %>
					</div>

					<div class="artist-album">
						<%= album.getName() %>
					</div>
				</div>

			<%
					}
				}
			}
			%>

		</div>
	</div>

	<div class="block events">
		<h3>
			<liferay-ui:message key="events-and-tickets" />
		</h3>

		<div class="events-inner">

			<%
			List<Event> events = MusicUtil.getEvents();

			Collections.sort(events, new Comparator<Event>() {
				@Override
				public int compare(Event o1, Event o2) {
					return new DateTime(o1.getDate()).compareTo(new DateTime(o2.getDate()));
				}
			});
			%>

			<table>

				<%
				for (Event event : events) {
				%>

				<tr>
					<td>
						<%= event.getArtist() %>
					</td>

					<td class="tour-name">
						<liferay-ui:message key="<%= event.getName() %>" />
					</td>

					<td>
						<liferay-ui:message key="<%= event.getCity() %>" />,

						<liferay-ui:message key="<%= event.getCountry() %>" />
					</td>

					<td>

						<%
						DateTime date = new DateTime(event.getDate()*1000);

						DateTimeFormatter userDateFormat = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm");
						%>

						<%= date.toString(userDateFormat) %>
					</td>

					<td class="more-info-td">
						<div class="more-info-wrapper">
							<aui:a cssClass="more-info" href="javascript:;">
								<liferay-ui:message key="more-info" />
							</aui:a>
						</div>
					</td>
				</tr>

				<%
				}
				%>

			</table>
		</div>
	</div>
</div>

<div class="block front-div search-result-hide">
	<div class="search-result-title"></div>

	<div class="search-result-artist"></div>
</div>

<div class="block footer">
	<liferay-ui:message key="soundsgood" />

	<liferay-ui:message key="contact" />
</div>

<aui:script use="music">
	new Liferay.Portlet.Music(
		{
			namespace: '<portlet:namespace />'
		}
	);
</aui:script>
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

package com.liferay.music.portlet;

import com.google.gson.Gson;

import com.liferay.music.portlet.model.Bend;
import com.liferay.music.portlet.util.MusicFiles;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Matea Pjanic
 */
public class MusicPortlet extends MVCPortlet {

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		if (resourceRequest.getResourceID().equals("search-resource")) {
			String music = ParamUtil.getString(resourceRequest, "music");

			if (music == null) {
				return;
			}

			List<Bend> bends = MusicFiles.getInstance().getBends();

			if (bends.isEmpty()) {
				return;
			}

			boolean found = false;

			for (Bend bend : bends) {
				if (StringUtil.equalsIgnoreCase(music, bend.getName())) {
					if (_log.isInfoEnabled()) {
						_log.info(music + " was found.");
					}

					found = true;

					Gson gson = MusicFiles.getGson();

					String json = gson.toJson(bend);

					writeJSON(resourceRequest, resourceResponse, json);

					break;
				}
			}

			if (!found) {
				if (_log.isInfoEnabled()) {
					_log.info(music + " was not found.");
				}

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				String message = LanguageUtil.get(
					getPortletConfig(), resourceRequest.getLocale(),
					"sorry-we-currently-dont-have-that-in-our-base");

				jsonObject.put("notFound", message);

				writeJSON(resourceRequest, resourceResponse, jsonObject);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MusicPortlet.class);

}
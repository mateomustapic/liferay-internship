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
import com.google.gson.reflect.TypeToken;

import com.liferay.music.portlet.model.Bend;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.FileReader;

import java.lang.reflect.Type;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Matea Pjanic
 */
public class MusicPortlet extends MVCPortlet {

	public void search(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String bend = ParamUtil.getString(actionRequest, "bend");

		if (bend == null) {
			return;
		}

		Gson gson = new Gson();

		FileReader file = null;

		try {
			file = new FileReader(
				"C:\\Users\\Matea Pjanic\\Git\\matea-pjanic\\assignments\\" +
					"liferay\\sdk\\portlets\\music-portlet\\docroot\\" +
						"json\\bends.json");
		}
		catch (Exception ex) {
			_log.error(ex);
		}

		Type list = new TypeToken<ArrayList<Bend>>(){}.getType();

		ArrayList<Bend> bends = gson.fromJson(file, list);

		int size = bends.size();

		if ((size != 0) && _log.isInfoEnabled()) {
			for (int i = 0; i < size; i++) {
				if (StringUtil.equalsIgnoreCase(bend, bends.get(i).getName())) {
					_log.info(bend + " found");

					break;
				}
				else if (i == (size - 1)) {
					_log.info("Bend not found");
				}
			}

			actionResponse.setRenderParameter("jspPage", "/view.jsp");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MusicPortlet.class);

}
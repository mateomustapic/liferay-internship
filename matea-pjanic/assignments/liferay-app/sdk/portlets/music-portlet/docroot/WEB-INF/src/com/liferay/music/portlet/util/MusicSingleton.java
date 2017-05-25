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

package com.liferay.music.portlet.util;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.liferay.music.portlet.model.Bend;
import com.liferay.music.portlet.model.Event;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matea Pjanic
 */
public class MusicSingleton {

	List<Bend> bendList;

	List<Event> eventList;

	public static Gson getGson() {
		FieldNamingStrategy customPolicy = new FieldNamingStrategy() {

			@Override
			public String translateName(Field field) {
				String name = field.getName();

				return name.substring(1);
			}
		};

		GsonBuilder gsonBuilder = new GsonBuilder();

		gsonBuilder.setFieldNamingStrategy(customPolicy);

		return gsonBuilder.create();
	}

	public static synchronized MusicSingleton getInstance() throws IOException {
		if (instance == null) {
			instance = new MusicSingleton();
		}

		return instance;
	}

	public List<Bend> getBendList() {
		return bendList;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	private static <T> List<T> getList(InputStream is, Class<T> type)
		throws IOException {

		String jsonText = StringUtil.read(is);

		Type typeList = new TypeToken<ArrayList<T>>(){}.where(
				new TypeParameter<T>(){}, type).getType();

		Gson gson = getGson();

		List<T> list = gson.fromJson(jsonText, typeList);

		return list;
	}

	private MusicSingleton() throws IOException {

		InputStream is = getInputStream("../../../../../../../json/bends.json");

		bendList = getList(is, Bend.class);

		is.close();

		is = getInputStream("../../../../../../../json/events.json");

		eventList = getList(is, Event.class);

		is.close();
	}

	private InputStream getInputStream(String filename) {
		return MusicSingleton.class.getResourceAsStream(filename);
	}

	private static MusicSingleton instance = null;

}
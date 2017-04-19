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

package com.liferay.music.portlet.model;

/**
 * @author Matea Pjanic
 */
public class Song {

	public String getMp3() {
		return _mp3;
	}

	public String getName() {
		return _name;
	}

	public void setMp3(String mp3) {
		this._mp3 = mp3;
	}

	public void setName(String name) {
		this._name = name;
	}

	private String _mp3;
	private String _name;

}
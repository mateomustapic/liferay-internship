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
public class Album {

	public String getAlbumName() {
		return _albumName;
	}

	public Song[] getSongs() {
		return _songs;
	}

	public int getYear() {
		return _year;
	}

	public void setAlbumName(String albumName) {
		this._albumName = albumName;
	}

	public void setSongs(Song[] songs) {
		this._songs = songs;
	}

	public void setYear(int year) {
		this._year = year;
	}

	private String _albumName;
	private Song[] _songs;
	private int _year;

}
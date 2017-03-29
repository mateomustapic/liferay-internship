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
public class Bend {

	public Album[] getAlbums() {
		return _albums;
	}

	public String getBendName() {
		return _bendName;
	}

	public String getImage() {
		return _image;
	}

	public void setAlbums(Album[] albums) {
		this._albums = albums;
	}

	public void setBendName(String bendName) {
		this._bendName = bendName;
	}

	public void setImage(String image) {
		this._image = image;
	}

	private Album[] _albums;
	private String _bendName;
	private String _image;

}
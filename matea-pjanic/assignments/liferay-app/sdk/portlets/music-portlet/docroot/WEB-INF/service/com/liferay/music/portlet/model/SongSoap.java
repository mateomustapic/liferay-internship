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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.music.portlet.service.http.SongServiceSoap}.
 *
 * @author Matea Pjanic
 * @see com.liferay.music.portlet.service.http.SongServiceSoap
 * @generated
 */
public class SongSoap implements Serializable {
	public static SongSoap toSoapModel(Song model) {
		SongSoap soapModel = new SongSoap();

		soapModel.setSongId(model.getSongId());
		soapModel.setAlbumId(model.getAlbumId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static SongSoap[] toSoapModels(Song[] models) {
		SongSoap[] soapModels = new SongSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SongSoap[][] toSoapModels(Song[][] models) {
		SongSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SongSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SongSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SongSoap[] toSoapModels(List<Song> models) {
		List<SongSoap> soapModels = new ArrayList<SongSoap>(models.size());

		for (Song model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SongSoap[soapModels.size()]);
	}

	public SongSoap() {
	}

	public long getPrimaryKey() {
		return _songId;
	}

	public void setPrimaryKey(long pk) {
		setSongId(pk);
	}

	public long getSongId() {
		return _songId;
	}

	public void setSongId(long songId) {
		_songId = songId;
	}

	public long getAlbumId() {
		return _albumId;
	}

	public void setAlbumId(long albumId) {
		_albumId = albumId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _songId;
	private long _albumId;
	private String _name;
}
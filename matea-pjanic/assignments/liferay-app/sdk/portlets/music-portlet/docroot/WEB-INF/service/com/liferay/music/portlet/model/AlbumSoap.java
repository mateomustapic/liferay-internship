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
 * This class is used by SOAP remote services, specifically {@link com.liferay.music.portlet.service.http.AlbumServiceSoap}.
 *
 * @author Matea Pjanic
 * @see com.liferay.music.portlet.service.http.AlbumServiceSoap
 * @generated
 */
public class AlbumSoap implements Serializable {
	public static AlbumSoap toSoapModel(Album model) {
		AlbumSoap soapModel = new AlbumSoap();

		soapModel.setAlbumId(model.getAlbumId());
		soapModel.setBendId(model.getBendId());
		soapModel.setImage(model.getImage());
		soapModel.setName(model.getName());
		soapModel.setYear(model.getYear());

		return soapModel;
	}

	public static AlbumSoap[] toSoapModels(Album[] models) {
		AlbumSoap[] soapModels = new AlbumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AlbumSoap[][] toSoapModels(Album[][] models) {
		AlbumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AlbumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AlbumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AlbumSoap[] toSoapModels(List<Album> models) {
		List<AlbumSoap> soapModels = new ArrayList<AlbumSoap>(models.size());

		for (Album model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AlbumSoap[soapModels.size()]);
	}

	public AlbumSoap() {
	}

	public long getPrimaryKey() {
		return _albumId;
	}

	public void setPrimaryKey(long pk) {
		setAlbumId(pk);
	}

	public long getAlbumId() {
		return _albumId;
	}

	public void setAlbumId(long albumId) {
		_albumId = albumId;
	}

	public long getBendId() {
		return _bendId;
	}

	public void setBendId(long bendId) {
		_bendId = bendId;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	private long _albumId;
	private long _bendId;
	private String _image;
	private String _name;
	private int _year;
}
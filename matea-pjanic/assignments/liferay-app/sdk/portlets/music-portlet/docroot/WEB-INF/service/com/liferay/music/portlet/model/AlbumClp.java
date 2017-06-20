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

import com.liferay.music.portlet.service.AlbumLocalServiceUtil;
import com.liferay.music.portlet.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matea Pjanic
 */
public class AlbumClp extends BaseModelImpl<Album> implements Album {
	public AlbumClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Album.class;
	}

	@Override
	public String getModelClassName() {
		return Album.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _albumId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAlbumId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _albumId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("albumId", getAlbumId());
		attributes.put("bendId", getBendId());
		attributes.put("image", getImage());
		attributes.put("name", getName());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		Long bendId = (Long)attributes.get("bendId");

		if (bendId != null) {
			setBendId(bendId);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public long getAlbumId() {
		return _albumId;
	}

	@Override
	public void setAlbumId(long albumId) {
		_albumId = albumId;

		if (_albumRemoteModel != null) {
			try {
				Class<?> clazz = _albumRemoteModel.getClass();

				Method method = clazz.getMethod("setAlbumId", long.class);

				method.invoke(_albumRemoteModel, albumId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBendId() {
		return _bendId;
	}

	@Override
	public void setBendId(long bendId) {
		_bendId = bendId;

		if (_albumRemoteModel != null) {
			try {
				Class<?> clazz = _albumRemoteModel.getClass();

				Method method = clazz.getMethod("setBendId", long.class);

				method.invoke(_albumRemoteModel, bendId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImage() {
		return _image;
	}

	@Override
	public void setImage(String image) {
		_image = image;

		if (_albumRemoteModel != null) {
			try {
				Class<?> clazz = _albumRemoteModel.getClass();

				Method method = clazz.getMethod("setImage", String.class);

				method.invoke(_albumRemoteModel, image);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_albumRemoteModel != null) {
			try {
				Class<?> clazz = _albumRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_albumRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_year = year;

		if (_albumRemoteModel != null) {
			try {
				Class<?> clazz = _albumRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_albumRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<com.liferay.music.portlet.model.Song> getSongs() {
		try {
			String methodName = "getSongs";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.liferay.music.portlet.model.Song> returnObj = (java.util.List<com.liferay.music.portlet.model.Song>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSongs(
		java.util.List<com.liferay.music.portlet.model.Song> songs) {
		try {
			String methodName = "setSongs";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.List.class };

			Object[] parameterValues = new Object[] { songs };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getAlbumRemoteModel() {
		return _albumRemoteModel;
	}

	public void setAlbumRemoteModel(BaseModel<?> albumRemoteModel) {
		_albumRemoteModel = albumRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _albumRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_albumRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AlbumLocalServiceUtil.addAlbum(this);
		}
		else {
			AlbumLocalServiceUtil.updateAlbum(this);
		}
	}

	@Override
	public Album toEscapedModel() {
		return (Album)ProxyUtil.newProxyInstance(Album.class.getClassLoader(),
			new Class[] { Album.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AlbumClp clone = new AlbumClp();

		clone.setAlbumId(getAlbumId());
		clone.setBendId(getBendId());
		clone.setImage(getImage());
		clone.setName(getName());
		clone.setYear(getYear());

		return clone;
	}

	@Override
	public int compareTo(Album album) {
		long primaryKey = album.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlbumClp)) {
			return false;
		}

		AlbumClp album = (AlbumClp)obj;

		long primaryKey = album.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{albumId=");
		sb.append(getAlbumId());
		sb.append(", bendId=");
		sb.append(getBendId());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", year=");
		sb.append(getYear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.music.portlet.model.Album");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>albumId</column-name><column-value><![CDATA[");
		sb.append(getAlbumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bendId</column-name><column-value><![CDATA[");
		sb.append(getBendId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _albumId;
	private long _bendId;
	private String _image;
	private String _name;
	private int _year;
	private BaseModel<?> _albumRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.music.portlet.service.ClpSerializer.class;
}
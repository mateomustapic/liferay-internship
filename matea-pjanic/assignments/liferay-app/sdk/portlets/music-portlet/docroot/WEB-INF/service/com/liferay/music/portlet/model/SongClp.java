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

import com.liferay.music.portlet.service.ClpSerializer;
import com.liferay.music.portlet.service.SongLocalServiceUtil;

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
public class SongClp extends BaseModelImpl<Song> implements Song {
	public SongClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Song.class;
	}

	@Override
	public String getModelClassName() {
		return Song.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _songId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSongId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _songId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("songId", getSongId());
		attributes.put("albumId", getAlbumId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long songId = (Long)attributes.get("songId");

		if (songId != null) {
			setSongId(songId);
		}

		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getSongId() {
		return _songId;
	}

	@Override
	public void setSongId(long songId) {
		_songId = songId;

		if (_songRemoteModel != null) {
			try {
				Class<?> clazz = _songRemoteModel.getClass();

				Method method = clazz.getMethod("setSongId", long.class);

				method.invoke(_songRemoteModel, songId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAlbumId() {
		return _albumId;
	}

	@Override
	public void setAlbumId(long albumId) {
		_albumId = albumId;

		if (_songRemoteModel != null) {
			try {
				Class<?> clazz = _songRemoteModel.getClass();

				Method method = clazz.getMethod("setAlbumId", long.class);

				method.invoke(_songRemoteModel, albumId);
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

		if (_songRemoteModel != null) {
			try {
				Class<?> clazz = _songRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_songRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSongRemoteModel() {
		return _songRemoteModel;
	}

	public void setSongRemoteModel(BaseModel<?> songRemoteModel) {
		_songRemoteModel = songRemoteModel;
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

		Class<?> remoteModelClass = _songRemoteModel.getClass();

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

		Object returnValue = method.invoke(_songRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SongLocalServiceUtil.addSong(this);
		}
		else {
			SongLocalServiceUtil.updateSong(this);
		}
	}

	@Override
	public Song toEscapedModel() {
		return (Song)ProxyUtil.newProxyInstance(Song.class.getClassLoader(),
			new Class[] { Song.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SongClp clone = new SongClp();

		clone.setSongId(getSongId());
		clone.setAlbumId(getAlbumId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(Song song) {
		long primaryKey = song.getPrimaryKey();

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

		if (!(obj instanceof SongClp)) {
			return false;
		}

		SongClp song = (SongClp)obj;

		long primaryKey = song.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{songId=");
		sb.append(getSongId());
		sb.append(", albumId=");
		sb.append(getAlbumId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.music.portlet.model.Song");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>songId</column-name><column-value><![CDATA[");
		sb.append(getSongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>albumId</column-name><column-value><![CDATA[");
		sb.append(getAlbumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _songId;
	private long _albumId;
	private String _name;
	private BaseModel<?> _songRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.music.portlet.service.ClpSerializer.class;
}
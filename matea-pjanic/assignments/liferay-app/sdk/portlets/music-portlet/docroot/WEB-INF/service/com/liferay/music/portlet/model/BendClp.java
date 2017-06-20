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

import com.liferay.music.portlet.service.BendLocalServiceUtil;
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
public class BendClp extends BaseModelImpl<Bend> implements Bend {
	public BendClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Bend.class;
	}

	@Override
	public String getModelClassName() {
		return Bend.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _bendId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBendId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bendId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bendId", getBendId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bendId = (Long)attributes.get("bendId");

		if (bendId != null) {
			setBendId(bendId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getBendId() {
		return _bendId;
	}

	@Override
	public void setBendId(long bendId) {
		_bendId = bendId;

		if (_bendRemoteModel != null) {
			try {
				Class<?> clazz = _bendRemoteModel.getClass();

				Method method = clazz.getMethod("setBendId", long.class);

				method.invoke(_bendRemoteModel, bendId);
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

		if (_bendRemoteModel != null) {
			try {
				Class<?> clazz = _bendRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_bendRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setAlbums(
		java.util.List<com.liferay.music.portlet.model.Album> albums) {
		try {
			String methodName = "setAlbums";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.List.class };

			Object[] parameterValues = new Object[] { albums };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.liferay.music.portlet.model.Album> getAlbums() {
		try {
			String methodName = "getAlbums";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.liferay.music.portlet.model.Album> returnObj = (java.util.List<com.liferay.music.portlet.model.Album>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getBendRemoteModel() {
		return _bendRemoteModel;
	}

	public void setBendRemoteModel(BaseModel<?> bendRemoteModel) {
		_bendRemoteModel = bendRemoteModel;
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

		Class<?> remoteModelClass = _bendRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bendRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BendLocalServiceUtil.addBend(this);
		}
		else {
			BendLocalServiceUtil.updateBend(this);
		}
	}

	@Override
	public Bend toEscapedModel() {
		return (Bend)ProxyUtil.newProxyInstance(Bend.class.getClassLoader(),
			new Class[] { Bend.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BendClp clone = new BendClp();

		clone.setBendId(getBendId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(Bend bend) {
		long primaryKey = bend.getPrimaryKey();

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

		if (!(obj instanceof BendClp)) {
			return false;
		}

		BendClp bend = (BendClp)obj;

		long primaryKey = bend.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{bendId=");
		sb.append(getBendId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.music.portlet.model.Bend");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bendId</column-name><column-value><![CDATA[");
		sb.append(getBendId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bendId;
	private String _name;
	private BaseModel<?> _bendRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.music.portlet.service.ClpSerializer.class;
}
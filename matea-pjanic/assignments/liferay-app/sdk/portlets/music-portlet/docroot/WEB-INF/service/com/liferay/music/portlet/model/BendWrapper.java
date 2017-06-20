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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Bend}.
 * </p>
 *
 * @author Matea Pjanic
 * @see Bend
 * @generated
 */
public class BendWrapper implements Bend, ModelWrapper<Bend> {
	public BendWrapper(Bend bend) {
		_bend = bend;
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

	/**
	* Returns the primary key of this bend.
	*
	* @return the primary key of this bend
	*/
	@Override
	public long getPrimaryKey() {
		return _bend.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bend.
	*
	* @param primaryKey the primary key of this bend
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bend.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bend ID of this bend.
	*
	* @return the bend ID of this bend
	*/
	@Override
	public long getBendId() {
		return _bend.getBendId();
	}

	/**
	* Sets the bend ID of this bend.
	*
	* @param bendId the bend ID of this bend
	*/
	@Override
	public void setBendId(long bendId) {
		_bend.setBendId(bendId);
	}

	/**
	* Returns the name of this bend.
	*
	* @return the name of this bend
	*/
	@Override
	public java.lang.String getName() {
		return _bend.getName();
	}

	/**
	* Sets the name of this bend.
	*
	* @param name the name of this bend
	*/
	@Override
	public void setName(java.lang.String name) {
		_bend.setName(name);
	}

	@Override
	public boolean isNew() {
		return _bend.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bend.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bend.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bend.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bend.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bend.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bend.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bend.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bend.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bend.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bend.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BendWrapper((Bend)_bend.clone());
	}

	@Override
	public int compareTo(com.liferay.music.portlet.model.Bend bend) {
		return _bend.compareTo(bend);
	}

	@Override
	public int hashCode() {
		return _bend.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.music.portlet.model.Bend> toCacheModel() {
		return _bend.toCacheModel();
	}

	@Override
	public com.liferay.music.portlet.model.Bend toEscapedModel() {
		return new BendWrapper(_bend.toEscapedModel());
	}

	@Override
	public com.liferay.music.portlet.model.Bend toUnescapedModel() {
		return new BendWrapper(_bend.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bend.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bend.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bend.persist();
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this class directly. All methods that expect a bend model instance should use the {@link com.liferay.music.portlet.model.Bend} interface instead.
	*/
	@Override
	public java.util.List<com.liferay.music.portlet.model.Album> getAlbums() {
		return _bend.getAlbums();
	}

	@Override
	public void setAlbums(
		java.util.List<com.liferay.music.portlet.model.Album> albums) {
		_bend.setAlbums(albums);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BendWrapper)) {
			return false;
		}

		BendWrapper bendWrapper = (BendWrapper)obj;

		if (Validator.equals(_bend, bendWrapper._bend)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Bend getWrappedBend() {
		return _bend;
	}

	@Override
	public Bend getWrappedModel() {
		return _bend;
	}

	@Override
	public void resetOriginalValues() {
		_bend.resetOriginalValues();
	}

	private Bend _bend;
}
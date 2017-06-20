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
 * This class is a wrapper for {@link Album}.
 * </p>
 *
 * @author Matea Pjanic
 * @see Album
 * @generated
 */
public class AlbumWrapper implements Album, ModelWrapper<Album> {
	public AlbumWrapper(Album album) {
		_album = album;
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

	/**
	* Returns the primary key of this album.
	*
	* @return the primary key of this album
	*/
	@Override
	public long getPrimaryKey() {
		return _album.getPrimaryKey();
	}

	/**
	* Sets the primary key of this album.
	*
	* @param primaryKey the primary key of this album
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_album.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the album ID of this album.
	*
	* @return the album ID of this album
	*/
	@Override
	public long getAlbumId() {
		return _album.getAlbumId();
	}

	/**
	* Sets the album ID of this album.
	*
	* @param albumId the album ID of this album
	*/
	@Override
	public void setAlbumId(long albumId) {
		_album.setAlbumId(albumId);
	}

	/**
	* Returns the bend ID of this album.
	*
	* @return the bend ID of this album
	*/
	@Override
	public long getBendId() {
		return _album.getBendId();
	}

	/**
	* Sets the bend ID of this album.
	*
	* @param bendId the bend ID of this album
	*/
	@Override
	public void setBendId(long bendId) {
		_album.setBendId(bendId);
	}

	/**
	* Returns the image of this album.
	*
	* @return the image of this album
	*/
	@Override
	public java.lang.String getImage() {
		return _album.getImage();
	}

	/**
	* Sets the image of this album.
	*
	* @param image the image of this album
	*/
	@Override
	public void setImage(java.lang.String image) {
		_album.setImage(image);
	}

	/**
	* Returns the name of this album.
	*
	* @return the name of this album
	*/
	@Override
	public java.lang.String getName() {
		return _album.getName();
	}

	/**
	* Sets the name of this album.
	*
	* @param name the name of this album
	*/
	@Override
	public void setName(java.lang.String name) {
		_album.setName(name);
	}

	/**
	* Returns the year of this album.
	*
	* @return the year of this album
	*/
	@Override
	public int getYear() {
		return _album.getYear();
	}

	/**
	* Sets the year of this album.
	*
	* @param year the year of this album
	*/
	@Override
	public void setYear(int year) {
		_album.setYear(year);
	}

	@Override
	public boolean isNew() {
		return _album.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_album.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _album.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_album.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _album.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _album.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_album.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _album.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_album.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_album.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_album.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AlbumWrapper((Album)_album.clone());
	}

	@Override
	public int compareTo(com.liferay.music.portlet.model.Album album) {
		return _album.compareTo(album);
	}

	@Override
	public int hashCode() {
		return _album.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.music.portlet.model.Album> toCacheModel() {
		return _album.toCacheModel();
	}

	@Override
	public com.liferay.music.portlet.model.Album toEscapedModel() {
		return new AlbumWrapper(_album.toEscapedModel());
	}

	@Override
	public com.liferay.music.portlet.model.Album toUnescapedModel() {
		return new AlbumWrapper(_album.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _album.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _album.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_album.persist();
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this class directly. All methods that expect a album model instance should use the {@link com.liferay.music.portlet.model.Album} interface instead.
	*/
	@Override
	public java.util.List<com.liferay.music.portlet.model.Song> getSongs() {
		return _album.getSongs();
	}

	@Override
	public void setSongs(
		java.util.List<com.liferay.music.portlet.model.Song> songs) {
		_album.setSongs(songs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlbumWrapper)) {
			return false;
		}

		AlbumWrapper albumWrapper = (AlbumWrapper)obj;

		if (Validator.equals(_album, albumWrapper._album)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Album getWrappedAlbum() {
		return _album;
	}

	@Override
	public Album getWrappedModel() {
		return _album;
	}

	@Override
	public void resetOriginalValues() {
		_album.resetOriginalValues();
	}

	private Album _album;
}
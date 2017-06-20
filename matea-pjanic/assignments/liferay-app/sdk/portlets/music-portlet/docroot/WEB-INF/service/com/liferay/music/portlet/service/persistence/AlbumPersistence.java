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

package com.liferay.music.portlet.service.persistence;

import com.liferay.music.portlet.model.Album;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the album service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see AlbumPersistenceImpl
 * @see AlbumUtil
 * @generated
 */
public interface AlbumPersistence extends BasePersistence<Album> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlbumUtil} to access the album persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the albums where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @return the matching albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Album> findByBendId(
		long bendId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the albums where bendId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bendId the bend ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Album> findByBendId(
		long bendId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the albums where bendId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bendId the bend ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Album> findByBendId(
		long bendId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album findByBendId_First(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album fetchByBendId_First(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album findByBendId_Last(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album fetchByBendId_Last(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the albums before and after the current album in the ordered set where bendId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album[] findByBendId_PrevAndNext(
		long albumId, long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the albums where bendId = &#63; from the database.
	*
	* @param bendId the bend ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBendId(long bendId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of albums where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @return the number of matching albums
	* @throws SystemException if a system exception occurred
	*/
	public int countByBendId(long bendId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the album in the entity cache if it is enabled.
	*
	* @param album the album
	*/
	public void cacheResult(com.liferay.music.portlet.model.Album album);

	/**
	* Caches the albums in the entity cache if it is enabled.
	*
	* @param albums the albums
	*/
	public void cacheResult(
		java.util.List<com.liferay.music.portlet.model.Album> albums);

	/**
	* Creates a new album with the primary key. Does not add the album to the database.
	*
	* @param albumId the primary key for the new album
	* @return the new album
	*/
	public com.liferay.music.portlet.model.Album create(long albumId);

	/**
	* Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the album
	* @return the album that was removed
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album remove(long albumId)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.music.portlet.model.Album updateImpl(
		com.liferay.music.portlet.model.Album album)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the album with the primary key or throws a {@link com.liferay.music.portlet.NoSuchAlbumException} if it could not be found.
	*
	* @param albumId the primary key of the album
	* @return the album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album findByPrimaryKey(long albumId)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the album with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param albumId the primary key of the album
	* @return the album, or <code>null</code> if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Album fetchByPrimaryKey(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the albums.
	*
	* @return the albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Album> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Album> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of albums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Album> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the albums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of albums.
	*
	* @return the number of albums
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
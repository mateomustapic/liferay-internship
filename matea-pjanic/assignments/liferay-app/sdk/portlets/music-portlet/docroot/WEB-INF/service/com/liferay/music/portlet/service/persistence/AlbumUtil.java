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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the album service. This utility wraps {@link AlbumPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see AlbumPersistence
 * @see AlbumPersistenceImpl
 * @generated
 */
public class AlbumUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Album album) {
		getPersistence().clearCache(album);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Album> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Album> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Album> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Album update(Album album) throws SystemException {
		return getPersistence().update(album);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Album update(Album album, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(album, serviceContext);
	}

	/**
	* Returns all the albums where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @return the matching albums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.music.portlet.model.Album> findByBendId(
		long bendId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBendId(bendId);
	}

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
	public static java.util.List<com.liferay.music.portlet.model.Album> findByBendId(
		long bendId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBendId(bendId, start, end);
	}

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
	public static java.util.List<com.liferay.music.portlet.model.Album> findByBendId(
		long bendId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBendId(bendId, start, end, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album findByBendId_First(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBendId_First(bendId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album fetchByBendId_First(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBendId_First(bendId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album findByBendId_Last(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBendId_Last(bendId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album fetchByBendId_Last(
		long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBendId_Last(bendId, orderByComparator);
	}

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
	public static com.liferay.music.portlet.model.Album[] findByBendId_PrevAndNext(
		long albumId, long bendId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBendId_PrevAndNext(albumId, bendId, orderByComparator);
	}

	/**
	* Removes all the albums where bendId = &#63; from the database.
	*
	* @param bendId the bend ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBendId(long bendId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBendId(bendId);
	}

	/**
	* Returns the number of albums where bendId = &#63;.
	*
	* @param bendId the bend ID
	* @return the number of matching albums
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBendId(long bendId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBendId(bendId);
	}

	/**
	* Caches the album in the entity cache if it is enabled.
	*
	* @param album the album
	*/
	public static void cacheResult(com.liferay.music.portlet.model.Album album) {
		getPersistence().cacheResult(album);
	}

	/**
	* Caches the albums in the entity cache if it is enabled.
	*
	* @param albums the albums
	*/
	public static void cacheResult(
		java.util.List<com.liferay.music.portlet.model.Album> albums) {
		getPersistence().cacheResult(albums);
	}

	/**
	* Creates a new album with the primary key. Does not add the album to the database.
	*
	* @param albumId the primary key for the new album
	* @return the new album
	*/
	public static com.liferay.music.portlet.model.Album create(long albumId) {
		return getPersistence().create(albumId);
	}

	/**
	* Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the album
	* @return the album that was removed
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album remove(long albumId)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(albumId);
	}

	public static com.liferay.music.portlet.model.Album updateImpl(
		com.liferay.music.portlet.model.Album album)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(album);
	}

	/**
	* Returns the album with the primary key or throws a {@link com.liferay.music.portlet.NoSuchAlbumException} if it could not be found.
	*
	* @param albumId the primary key of the album
	* @return the album
	* @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album findByPrimaryKey(
		long albumId)
		throws com.liferay.music.portlet.NoSuchAlbumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(albumId);
	}

	/**
	* Returns the album with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param albumId the primary key of the album
	* @return the album, or <code>null</code> if a album with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.music.portlet.model.Album fetchByPrimaryKey(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(albumId);
	}

	/**
	* Returns all the albums.
	*
	* @return the albums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.music.portlet.model.Album> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.music.portlet.model.Album> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.music.portlet.model.Album> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the albums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of albums.
	*
	* @return the number of albums
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AlbumPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AlbumPersistence)PortletBeanLocatorUtil.locate(com.liferay.music.portlet.service.ClpSerializer.getServletContextName(),
					AlbumPersistence.class.getName());

			ReferenceRegistry.registerReference(AlbumUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AlbumPersistence persistence) {
	}

	private static AlbumPersistence _persistence;
}
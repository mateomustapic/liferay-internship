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

import com.liferay.music.portlet.model.Bend;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bend service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see BendPersistenceImpl
 * @see BendUtil
 * @generated
 */
public interface BendPersistence extends BasePersistence<Bend> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BendUtil} to access the bend persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bend where name = &#63; or throws a {@link com.liferay.music.portlet.NoSuchBendException} if it could not be found.
	*
	* @param name the name
	* @return the matching bend
	* @throws com.liferay.music.portlet.NoSuchBendException if a matching bend could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend findByName(
		java.lang.String name)
		throws com.liferay.music.portlet.NoSuchBendException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bend where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching bend, or <code>null</code> if a matching bend could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bend where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bend, or <code>null</code> if a matching bend could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bend where name = &#63; from the database.
	*
	* @param name the name
	* @return the bend that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend removeByName(
		java.lang.String name)
		throws com.liferay.music.portlet.NoSuchBendException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bends where name = &#63;.
	*
	* @param name the name
	* @return the number of matching bends
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bend in the entity cache if it is enabled.
	*
	* @param bend the bend
	*/
	public void cacheResult(com.liferay.music.portlet.model.Bend bend);

	/**
	* Caches the bends in the entity cache if it is enabled.
	*
	* @param bends the bends
	*/
	public void cacheResult(
		java.util.List<com.liferay.music.portlet.model.Bend> bends);

	/**
	* Creates a new bend with the primary key. Does not add the bend to the database.
	*
	* @param bendId the primary key for the new bend
	* @return the new bend
	*/
	public com.liferay.music.portlet.model.Bend create(long bendId);

	/**
	* Removes the bend with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bendId the primary key of the bend
	* @return the bend that was removed
	* @throws com.liferay.music.portlet.NoSuchBendException if a bend with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend remove(long bendId)
		throws com.liferay.music.portlet.NoSuchBendException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.music.portlet.model.Bend updateImpl(
		com.liferay.music.portlet.model.Bend bend)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bend with the primary key or throws a {@link com.liferay.music.portlet.NoSuchBendException} if it could not be found.
	*
	* @param bendId the primary key of the bend
	* @return the bend
	* @throws com.liferay.music.portlet.NoSuchBendException if a bend with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend findByPrimaryKey(long bendId)
		throws com.liferay.music.portlet.NoSuchBendException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bend with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bendId the primary key of the bend
	* @return the bend, or <code>null</code> if a bend with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Bend fetchByPrimaryKey(long bendId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bends.
	*
	* @return the bends
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Bend> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bends.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.BendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bends
	* @param end the upper bound of the range of bends (not inclusive)
	* @return the range of bends
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Bend> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bends.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.BendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bends
	* @param end the upper bound of the range of bends (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bends
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Bend> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bends from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bends.
	*
	* @return the number of bends
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
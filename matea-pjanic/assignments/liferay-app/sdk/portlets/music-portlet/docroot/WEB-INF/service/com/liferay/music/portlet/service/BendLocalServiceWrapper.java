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

package com.liferay.music.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BendLocalService}.
 *
 * @author Matea Pjanic
 * @see BendLocalService
 * @generated
 */
public class BendLocalServiceWrapper implements BendLocalService,
	ServiceWrapper<BendLocalService> {
	public BendLocalServiceWrapper(BendLocalService bendLocalService) {
		_bendLocalService = bendLocalService;
	}

	/**
	* Adds the bend to the database. Also notifies the appropriate model listeners.
	*
	* @param bend the bend
	* @return the bend that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.music.portlet.model.Bend addBend(
		com.liferay.music.portlet.model.Bend bend)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.addBend(bend);
	}

	/**
	* Creates a new bend with the primary key. Does not add the bend to the database.
	*
	* @param bendId the primary key for the new bend
	* @return the new bend
	*/
	@Override
	public com.liferay.music.portlet.model.Bend createBend(long bendId) {
		return _bendLocalService.createBend(bendId);
	}

	/**
	* Deletes the bend with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bendId the primary key of the bend
	* @return the bend that was removed
	* @throws PortalException if a bend with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.music.portlet.model.Bend deleteBend(long bendId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.deleteBend(bendId);
	}

	/**
	* Deletes the bend from the database. Also notifies the appropriate model listeners.
	*
	* @param bend the bend
	* @return the bend that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.music.portlet.model.Bend deleteBend(
		com.liferay.music.portlet.model.Bend bend)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.deleteBend(bend);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bendLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.BendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.BendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.music.portlet.model.Bend fetchBend(long bendId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.fetchBend(bendId);
	}

	/**
	* Returns the bend with the primary key.
	*
	* @param bendId the primary key of the bend
	* @return the bend
	* @throws PortalException if a bend with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.music.portlet.model.Bend getBend(long bendId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.getBend(bendId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.liferay.music.portlet.model.Bend> getBends(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.getBends(start, end);
	}

	/**
	* Returns the number of bends.
	*
	* @return the number of bends
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBendsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.getBendsCount();
	}

	/**
	* Updates the bend in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bend the bend
	* @return the bend that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.music.portlet.model.Bend updateBend(
		com.liferay.music.portlet.model.Bend bend)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.updateBend(bend);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bendLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bendLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bendLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.music.portlet.service.BendLocalServiceUtil} to access the bend local service.
	*/
	@Override
	public com.liferay.music.portlet.model.Bend findBend(java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.findBend(name);
	}

	@Override
	public java.util.List<com.liferay.music.portlet.model.Album> getBendAlbums(
		long bendId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bendLocalService.getBendAlbums(bendId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BendLocalService getWrappedBendLocalService() {
		return _bendLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBendLocalService(BendLocalService bendLocalService) {
		_bendLocalService = bendLocalService;
	}

	@Override
	public BendLocalService getWrappedService() {
		return _bendLocalService;
	}

	@Override
	public void setWrappedService(BendLocalService bendLocalService) {
		_bendLocalService = bendLocalService;
	}

	private BendLocalService _bendLocalService;
}
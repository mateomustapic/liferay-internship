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

import com.liferay.music.portlet.NoSuchBendException;
import com.liferay.music.portlet.model.Bend;
import com.liferay.music.portlet.model.impl.BendImpl;
import com.liferay.music.portlet.model.impl.BendModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bend service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see BendPersistence
 * @see BendUtil
 * @generated
 */
public class BendPersistenceImpl extends BasePersistenceImpl<Bend>
	implements BendPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BendUtil} to access the bend persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BendImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendModelImpl.FINDER_CACHE_ENABLED, BendImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendModelImpl.FINDER_CACHE_ENABLED, BendImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendModelImpl.FINDER_CACHE_ENABLED, BendImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			BendModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the bend where name = &#63; or throws a {@link com.liferay.music.portlet.NoSuchBendException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching bend
	 * @throws com.liferay.music.portlet.NoSuchBendException if a matching bend could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend findByName(String name)
		throws NoSuchBendException, SystemException {
		Bend bend = fetchByName(name);

		if (bend == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBendException(msg.toString());
		}

		return bend;
	}

	/**
	 * Returns the bend where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching bend, or <code>null</code> if a matching bend could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the bend where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bend, or <code>null</code> if a matching bend could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Bend) {
			Bend bend = (Bend)result;

			if (!Validator.equals(name, bend.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BEND_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Bend> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BendPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Bend bend = list.get(0);

					result = bend;

					cacheResult(bend);

					if ((bend.getName() == null) ||
							!bend.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, bend);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Bend)result;
		}
	}

	/**
	 * Removes the bend where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the bend that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend removeByName(String name)
		throws NoSuchBendException, SystemException {
		Bend bend = findByName(name);

		return remove(bend);
	}

	/**
	 * Returns the number of bends where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching bends
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BEND_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "bend.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "bend.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(bend.name IS NULL OR bend.name = '')";

	public BendPersistenceImpl() {
		setModelClass(Bend.class);
	}

	/**
	 * Caches the bend in the entity cache if it is enabled.
	 *
	 * @param bend the bend
	 */
	@Override
	public void cacheResult(Bend bend) {
		EntityCacheUtil.putResult(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendImpl.class, bend.getPrimaryKey(), bend);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { bend.getName() }, bend);

		bend.resetOriginalValues();
	}

	/**
	 * Caches the bends in the entity cache if it is enabled.
	 *
	 * @param bends the bends
	 */
	@Override
	public void cacheResult(List<Bend> bends) {
		for (Bend bend : bends) {
			if (EntityCacheUtil.getResult(BendModelImpl.ENTITY_CACHE_ENABLED,
						BendImpl.class, bend.getPrimaryKey()) == null) {
				cacheResult(bend);
			}
			else {
				bend.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bends.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BendImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BendImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bend.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bend bend) {
		EntityCacheUtil.removeResult(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendImpl.class, bend.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bend);
	}

	@Override
	public void clearCache(List<Bend> bends) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Bend bend : bends) {
			EntityCacheUtil.removeResult(BendModelImpl.ENTITY_CACHE_ENABLED,
				BendImpl.class, bend.getPrimaryKey());

			clearUniqueFindersCache(bend);
		}
	}

	protected void cacheUniqueFindersCache(Bend bend) {
		if (bend.isNew()) {
			Object[] args = new Object[] { bend.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, bend);
		}
		else {
			BendModelImpl bendModelImpl = (BendModelImpl)bend;

			if ((bendModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bend.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, bend);
			}
		}
	}

	protected void clearUniqueFindersCache(Bend bend) {
		BendModelImpl bendModelImpl = (BendModelImpl)bend;

		Object[] args = new Object[] { bend.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((bendModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { bendModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new bend with the primary key. Does not add the bend to the database.
	 *
	 * @param bendId the primary key for the new bend
	 * @return the new bend
	 */
	@Override
	public Bend create(long bendId) {
		Bend bend = new BendImpl();

		bend.setNew(true);
		bend.setPrimaryKey(bendId);

		return bend;
	}

	/**
	 * Removes the bend with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bendId the primary key of the bend
	 * @return the bend that was removed
	 * @throws com.liferay.music.portlet.NoSuchBendException if a bend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend remove(long bendId) throws NoSuchBendException, SystemException {
		return remove((Serializable)bendId);
	}

	/**
	 * Removes the bend with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bend
	 * @return the bend that was removed
	 * @throws com.liferay.music.portlet.NoSuchBendException if a bend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend remove(Serializable primaryKey)
		throws NoSuchBendException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Bend bend = (Bend)session.get(BendImpl.class, primaryKey);

			if (bend == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBendException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bend);
		}
		catch (NoSuchBendException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Bend removeImpl(Bend bend) throws SystemException {
		bend = toUnwrappedModel(bend);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bend)) {
				bend = (Bend)session.get(BendImpl.class, bend.getPrimaryKeyObj());
			}

			if (bend != null) {
				session.delete(bend);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bend != null) {
			clearCache(bend);
		}

		return bend;
	}

	@Override
	public Bend updateImpl(com.liferay.music.portlet.model.Bend bend)
		throws SystemException {
		bend = toUnwrappedModel(bend);

		boolean isNew = bend.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bend.isNew()) {
				session.save(bend);

				bend.setNew(false);
			}
			else {
				session.merge(bend);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BendModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BendModelImpl.ENTITY_CACHE_ENABLED,
			BendImpl.class, bend.getPrimaryKey(), bend);

		clearUniqueFindersCache(bend);
		cacheUniqueFindersCache(bend);

		return bend;
	}

	protected Bend toUnwrappedModel(Bend bend) {
		if (bend instanceof BendImpl) {
			return bend;
		}

		BendImpl bendImpl = new BendImpl();

		bendImpl.setNew(bend.isNew());
		bendImpl.setPrimaryKey(bend.getPrimaryKey());

		bendImpl.setBendId(bend.getBendId());
		bendImpl.setName(bend.getName());

		return bendImpl;
	}

	/**
	 * Returns the bend with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bend
	 * @return the bend
	 * @throws com.liferay.music.portlet.NoSuchBendException if a bend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBendException, SystemException {
		Bend bend = fetchByPrimaryKey(primaryKey);

		if (bend == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBendException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bend;
	}

	/**
	 * Returns the bend with the primary key or throws a {@link com.liferay.music.portlet.NoSuchBendException} if it could not be found.
	 *
	 * @param bendId the primary key of the bend
	 * @return the bend
	 * @throws com.liferay.music.portlet.NoSuchBendException if a bend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend findByPrimaryKey(long bendId)
		throws NoSuchBendException, SystemException {
		return findByPrimaryKey((Serializable)bendId);
	}

	/**
	 * Returns the bend with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bend
	 * @return the bend, or <code>null</code> if a bend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Bend bend = (Bend)EntityCacheUtil.getResult(BendModelImpl.ENTITY_CACHE_ENABLED,
				BendImpl.class, primaryKey);

		if (bend == _nullBend) {
			return null;
		}

		if (bend == null) {
			Session session = null;

			try {
				session = openSession();

				bend = (Bend)session.get(BendImpl.class, primaryKey);

				if (bend != null) {
					cacheResult(bend);
				}
				else {
					EntityCacheUtil.putResult(BendModelImpl.ENTITY_CACHE_ENABLED,
						BendImpl.class, primaryKey, _nullBend);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BendModelImpl.ENTITY_CACHE_ENABLED,
					BendImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bend;
	}

	/**
	 * Returns the bend with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bendId the primary key of the bend
	 * @return the bend, or <code>null</code> if a bend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bend fetchByPrimaryKey(long bendId) throws SystemException {
		return fetchByPrimaryKey((Serializable)bendId);
	}

	/**
	 * Returns all the bends.
	 *
	 * @return the bends
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bend> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Bend> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Bend> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Bend> list = (List<Bend>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BEND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BEND;

				if (pagination) {
					sql = sql.concat(BendModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Bend>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Bend>(list);
				}
				else {
					list = (List<Bend>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the bends from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Bend bend : findAll()) {
			remove(bend);
		}
	}

	/**
	 * Returns the number of bends.
	 *
	 * @return the number of bends
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BEND);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the bend persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.music.portlet.model.Bend")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Bend>> listenersList = new ArrayList<ModelListener<Bend>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Bend>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BendImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BEND = "SELECT bend FROM Bend bend";
	private static final String _SQL_SELECT_BEND_WHERE = "SELECT bend FROM Bend bend WHERE ";
	private static final String _SQL_COUNT_BEND = "SELECT COUNT(bend) FROM Bend bend";
	private static final String _SQL_COUNT_BEND_WHERE = "SELECT COUNT(bend) FROM Bend bend WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bend.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bend exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Bend exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BendPersistenceImpl.class);
	private static Bend _nullBend = new BendImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Bend> toCacheModel() {
				return _nullBendCacheModel;
			}
		};

	private static CacheModel<Bend> _nullBendCacheModel = new CacheModel<Bend>() {
			@Override
			public Bend toEntityModel() {
				return _nullBend;
			}
		};
}
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

import com.liferay.music.portlet.NoSuchAlbumException;
import com.liferay.music.portlet.model.Album;
import com.liferay.music.portlet.model.impl.AlbumImpl;
import com.liferay.music.portlet.model.impl.AlbumModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the album service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see AlbumPersistence
 * @see AlbumUtil
 * @generated
 */
public class AlbumPersistenceImpl extends BasePersistenceImpl<Album>
	implements AlbumPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AlbumUtil} to access the album persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AlbumImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, AlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, AlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BENDID = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, AlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBendId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENDID =
		new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, AlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBendId",
			new String[] { Long.class.getName() },
			AlbumModelImpl.BENDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BENDID = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBendId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the albums where bendId = &#63;.
	 *
	 * @param bendId the bend ID
	 * @return the matching albums
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Album> findByBendId(long bendId) throws SystemException {
		return findByBendId(bendId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Album> findByBendId(long bendId, int start, int end)
		throws SystemException {
		return findByBendId(bendId, start, end, null);
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
	@Override
	public List<Album> findByBendId(long bendId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENDID;
			finderArgs = new Object[] { bendId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BENDID;
			finderArgs = new Object[] { bendId, start, end, orderByComparator };
		}

		List<Album> list = (List<Album>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Album album : list) {
				if ((bendId != album.getBendId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ALBUM_WHERE);

			query.append(_FINDER_COLUMN_BENDID_BENDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AlbumModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bendId);

				if (!pagination) {
					list = (List<Album>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Album>(list);
				}
				else {
					list = (List<Album>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first album in the ordered set where bendId = &#63;.
	 *
	 * @param bendId the bend ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album
	 * @throws com.liferay.music.portlet.NoSuchAlbumException if a matching album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album findByBendId_First(long bendId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumException, SystemException {
		Album album = fetchByBendId_First(bendId, orderByComparator);

		if (album != null) {
			return album;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bendId=");
		msg.append(bendId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumException(msg.toString());
	}

	/**
	 * Returns the first album in the ordered set where bendId = &#63;.
	 *
	 * @param bendId the bend ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching album, or <code>null</code> if a matching album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album fetchByBendId_First(long bendId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Album> list = findByBendId(bendId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Album findByBendId_Last(long bendId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumException, SystemException {
		Album album = fetchByBendId_Last(bendId, orderByComparator);

		if (album != null) {
			return album;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bendId=");
		msg.append(bendId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlbumException(msg.toString());
	}

	/**
	 * Returns the last album in the ordered set where bendId = &#63;.
	 *
	 * @param bendId the bend ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching album, or <code>null</code> if a matching album could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album fetchByBendId_Last(long bendId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBendId(bendId);

		if (count == 0) {
			return null;
		}

		List<Album> list = findByBendId(bendId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Album[] findByBendId_PrevAndNext(long albumId, long bendId,
		OrderByComparator orderByComparator)
		throws NoSuchAlbumException, SystemException {
		Album album = findByPrimaryKey(albumId);

		Session session = null;

		try {
			session = openSession();

			Album[] array = new AlbumImpl[3];

			array[0] = getByBendId_PrevAndNext(session, album, bendId,
					orderByComparator, true);

			array[1] = album;

			array[2] = getByBendId_PrevAndNext(session, album, bendId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Album getByBendId_PrevAndNext(Session session, Album album,
		long bendId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ALBUM_WHERE);

		query.append(_FINDER_COLUMN_BENDID_BENDID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AlbumModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bendId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(album);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Album> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the albums where bendId = &#63; from the database.
	 *
	 * @param bendId the bend ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBendId(long bendId) throws SystemException {
		for (Album album : findByBendId(bendId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(album);
		}
	}

	/**
	 * Returns the number of albums where bendId = &#63;.
	 *
	 * @param bendId the bend ID
	 * @return the number of matching albums
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBendId(long bendId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BENDID;

		Object[] finderArgs = new Object[] { bendId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALBUM_WHERE);

			query.append(_FINDER_COLUMN_BENDID_BENDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bendId);

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

	private static final String _FINDER_COLUMN_BENDID_BENDID_2 = "album.bendId = ?";

	public AlbumPersistenceImpl() {
		setModelClass(Album.class);
	}

	/**
	 * Caches the album in the entity cache if it is enabled.
	 *
	 * @param album the album
	 */
	@Override
	public void cacheResult(Album album) {
		EntityCacheUtil.putResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumImpl.class, album.getPrimaryKey(), album);

		album.resetOriginalValues();
	}

	/**
	 * Caches the albums in the entity cache if it is enabled.
	 *
	 * @param albums the albums
	 */
	@Override
	public void cacheResult(List<Album> albums) {
		for (Album album : albums) {
			if (EntityCacheUtil.getResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
						AlbumImpl.class, album.getPrimaryKey()) == null) {
				cacheResult(album);
			}
			else {
				album.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all albums.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AlbumImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AlbumImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the album.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Album album) {
		EntityCacheUtil.removeResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumImpl.class, album.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Album> albums) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Album album : albums) {
			EntityCacheUtil.removeResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
				AlbumImpl.class, album.getPrimaryKey());
		}
	}

	/**
	 * Creates a new album with the primary key. Does not add the album to the database.
	 *
	 * @param albumId the primary key for the new album
	 * @return the new album
	 */
	@Override
	public Album create(long albumId) {
		Album album = new AlbumImpl();

		album.setNew(true);
		album.setPrimaryKey(albumId);

		return album;
	}

	/**
	 * Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param albumId the primary key of the album
	 * @return the album that was removed
	 * @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album remove(long albumId)
		throws NoSuchAlbumException, SystemException {
		return remove((Serializable)albumId);
	}

	/**
	 * Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the album
	 * @return the album that was removed
	 * @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album remove(Serializable primaryKey)
		throws NoSuchAlbumException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Album album = (Album)session.get(AlbumImpl.class, primaryKey);

			if (album == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlbumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(album);
		}
		catch (NoSuchAlbumException nsee) {
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
	protected Album removeImpl(Album album) throws SystemException {
		album = toUnwrappedModel(album);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(album)) {
				album = (Album)session.get(AlbumImpl.class,
						album.getPrimaryKeyObj());
			}

			if (album != null) {
				session.delete(album);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (album != null) {
			clearCache(album);
		}

		return album;
	}

	@Override
	public Album updateImpl(com.liferay.music.portlet.model.Album album)
		throws SystemException {
		album = toUnwrappedModel(album);

		boolean isNew = album.isNew();

		AlbumModelImpl albumModelImpl = (AlbumModelImpl)album;

		Session session = null;

		try {
			session = openSession();

			if (album.isNew()) {
				session.save(album);

				album.setNew(false);
			}
			else {
				session.merge(album);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AlbumModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((albumModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { albumModelImpl.getOriginalBendId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BENDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENDID,
					args);

				args = new Object[] { albumModelImpl.getBendId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BENDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENDID,
					args);
			}
		}

		EntityCacheUtil.putResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumImpl.class, album.getPrimaryKey(), album);

		return album;
	}

	protected Album toUnwrappedModel(Album album) {
		if (album instanceof AlbumImpl) {
			return album;
		}

		AlbumImpl albumImpl = new AlbumImpl();

		albumImpl.setNew(album.isNew());
		albumImpl.setPrimaryKey(album.getPrimaryKey());

		albumImpl.setAlbumId(album.getAlbumId());
		albumImpl.setBendId(album.getBendId());
		albumImpl.setImage(album.getImage());
		albumImpl.setName(album.getName());
		albumImpl.setYear(album.getYear());

		return albumImpl;
	}

	/**
	 * Returns the album with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the album
	 * @return the album
	 * @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAlbumException, SystemException {
		Album album = fetchByPrimaryKey(primaryKey);

		if (album == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAlbumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return album;
	}

	/**
	 * Returns the album with the primary key or throws a {@link com.liferay.music.portlet.NoSuchAlbumException} if it could not be found.
	 *
	 * @param albumId the primary key of the album
	 * @return the album
	 * @throws com.liferay.music.portlet.NoSuchAlbumException if a album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album findByPrimaryKey(long albumId)
		throws NoSuchAlbumException, SystemException {
		return findByPrimaryKey((Serializable)albumId);
	}

	/**
	 * Returns the album with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the album
	 * @return the album, or <code>null</code> if a album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Album album = (Album)EntityCacheUtil.getResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
				AlbumImpl.class, primaryKey);

		if (album == _nullAlbum) {
			return null;
		}

		if (album == null) {
			Session session = null;

			try {
				session = openSession();

				album = (Album)session.get(AlbumImpl.class, primaryKey);

				if (album != null) {
					cacheResult(album);
				}
				else {
					EntityCacheUtil.putResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
						AlbumImpl.class, primaryKey, _nullAlbum);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
					AlbumImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return album;
	}

	/**
	 * Returns the album with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param albumId the primary key of the album
	 * @return the album, or <code>null</code> if a album with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Album fetchByPrimaryKey(long albumId) throws SystemException {
		return fetchByPrimaryKey((Serializable)albumId);
	}

	/**
	 * Returns all the albums.
	 *
	 * @return the albums
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Album> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Album> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Album> findAll(int start, int end,
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

		List<Album> list = (List<Album>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ALBUM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALBUM;

				if (pagination) {
					sql = sql.concat(AlbumModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Album>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Album>(list);
				}
				else {
					list = (List<Album>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the albums from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Album album : findAll()) {
			remove(album);
		}
	}

	/**
	 * Returns the number of albums.
	 *
	 * @return the number of albums
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

				Query q = session.createQuery(_SQL_COUNT_ALBUM);

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
	 * Initializes the album persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.music.portlet.model.Album")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Album>> listenersList = new ArrayList<ModelListener<Album>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Album>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AlbumImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ALBUM = "SELECT album FROM Album album";
	private static final String _SQL_SELECT_ALBUM_WHERE = "SELECT album FROM Album album WHERE ";
	private static final String _SQL_COUNT_ALBUM = "SELECT COUNT(album) FROM Album album";
	private static final String _SQL_COUNT_ALBUM_WHERE = "SELECT COUNT(album) FROM Album album WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "album.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Album exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Album exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AlbumPersistenceImpl.class);
	private static Album _nullAlbum = new AlbumImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Album> toCacheModel() {
				return _nullAlbumCacheModel;
			}
		};

	private static CacheModel<Album> _nullAlbumCacheModel = new CacheModel<Album>() {
			@Override
			public Album toEntityModel() {
				return _nullAlbum;
			}
		};
}
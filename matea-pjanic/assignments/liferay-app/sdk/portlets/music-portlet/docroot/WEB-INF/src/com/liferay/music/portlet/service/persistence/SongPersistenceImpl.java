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

import com.liferay.music.portlet.NoSuchSongException;
import com.liferay.music.portlet.model.Song;
import com.liferay.music.portlet.model.impl.SongImpl;
import com.liferay.music.portlet.model.impl.SongModelImpl;

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
 * The persistence implementation for the song service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see SongPersistence
 * @see SongUtil
 * @generated
 */
public class SongPersistenceImpl extends BasePersistenceImpl<Song>
	implements SongPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SongUtil} to access the song persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUMID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAlbumId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAlbumId",
			new String[] { Long.class.getName() },
			SongModelImpl.ALBUMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALBUMID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAlbumId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the songs where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the matching songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Song> findByAlbumId(long albumId) throws SystemException {
		return findByAlbumId(albumId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the songs where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of songs
	 * @param end the upper bound of the range of songs (not inclusive)
	 * @return the range of matching songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Song> findByAlbumId(long albumId, int start, int end)
		throws SystemException {
		return findByAlbumId(albumId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the songs where albumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param albumId the album ID
	 * @param start the lower bound of the range of songs
	 * @param end the upper bound of the range of songs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Song> findByAlbumId(long albumId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID;
			finderArgs = new Object[] { albumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUMID;
			finderArgs = new Object[] { albumId, start, end, orderByComparator };
		}

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Song song : list) {
				if ((albumId != song.getAlbumId())) {
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

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_ALBUMID_ALBUMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(albumId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Song>(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws com.liferay.music.portlet.NoSuchSongException if a matching song could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song findByAlbumId_First(long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchSongException, SystemException {
		Song song = fetchByAlbumId_First(albumId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song fetchByAlbumId_First(long albumId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Song> list = findByAlbumId(albumId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws com.liferay.music.portlet.NoSuchSongException if a matching song could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song findByAlbumId_Last(long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchSongException, SystemException {
		Song song = fetchByAlbumId_Last(albumId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song fetchByAlbumId_Last(long albumId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAlbumId(albumId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByAlbumId(albumId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the songs before and after the current song in the ordered set where albumId = &#63;.
	 *
	 * @param songId the primary key of the current song
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next song
	 * @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song[] findByAlbumId_PrevAndNext(long songId, long albumId,
		OrderByComparator orderByComparator)
		throws NoSuchSongException, SystemException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByAlbumId_PrevAndNext(session, song, albumId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByAlbumId_PrevAndNext(session, song, albumId,
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

	protected Song getByAlbumId_PrevAndNext(Session session, Song song,
		long albumId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_ALBUMID_ALBUMID_2);

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
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(albumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where albumId = &#63; from the database.
	 *
	 * @param albumId the album ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAlbumId(long albumId) throws SystemException {
		for (Song song : findByAlbumId(albumId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the number of matching songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAlbumId(long albumId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALBUMID;

		Object[] finderArgs = new Object[] { albumId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_ALBUMID_ALBUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(albumId);

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

	private static final String _FINDER_COLUMN_ALBUMID_ALBUMID_2 = "song.albumId = ?";

	public SongPersistenceImpl() {
		setModelClass(Song.class);
	}

	/**
	 * Caches the song in the entity cache if it is enabled.
	 *
	 * @param song the song
	 */
	@Override
	public void cacheResult(Song song) {
		EntityCacheUtil.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey(), song);

		song.resetOriginalValues();
	}

	/**
	 * Caches the songs in the entity cache if it is enabled.
	 *
	 * @param songs the songs
	 */
	@Override
	public void cacheResult(List<Song> songs) {
		for (Song song : songs) {
			if (EntityCacheUtil.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
						SongImpl.class, song.getPrimaryKey()) == null) {
				cacheResult(song);
			}
			else {
				song.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all songs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SongImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SongImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the song.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Song song) {
		EntityCacheUtil.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Song> songs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Song song : songs) {
			EntityCacheUtil.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
				SongImpl.class, song.getPrimaryKey());
		}
	}

	/**
	 * Creates a new song with the primary key. Does not add the song to the database.
	 *
	 * @param songId the primary key for the new song
	 * @return the new song
	 */
	@Override
	public Song create(long songId) {
		Song song = new SongImpl();

		song.setNew(true);
		song.setPrimaryKey(songId);

		return song;
	}

	/**
	 * Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param songId the primary key of the song
	 * @return the song that was removed
	 * @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song remove(long songId) throws NoSuchSongException, SystemException {
		return remove((Serializable)songId);
	}

	/**
	 * Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the song
	 * @return the song that was removed
	 * @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song remove(Serializable primaryKey)
		throws NoSuchSongException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Song song = (Song)session.get(SongImpl.class, primaryKey);

			if (song == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(song);
		}
		catch (NoSuchSongException nsee) {
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
	protected Song removeImpl(Song song) throws SystemException {
		song = toUnwrappedModel(song);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(song)) {
				song = (Song)session.get(SongImpl.class, song.getPrimaryKeyObj());
			}

			if (song != null) {
				session.delete(song);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (song != null) {
			clearCache(song);
		}

		return song;
	}

	@Override
	public Song updateImpl(com.liferay.music.portlet.model.Song song)
		throws SystemException {
		song = toUnwrappedModel(song);

		boolean isNew = song.isNew();

		SongModelImpl songModelImpl = (SongModelImpl)song;

		Session session = null;

		try {
			session = openSession();

			if (song.isNew()) {
				session.save(song);

				song.setNew(false);
			}
			else {
				session.merge(song);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SongModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { songModelImpl.getOriginalAlbumId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALBUMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID,
					args);

				args = new Object[] { songModelImpl.getAlbumId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALBUMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID,
					args);
			}
		}

		EntityCacheUtil.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey(), song);

		return song;
	}

	protected Song toUnwrappedModel(Song song) {
		if (song instanceof SongImpl) {
			return song;
		}

		SongImpl songImpl = new SongImpl();

		songImpl.setNew(song.isNew());
		songImpl.setPrimaryKey(song.getPrimaryKey());

		songImpl.setSongId(song.getSongId());
		songImpl.setAlbumId(song.getAlbumId());
		songImpl.setName(song.getName());

		return songImpl;
	}

	/**
	 * Returns the song with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the song
	 * @return the song
	 * @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSongException, SystemException {
		Song song = fetchByPrimaryKey(primaryKey);

		if (song == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return song;
	}

	/**
	 * Returns the song with the primary key or throws a {@link com.liferay.music.portlet.NoSuchSongException} if it could not be found.
	 *
	 * @param songId the primary key of the song
	 * @return the song
	 * @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song findByPrimaryKey(long songId)
		throws NoSuchSongException, SystemException {
		return findByPrimaryKey((Serializable)songId);
	}

	/**
	 * Returns the song with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the song
	 * @return the song, or <code>null</code> if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Song song = (Song)EntityCacheUtil.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
				SongImpl.class, primaryKey);

		if (song == _nullSong) {
			return null;
		}

		if (song == null) {
			Session session = null;

			try {
				session = openSession();

				song = (Song)session.get(SongImpl.class, primaryKey);

				if (song != null) {
					cacheResult(song);
				}
				else {
					EntityCacheUtil.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
						SongImpl.class, primaryKey, _nullSong);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
					SongImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return song;
	}

	/**
	 * Returns the song with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param songId the primary key of the song
	 * @return the song, or <code>null</code> if a song with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Song fetchByPrimaryKey(long songId) throws SystemException {
		return fetchByPrimaryKey((Serializable)songId);
	}

	/**
	 * Returns all the songs.
	 *
	 * @return the songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Song> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the songs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of songs
	 * @param end the upper bound of the range of songs (not inclusive)
	 * @return the range of songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Song> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the songs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.music.portlet.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of songs
	 * @param end the upper bound of the range of songs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of songs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Song> findAll(int start, int end,
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

		List<Song> list = (List<Song>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SONG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SONG;

				if (pagination) {
					sql = sql.concat(SongModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Song>(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the songs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Song song : findAll()) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs.
	 *
	 * @return the number of songs
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

				Query q = session.createQuery(_SQL_COUNT_SONG);

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
	 * Initializes the song persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.music.portlet.model.Song")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Song>> listenersList = new ArrayList<ModelListener<Song>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Song>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SongImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SONG = "SELECT song FROM Song song";
	private static final String _SQL_SELECT_SONG_WHERE = "SELECT song FROM Song song WHERE ";
	private static final String _SQL_COUNT_SONG = "SELECT COUNT(song) FROM Song song";
	private static final String _SQL_COUNT_SONG_WHERE = "SELECT COUNT(song) FROM Song song WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "song.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Song exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Song exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SongPersistenceImpl.class);
	private static Song _nullSong = new SongImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Song> toCacheModel() {
				return _nullSongCacheModel;
			}
		};

	private static CacheModel<Song> _nullSongCacheModel = new CacheModel<Song>() {
			@Override
			public Song toEntityModel() {
				return _nullSong;
			}
		};
}
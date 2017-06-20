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

import com.liferay.music.portlet.model.Song;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the song service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Matea Pjanic
 * @see SongPersistenceImpl
 * @see SongUtil
 * @generated
 */
public interface SongPersistence extends BasePersistence<Song> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SongUtil} to access the song persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the songs where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the matching songs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Song> findByAlbumId(
		long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.music.portlet.model.Song> findByAlbumId(
		long albumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.music.portlet.model.Song> findByAlbumId(
		long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws com.liferay.music.portlet.NoSuchSongException if a matching song could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song findByAlbumId_First(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchSongException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song fetchByAlbumId_First(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws com.liferay.music.portlet.NoSuchSongException if a matching song could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song findByAlbumId_Last(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchSongException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song fetchByAlbumId_Last(
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.music.portlet.model.Song[] findByAlbumId_PrevAndNext(
		long songId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.music.portlet.NoSuchSongException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the songs where albumId = &#63; from the database.
	*
	* @param albumId the album ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAlbumId(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of songs where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the number of matching songs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAlbumId(long albumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the song in the entity cache if it is enabled.
	*
	* @param song the song
	*/
	public void cacheResult(com.liferay.music.portlet.model.Song song);

	/**
	* Caches the songs in the entity cache if it is enabled.
	*
	* @param songs the songs
	*/
	public void cacheResult(
		java.util.List<com.liferay.music.portlet.model.Song> songs);

	/**
	* Creates a new song with the primary key. Does not add the song to the database.
	*
	* @param songId the primary key for the new song
	* @return the new song
	*/
	public com.liferay.music.portlet.model.Song create(long songId);

	/**
	* Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param songId the primary key of the song
	* @return the song that was removed
	* @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song remove(long songId)
		throws com.liferay.music.portlet.NoSuchSongException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.music.portlet.model.Song updateImpl(
		com.liferay.music.portlet.model.Song song)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the song with the primary key or throws a {@link com.liferay.music.portlet.NoSuchSongException} if it could not be found.
	*
	* @param songId the primary key of the song
	* @return the song
	* @throws com.liferay.music.portlet.NoSuchSongException if a song with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song findByPrimaryKey(long songId)
		throws com.liferay.music.portlet.NoSuchSongException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the song with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param songId the primary key of the song
	* @return the song, or <code>null</code> if a song with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.music.portlet.model.Song fetchByPrimaryKey(long songId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the songs.
	*
	* @return the songs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.music.portlet.model.Song> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.music.portlet.model.Song> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.music.portlet.model.Song> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the songs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of songs.
	*
	* @return the number of songs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
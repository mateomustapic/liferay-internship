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

package com.liferay.music.portlet.model.impl;

import com.liferay.music.portlet.model.Song;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Song in entity cache.
 *
 * @author Matea Pjanic
 * @see Song
 * @generated
 */
public class SongCacheModel implements CacheModel<Song>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{songId=");
		sb.append(songId);
		sb.append(", albumId=");
		sb.append(albumId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Song toEntityModel() {
		SongImpl songImpl = new SongImpl();

		songImpl.setSongId(songId);
		songImpl.setAlbumId(albumId);

		if (name == null) {
			songImpl.setName(StringPool.BLANK);
		}
		else {
			songImpl.setName(name);
		}

		songImpl.resetOriginalValues();

		return songImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		songId = objectInput.readLong();
		albumId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(songId);
		objectOutput.writeLong(albumId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long songId;
	public long albumId;
	public String name;
}
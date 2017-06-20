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

import com.liferay.music.portlet.model.Album;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Album in entity cache.
 *
 * @author Matea Pjanic
 * @see Album
 * @generated
 */
public class AlbumCacheModel implements CacheModel<Album>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{albumId=");
		sb.append(albumId);
		sb.append(", bendId=");
		sb.append(bendId);
		sb.append(", image=");
		sb.append(image);
		sb.append(", name=");
		sb.append(name);
		sb.append(", year=");
		sb.append(year);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Album toEntityModel() {
		AlbumImpl albumImpl = new AlbumImpl();

		albumImpl.setAlbumId(albumId);
		albumImpl.setBendId(bendId);

		if (image == null) {
			albumImpl.setImage(StringPool.BLANK);
		}
		else {
			albumImpl.setImage(image);
		}

		if (name == null) {
			albumImpl.setName(StringPool.BLANK);
		}
		else {
			albumImpl.setName(name);
		}

		albumImpl.setYear(year);

		albumImpl.resetOriginalValues();

		return albumImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		albumId = objectInput.readLong();
		bendId = objectInput.readLong();
		image = objectInput.readUTF();
		name = objectInput.readUTF();
		year = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(albumId);
		objectOutput.writeLong(bendId);

		if (image == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(image);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(year);
	}

	public long albumId;
	public long bendId;
	public String image;
	public String name;
	public int year;
}
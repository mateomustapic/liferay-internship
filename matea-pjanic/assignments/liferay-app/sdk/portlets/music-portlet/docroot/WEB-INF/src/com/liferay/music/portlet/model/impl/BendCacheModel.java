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

import com.liferay.music.portlet.model.Bend;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Bend in entity cache.
 *
 * @author Matea Pjanic
 * @see Bend
 * @generated
 */
public class BendCacheModel implements CacheModel<Bend>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{bendId=");
		sb.append(bendId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bend toEntityModel() {
		BendImpl bendImpl = new BendImpl();

		bendImpl.setBendId(bendId);

		if (name == null) {
			bendImpl.setName(StringPool.BLANK);
		}
		else {
			bendImpl.setName(name);
		}

		bendImpl.resetOriginalValues();

		return bendImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bendId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bendId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long bendId;
	public String name;
}
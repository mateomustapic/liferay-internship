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

package com.liferay.music.portlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.music.portlet.service.http.BendServiceSoap}.
 *
 * @author Matea Pjanic
 * @see com.liferay.music.portlet.service.http.BendServiceSoap
 * @generated
 */
public class BendSoap implements Serializable {
	public static BendSoap toSoapModel(Bend model) {
		BendSoap soapModel = new BendSoap();

		soapModel.setBendId(model.getBendId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static BendSoap[] toSoapModels(Bend[] models) {
		BendSoap[] soapModels = new BendSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BendSoap[][] toSoapModels(Bend[][] models) {
		BendSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BendSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BendSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BendSoap[] toSoapModels(List<Bend> models) {
		List<BendSoap> soapModels = new ArrayList<BendSoap>(models.size());

		for (Bend model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BendSoap[soapModels.size()]);
	}

	public BendSoap() {
	}

	public long getPrimaryKey() {
		return _bendId;
	}

	public void setPrimaryKey(long pk) {
		setBendId(pk);
	}

	public long getBendId() {
		return _bendId;
	}

	public void setBendId(long bendId) {
		_bendId = bendId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _bendId;
	private String _name;
}
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

/**
 * @author Matea Pjanic
 */
public class Event {

	public String getArtist() {

		return _artist;
	}

	public String getCity() {

		return _city;
	}

	public String getCountry() {

		return _country;
	}

	public long getDate() {

		return _date;
	}

	public String getName() {

		return _name;
	}

	public void setArtist(String artist) {

		this._artist = artist;
	}

	public void setCity(String city) {

		this._city = city;
	}

	public void setCountry(String country) {

		this._country = country;
	}

	public void setDate(long date) {

		this._date = date;
	}

	public void setName(String name) {

		this._name = name;
	}

	private String _artist;
	private String _city;
	private String _country;
	private long _date;
	private String _name;

}
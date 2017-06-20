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

import java.util.List;

/**
 * The extended model implementation for the Bend service. Represents a row in the &quot;Music_Bend&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.music.portlet.model.Bend} interface.
 * </p>
 *
 * @author Matea Pjanic
 */
public class BendImpl extends BendBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a bend model instance should use the {@link com.liferay.music.portlet.model.Bend} interface instead.
	 */
	public List<Album> getAlbums() {
		return _albums;
	}

	public void setAlbums(List<Album> albums) {
		this._albums = albums;
	}

	private List<Album> _albums;

}
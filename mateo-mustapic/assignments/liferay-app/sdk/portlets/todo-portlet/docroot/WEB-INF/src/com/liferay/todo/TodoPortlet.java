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

package com.liferay.todo;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Mateo Mustapic
 */

public class TodoPortlet extends MVCPortlet {

	public void contact(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("Process action for contact form works");
		}

		String birthday = ParamUtil.getString(actionRequest, "birthday");
		String comment = ParamUtil.getString(actionRequest, "comment");
		String email = ParamUtil.getString(actionRequest, "email");
		String lastName = ParamUtil.getString(actionRequest, "last-name");
		String name = ParamUtil.getString(actionRequest, "name");

		if (comment.isEmpty()) {
			SessionErrors.add(actionRequest, "formSubmissionFailed");

			SessionMessages.add(
				actionRequest, PortalUtil.getPortletId(actionRequest) +
				SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		else {
			StringBundler sb = new StringBundler(9);

			sb.append(name);
			sb.append(StringPool.COMMA);
			sb.append(lastName);
			sb.append(StringPool.COMMA);
			sb.append(email);
			sb.append(StringPool.COMMA);
			sb.append(birthday);
			sb.append(StringPool.COMMA);
			sb.append(comment);

			if (_log.isInfoEnabled()) {
				_log.info(sb.toString());
			}

			SessionMessages.add(actionRequest, "formSuccessfullySubmitted");
		}

		actionResponse.setRenderParameter("mvcPath", "/contact.jsp");
	}

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
			if (_log.isInfoEnabled()) {
				_log.info("Render view of Todo Portlet");
			}

			super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
			String resourceID = resourceRequest.getResourceID();
				try {
					if (resourceID.equals("task-resource")) {
						String taskContent = ParamUtil.getString(
							resourceRequest, "task");

						if (taskContent == null) {
							if (_log.isInfoEnabled()) {
								_log.info("Ajax call is not performed");
							}
						}
						else {
							if (_log.isInfoEnabled()) {
								_log.info("Ajax call is performed");
							}
						}

						super.serveResource(resourceRequest, resourceResponse);
					}
				}

				catch (Exception e) {
					e.printStackTrace();
				}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoPortlet.class);

}
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package ru.psavinov.liferay.langlearn.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import ru.psavinov.liferay.langlearn.NoSuchLLSettingsException;
import ru.psavinov.liferay.langlearn.model.LLSettings;
import ru.psavinov.liferay.langlearn.service.base.LLSettingsLocalServiceBaseImpl;
import ru.psavinov.liferay.langlearn.service.persistence.LLSettingsUtil;

/**
 * The implementation of the LangLearnSettings local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.psavinov.liferay.langlearn.service.LLSettingsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pavel Savinov
 * @see ru.psavinov.liferay.langlearn.service.base.LLSettingsLocalServiceBaseImpl
 * @see ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil
 */
public class LLSettingsLocalServiceImpl extends LLSettingsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil} to access the LangLearnSettings local service.
	 */
	public LLSettings findByUserId(long userId) throws NoSuchLLSettingsException, SystemException {
		return LLSettingsUtil.findByUserId(userId);
	}
}
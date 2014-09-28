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

package ru.psavinov.liferay.langlearn.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.psavinov.liferay.langlearn.model.LLSettings;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LLSettings in entity cache.
 *
 * @author Pavel Savinov
 * @see LLSettings
 * @generated
 */
public class LLSettingsCacheModel implements CacheModel<LLSettings>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{settingsId=");
		sb.append(settingsId);
		sb.append(", localeFrom=");
		sb.append(localeFrom);
		sb.append(", localeTo=");
		sb.append(localeTo);
		sb.append(", wordsPerDay=");
		sb.append(wordsPerDay);
		sb.append(", mode=");
		sb.append(mode);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public LLSettings toEntityModel() {
		LLSettingsImpl llSettingsImpl = new LLSettingsImpl();

		llSettingsImpl.setSettingsId(settingsId);

		if (localeFrom == null) {
			llSettingsImpl.setLocaleFrom(StringPool.BLANK);
		}
		else {
			llSettingsImpl.setLocaleFrom(localeFrom);
		}

		if (localeTo == null) {
			llSettingsImpl.setLocaleTo(StringPool.BLANK);
		}
		else {
			llSettingsImpl.setLocaleTo(localeTo);
		}

		llSettingsImpl.setWordsPerDay(wordsPerDay);
		llSettingsImpl.setMode(mode);
		llSettingsImpl.setCompanyId(companyId);
		llSettingsImpl.setUserId(userId);

		if (userName == null) {
			llSettingsImpl.setUserName(StringPool.BLANK);
		}
		else {
			llSettingsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			llSettingsImpl.setCreateDate(null);
		}
		else {
			llSettingsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			llSettingsImpl.setModifiedDate(null);
		}
		else {
			llSettingsImpl.setModifiedDate(new Date(modifiedDate));
		}

		llSettingsImpl.resetOriginalValues();

		return llSettingsImpl;
	}

	public long settingsId;
	public String localeFrom;
	public String localeTo;
	public int wordsPerDay;
	public int mode;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
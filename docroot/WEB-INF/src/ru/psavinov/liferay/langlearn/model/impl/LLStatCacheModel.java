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

import ru.psavinov.liferay.langlearn.model.LLStat;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LLStat in entity cache.
 *
 * @author Pavel Savinov
 * @see LLStat
 * @generated
 */
public class LLStatCacheModel implements CacheModel<LLStat>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{statId=");
		sb.append(statId);
		sb.append(", statType=");
		sb.append(statType);
		sb.append(", statString=");
		sb.append(statString);
		sb.append(", statInt=");
		sb.append(statInt);
		sb.append(", statLong=");
		sb.append(statLong);
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

	public LLStat toEntityModel() {
		LLStatImpl llStatImpl = new LLStatImpl();

		llStatImpl.setStatId(statId);
		llStatImpl.setStatType(statType);

		if (statString == null) {
			llStatImpl.setStatString(StringPool.BLANK);
		}
		else {
			llStatImpl.setStatString(statString);
		}

		llStatImpl.setStatInt(statInt);
		llStatImpl.setStatLong(statLong);
		llStatImpl.setCompanyId(companyId);
		llStatImpl.setUserId(userId);

		if (userName == null) {
			llStatImpl.setUserName(StringPool.BLANK);
		}
		else {
			llStatImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			llStatImpl.setCreateDate(null);
		}
		else {
			llStatImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			llStatImpl.setModifiedDate(null);
		}
		else {
			llStatImpl.setModifiedDate(new Date(modifiedDate));
		}

		llStatImpl.resetOriginalValues();

		return llStatImpl;
	}

	public long statId;
	public int statType;
	public String statString;
	public int statInt;
	public long statLong;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
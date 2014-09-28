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

import ru.psavinov.liferay.langlearn.model.LLWordPair;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LLWordPair in entity cache.
 *
 * @author Pavel Savinov
 * @see LLWordPair
 * @generated
 */
public class LLWordPairCacheModel implements CacheModel<LLWordPair>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{wordPairId=");
		sb.append(wordPairId);
		sb.append(", wordFromId=");
		sb.append(wordFromId);
		sb.append(", wordToId=");
		sb.append(wordToId);
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

	public LLWordPair toEntityModel() {
		LLWordPairImpl llWordPairImpl = new LLWordPairImpl();

		llWordPairImpl.setWordPairId(wordPairId);
		llWordPairImpl.setWordFromId(wordFromId);
		llWordPairImpl.setWordToId(wordToId);
		llWordPairImpl.setCompanyId(companyId);
		llWordPairImpl.setUserId(userId);

		if (userName == null) {
			llWordPairImpl.setUserName(StringPool.BLANK);
		}
		else {
			llWordPairImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			llWordPairImpl.setCreateDate(null);
		}
		else {
			llWordPairImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			llWordPairImpl.setModifiedDate(null);
		}
		else {
			llWordPairImpl.setModifiedDate(new Date(modifiedDate));
		}

		llWordPairImpl.resetOriginalValues();

		return llWordPairImpl;
	}

	public long wordPairId;
	public long wordFromId;
	public long wordToId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
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

import ru.psavinov.liferay.langlearn.model.LLWord;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LLWord in entity cache.
 *
 * @author Pavel Savinov
 * @see LLWord
 * @generated
 */
public class LLWordCacheModel implements CacheModel<LLWord>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{wordId=");
		sb.append(wordId);
		sb.append(", locale=");
		sb.append(locale);
		sb.append(", word=");
		sb.append(word);
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

	public LLWord toEntityModel() {
		LLWordImpl llWordImpl = new LLWordImpl();

		llWordImpl.setWordId(wordId);

		if (locale == null) {
			llWordImpl.setLocale(StringPool.BLANK);
		}
		else {
			llWordImpl.setLocale(locale);
		}

		if (word == null) {
			llWordImpl.setWord(StringPool.BLANK);
		}
		else {
			llWordImpl.setWord(word);
		}

		llWordImpl.setCompanyId(companyId);
		llWordImpl.setUserId(userId);

		if (userName == null) {
			llWordImpl.setUserName(StringPool.BLANK);
		}
		else {
			llWordImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			llWordImpl.setCreateDate(null);
		}
		else {
			llWordImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			llWordImpl.setModifiedDate(null);
		}
		else {
			llWordImpl.setModifiedDate(new Date(modifiedDate));
		}

		llWordImpl.resetOriginalValues();

		return llWordImpl;
	}

	public long wordId;
	public String locale;
	public String word;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
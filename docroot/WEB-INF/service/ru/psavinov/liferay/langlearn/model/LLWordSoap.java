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

package ru.psavinov.liferay.langlearn.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ru.psavinov.liferay.langlearn.service.http.LLWordServiceSoap}.
 *
 * @author    Pavel Savinov
 * @see       ru.psavinov.liferay.langlearn.service.http.LLWordServiceSoap
 * @generated
 */
public class LLWordSoap implements Serializable {
	public static LLWordSoap toSoapModel(LLWord model) {
		LLWordSoap soapModel = new LLWordSoap();

		soapModel.setWordId(model.getWordId());
		soapModel.setLocale(model.getLocale());
		soapModel.setWord(model.getWord());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LLWordSoap[] toSoapModels(LLWord[] models) {
		LLWordSoap[] soapModels = new LLWordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LLWordSoap[][] toSoapModels(LLWord[][] models) {
		LLWordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LLWordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LLWordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LLWordSoap[] toSoapModels(List<LLWord> models) {
		List<LLWordSoap> soapModels = new ArrayList<LLWordSoap>(models.size());

		for (LLWord model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LLWordSoap[soapModels.size()]);
	}

	public LLWordSoap() {
	}

	public long getPrimaryKey() {
		return _wordId;
	}

	public void setPrimaryKey(long pk) {
		setWordId(pk);
	}

	public long getWordId() {
		return _wordId;
	}

	public void setWordId(long wordId) {
		_wordId = wordId;
	}

	public String getLocale() {
		return _locale;
	}

	public void setLocale(String locale) {
		_locale = locale;
	}

	public String getWord() {
		return _word;
	}

	public void setWord(String word) {
		_word = word;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _wordId;
	private String _locale;
	private String _word;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
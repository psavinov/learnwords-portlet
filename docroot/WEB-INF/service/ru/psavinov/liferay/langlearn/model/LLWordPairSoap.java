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
 * This class is used by SOAP remote services, specifically {@link ru.psavinov.liferay.langlearn.service.http.LLWordPairServiceSoap}.
 *
 * @author    Pavel Savinov
 * @see       ru.psavinov.liferay.langlearn.service.http.LLWordPairServiceSoap
 * @generated
 */
public class LLWordPairSoap implements Serializable {
	public static LLWordPairSoap toSoapModel(LLWordPair model) {
		LLWordPairSoap soapModel = new LLWordPairSoap();

		soapModel.setWordPairId(model.getWordPairId());
		soapModel.setWordFromId(model.getWordFromId());
		soapModel.setWordToId(model.getWordToId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LLWordPairSoap[] toSoapModels(LLWordPair[] models) {
		LLWordPairSoap[] soapModels = new LLWordPairSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LLWordPairSoap[][] toSoapModels(LLWordPair[][] models) {
		LLWordPairSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LLWordPairSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LLWordPairSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LLWordPairSoap[] toSoapModels(List<LLWordPair> models) {
		List<LLWordPairSoap> soapModels = new ArrayList<LLWordPairSoap>(models.size());

		for (LLWordPair model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LLWordPairSoap[soapModels.size()]);
	}

	public LLWordPairSoap() {
	}

	public long getPrimaryKey() {
		return _wordPairId;
	}

	public void setPrimaryKey(long pk) {
		setWordPairId(pk);
	}

	public long getWordPairId() {
		return _wordPairId;
	}

	public void setWordPairId(long wordPairId) {
		_wordPairId = wordPairId;
	}

	public long getWordFromId() {
		return _wordFromId;
	}

	public void setWordFromId(long wordFromId) {
		_wordFromId = wordFromId;
	}

	public long getWordToId() {
		return _wordToId;
	}

	public void setWordToId(long wordToId) {
		_wordToId = wordToId;
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

	private long _wordPairId;
	private long _wordFromId;
	private long _wordToId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
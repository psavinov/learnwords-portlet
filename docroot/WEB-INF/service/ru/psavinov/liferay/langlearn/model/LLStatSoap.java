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
 * This class is used by SOAP remote services, specifically {@link ru.psavinov.liferay.langlearn.service.http.LLStatServiceSoap}.
 *
 * @author    Pavel Savinov
 * @see       ru.psavinov.liferay.langlearn.service.http.LLStatServiceSoap
 * @generated
 */
public class LLStatSoap implements Serializable {
	public static LLStatSoap toSoapModel(LLStat model) {
		LLStatSoap soapModel = new LLStatSoap();

		soapModel.setStatId(model.getStatId());
		soapModel.setStatType(model.getStatType());
		soapModel.setStatString(model.getStatString());
		soapModel.setStatInt(model.getStatInt());
		soapModel.setStatLong(model.getStatLong());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LLStatSoap[] toSoapModels(LLStat[] models) {
		LLStatSoap[] soapModels = new LLStatSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LLStatSoap[][] toSoapModels(LLStat[][] models) {
		LLStatSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LLStatSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LLStatSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LLStatSoap[] toSoapModels(List<LLStat> models) {
		List<LLStatSoap> soapModels = new ArrayList<LLStatSoap>(models.size());

		for (LLStat model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LLStatSoap[soapModels.size()]);
	}

	public LLStatSoap() {
	}

	public long getPrimaryKey() {
		return _statId;
	}

	public void setPrimaryKey(long pk) {
		setStatId(pk);
	}

	public long getStatId() {
		return _statId;
	}

	public void setStatId(long statId) {
		_statId = statId;
	}

	public int getStatType() {
		return _statType;
	}

	public void setStatType(int statType) {
		_statType = statType;
	}

	public String getStatString() {
		return _statString;
	}

	public void setStatString(String statString) {
		_statString = statString;
	}

	public int getStatInt() {
		return _statInt;
	}

	public void setStatInt(int statInt) {
		_statInt = statInt;
	}

	public long getStatLong() {
		return _statLong;
	}

	public void setStatLong(long statLong) {
		_statLong = statLong;
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

	private long _statId;
	private int _statType;
	private String _statString;
	private int _statInt;
	private long _statLong;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
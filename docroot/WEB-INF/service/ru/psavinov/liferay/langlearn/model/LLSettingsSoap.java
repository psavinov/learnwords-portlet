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
 * This class is used by SOAP remote services, specifically {@link ru.psavinov.liferay.langlearn.service.http.LLSettingsServiceSoap}.
 *
 * @author    Pavel Savinov
 * @see       ru.psavinov.liferay.langlearn.service.http.LLSettingsServiceSoap
 * @generated
 */
public class LLSettingsSoap implements Serializable {
	public static LLSettingsSoap toSoapModel(LLSettings model) {
		LLSettingsSoap soapModel = new LLSettingsSoap();

		soapModel.setSettingsId(model.getSettingsId());
		soapModel.setLocaleFrom(model.getLocaleFrom());
		soapModel.setLocaleTo(model.getLocaleTo());
		soapModel.setWordsPerDay(model.getWordsPerDay());
		soapModel.setMode(model.getMode());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LLSettingsSoap[] toSoapModels(LLSettings[] models) {
		LLSettingsSoap[] soapModels = new LLSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LLSettingsSoap[][] toSoapModels(LLSettings[][] models) {
		LLSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LLSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LLSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LLSettingsSoap[] toSoapModels(List<LLSettings> models) {
		List<LLSettingsSoap> soapModels = new ArrayList<LLSettingsSoap>(models.size());

		for (LLSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LLSettingsSoap[soapModels.size()]);
	}

	public LLSettingsSoap() {
	}

	public long getPrimaryKey() {
		return _settingsId;
	}

	public void setPrimaryKey(long pk) {
		setSettingsId(pk);
	}

	public long getSettingsId() {
		return _settingsId;
	}

	public void setSettingsId(long settingsId) {
		_settingsId = settingsId;
	}

	public String getLocaleFrom() {
		return _localeFrom;
	}

	public void setLocaleFrom(String localeFrom) {
		_localeFrom = localeFrom;
	}

	public String getLocaleTo() {
		return _localeTo;
	}

	public void setLocaleTo(String localeTo) {
		_localeTo = localeTo;
	}

	public int getWordsPerDay() {
		return _wordsPerDay;
	}

	public void setWordsPerDay(int wordsPerDay) {
		_wordsPerDay = wordsPerDay;
	}

	public int getMode() {
		return _mode;
	}

	public void setMode(int mode) {
		_mode = mode;
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

	private long _settingsId;
	private String _localeFrom;
	private String _localeTo;
	private int _wordsPerDay;
	private int _mode;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
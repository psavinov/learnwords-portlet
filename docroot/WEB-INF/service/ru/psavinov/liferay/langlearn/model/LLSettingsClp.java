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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Savinov
 */
public class LLSettingsClp extends BaseModelImpl<LLSettings>
	implements LLSettings {
	public LLSettingsClp() {
	}

	public Class<?> getModelClass() {
		return LLSettings.class;
	}

	public String getModelClassName() {
		return LLSettings.class.getName();
	}

	public long getPrimaryKey() {
		return _settingsId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSettingsId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_settingsId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("settingsId", getSettingsId());
		attributes.put("localeFrom", getLocaleFrom());
		attributes.put("localeTo", getLocaleTo());
		attributes.put("wordsPerDay", getWordsPerDay());
		attributes.put("mode", getMode());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long settingsId = (Long)attributes.get("settingsId");

		if (settingsId != null) {
			setSettingsId(settingsId);
		}

		String localeFrom = (String)attributes.get("localeFrom");

		if (localeFrom != null) {
			setLocaleFrom(localeFrom);
		}

		String localeTo = (String)attributes.get("localeTo");

		if (localeTo != null) {
			setLocaleTo(localeTo);
		}

		Integer wordsPerDay = (Integer)attributes.get("wordsPerDay");

		if (wordsPerDay != null) {
			setWordsPerDay(wordsPerDay);
		}

		Integer mode = (Integer)attributes.get("mode");

		if (mode != null) {
			setMode(mode);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public BaseModel<?> getLLSettingsRemoteModel() {
		return _llSettingsRemoteModel;
	}

	public void setLLSettingsRemoteModel(BaseModel<?> llSettingsRemoteModel) {
		_llSettingsRemoteModel = llSettingsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LLSettingsLocalServiceUtil.addLLSettings(this);
		}
		else {
			LLSettingsLocalServiceUtil.updateLLSettings(this);
		}
	}

	@Override
	public LLSettings toEscapedModel() {
		return (LLSettings)Proxy.newProxyInstance(LLSettings.class.getClassLoader(),
			new Class[] { LLSettings.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LLSettingsClp clone = new LLSettingsClp();

		clone.setSettingsId(getSettingsId());
		clone.setLocaleFrom(getLocaleFrom());
		clone.setLocaleTo(getLocaleTo());
		clone.setWordsPerDay(getWordsPerDay());
		clone.setMode(getMode());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(LLSettings llSettings) {
		long primaryKey = llSettings.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LLSettingsClp llSettings = null;

		try {
			llSettings = (LLSettingsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = llSettings.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{settingsId=");
		sb.append(getSettingsId());
		sb.append(", localeFrom=");
		sb.append(getLocaleFrom());
		sb.append(", localeTo=");
		sb.append(getLocaleTo());
		sb.append(", wordsPerDay=");
		sb.append(getWordsPerDay());
		sb.append(", mode=");
		sb.append(getMode());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("ru.psavinov.liferay.langlearn.model.LLSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>settingsId</column-name><column-value><![CDATA[");
		sb.append(getSettingsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeFrom</column-name><column-value><![CDATA[");
		sb.append(getLocaleFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeTo</column-name><column-value><![CDATA[");
		sb.append(getLocaleTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wordsPerDay</column-name><column-value><![CDATA[");
		sb.append(getWordsPerDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mode</column-name><column-value><![CDATA[");
		sb.append(getMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _settingsId;
	private String _localeFrom;
	private String _localeTo;
	private int _wordsPerDay;
	private int _mode;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _llSettingsRemoteModel;
}
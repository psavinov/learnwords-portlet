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

import ru.psavinov.liferay.langlearn.service.LLStatLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Savinov
 */
public class LLStatClp extends BaseModelImpl<LLStat> implements LLStat {
	public LLStatClp() {
	}

	public Class<?> getModelClass() {
		return LLStat.class;
	}

	public String getModelClassName() {
		return LLStat.class.getName();
	}

	public long getPrimaryKey() {
		return _statId;
	}

	public void setPrimaryKey(long primaryKey) {
		setStatId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_statId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("statId", getStatId());
		attributes.put("statType", getStatType());
		attributes.put("statString", getStatString());
		attributes.put("statInt", getStatInt());
		attributes.put("statLong", getStatLong());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long statId = (Long)attributes.get("statId");

		if (statId != null) {
			setStatId(statId);
		}

		Integer statType = (Integer)attributes.get("statType");

		if (statType != null) {
			setStatType(statType);
		}

		String statString = (String)attributes.get("statString");

		if (statString != null) {
			setStatString(statString);
		}

		Integer statInt = (Integer)attributes.get("statInt");

		if (statInt != null) {
			setStatInt(statInt);
		}

		Long statLong = (Long)attributes.get("statLong");

		if (statLong != null) {
			setStatLong(statLong);
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

	public BaseModel<?> getLLStatRemoteModel() {
		return _llStatRemoteModel;
	}

	public void setLLStatRemoteModel(BaseModel<?> llStatRemoteModel) {
		_llStatRemoteModel = llStatRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LLStatLocalServiceUtil.addLLStat(this);
		}
		else {
			LLStatLocalServiceUtil.updateLLStat(this);
		}
	}

	@Override
	public LLStat toEscapedModel() {
		return (LLStat)Proxy.newProxyInstance(LLStat.class.getClassLoader(),
			new Class[] { LLStat.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LLStatClp clone = new LLStatClp();

		clone.setStatId(getStatId());
		clone.setStatType(getStatType());
		clone.setStatString(getStatString());
		clone.setStatInt(getStatInt());
		clone.setStatLong(getStatLong());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(LLStat llStat) {
		long primaryKey = llStat.getPrimaryKey();

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

		LLStatClp llStat = null;

		try {
			llStat = (LLStatClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = llStat.getPrimaryKey();

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

		sb.append("{statId=");
		sb.append(getStatId());
		sb.append(", statType=");
		sb.append(getStatType());
		sb.append(", statString=");
		sb.append(getStatString());
		sb.append(", statInt=");
		sb.append(getStatInt());
		sb.append(", statLong=");
		sb.append(getStatLong());
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
		sb.append("ru.psavinov.liferay.langlearn.model.LLStat");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statId</column-name><column-value><![CDATA[");
		sb.append(getStatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statType</column-name><column-value><![CDATA[");
		sb.append(getStatType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statString</column-name><column-value><![CDATA[");
		sb.append(getStatString());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statInt</column-name><column-value><![CDATA[");
		sb.append(getStatInt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statLong</column-name><column-value><![CDATA[");
		sb.append(getStatLong());
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

	private long _statId;
	private int _statType;
	private String _statString;
	private int _statInt;
	private long _statLong;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _llStatRemoteModel;
}
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

import ru.psavinov.liferay.langlearn.service.LLWordPairLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Savinov
 */
public class LLWordPairClp extends BaseModelImpl<LLWordPair>
	implements LLWordPair {
	public LLWordPairClp() {
	}

	public Class<?> getModelClass() {
		return LLWordPair.class;
	}

	public String getModelClassName() {
		return LLWordPair.class.getName();
	}

	public long getPrimaryKey() {
		return _wordPairId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWordPairId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_wordPairId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wordPairId", getWordPairId());
		attributes.put("wordFromId", getWordFromId());
		attributes.put("wordToId", getWordToId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wordPairId = (Long)attributes.get("wordPairId");

		if (wordPairId != null) {
			setWordPairId(wordPairId);
		}

		Long wordFromId = (Long)attributes.get("wordFromId");

		if (wordFromId != null) {
			setWordFromId(wordFromId);
		}

		Long wordToId = (Long)attributes.get("wordToId");

		if (wordToId != null) {
			setWordToId(wordToId);
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

	public BaseModel<?> getLLWordPairRemoteModel() {
		return _llWordPairRemoteModel;
	}

	public void setLLWordPairRemoteModel(BaseModel<?> llWordPairRemoteModel) {
		_llWordPairRemoteModel = llWordPairRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LLWordPairLocalServiceUtil.addLLWordPair(this);
		}
		else {
			LLWordPairLocalServiceUtil.updateLLWordPair(this);
		}
	}

	@Override
	public LLWordPair toEscapedModel() {
		return (LLWordPair)Proxy.newProxyInstance(LLWordPair.class.getClassLoader(),
			new Class[] { LLWordPair.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LLWordPairClp clone = new LLWordPairClp();

		clone.setWordPairId(getWordPairId());
		clone.setWordFromId(getWordFromId());
		clone.setWordToId(getWordToId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(LLWordPair llWordPair) {
		long primaryKey = llWordPair.getPrimaryKey();

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

		LLWordPairClp llWordPair = null;

		try {
			llWordPair = (LLWordPairClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = llWordPair.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{wordPairId=");
		sb.append(getWordPairId());
		sb.append(", wordFromId=");
		sb.append(getWordFromId());
		sb.append(", wordToId=");
		sb.append(getWordToId());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("ru.psavinov.liferay.langlearn.model.LLWordPair");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wordPairId</column-name><column-value><![CDATA[");
		sb.append(getWordPairId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wordFromId</column-name><column-value><![CDATA[");
		sb.append(getWordFromId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wordToId</column-name><column-value><![CDATA[");
		sb.append(getWordToId());
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

	private long _wordPairId;
	private long _wordFromId;
	private long _wordToId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _llWordPairRemoteModel;
}
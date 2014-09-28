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

import ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Savinov
 */
public class LLWordClp extends BaseModelImpl<LLWord> implements LLWord {
	public LLWordClp() {
	}

	public Class<?> getModelClass() {
		return LLWord.class;
	}

	public String getModelClassName() {
		return LLWord.class.getName();
	}

	public long getPrimaryKey() {
		return _wordId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWordId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_wordId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wordId", getWordId());
		attributes.put("locale", getLocale());
		attributes.put("word", getWord());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wordId = (Long)attributes.get("wordId");

		if (wordId != null) {
			setWordId(wordId);
		}

		String locale = (String)attributes.get("locale");

		if (locale != null) {
			setLocale(locale);
		}

		String word = (String)attributes.get("word");

		if (word != null) {
			setWord(word);
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

	public BaseModel<?> getLLWordRemoteModel() {
		return _llWordRemoteModel;
	}

	public void setLLWordRemoteModel(BaseModel<?> llWordRemoteModel) {
		_llWordRemoteModel = llWordRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LLWordLocalServiceUtil.addLLWord(this);
		}
		else {
			LLWordLocalServiceUtil.updateLLWord(this);
		}
	}

	@Override
	public LLWord toEscapedModel() {
		return (LLWord)Proxy.newProxyInstance(LLWord.class.getClassLoader(),
			new Class[] { LLWord.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LLWordClp clone = new LLWordClp();

		clone.setWordId(getWordId());
		clone.setLocale(getLocale());
		clone.setWord(getWord());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(LLWord llWord) {
		long primaryKey = llWord.getPrimaryKey();

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

		LLWordClp llWord = null;

		try {
			llWord = (LLWordClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = llWord.getPrimaryKey();

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

		sb.append("{wordId=");
		sb.append(getWordId());
		sb.append(", locale=");
		sb.append(getLocale());
		sb.append(", word=");
		sb.append(getWord());
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
		sb.append("ru.psavinov.liferay.langlearn.model.LLWord");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wordId</column-name><column-value><![CDATA[");
		sb.append(getWordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locale</column-name><column-value><![CDATA[");
		sb.append(getLocale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>word</column-name><column-value><![CDATA[");
		sb.append(getWord());
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

	private long _wordId;
	private String _locale;
	private String _word;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _llWordRemoteModel;
}
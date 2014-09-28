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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import ru.psavinov.liferay.langlearn.model.LLSettings;
import ru.psavinov.liferay.langlearn.model.LLSettingsModel;
import ru.psavinov.liferay.langlearn.model.LLSettingsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LLSettings service. Represents a row in the &quot;LangLearn_LLSettings&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ru.psavinov.liferay.langlearn.model.LLSettingsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LLSettingsImpl}.
 * </p>
 *
 * @author Pavel Savinov
 * @see LLSettingsImpl
 * @see ru.psavinov.liferay.langlearn.model.LLSettings
 * @see ru.psavinov.liferay.langlearn.model.LLSettingsModel
 * @generated
 */
@JSON(strict = true)
public class LLSettingsModelImpl extends BaseModelImpl<LLSettings>
	implements LLSettingsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a LangLearnSettings model instance should use the {@link ru.psavinov.liferay.langlearn.model.LLSettings} interface instead.
	 */
	public static final String TABLE_NAME = "LangLearn_LLSettings";
	public static final Object[][] TABLE_COLUMNS = {
			{ "settingsId", Types.BIGINT },
			{ "localeFrom", Types.VARCHAR },
			{ "localeTo", Types.VARCHAR },
			{ "wordsPerDay", Types.INTEGER },
			{ "mode_", Types.INTEGER },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table LangLearn_LLSettings (settingsId LONG not null primary key,localeFrom VARCHAR(75) null,localeTo VARCHAR(75) null,wordsPerDay INTEGER,mode_ INTEGER,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table LangLearn_LLSettings";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.ru.psavinov.liferay.langlearn.model.LLSettings"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.ru.psavinov.liferay.langlearn.model.LLSettings"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.ru.psavinov.liferay.langlearn.model.LLSettings"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LLSettings toModel(LLSettingsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LLSettings model = new LLSettingsImpl();

		model.setSettingsId(soapModel.getSettingsId());
		model.setLocaleFrom(soapModel.getLocaleFrom());
		model.setLocaleTo(soapModel.getLocaleTo());
		model.setWordsPerDay(soapModel.getWordsPerDay());
		model.setMode(soapModel.getMode());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LLSettings> toModels(LLSettingsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LLSettings> models = new ArrayList<LLSettings>(soapModels.length);

		for (LLSettingsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.ru.psavinov.liferay.langlearn.model.LLSettings"));

	public LLSettingsModelImpl() {
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

	public Class<?> getModelClass() {
		return LLSettings.class;
	}

	public String getModelClassName() {
		return LLSettings.class.getName();
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

	@JSON
	public long getSettingsId() {
		return _settingsId;
	}

	public void setSettingsId(long settingsId) {
		_settingsId = settingsId;
	}

	@JSON
	public String getLocaleFrom() {
		if (_localeFrom == null) {
			return StringPool.BLANK;
		}
		else {
			return _localeFrom;
		}
	}

	public void setLocaleFrom(String localeFrom) {
		_localeFrom = localeFrom;
	}

	@JSON
	public String getLocaleTo() {
		if (_localeTo == null) {
			return StringPool.BLANK;
		}
		else {
			return _localeTo;
		}
	}

	public void setLocaleTo(String localeTo) {
		_localeTo = localeTo;
	}

	@JSON
	public int getWordsPerDay() {
		return _wordsPerDay;
	}

	public void setWordsPerDay(int wordsPerDay) {
		_wordsPerDay = wordsPerDay;
	}

	@JSON
	public int getMode() {
		return _mode;
	}

	public void setMode(int mode) {
		_mode = mode;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			LLSettings.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LLSettings toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (LLSettings)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		LLSettingsImpl llSettingsImpl = new LLSettingsImpl();

		llSettingsImpl.setSettingsId(getSettingsId());
		llSettingsImpl.setLocaleFrom(getLocaleFrom());
		llSettingsImpl.setLocaleTo(getLocaleTo());
		llSettingsImpl.setWordsPerDay(getWordsPerDay());
		llSettingsImpl.setMode(getMode());
		llSettingsImpl.setCompanyId(getCompanyId());
		llSettingsImpl.setUserId(getUserId());
		llSettingsImpl.setUserName(getUserName());
		llSettingsImpl.setCreateDate(getCreateDate());
		llSettingsImpl.setModifiedDate(getModifiedDate());

		llSettingsImpl.resetOriginalValues();

		return llSettingsImpl;
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

		LLSettings llSettings = null;

		try {
			llSettings = (LLSettings)obj;
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
	public void resetOriginalValues() {
		LLSettingsModelImpl llSettingsModelImpl = this;

		llSettingsModelImpl._originalUserId = llSettingsModelImpl._userId;

		llSettingsModelImpl._setOriginalUserId = false;

		llSettingsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LLSettings> toCacheModel() {
		LLSettingsCacheModel llSettingsCacheModel = new LLSettingsCacheModel();

		llSettingsCacheModel.settingsId = getSettingsId();

		llSettingsCacheModel.localeFrom = getLocaleFrom();

		String localeFrom = llSettingsCacheModel.localeFrom;

		if ((localeFrom != null) && (localeFrom.length() == 0)) {
			llSettingsCacheModel.localeFrom = null;
		}

		llSettingsCacheModel.localeTo = getLocaleTo();

		String localeTo = llSettingsCacheModel.localeTo;

		if ((localeTo != null) && (localeTo.length() == 0)) {
			llSettingsCacheModel.localeTo = null;
		}

		llSettingsCacheModel.wordsPerDay = getWordsPerDay();

		llSettingsCacheModel.mode = getMode();

		llSettingsCacheModel.companyId = getCompanyId();

		llSettingsCacheModel.userId = getUserId();

		llSettingsCacheModel.userName = getUserName();

		String userName = llSettingsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			llSettingsCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			llSettingsCacheModel.createDate = createDate.getTime();
		}
		else {
			llSettingsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			llSettingsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			llSettingsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return llSettingsCacheModel;
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

	private static ClassLoader _classLoader = LLSettings.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			LLSettings.class
		};
	private long _settingsId;
	private String _localeFrom;
	private String _localeTo;
	private int _wordsPerDay;
	private int _mode;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private LLSettings _escapedModelProxy;
}
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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LLSettings}.
 * </p>
 *
 * @author    Pavel Savinov
 * @see       LLSettings
 * @generated
 */
public class LLSettingsWrapper implements LLSettings, ModelWrapper<LLSettings> {
	public LLSettingsWrapper(LLSettings llSettings) {
		_llSettings = llSettings;
	}

	public Class<?> getModelClass() {
		return LLSettings.class;
	}

	public String getModelClassName() {
		return LLSettings.class.getName();
	}

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

	/**
	* Returns the primary key of this LangLearnSettings.
	*
	* @return the primary key of this LangLearnSettings
	*/
	public long getPrimaryKey() {
		return _llSettings.getPrimaryKey();
	}

	/**
	* Sets the primary key of this LangLearnSettings.
	*
	* @param primaryKey the primary key of this LangLearnSettings
	*/
	public void setPrimaryKey(long primaryKey) {
		_llSettings.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the settings ID of this LangLearnSettings.
	*
	* @return the settings ID of this LangLearnSettings
	*/
	public long getSettingsId() {
		return _llSettings.getSettingsId();
	}

	/**
	* Sets the settings ID of this LangLearnSettings.
	*
	* @param settingsId the settings ID of this LangLearnSettings
	*/
	public void setSettingsId(long settingsId) {
		_llSettings.setSettingsId(settingsId);
	}

	/**
	* Returns the locale from of this LangLearnSettings.
	*
	* @return the locale from of this LangLearnSettings
	*/
	public java.lang.String getLocaleFrom() {
		return _llSettings.getLocaleFrom();
	}

	/**
	* Sets the locale from of this LangLearnSettings.
	*
	* @param localeFrom the locale from of this LangLearnSettings
	*/
	public void setLocaleFrom(java.lang.String localeFrom) {
		_llSettings.setLocaleFrom(localeFrom);
	}

	/**
	* Returns the locale to of this LangLearnSettings.
	*
	* @return the locale to of this LangLearnSettings
	*/
	public java.lang.String getLocaleTo() {
		return _llSettings.getLocaleTo();
	}

	/**
	* Sets the locale to of this LangLearnSettings.
	*
	* @param localeTo the locale to of this LangLearnSettings
	*/
	public void setLocaleTo(java.lang.String localeTo) {
		_llSettings.setLocaleTo(localeTo);
	}

	/**
	* Returns the words per day of this LangLearnSettings.
	*
	* @return the words per day of this LangLearnSettings
	*/
	public int getWordsPerDay() {
		return _llSettings.getWordsPerDay();
	}

	/**
	* Sets the words per day of this LangLearnSettings.
	*
	* @param wordsPerDay the words per day of this LangLearnSettings
	*/
	public void setWordsPerDay(int wordsPerDay) {
		_llSettings.setWordsPerDay(wordsPerDay);
	}

	/**
	* Returns the mode of this LangLearnSettings.
	*
	* @return the mode of this LangLearnSettings
	*/
	public int getMode() {
		return _llSettings.getMode();
	}

	/**
	* Sets the mode of this LangLearnSettings.
	*
	* @param mode the mode of this LangLearnSettings
	*/
	public void setMode(int mode) {
		_llSettings.setMode(mode);
	}

	/**
	* Returns the company ID of this LangLearnSettings.
	*
	* @return the company ID of this LangLearnSettings
	*/
	public long getCompanyId() {
		return _llSettings.getCompanyId();
	}

	/**
	* Sets the company ID of this LangLearnSettings.
	*
	* @param companyId the company ID of this LangLearnSettings
	*/
	public void setCompanyId(long companyId) {
		_llSettings.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this LangLearnSettings.
	*
	* @return the user ID of this LangLearnSettings
	*/
	public long getUserId() {
		return _llSettings.getUserId();
	}

	/**
	* Sets the user ID of this LangLearnSettings.
	*
	* @param userId the user ID of this LangLearnSettings
	*/
	public void setUserId(long userId) {
		_llSettings.setUserId(userId);
	}

	/**
	* Returns the user uuid of this LangLearnSettings.
	*
	* @return the user uuid of this LangLearnSettings
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettings.getUserUuid();
	}

	/**
	* Sets the user uuid of this LangLearnSettings.
	*
	* @param userUuid the user uuid of this LangLearnSettings
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_llSettings.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this LangLearnSettings.
	*
	* @return the user name of this LangLearnSettings
	*/
	public java.lang.String getUserName() {
		return _llSettings.getUserName();
	}

	/**
	* Sets the user name of this LangLearnSettings.
	*
	* @param userName the user name of this LangLearnSettings
	*/
	public void setUserName(java.lang.String userName) {
		_llSettings.setUserName(userName);
	}

	/**
	* Returns the create date of this LangLearnSettings.
	*
	* @return the create date of this LangLearnSettings
	*/
	public java.util.Date getCreateDate() {
		return _llSettings.getCreateDate();
	}

	/**
	* Sets the create date of this LangLearnSettings.
	*
	* @param createDate the create date of this LangLearnSettings
	*/
	public void setCreateDate(java.util.Date createDate) {
		_llSettings.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this LangLearnSettings.
	*
	* @return the modified date of this LangLearnSettings
	*/
	public java.util.Date getModifiedDate() {
		return _llSettings.getModifiedDate();
	}

	/**
	* Sets the modified date of this LangLearnSettings.
	*
	* @param modifiedDate the modified date of this LangLearnSettings
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_llSettings.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _llSettings.isNew();
	}

	public void setNew(boolean n) {
		_llSettings.setNew(n);
	}

	public boolean isCachedModel() {
		return _llSettings.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_llSettings.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _llSettings.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _llSettings.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_llSettings.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _llSettings.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_llSettings.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LLSettingsWrapper((LLSettings)_llSettings.clone());
	}

	public int compareTo(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings) {
		return _llSettings.compareTo(llSettings);
	}

	@Override
	public int hashCode() {
		return _llSettings.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ru.psavinov.liferay.langlearn.model.LLSettings> toCacheModel() {
		return _llSettings.toCacheModel();
	}

	public ru.psavinov.liferay.langlearn.model.LLSettings toEscapedModel() {
		return new LLSettingsWrapper(_llSettings.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _llSettings.toString();
	}

	public java.lang.String toXmlString() {
		return _llSettings.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_llSettings.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LLSettings getWrappedLLSettings() {
		return _llSettings;
	}

	public LLSettings getWrappedModel() {
		return _llSettings;
	}

	public void resetOriginalValues() {
		_llSettings.resetOriginalValues();
	}

	private LLSettings _llSettings;
}
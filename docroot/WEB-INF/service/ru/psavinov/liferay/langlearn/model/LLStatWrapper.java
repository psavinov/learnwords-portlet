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
 * This class is a wrapper for {@link LLStat}.
 * </p>
 *
 * @author    Pavel Savinov
 * @see       LLStat
 * @generated
 */
public class LLStatWrapper implements LLStat, ModelWrapper<LLStat> {
	public LLStatWrapper(LLStat llStat) {
		_llStat = llStat;
	}

	public Class<?> getModelClass() {
		return LLStat.class;
	}

	public String getModelClassName() {
		return LLStat.class.getName();
	}

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

	/**
	* Returns the primary key of this LangLearnStatistics.
	*
	* @return the primary key of this LangLearnStatistics
	*/
	public long getPrimaryKey() {
		return _llStat.getPrimaryKey();
	}

	/**
	* Sets the primary key of this LangLearnStatistics.
	*
	* @param primaryKey the primary key of this LangLearnStatistics
	*/
	public void setPrimaryKey(long primaryKey) {
		_llStat.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the stat ID of this LangLearnStatistics.
	*
	* @return the stat ID of this LangLearnStatistics
	*/
	public long getStatId() {
		return _llStat.getStatId();
	}

	/**
	* Sets the stat ID of this LangLearnStatistics.
	*
	* @param statId the stat ID of this LangLearnStatistics
	*/
	public void setStatId(long statId) {
		_llStat.setStatId(statId);
	}

	/**
	* Returns the stat type of this LangLearnStatistics.
	*
	* @return the stat type of this LangLearnStatistics
	*/
	public int getStatType() {
		return _llStat.getStatType();
	}

	/**
	* Sets the stat type of this LangLearnStatistics.
	*
	* @param statType the stat type of this LangLearnStatistics
	*/
	public void setStatType(int statType) {
		_llStat.setStatType(statType);
	}

	/**
	* Returns the stat string of this LangLearnStatistics.
	*
	* @return the stat string of this LangLearnStatistics
	*/
	public java.lang.String getStatString() {
		return _llStat.getStatString();
	}

	/**
	* Sets the stat string of this LangLearnStatistics.
	*
	* @param statString the stat string of this LangLearnStatistics
	*/
	public void setStatString(java.lang.String statString) {
		_llStat.setStatString(statString);
	}

	/**
	* Returns the stat int of this LangLearnStatistics.
	*
	* @return the stat int of this LangLearnStatistics
	*/
	public int getStatInt() {
		return _llStat.getStatInt();
	}

	/**
	* Sets the stat int of this LangLearnStatistics.
	*
	* @param statInt the stat int of this LangLearnStatistics
	*/
	public void setStatInt(int statInt) {
		_llStat.setStatInt(statInt);
	}

	/**
	* Returns the stat long of this LangLearnStatistics.
	*
	* @return the stat long of this LangLearnStatistics
	*/
	public long getStatLong() {
		return _llStat.getStatLong();
	}

	/**
	* Sets the stat long of this LangLearnStatistics.
	*
	* @param statLong the stat long of this LangLearnStatistics
	*/
	public void setStatLong(long statLong) {
		_llStat.setStatLong(statLong);
	}

	/**
	* Returns the company ID of this LangLearnStatistics.
	*
	* @return the company ID of this LangLearnStatistics
	*/
	public long getCompanyId() {
		return _llStat.getCompanyId();
	}

	/**
	* Sets the company ID of this LangLearnStatistics.
	*
	* @param companyId the company ID of this LangLearnStatistics
	*/
	public void setCompanyId(long companyId) {
		_llStat.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this LangLearnStatistics.
	*
	* @return the user ID of this LangLearnStatistics
	*/
	public long getUserId() {
		return _llStat.getUserId();
	}

	/**
	* Sets the user ID of this LangLearnStatistics.
	*
	* @param userId the user ID of this LangLearnStatistics
	*/
	public void setUserId(long userId) {
		_llStat.setUserId(userId);
	}

	/**
	* Returns the user uuid of this LangLearnStatistics.
	*
	* @return the user uuid of this LangLearnStatistics
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llStat.getUserUuid();
	}

	/**
	* Sets the user uuid of this LangLearnStatistics.
	*
	* @param userUuid the user uuid of this LangLearnStatistics
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_llStat.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this LangLearnStatistics.
	*
	* @return the user name of this LangLearnStatistics
	*/
	public java.lang.String getUserName() {
		return _llStat.getUserName();
	}

	/**
	* Sets the user name of this LangLearnStatistics.
	*
	* @param userName the user name of this LangLearnStatistics
	*/
	public void setUserName(java.lang.String userName) {
		_llStat.setUserName(userName);
	}

	/**
	* Returns the create date of this LangLearnStatistics.
	*
	* @return the create date of this LangLearnStatistics
	*/
	public java.util.Date getCreateDate() {
		return _llStat.getCreateDate();
	}

	/**
	* Sets the create date of this LangLearnStatistics.
	*
	* @param createDate the create date of this LangLearnStatistics
	*/
	public void setCreateDate(java.util.Date createDate) {
		_llStat.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this LangLearnStatistics.
	*
	* @return the modified date of this LangLearnStatistics
	*/
	public java.util.Date getModifiedDate() {
		return _llStat.getModifiedDate();
	}

	/**
	* Sets the modified date of this LangLearnStatistics.
	*
	* @param modifiedDate the modified date of this LangLearnStatistics
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_llStat.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _llStat.isNew();
	}

	public void setNew(boolean n) {
		_llStat.setNew(n);
	}

	public boolean isCachedModel() {
		return _llStat.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_llStat.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _llStat.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _llStat.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_llStat.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _llStat.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_llStat.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LLStatWrapper((LLStat)_llStat.clone());
	}

	public int compareTo(ru.psavinov.liferay.langlearn.model.LLStat llStat) {
		return _llStat.compareTo(llStat);
	}

	@Override
	public int hashCode() {
		return _llStat.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ru.psavinov.liferay.langlearn.model.LLStat> toCacheModel() {
		return _llStat.toCacheModel();
	}

	public ru.psavinov.liferay.langlearn.model.LLStat toEscapedModel() {
		return new LLStatWrapper(_llStat.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _llStat.toString();
	}

	public java.lang.String toXmlString() {
		return _llStat.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_llStat.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LLStat getWrappedLLStat() {
		return _llStat;
	}

	public LLStat getWrappedModel() {
		return _llStat;
	}

	public void resetOriginalValues() {
		_llStat.resetOriginalValues();
	}

	private LLStat _llStat;
}
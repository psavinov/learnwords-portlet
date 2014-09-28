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
 * This class is a wrapper for {@link LLWordPair}.
 * </p>
 *
 * @author    Pavel Savinov
 * @see       LLWordPair
 * @generated
 */
public class LLWordPairWrapper implements LLWordPair, ModelWrapper<LLWordPair> {
	public LLWordPairWrapper(LLWordPair llWordPair) {
		_llWordPair = llWordPair;
	}

	public Class<?> getModelClass() {
		return LLWordPair.class;
	}

	public String getModelClassName() {
		return LLWordPair.class.getName();
	}

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

	/**
	* Returns the primary key of this LangLearnWordPair.
	*
	* @return the primary key of this LangLearnWordPair
	*/
	public long getPrimaryKey() {
		return _llWordPair.getPrimaryKey();
	}

	/**
	* Sets the primary key of this LangLearnWordPair.
	*
	* @param primaryKey the primary key of this LangLearnWordPair
	*/
	public void setPrimaryKey(long primaryKey) {
		_llWordPair.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the word pair ID of this LangLearnWordPair.
	*
	* @return the word pair ID of this LangLearnWordPair
	*/
	public long getWordPairId() {
		return _llWordPair.getWordPairId();
	}

	/**
	* Sets the word pair ID of this LangLearnWordPair.
	*
	* @param wordPairId the word pair ID of this LangLearnWordPair
	*/
	public void setWordPairId(long wordPairId) {
		_llWordPair.setWordPairId(wordPairId);
	}

	/**
	* Returns the word from ID of this LangLearnWordPair.
	*
	* @return the word from ID of this LangLearnWordPair
	*/
	public long getWordFromId() {
		return _llWordPair.getWordFromId();
	}

	/**
	* Sets the word from ID of this LangLearnWordPair.
	*
	* @param wordFromId the word from ID of this LangLearnWordPair
	*/
	public void setWordFromId(long wordFromId) {
		_llWordPair.setWordFromId(wordFromId);
	}

	/**
	* Returns the word to ID of this LangLearnWordPair.
	*
	* @return the word to ID of this LangLearnWordPair
	*/
	public long getWordToId() {
		return _llWordPair.getWordToId();
	}

	/**
	* Sets the word to ID of this LangLearnWordPair.
	*
	* @param wordToId the word to ID of this LangLearnWordPair
	*/
	public void setWordToId(long wordToId) {
		_llWordPair.setWordToId(wordToId);
	}

	/**
	* Returns the company ID of this LangLearnWordPair.
	*
	* @return the company ID of this LangLearnWordPair
	*/
	public long getCompanyId() {
		return _llWordPair.getCompanyId();
	}

	/**
	* Sets the company ID of this LangLearnWordPair.
	*
	* @param companyId the company ID of this LangLearnWordPair
	*/
	public void setCompanyId(long companyId) {
		_llWordPair.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this LangLearnWordPair.
	*
	* @return the user ID of this LangLearnWordPair
	*/
	public long getUserId() {
		return _llWordPair.getUserId();
	}

	/**
	* Sets the user ID of this LangLearnWordPair.
	*
	* @param userId the user ID of this LangLearnWordPair
	*/
	public void setUserId(long userId) {
		_llWordPair.setUserId(userId);
	}

	/**
	* Returns the user uuid of this LangLearnWordPair.
	*
	* @return the user uuid of this LangLearnWordPair
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llWordPair.getUserUuid();
	}

	/**
	* Sets the user uuid of this LangLearnWordPair.
	*
	* @param userUuid the user uuid of this LangLearnWordPair
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_llWordPair.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this LangLearnWordPair.
	*
	* @return the user name of this LangLearnWordPair
	*/
	public java.lang.String getUserName() {
		return _llWordPair.getUserName();
	}

	/**
	* Sets the user name of this LangLearnWordPair.
	*
	* @param userName the user name of this LangLearnWordPair
	*/
	public void setUserName(java.lang.String userName) {
		_llWordPair.setUserName(userName);
	}

	/**
	* Returns the create date of this LangLearnWordPair.
	*
	* @return the create date of this LangLearnWordPair
	*/
	public java.util.Date getCreateDate() {
		return _llWordPair.getCreateDate();
	}

	/**
	* Sets the create date of this LangLearnWordPair.
	*
	* @param createDate the create date of this LangLearnWordPair
	*/
	public void setCreateDate(java.util.Date createDate) {
		_llWordPair.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this LangLearnWordPair.
	*
	* @return the modified date of this LangLearnWordPair
	*/
	public java.util.Date getModifiedDate() {
		return _llWordPair.getModifiedDate();
	}

	/**
	* Sets the modified date of this LangLearnWordPair.
	*
	* @param modifiedDate the modified date of this LangLearnWordPair
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_llWordPair.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _llWordPair.isNew();
	}

	public void setNew(boolean n) {
		_llWordPair.setNew(n);
	}

	public boolean isCachedModel() {
		return _llWordPair.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_llWordPair.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _llWordPair.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _llWordPair.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_llWordPair.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _llWordPair.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_llWordPair.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LLWordPairWrapper((LLWordPair)_llWordPair.clone());
	}

	public int compareTo(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair) {
		return _llWordPair.compareTo(llWordPair);
	}

	@Override
	public int hashCode() {
		return _llWordPair.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ru.psavinov.liferay.langlearn.model.LLWordPair> toCacheModel() {
		return _llWordPair.toCacheModel();
	}

	public ru.psavinov.liferay.langlearn.model.LLWordPair toEscapedModel() {
		return new LLWordPairWrapper(_llWordPair.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _llWordPair.toString();
	}

	public java.lang.String toXmlString() {
		return _llWordPair.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_llWordPair.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LLWordPair getWrappedLLWordPair() {
		return _llWordPair;
	}

	public LLWordPair getWrappedModel() {
		return _llWordPair;
	}

	public void resetOriginalValues() {
		_llWordPair.resetOriginalValues();
	}

	private LLWordPair _llWordPair;
}
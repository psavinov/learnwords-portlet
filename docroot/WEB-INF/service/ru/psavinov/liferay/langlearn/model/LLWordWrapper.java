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
 * This class is a wrapper for {@link LLWord}.
 * </p>
 *
 * @author    Pavel Savinov
 * @see       LLWord
 * @generated
 */
public class LLWordWrapper implements LLWord, ModelWrapper<LLWord> {
	public LLWordWrapper(LLWord llWord) {
		_llWord = llWord;
	}

	public Class<?> getModelClass() {
		return LLWord.class;
	}

	public String getModelClassName() {
		return LLWord.class.getName();
	}

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

	/**
	* Returns the primary key of this LangLeardWord.
	*
	* @return the primary key of this LangLeardWord
	*/
	public long getPrimaryKey() {
		return _llWord.getPrimaryKey();
	}

	/**
	* Sets the primary key of this LangLeardWord.
	*
	* @param primaryKey the primary key of this LangLeardWord
	*/
	public void setPrimaryKey(long primaryKey) {
		_llWord.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the word ID of this LangLeardWord.
	*
	* @return the word ID of this LangLeardWord
	*/
	public long getWordId() {
		return _llWord.getWordId();
	}

	/**
	* Sets the word ID of this LangLeardWord.
	*
	* @param wordId the word ID of this LangLeardWord
	*/
	public void setWordId(long wordId) {
		_llWord.setWordId(wordId);
	}

	/**
	* Returns the locale of this LangLeardWord.
	*
	* @return the locale of this LangLeardWord
	*/
	public java.lang.String getLocale() {
		return _llWord.getLocale();
	}

	/**
	* Sets the locale of this LangLeardWord.
	*
	* @param locale the locale of this LangLeardWord
	*/
	public void setLocale(java.lang.String locale) {
		_llWord.setLocale(locale);
	}

	/**
	* Returns the word of this LangLeardWord.
	*
	* @return the word of this LangLeardWord
	*/
	public java.lang.String getWord() {
		return _llWord.getWord();
	}

	/**
	* Sets the word of this LangLeardWord.
	*
	* @param word the word of this LangLeardWord
	*/
	public void setWord(java.lang.String word) {
		_llWord.setWord(word);
	}

	/**
	* Returns the company ID of this LangLeardWord.
	*
	* @return the company ID of this LangLeardWord
	*/
	public long getCompanyId() {
		return _llWord.getCompanyId();
	}

	/**
	* Sets the company ID of this LangLeardWord.
	*
	* @param companyId the company ID of this LangLeardWord
	*/
	public void setCompanyId(long companyId) {
		_llWord.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this LangLeardWord.
	*
	* @return the user ID of this LangLeardWord
	*/
	public long getUserId() {
		return _llWord.getUserId();
	}

	/**
	* Sets the user ID of this LangLeardWord.
	*
	* @param userId the user ID of this LangLeardWord
	*/
	public void setUserId(long userId) {
		_llWord.setUserId(userId);
	}

	/**
	* Returns the user uuid of this LangLeardWord.
	*
	* @return the user uuid of this LangLeardWord
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llWord.getUserUuid();
	}

	/**
	* Sets the user uuid of this LangLeardWord.
	*
	* @param userUuid the user uuid of this LangLeardWord
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_llWord.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this LangLeardWord.
	*
	* @return the user name of this LangLeardWord
	*/
	public java.lang.String getUserName() {
		return _llWord.getUserName();
	}

	/**
	* Sets the user name of this LangLeardWord.
	*
	* @param userName the user name of this LangLeardWord
	*/
	public void setUserName(java.lang.String userName) {
		_llWord.setUserName(userName);
	}

	/**
	* Returns the create date of this LangLeardWord.
	*
	* @return the create date of this LangLeardWord
	*/
	public java.util.Date getCreateDate() {
		return _llWord.getCreateDate();
	}

	/**
	* Sets the create date of this LangLeardWord.
	*
	* @param createDate the create date of this LangLeardWord
	*/
	public void setCreateDate(java.util.Date createDate) {
		_llWord.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this LangLeardWord.
	*
	* @return the modified date of this LangLeardWord
	*/
	public java.util.Date getModifiedDate() {
		return _llWord.getModifiedDate();
	}

	/**
	* Sets the modified date of this LangLeardWord.
	*
	* @param modifiedDate the modified date of this LangLeardWord
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_llWord.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _llWord.isNew();
	}

	public void setNew(boolean n) {
		_llWord.setNew(n);
	}

	public boolean isCachedModel() {
		return _llWord.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_llWord.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _llWord.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _llWord.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_llWord.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _llWord.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_llWord.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LLWordWrapper((LLWord)_llWord.clone());
	}

	public int compareTo(ru.psavinov.liferay.langlearn.model.LLWord llWord) {
		return _llWord.compareTo(llWord);
	}

	@Override
	public int hashCode() {
		return _llWord.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ru.psavinov.liferay.langlearn.model.LLWord> toCacheModel() {
		return _llWord.toCacheModel();
	}

	public ru.psavinov.liferay.langlearn.model.LLWord toEscapedModel() {
		return new LLWordWrapper(_llWord.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _llWord.toString();
	}

	public java.lang.String toXmlString() {
		return _llWord.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_llWord.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LLWord getWrappedLLWord() {
		return _llWord;
	}

	public LLWord getWrappedModel() {
		return _llWord;
	}

	public void resetOriginalValues() {
		_llWord.resetOriginalValues();
	}

	private LLWord _llWord;
}
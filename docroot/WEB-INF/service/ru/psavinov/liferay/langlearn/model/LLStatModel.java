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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LLStat service. Represents a row in the &quot;LangLearn_LLStat&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.psavinov.liferay.langlearn.model.impl.LLStatModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.psavinov.liferay.langlearn.model.impl.LLStatImpl}.
 * </p>
 *
 * @author Pavel Savinov
 * @see LLStat
 * @see ru.psavinov.liferay.langlearn.model.impl.LLStatImpl
 * @see ru.psavinov.liferay.langlearn.model.impl.LLStatModelImpl
 * @generated
 */
public interface LLStatModel extends AuditedModel, BaseModel<LLStat> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a LangLearnStatistics model instance should use the {@link LLStat} interface instead.
	 */

	/**
	 * Returns the primary key of this LangLearnStatistics.
	 *
	 * @return the primary key of this LangLearnStatistics
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this LangLearnStatistics.
	 *
	 * @param primaryKey the primary key of this LangLearnStatistics
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the stat ID of this LangLearnStatistics.
	 *
	 * @return the stat ID of this LangLearnStatistics
	 */
	public long getStatId();

	/**
	 * Sets the stat ID of this LangLearnStatistics.
	 *
	 * @param statId the stat ID of this LangLearnStatistics
	 */
	public void setStatId(long statId);

	/**
	 * Returns the stat type of this LangLearnStatistics.
	 *
	 * @return the stat type of this LangLearnStatistics
	 */
	public int getStatType();

	/**
	 * Sets the stat type of this LangLearnStatistics.
	 *
	 * @param statType the stat type of this LangLearnStatistics
	 */
	public void setStatType(int statType);

	/**
	 * Returns the stat string of this LangLearnStatistics.
	 *
	 * @return the stat string of this LangLearnStatistics
	 */
	@AutoEscape
	public String getStatString();

	/**
	 * Sets the stat string of this LangLearnStatistics.
	 *
	 * @param statString the stat string of this LangLearnStatistics
	 */
	public void setStatString(String statString);

	/**
	 * Returns the stat int of this LangLearnStatistics.
	 *
	 * @return the stat int of this LangLearnStatistics
	 */
	public int getStatInt();

	/**
	 * Sets the stat int of this LangLearnStatistics.
	 *
	 * @param statInt the stat int of this LangLearnStatistics
	 */
	public void setStatInt(int statInt);

	/**
	 * Returns the stat long of this LangLearnStatistics.
	 *
	 * @return the stat long of this LangLearnStatistics
	 */
	public long getStatLong();

	/**
	 * Sets the stat long of this LangLearnStatistics.
	 *
	 * @param statLong the stat long of this LangLearnStatistics
	 */
	public void setStatLong(long statLong);

	/**
	 * Returns the company ID of this LangLearnStatistics.
	 *
	 * @return the company ID of this LangLearnStatistics
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this LangLearnStatistics.
	 *
	 * @param companyId the company ID of this LangLearnStatistics
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this LangLearnStatistics.
	 *
	 * @return the user ID of this LangLearnStatistics
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this LangLearnStatistics.
	 *
	 * @param userId the user ID of this LangLearnStatistics
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this LangLearnStatistics.
	 *
	 * @return the user uuid of this LangLearnStatistics
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this LangLearnStatistics.
	 *
	 * @param userUuid the user uuid of this LangLearnStatistics
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this LangLearnStatistics.
	 *
	 * @return the user name of this LangLearnStatistics
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this LangLearnStatistics.
	 *
	 * @param userName the user name of this LangLearnStatistics
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this LangLearnStatistics.
	 *
	 * @return the create date of this LangLearnStatistics
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this LangLearnStatistics.
	 *
	 * @param createDate the create date of this LangLearnStatistics
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this LangLearnStatistics.
	 *
	 * @return the modified date of this LangLearnStatistics
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this LangLearnStatistics.
	 *
	 * @param modifiedDate the modified date of this LangLearnStatistics
	 */
	public void setModifiedDate(Date modifiedDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(LLStat llStat);

	public int hashCode();

	public CacheModel<LLStat> toCacheModel();

	public LLStat toEscapedModel();

	public String toString();

	public String toXmlString();
}
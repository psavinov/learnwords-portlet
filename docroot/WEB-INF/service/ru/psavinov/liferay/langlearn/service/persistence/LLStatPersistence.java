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

package ru.psavinov.liferay.langlearn.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ru.psavinov.liferay.langlearn.model.LLStat;

/**
 * The persistence interface for the LangLearnStatistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLStatPersistenceImpl
 * @see LLStatUtil
 * @generated
 */
public interface LLStatPersistence extends BasePersistence<LLStat> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LLStatUtil} to access the LangLearnStatistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the LangLearnStatistics in the entity cache if it is enabled.
	*
	* @param llStat the LangLearnStatistics
	*/
	public void cacheResult(ru.psavinov.liferay.langlearn.model.LLStat llStat);

	/**
	* Caches the LangLearnStatisticses in the entity cache if it is enabled.
	*
	* @param llStats the LangLearnStatisticses
	*/
	public void cacheResult(
		java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> llStats);

	/**
	* Creates a new LangLearnStatistics with the primary key. Does not add the LangLearnStatistics to the database.
	*
	* @param statId the primary key for the new LangLearnStatistics
	* @return the new LangLearnStatistics
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat create(long statId);

	/**
	* Removes the LangLearnStatistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statId the primary key of the LangLearnStatistics
	* @return the LangLearnStatistics that was removed
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat remove(long statId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	public ru.psavinov.liferay.langlearn.model.LLStat updateImpl(
		ru.psavinov.liferay.langlearn.model.LLStat llStat, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnStatistics with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLStatException} if it could not be found.
	*
	* @param statId the primary key of the LangLearnStatistics
	* @return the LangLearnStatistics
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat findByPrimaryKey(
		long statId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Returns the LangLearnStatistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param statId the primary key of the LangLearnStatistics
	* @return the LangLearnStatistics, or <code>null</code> if a LangLearnStatistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByPrimaryKey(
		long statId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLStatException} if it could not be found.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param statType the stat type
	* @return the matching LangLearnStatistics
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat findByStatCountPerDay(
		long userId, java.util.Date createDate, int statType)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Returns the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param statType the stat type
	* @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByStatCountPerDay(
		long userId, java.util.Date createDate, int statType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param statType the stat type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByStatCountPerDay(
		long userId, java.util.Date createDate, int statType,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the LangLearnStatisticses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the LangLearnStatisticses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of LangLearnStatisticses
	* @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	* @return the range of matching LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the LangLearnStatisticses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of LangLearnStatisticses
	* @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first LangLearnStatistics in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLearnStatistics
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Returns the first LangLearnStatistics in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last LangLearnStatistics in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLearnStatistics
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Returns the last LangLearnStatistics in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnStatisticses before and after the current LangLearnStatistics in the ordered set where userId = &#63;.
	*
	* @param statId the primary key of the current LangLearnStatistics
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next LangLearnStatistics
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat[] findByUserId_PrevAndNext(
		long statId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Returns the LangLearnStatistics where userId = &#63; and statType = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLStatException} if it could not be found.
	*
	* @param userId the user ID
	* @param statType the stat type
	* @return the matching LangLearnStatistics
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat findByUserIdAndType(
		long userId, int statType)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Returns the LangLearnStatistics where userId = &#63; and statType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param statType the stat type
	* @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByUserIdAndType(
		long userId, int statType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnStatistics where userId = &#63; and statType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param statType the stat type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat fetchByUserIdAndType(
		long userId, int statType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the LangLearnStatisticses.
	*
	* @return the LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the LangLearnStatisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLearnStatisticses
	* @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	* @return the range of LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the LangLearnStatisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLearnStatisticses
	* @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; from the database.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param statType the stat type
	* @return the LangLearnStatistics that was removed
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat removeByStatCountPerDay(
		long userId, java.util.Date createDate, int statType)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Removes all the LangLearnStatisticses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the LangLearnStatistics where userId = &#63; and statType = &#63; from the database.
	*
	* @param userId the user ID
	* @param statType the stat type
	* @return the LangLearnStatistics that was removed
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLStat removeByUserIdAndType(
		long userId, int statType)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException;

	/**
	* Removes all the LangLearnStatisticses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnStatisticses where userId = &#63; and createDate = &#63; and statType = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param statType the stat type
	* @return the number of matching LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatCountPerDay(long userId, java.util.Date createDate,
		int statType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnStatisticses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnStatisticses where userId = &#63; and statType = &#63;.
	*
	* @param userId the user ID
	* @param statType the stat type
	* @return the number of matching LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndType(long userId, int statType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnStatisticses.
	*
	* @return the number of LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
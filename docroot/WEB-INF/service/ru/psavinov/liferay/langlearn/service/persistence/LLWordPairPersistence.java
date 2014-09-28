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

import ru.psavinov.liferay.langlearn.model.LLWordPair;

/**
 * The persistence interface for the LangLearnWordPair service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPairPersistenceImpl
 * @see LLWordPairUtil
 * @generated
 */
public interface LLWordPairPersistence extends BasePersistence<LLWordPair> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LLWordPairUtil} to access the LangLearnWordPair persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the LangLearnWordPair in the entity cache if it is enabled.
	*
	* @param llWordPair the LangLearnWordPair
	*/
	public void cacheResult(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair);

	/**
	* Caches the LangLearnWordPairs in the entity cache if it is enabled.
	*
	* @param llWordPairs the LangLearnWordPairs
	*/
	public void cacheResult(
		java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> llWordPairs);

	/**
	* Creates a new LangLearnWordPair with the primary key. Does not add the LangLearnWordPair to the database.
	*
	* @param wordPairId the primary key for the new LangLearnWordPair
	* @return the new LangLearnWordPair
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair create(
		long wordPairId);

	/**
	* Removes the LangLearnWordPair with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair that was removed
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair remove(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	public ru.psavinov.liferay.langlearn.model.LLWordPair updateImpl(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnWordPair with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordPairException} if it could not be found.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair findByPrimaryKey(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	/**
	* Returns the LangLearnWordPair with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair, or <code>null</code> if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair fetchByPrimaryKey(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the LangLearnWordPairs where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @return the matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the LangLearnWordPairs where wordFromId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wordFromId the word from ID
	* @param start the lower bound of the range of LangLearnWordPairs
	* @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	* @return the range of matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the LangLearnWordPairs where wordFromId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wordFromId the word from ID
	* @param start the lower bound of the range of LangLearnWordPairs
	* @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair findByWordFrom_First(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	/**
	* Returns the first LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWordFrom_First(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair findByWordFrom_Last(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	/**
	* Returns the last LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWordFrom_Last(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnWordPairs before and after the current LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordPairId the primary key of the current LangLearnWordPair
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair[] findByWordFrom_PrevAndNext(
		long wordPairId, long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	/**
	* Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordPairException} if it could not be found.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the matching LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair findByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	/**
	* Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWords(
		long wordFromId, long wordToId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the LangLearnWordPairs.
	*
	* @return the LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the LangLearnWordPairs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLearnWordPairs
	* @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	* @return the range of LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the LangLearnWordPairs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLearnWordPairs
	* @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the LangLearnWordPairs where wordFromId = &#63; from the database.
	*
	* @param wordFromId the word from ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWordFrom(long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; from the database.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the LangLearnWordPair that was removed
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWordPair removeByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;

	/**
	* Removes all the LangLearnWordPairs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnWordPairs where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @return the number of matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public int countByWordFrom(long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnWordPairs where wordFromId = &#63; and wordToId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the number of matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public int countByWords(long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLearnWordPairs.
	*
	* @return the number of LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
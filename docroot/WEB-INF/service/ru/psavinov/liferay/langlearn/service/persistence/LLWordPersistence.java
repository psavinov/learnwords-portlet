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

import ru.psavinov.liferay.langlearn.model.LLWord;

/**
 * The persistence interface for the LangLeardWord service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPersistenceImpl
 * @see LLWordUtil
 * @generated
 */
public interface LLWordPersistence extends BasePersistence<LLWord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LLWordUtil} to access the LangLeardWord persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the LangLeardWord in the entity cache if it is enabled.
	*
	* @param llWord the LangLeardWord
	*/
	public void cacheResult(ru.psavinov.liferay.langlearn.model.LLWord llWord);

	/**
	* Caches the LangLeardWords in the entity cache if it is enabled.
	*
	* @param llWords the LangLeardWords
	*/
	public void cacheResult(
		java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> llWords);

	/**
	* Creates a new LangLeardWord with the primary key. Does not add the LangLeardWord to the database.
	*
	* @param wordId the primary key for the new LangLeardWord
	* @return the new LangLeardWord
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord create(long wordId);

	/**
	* Removes the LangLeardWord with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord that was removed
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord remove(long wordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	public ru.psavinov.liferay.langlearn.model.LLWord updateImpl(
		ru.psavinov.liferay.langlearn.model.LLWord llWord, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLeardWord with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordException} if it could not be found.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord findByPrimaryKey(
		long wordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	/**
	* Returns the LangLeardWord with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord, or <code>null</code> if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord fetchByPrimaryKey(
		long wordId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLeardWord where word = &#63; and locale = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordException} if it could not be found.
	*
	* @param word the word
	* @param locale the locale
	* @return the matching LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord findByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	/**
	* Returns the LangLeardWord where word = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param word the word
	* @param locale the locale
	* @return the matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord fetchByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLeardWord where word = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param word the word
	* @param locale the locale
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord fetchByWordAndLocale(
		java.lang.String word, java.lang.String locale,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the LangLeardWords where locale = &#63;.
	*
	* @param locale the locale
	* @return the matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the LangLeardWords where locale = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locale the locale
	* @param start the lower bound of the range of LangLeardWords
	* @param end the upper bound of the range of LangLeardWords (not inclusive)
	* @return the range of matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the LangLeardWords where locale = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locale the locale
	* @param start the lower bound of the range of LangLeardWords
	* @param end the upper bound of the range of LangLeardWords (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord findByLocale_First(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	/**
	* Returns the first LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord fetchByLocale_First(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord findByLocale_Last(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	/**
	* Returns the last LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord fetchByLocale_Last(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the LangLeardWords before and after the current LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param wordId the primary key of the current LangLeardWord
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord[] findByLocale_PrevAndNext(
		long wordId, java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	/**
	* Returns all the LangLeardWords.
	*
	* @return the LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the LangLeardWords.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLeardWords
	* @param end the upper bound of the range of LangLeardWords (not inclusive)
	* @return the range of LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the LangLeardWords.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLeardWords
	* @param end the upper bound of the range of LangLeardWords (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the LangLeardWord where word = &#63; and locale = &#63; from the database.
	*
	* @param word the word
	* @param locale the locale
	* @return the LangLeardWord that was removed
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLWord removeByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException;

	/**
	* Removes all the LangLeardWords where locale = &#63; from the database.
	*
	* @param locale the locale
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLocale(java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the LangLeardWords from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLeardWords where word = &#63; and locale = &#63;.
	*
	* @param word the word
	* @param locale the locale
	* @return the number of matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public int countByWordAndLocale(java.lang.String word,
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLeardWords where locale = &#63;.
	*
	* @param locale the locale
	* @return the number of matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocale(java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of LangLeardWords.
	*
	* @return the number of LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.psavinov.liferay.langlearn.model.LLWord;

import java.util.List;

/**
 * The persistence utility for the LangLeardWord service. This utility wraps {@link LLWordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPersistence
 * @see LLWordPersistenceImpl
 * @generated
 */
public class LLWordUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LLWord llWord) {
		getPersistence().clearCache(llWord);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LLWord> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LLWord> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LLWord> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LLWord update(LLWord llWord, boolean merge)
		throws SystemException {
		return getPersistence().update(llWord, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LLWord update(LLWord llWord, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(llWord, merge, serviceContext);
	}

	/**
	* Caches the LangLeardWord in the entity cache if it is enabled.
	*
	* @param llWord the LangLeardWord
	*/
	public static void cacheResult(
		ru.psavinov.liferay.langlearn.model.LLWord llWord) {
		getPersistence().cacheResult(llWord);
	}

	/**
	* Caches the LangLeardWords in the entity cache if it is enabled.
	*
	* @param llWords the LangLeardWords
	*/
	public static void cacheResult(
		java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> llWords) {
		getPersistence().cacheResult(llWords);
	}

	/**
	* Creates a new LangLeardWord with the primary key. Does not add the LangLeardWord to the database.
	*
	* @param wordId the primary key for the new LangLeardWord
	* @return the new LangLeardWord
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord create(long wordId) {
		return getPersistence().create(wordId);
	}

	/**
	* Removes the LangLeardWord with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord that was removed
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord remove(long wordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence().remove(wordId);
	}

	public static ru.psavinov.liferay.langlearn.model.LLWord updateImpl(
		ru.psavinov.liferay.langlearn.model.LLWord llWord, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(llWord, merge);
	}

	/**
	* Returns the LangLeardWord with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordException} if it could not be found.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord findByPrimaryKey(
		long wordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence().findByPrimaryKey(wordId);
	}

	/**
	* Returns the LangLeardWord with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord, or <code>null</code> if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord fetchByPrimaryKey(
		long wordId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wordId);
	}

	/**
	* Returns the LangLeardWord where word = &#63; and locale = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordException} if it could not be found.
	*
	* @param word the word
	* @param locale the locale
	* @return the matching LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord findByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence().findByWordAndLocale(word, locale);
	}

	/**
	* Returns the LangLeardWord where word = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param word the word
	* @param locale the locale
	* @return the matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord fetchByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWordAndLocale(word, locale);
	}

	/**
	* Returns the LangLeardWord where word = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param word the word
	* @param locale the locale
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord fetchByWordAndLocale(
		java.lang.String word, java.lang.String locale,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWordAndLocale(word, locale, retrieveFromCache);
	}

	/**
	* Returns all the LangLeardWords where locale = &#63;.
	*
	* @param locale the locale
	* @return the matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocale(locale);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocale(locale, start, end);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocale(locale, start, end, orderByComparator);
	}

	/**
	* Returns the first LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord findByLocale_First(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence().findByLocale_First(locale, orderByComparator);
	}

	/**
	* Returns the first LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord fetchByLocale_First(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLocale_First(locale, orderByComparator);
	}

	/**
	* Returns the last LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLeardWord
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord findByLocale_Last(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence().findByLocale_Last(locale, orderByComparator);
	}

	/**
	* Returns the last LangLeardWord in the ordered set where locale = &#63;.
	*
	* @param locale the locale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord fetchByLocale_Last(
		java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLocale_Last(locale, orderByComparator);
	}

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
	public static ru.psavinov.liferay.langlearn.model.LLWord[] findByLocale_PrevAndNext(
		long wordId, java.lang.String locale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence()
				   .findByLocale_PrevAndNext(wordId, locale, orderByComparator);
	}

	/**
	* Returns all the LangLeardWords.
	*
	* @return the LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the LangLeardWord where word = &#63; and locale = &#63; from the database.
	*
	* @param word the word
	* @param locale the locale
	* @return the LangLeardWord that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord removeByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getPersistence().removeByWordAndLocale(word, locale);
	}

	/**
	* Removes all the LangLeardWords where locale = &#63; from the database.
	*
	* @param locale the locale
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocale(java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocale(locale);
	}

	/**
	* Removes all the LangLeardWords from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of LangLeardWords where word = &#63; and locale = &#63;.
	*
	* @param word the word
	* @param locale the locale
	* @return the number of matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWordAndLocale(java.lang.String word,
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWordAndLocale(word, locale);
	}

	/**
	* Returns the number of LangLeardWords where locale = &#63;.
	*
	* @param locale the locale
	* @return the number of matching LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocale(java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocale(locale);
	}

	/**
	* Returns the number of LangLeardWords.
	*
	* @return the number of LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LLWordPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LLWordPersistence)PortletBeanLocatorUtil.locate(ru.psavinov.liferay.langlearn.service.ClpSerializer.getServletContextName(),
					LLWordPersistence.class.getName());

			ReferenceRegistry.registerReference(LLWordUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LLWordPersistence persistence) {
	}

	private static LLWordPersistence _persistence;
}
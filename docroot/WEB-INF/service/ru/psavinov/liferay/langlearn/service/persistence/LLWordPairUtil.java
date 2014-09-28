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

import ru.psavinov.liferay.langlearn.model.LLWordPair;

import java.util.List;

/**
 * The persistence utility for the LangLearnWordPair service. This utility wraps {@link LLWordPairPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPairPersistence
 * @see LLWordPairPersistenceImpl
 * @generated
 */
public class LLWordPairUtil {
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
	public static void clearCache(LLWordPair llWordPair) {
		getPersistence().clearCache(llWordPair);
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
	public static List<LLWordPair> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LLWordPair> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LLWordPair> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LLWordPair update(LLWordPair llWordPair, boolean merge)
		throws SystemException {
		return getPersistence().update(llWordPair, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LLWordPair update(LLWordPair llWordPair, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(llWordPair, merge, serviceContext);
	}

	/**
	* Caches the LangLearnWordPair in the entity cache if it is enabled.
	*
	* @param llWordPair the LangLearnWordPair
	*/
	public static void cacheResult(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair) {
		getPersistence().cacheResult(llWordPair);
	}

	/**
	* Caches the LangLearnWordPairs in the entity cache if it is enabled.
	*
	* @param llWordPairs the LangLearnWordPairs
	*/
	public static void cacheResult(
		java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> llWordPairs) {
		getPersistence().cacheResult(llWordPairs);
	}

	/**
	* Creates a new LangLearnWordPair with the primary key. Does not add the LangLearnWordPair to the database.
	*
	* @param wordPairId the primary key for the new LangLearnWordPair
	* @return the new LangLearnWordPair
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair create(
		long wordPairId) {
		return getPersistence().create(wordPairId);
	}

	/**
	* Removes the LangLearnWordPair with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair that was removed
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair remove(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence().remove(wordPairId);
	}

	public static ru.psavinov.liferay.langlearn.model.LLWordPair updateImpl(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(llWordPair, merge);
	}

	/**
	* Returns the LangLearnWordPair with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordPairException} if it could not be found.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair findByPrimaryKey(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence().findByPrimaryKey(wordPairId);
	}

	/**
	* Returns the LangLearnWordPair with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair, or <code>null</code> if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair fetchByPrimaryKey(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wordPairId);
	}

	/**
	* Returns all the LangLearnWordPairs where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @return the matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWordFrom(wordFromId);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByWordFrom(wordFromId, start, end);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByWordFrom(wordFromId, start, end, orderByComparator);
	}

	/**
	* Returns the first LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair findByWordFrom_First(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence()
				   .findByWordFrom_First(wordFromId, orderByComparator);
	}

	/**
	* Returns the first LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWordFrom_First(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWordFrom_First(wordFromId, orderByComparator);
	}

	/**
	* Returns the last LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair findByWordFrom_Last(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence()
				   .findByWordFrom_Last(wordFromId, orderByComparator);
	}

	/**
	* Returns the last LangLearnWordPair in the ordered set where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWordFrom_Last(
		long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWordFrom_Last(wordFromId, orderByComparator);
	}

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
	public static ru.psavinov.liferay.langlearn.model.LLWordPair[] findByWordFrom_PrevAndNext(
		long wordPairId, long wordFromId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence()
				   .findByWordFrom_PrevAndNext(wordPairId, wordFromId,
			orderByComparator);
	}

	/**
	* Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordPairException} if it could not be found.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the matching LangLearnWordPair
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair findByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence().findByWords(wordFromId, wordToId);
	}

	/**
	* Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWords(wordFromId, wordToId);
	}

	/**
	* Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair fetchByWords(
		long wordFromId, long wordToId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWords(wordFromId, wordToId, retrieveFromCache);
	}

	/**
	* Returns all the LangLearnWordPairs.
	*
	* @return the LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the LangLearnWordPairs where wordFromId = &#63; from the database.
	*
	* @param wordFromId the word from ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWordFrom(long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByWordFrom(wordFromId);
	}

	/**
	* Removes the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; from the database.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the LangLearnWordPair that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair removeByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getPersistence().removeByWords(wordFromId, wordToId);
	}

	/**
	* Removes all the LangLearnWordPairs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of LangLearnWordPairs where wordFromId = &#63;.
	*
	* @param wordFromId the word from ID
	* @return the number of matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWordFrom(long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWordFrom(wordFromId);
	}

	/**
	* Returns the number of LangLearnWordPairs where wordFromId = &#63; and wordToId = &#63;.
	*
	* @param wordFromId the word from ID
	* @param wordToId the word to ID
	* @return the number of matching LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWords(long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWords(wordFromId, wordToId);
	}

	/**
	* Returns the number of LangLearnWordPairs.
	*
	* @return the number of LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LLWordPairPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LLWordPairPersistence)PortletBeanLocatorUtil.locate(ru.psavinov.liferay.langlearn.service.ClpSerializer.getServletContextName(),
					LLWordPairPersistence.class.getName());

			ReferenceRegistry.registerReference(LLWordPairUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LLWordPairPersistence persistence) {
	}

	private static LLWordPairPersistence _persistence;
}
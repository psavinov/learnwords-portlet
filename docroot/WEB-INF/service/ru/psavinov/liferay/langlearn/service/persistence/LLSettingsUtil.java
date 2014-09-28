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

import ru.psavinov.liferay.langlearn.model.LLSettings;

import java.util.List;

/**
 * The persistence utility for the LangLearnSettings service. This utility wraps {@link LLSettingsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLSettingsPersistence
 * @see LLSettingsPersistenceImpl
 * @generated
 */
public class LLSettingsUtil {
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
	public static void clearCache(LLSettings llSettings) {
		getPersistence().clearCache(llSettings);
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
	public static List<LLSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LLSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LLSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LLSettings update(LLSettings llSettings, boolean merge)
		throws SystemException {
		return getPersistence().update(llSettings, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LLSettings update(LLSettings llSettings, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(llSettings, merge, serviceContext);
	}

	/**
	* Caches the LangLearnSettings in the entity cache if it is enabled.
	*
	* @param llSettings the LangLearnSettings
	*/
	public static void cacheResult(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings) {
		getPersistence().cacheResult(llSettings);
	}

	/**
	* Caches the LangLearnSettingses in the entity cache if it is enabled.
	*
	* @param llSettingses the LangLearnSettingses
	*/
	public static void cacheResult(
		java.util.List<ru.psavinov.liferay.langlearn.model.LLSettings> llSettingses) {
		getPersistence().cacheResult(llSettingses);
	}

	/**
	* Creates a new LangLearnSettings with the primary key. Does not add the LangLearnSettings to the database.
	*
	* @param settingsId the primary key for the new LangLearnSettings
	* @return the new LangLearnSettings
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings create(
		long settingsId) {
		return getPersistence().create(settingsId);
	}

	/**
	* Removes the LangLearnSettings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param settingsId the primary key of the LangLearnSettings
	* @return the LangLearnSettings that was removed
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a LangLearnSettings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings remove(
		long settingsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLSettingsException {
		return getPersistence().remove(settingsId);
	}

	public static ru.psavinov.liferay.langlearn.model.LLSettings updateImpl(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(llSettings, merge);
	}

	/**
	* Returns the LangLearnSettings with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLSettingsException} if it could not be found.
	*
	* @param settingsId the primary key of the LangLearnSettings
	* @return the LangLearnSettings
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a LangLearnSettings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings findByPrimaryKey(
		long settingsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLSettingsException {
		return getPersistence().findByPrimaryKey(settingsId);
	}

	/**
	* Returns the LangLearnSettings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param settingsId the primary key of the LangLearnSettings
	* @return the LangLearnSettings, or <code>null</code> if a LangLearnSettings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings fetchByPrimaryKey(
		long settingsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(settingsId);
	}

	/**
	* Returns the LangLearnSettings where userId = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLSettingsException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching LangLearnSettings
	* @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a matching LangLearnSettings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLSettingsException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the LangLearnSettings where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching LangLearnSettings, or <code>null</code> if a matching LangLearnSettings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the LangLearnSettings where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching LangLearnSettings, or <code>null</code> if a matching LangLearnSettings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Returns all the LangLearnSettingses.
	*
	* @return the LangLearnSettingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLSettings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the LangLearnSettingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLearnSettingses
	* @param end the upper bound of the range of LangLearnSettingses (not inclusive)
	* @return the range of LangLearnSettingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLSettings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the LangLearnSettingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of LangLearnSettingses
	* @param end the upper bound of the range of LangLearnSettingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of LangLearnSettingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLSettings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the LangLearnSettings where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the LangLearnSettings that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLSettings removeByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLSettingsException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the LangLearnSettingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of LangLearnSettingses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching LangLearnSettingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of LangLearnSettingses.
	*
	* @return the number of LangLearnSettingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LLSettingsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LLSettingsPersistence)PortletBeanLocatorUtil.locate(ru.psavinov.liferay.langlearn.service.ClpSerializer.getServletContextName(),
					LLSettingsPersistence.class.getName());

			ReferenceRegistry.registerReference(LLSettingsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LLSettingsPersistence persistence) {
	}

	private static LLSettingsPersistence _persistence;
}
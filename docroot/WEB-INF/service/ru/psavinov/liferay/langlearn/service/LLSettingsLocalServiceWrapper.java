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

package ru.psavinov.liferay.langlearn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LLSettingsLocalService}.
 * </p>
 *
 * @author    Pavel Savinov
 * @see       LLSettingsLocalService
 * @generated
 */
public class LLSettingsLocalServiceWrapper implements LLSettingsLocalService,
	ServiceWrapper<LLSettingsLocalService> {
	public LLSettingsLocalServiceWrapper(
		LLSettingsLocalService llSettingsLocalService) {
		_llSettingsLocalService = llSettingsLocalService;
	}

	/**
	* Adds the LangLearnSettings to the database. Also notifies the appropriate model listeners.
	*
	* @param llSettings the LangLearnSettings
	* @return the LangLearnSettings that was added
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings addLLSettings(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.addLLSettings(llSettings);
	}

	/**
	* Creates a new LangLearnSettings with the primary key. Does not add the LangLearnSettings to the database.
	*
	* @param settingsId the primary key for the new LangLearnSettings
	* @return the new LangLearnSettings
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings createLLSettings(
		long settingsId) {
		return _llSettingsLocalService.createLLSettings(settingsId);
	}

	/**
	* Deletes the LangLearnSettings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param settingsId the primary key of the LangLearnSettings
	* @return the LangLearnSettings that was removed
	* @throws PortalException if a LangLearnSettings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings deleteLLSettings(
		long settingsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.deleteLLSettings(settingsId);
	}

	/**
	* Deletes the LangLearnSettings from the database. Also notifies the appropriate model listeners.
	*
	* @param llSettings the LangLearnSettings
	* @return the LangLearnSettings that was removed
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings deleteLLSettings(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.deleteLLSettings(llSettings);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _llSettingsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public ru.psavinov.liferay.langlearn.model.LLSettings fetchLLSettings(
		long settingsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.fetchLLSettings(settingsId);
	}

	/**
	* Returns the LangLearnSettings with the primary key.
	*
	* @param settingsId the primary key of the LangLearnSettings
	* @return the LangLearnSettings
	* @throws PortalException if a LangLearnSettings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings getLLSettings(
		long settingsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.getLLSettings(settingsId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<ru.psavinov.liferay.langlearn.model.LLSettings> getLLSettingses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.getLLSettingses(start, end);
	}

	/**
	* Returns the number of LangLearnSettingses.
	*
	* @return the number of LangLearnSettingses
	* @throws SystemException if a system exception occurred
	*/
	public int getLLSettingsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.getLLSettingsesCount();
	}

	/**
	* Updates the LangLearnSettings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llSettings the LangLearnSettings
	* @return the LangLearnSettings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings updateLLSettings(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.updateLLSettings(llSettings);
	}

	/**
	* Updates the LangLearnSettings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llSettings the LangLearnSettings
	* @param merge whether to merge the LangLearnSettings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the LangLearnSettings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public ru.psavinov.liferay.langlearn.model.LLSettings updateLLSettings(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _llSettingsLocalService.updateLLSettings(llSettings, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _llSettingsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_llSettingsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _llSettingsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public ru.psavinov.liferay.langlearn.model.LLSettings findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLSettingsException {
		return _llSettingsLocalService.findByUserId(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LLSettingsLocalService getWrappedLLSettingsLocalService() {
		return _llSettingsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLLSettingsLocalService(
		LLSettingsLocalService llSettingsLocalService) {
		_llSettingsLocalService = llSettingsLocalService;
	}

	public LLSettingsLocalService getWrappedService() {
		return _llSettingsLocalService;
	}

	public void setWrappedService(LLSettingsLocalService llSettingsLocalService) {
		_llSettingsLocalService = llSettingsLocalService;
	}

	private LLSettingsLocalService _llSettingsLocalService;
}
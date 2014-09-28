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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the LangLeardWord local service. This utility wraps {@link ru.psavinov.liferay.langlearn.service.impl.LLWordLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordLocalService
 * @see ru.psavinov.liferay.langlearn.service.base.LLWordLocalServiceBaseImpl
 * @see ru.psavinov.liferay.langlearn.service.impl.LLWordLocalServiceImpl
 * @generated
 */
public class LLWordLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ru.psavinov.liferay.langlearn.service.impl.LLWordLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the LangLeardWord to the database. Also notifies the appropriate model listeners.
	*
	* @param llWord the LangLeardWord
	* @return the LangLeardWord that was added
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord addLLWord(
		ru.psavinov.liferay.langlearn.model.LLWord llWord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLLWord(llWord);
	}

	/**
	* Creates a new LangLeardWord with the primary key. Does not add the LangLeardWord to the database.
	*
	* @param wordId the primary key for the new LangLeardWord
	* @return the new LangLeardWord
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord createLLWord(
		long wordId) {
		return getService().createLLWord(wordId);
	}

	/**
	* Deletes the LangLeardWord with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord that was removed
	* @throws PortalException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord deleteLLWord(
		long wordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLLWord(wordId);
	}

	/**
	* Deletes the LangLeardWord from the database. Also notifies the appropriate model listeners.
	*
	* @param llWord the LangLeardWord
	* @return the LangLeardWord that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord deleteLLWord(
		ru.psavinov.liferay.langlearn.model.LLWord llWord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLLWord(llWord);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static ru.psavinov.liferay.langlearn.model.LLWord fetchLLWord(
		long wordId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLLWord(wordId);
	}

	/**
	* Returns the LangLeardWord with the primary key.
	*
	* @param wordId the primary key of the LangLeardWord
	* @return the LangLeardWord
	* @throws PortalException if a LangLeardWord with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord getLLWord(
		long wordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLWord(wordId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> getLLWords(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLWords(start, end);
	}

	/**
	* Returns the number of LangLeardWords.
	*
	* @return the number of LangLeardWords
	* @throws SystemException if a system exception occurred
	*/
	public static int getLLWordsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLWordsCount();
	}

	/**
	* Updates the LangLeardWord in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llWord the LangLeardWord
	* @return the LangLeardWord that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord updateLLWord(
		ru.psavinov.liferay.langlearn.model.LLWord llWord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLLWord(llWord);
	}

	/**
	* Updates the LangLeardWord in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llWord the LangLeardWord
	* @param merge whether to merge the LangLeardWord with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the LangLeardWord that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWord updateLLWord(
		ru.psavinov.liferay.langlearn.model.LLWord llWord, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLLWord(llWord, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static ru.psavinov.liferay.langlearn.model.LLWord findByWordAndLocale(
		java.lang.String word, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordException {
		return getService().findByWordAndLocale(word, locale);
	}

	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLocale(locale);
	}

	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocale(
		java.lang.String locale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLocale(locale, start, end);
	}

	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocaleWithPair(
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLocaleWithPair(locale);
	}

	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWord> findByLocaleWithPair(
		java.lang.String locale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLocaleWithPair(locale, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static LLWordLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LLWordLocalService.class.getName());

			if (invokableLocalService instanceof LLWordLocalService) {
				_service = (LLWordLocalService)invokableLocalService;
			}
			else {
				_service = new LLWordLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LLWordLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LLWordLocalService service) {
	}

	private static LLWordLocalService _service;
}
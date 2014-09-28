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
 * The utility for the LangLearnWordPair local service. This utility wraps {@link ru.psavinov.liferay.langlearn.service.impl.LLWordPairLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPairLocalService
 * @see ru.psavinov.liferay.langlearn.service.base.LLWordPairLocalServiceBaseImpl
 * @see ru.psavinov.liferay.langlearn.service.impl.LLWordPairLocalServiceImpl
 * @generated
 */
public class LLWordPairLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ru.psavinov.liferay.langlearn.service.impl.LLWordPairLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the LangLearnWordPair to the database. Also notifies the appropriate model listeners.
	*
	* @param llWordPair the LangLearnWordPair
	* @return the LangLearnWordPair that was added
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair addLLWordPair(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLLWordPair(llWordPair);
	}

	/**
	* Creates a new LangLearnWordPair with the primary key. Does not add the LangLearnWordPair to the database.
	*
	* @param wordPairId the primary key for the new LangLearnWordPair
	* @return the new LangLearnWordPair
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair createLLWordPair(
		long wordPairId) {
		return getService().createLLWordPair(wordPairId);
	}

	/**
	* Deletes the LangLearnWordPair with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair that was removed
	* @throws PortalException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair deleteLLWordPair(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLLWordPair(wordPairId);
	}

	/**
	* Deletes the LangLearnWordPair from the database. Also notifies the appropriate model listeners.
	*
	* @param llWordPair the LangLearnWordPair
	* @return the LangLearnWordPair that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair deleteLLWordPair(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLLWordPair(llWordPair);
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

	public static ru.psavinov.liferay.langlearn.model.LLWordPair fetchLLWordPair(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLLWordPair(wordPairId);
	}

	/**
	* Returns the LangLearnWordPair with the primary key.
	*
	* @param wordPairId the primary key of the LangLearnWordPair
	* @return the LangLearnWordPair
	* @throws PortalException if a LangLearnWordPair with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair getLLWordPair(
		long wordPairId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLWordPair(wordPairId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> getLLWordPairs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLWordPairs(start, end);
	}

	/**
	* Returns the number of LangLearnWordPairs.
	*
	* @return the number of LangLearnWordPairs
	* @throws SystemException if a system exception occurred
	*/
	public static int getLLWordPairsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLWordPairsCount();
	}

	/**
	* Updates the LangLearnWordPair in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llWordPair the LangLearnWordPair
	* @return the LangLearnWordPair that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair updateLLWordPair(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLLWordPair(llWordPair);
	}

	/**
	* Updates the LangLearnWordPair in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llWordPair the LangLearnWordPair
	* @param merge whether to merge the LangLearnWordPair with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the LangLearnWordPair that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLWordPair updateLLWordPair(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLLWordPair(llWordPair, merge);
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

	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLWordPair> findByWordFrom(
		long wordFromId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByWordFrom(wordFromId);
	}

	public static ru.psavinov.liferay.langlearn.model.LLWordPair findByWordFromAndLocale(
		long wordFromId, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByWordFromAndLocale(wordFromId, locale);
	}

	public static ru.psavinov.liferay.langlearn.model.LLWordPair findByWords(
		long wordFromId, long wordToId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLWordPairException {
		return getService().findByWords(wordFromId, wordToId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LLWordPairLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LLWordPairLocalService.class.getName());

			if (invokableLocalService instanceof LLWordPairLocalService) {
				_service = (LLWordPairLocalService)invokableLocalService;
			}
			else {
				_service = new LLWordPairLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LLWordPairLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LLWordPairLocalService service) {
	}

	private static LLWordPairLocalService _service;
}
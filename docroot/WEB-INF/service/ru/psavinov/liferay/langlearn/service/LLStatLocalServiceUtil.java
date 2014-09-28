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
 * The utility for the LangLearnStatistics local service. This utility wraps {@link ru.psavinov.liferay.langlearn.service.impl.LLStatLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pavel Savinov
 * @see LLStatLocalService
 * @see ru.psavinov.liferay.langlearn.service.base.LLStatLocalServiceBaseImpl
 * @see ru.psavinov.liferay.langlearn.service.impl.LLStatLocalServiceImpl
 * @generated
 */
public class LLStatLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ru.psavinov.liferay.langlearn.service.impl.LLStatLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the LangLearnStatistics to the database. Also notifies the appropriate model listeners.
	*
	* @param llStat the LangLearnStatistics
	* @return the LangLearnStatistics that was added
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat addLLStat(
		ru.psavinov.liferay.langlearn.model.LLStat llStat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLLStat(llStat);
	}

	/**
	* Creates a new LangLearnStatistics with the primary key. Does not add the LangLearnStatistics to the database.
	*
	* @param statId the primary key for the new LangLearnStatistics
	* @return the new LangLearnStatistics
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat createLLStat(
		long statId) {
		return getService().createLLStat(statId);
	}

	/**
	* Deletes the LangLearnStatistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statId the primary key of the LangLearnStatistics
	* @return the LangLearnStatistics that was removed
	* @throws PortalException if a LangLearnStatistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat deleteLLStat(
		long statId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLLStat(statId);
	}

	/**
	* Deletes the LangLearnStatistics from the database. Also notifies the appropriate model listeners.
	*
	* @param llStat the LangLearnStatistics
	* @return the LangLearnStatistics that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat deleteLLStat(
		ru.psavinov.liferay.langlearn.model.LLStat llStat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLLStat(llStat);
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

	public static ru.psavinov.liferay.langlearn.model.LLStat fetchLLStat(
		long statId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLLStat(statId);
	}

	/**
	* Returns the LangLearnStatistics with the primary key.
	*
	* @param statId the primary key of the LangLearnStatistics
	* @return the LangLearnStatistics
	* @throws PortalException if a LangLearnStatistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat getLLStat(
		long statId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLStat(statId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> getLLStats(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLStats(start, end);
	}

	/**
	* Returns the number of LangLearnStatisticses.
	*
	* @return the number of LangLearnStatisticses
	* @throws SystemException if a system exception occurred
	*/
	public static int getLLStatsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLLStatsCount();
	}

	/**
	* Updates the LangLearnStatistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llStat the LangLearnStatistics
	* @return the LangLearnStatistics that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat updateLLStat(
		ru.psavinov.liferay.langlearn.model.LLStat llStat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLLStat(llStat);
	}

	/**
	* Updates the LangLearnStatistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param llStat the LangLearnStatistics
	* @param merge whether to merge the LangLearnStatistics with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the LangLearnStatistics that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.psavinov.liferay.langlearn.model.LLStat updateLLStat(
		ru.psavinov.liferay.langlearn.model.LLStat llStat, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLLStat(llStat, merge);
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

	public static java.util.List<ru.psavinov.liferay.langlearn.model.LLStat> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(userId);
	}

	public static ru.psavinov.liferay.langlearn.model.LLStat findByUserIdAndType(
		long userId, int type)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.psavinov.liferay.langlearn.NoSuchLLStatException {
		return getService().findByUserIdAndType(userId, type);
	}

	public static void clearService() {
		_service = null;
	}

	public static LLStatLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LLStatLocalService.class.getName());

			if (invokableLocalService instanceof LLStatLocalService) {
				_service = (LLStatLocalService)invokableLocalService;
			}
			else {
				_service = new LLStatLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LLStatLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LLStatLocalService service) {
	}

	private static LLStatLocalService _service;
}
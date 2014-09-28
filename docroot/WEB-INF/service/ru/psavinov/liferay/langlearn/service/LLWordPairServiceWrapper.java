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
 * This class is a wrapper for {@link LLWordPairService}.
 * </p>
 *
 * @author    Pavel Savinov
 * @see       LLWordPairService
 * @generated
 */
public class LLWordPairServiceWrapper implements LLWordPairService,
	ServiceWrapper<LLWordPairService> {
	public LLWordPairServiceWrapper(LLWordPairService llWordPairService) {
		_llWordPairService = llWordPairService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _llWordPairService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_llWordPairService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _llWordPairService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LLWordPairService getWrappedLLWordPairService() {
		return _llWordPairService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLLWordPairService(LLWordPairService llWordPairService) {
		_llWordPairService = llWordPairService;
	}

	public LLWordPairService getWrappedService() {
		return _llWordPairService;
	}

	public void setWrappedService(LLWordPairService llWordPairService) {
		_llWordPairService = llWordPairService;
	}

	private LLWordPairService _llWordPairService;
}
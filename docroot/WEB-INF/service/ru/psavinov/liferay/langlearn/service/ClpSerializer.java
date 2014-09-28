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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import ru.psavinov.liferay.langlearn.model.LLSettingsClp;
import ru.psavinov.liferay.langlearn.model.LLStatClp;
import ru.psavinov.liferay.langlearn.model.LLWordClp;
import ru.psavinov.liferay.langlearn.model.LLWordPairClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"LangLearn-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"LangLearn-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "LangLearn-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LLSettingsClp.class.getName())) {
			return translateInputLLSettings(oldModel);
		}

		if (oldModelClassName.equals(LLStatClp.class.getName())) {
			return translateInputLLStat(oldModel);
		}

		if (oldModelClassName.equals(LLWordClp.class.getName())) {
			return translateInputLLWord(oldModel);
		}

		if (oldModelClassName.equals(LLWordPairClp.class.getName())) {
			return translateInputLLWordPair(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputLLSettings(BaseModel<?> oldModel) {
		LLSettingsClp oldClpModel = (LLSettingsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLLSettingsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLLStat(BaseModel<?> oldModel) {
		LLStatClp oldClpModel = (LLStatClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLLStatRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLLWord(BaseModel<?> oldModel) {
		LLWordClp oldClpModel = (LLWordClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLLWordRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLLWordPair(BaseModel<?> oldModel) {
		LLWordPairClp oldClpModel = (LLWordPairClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLLWordPairRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"ru.psavinov.liferay.langlearn.model.impl.LLSettingsImpl")) {
			return translateOutputLLSettings(oldModel);
		}

		if (oldModelClassName.equals(
					"ru.psavinov.liferay.langlearn.model.impl.LLStatImpl")) {
			return translateOutputLLStat(oldModel);
		}

		if (oldModelClassName.equals(
					"ru.psavinov.liferay.langlearn.model.impl.LLWordImpl")) {
			return translateOutputLLWord(oldModel);
		}

		if (oldModelClassName.equals(
					"ru.psavinov.liferay.langlearn.model.impl.LLWordPairImpl")) {
			return translateOutputLLWordPair(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"ru.psavinov.liferay.langlearn.NoSuchLLSettingsException")) {
			return new ru.psavinov.liferay.langlearn.NoSuchLLSettingsException();
		}

		if (className.equals(
					"ru.psavinov.liferay.langlearn.NoSuchLLStatException")) {
			return new ru.psavinov.liferay.langlearn.NoSuchLLStatException();
		}

		if (className.equals(
					"ru.psavinov.liferay.langlearn.NoSuchLLWordException")) {
			return new ru.psavinov.liferay.langlearn.NoSuchLLWordException();
		}

		if (className.equals(
					"ru.psavinov.liferay.langlearn.NoSuchLLWordPairException")) {
			return new ru.psavinov.liferay.langlearn.NoSuchLLWordPairException();
		}

		return throwable;
	}

	public static Object translateOutputLLSettings(BaseModel<?> oldModel) {
		LLSettingsClp newModel = new LLSettingsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLLSettingsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLLStat(BaseModel<?> oldModel) {
		LLStatClp newModel = new LLStatClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLLStatRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLLWord(BaseModel<?> oldModel) {
		LLWordClp newModel = new LLWordClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLLWordRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLLWordPair(BaseModel<?> oldModel) {
		LLWordPairClp newModel = new LLWordPairClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLLWordPairRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
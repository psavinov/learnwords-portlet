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

package ru.psavinov.liferay.langlearn.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import ru.psavinov.liferay.langlearn.NoSuchLLWordException;
import ru.psavinov.liferay.langlearn.model.LLWord;
import ru.psavinov.liferay.langlearn.model.LLWordPair;
import ru.psavinov.liferay.langlearn.service.base.LLWordLocalServiceBaseImpl;
import ru.psavinov.liferay.langlearn.service.persistence.LLWordPairUtil;
import ru.psavinov.liferay.langlearn.service.persistence.LLWordUtil;

/**
 * The implementation of the LangLeardWord local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.psavinov.liferay.langlearn.service.LLWordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pavel Savinov
 * @see ru.psavinov.liferay.langlearn.service.base.LLWordLocalServiceBaseImpl
 * @see ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil
 */
public class LLWordLocalServiceImpl extends LLWordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil} to access the LangLeardWord local service.
	 */
	public LLWord findByWordAndLocale(String word, String locale) throws SystemException, NoSuchLLWordException {
		return LLWordUtil.findByWordAndLocale(word,locale);
	}
	
	public List<LLWord> findByLocale(String locale) throws SystemException {
		return LLWordUtil.findByLocale(locale);
	}
	
	public List<LLWord> findByLocale(String locale,int start, int end) throws SystemException {
		return LLWordUtil.findByLocale(locale,start,end);
		
	}
	
	public List<LLWord> findByLocaleWithPair(String locale) throws SystemException {
		DynamicQuery wordQuery = DynamicQueryFactoryUtil.forClass(LLWord.class);
		List<LLWordPair> pairList = LLWordPairUtil.findAll();
		wordQuery.add(PropertyFactoryUtil.forName("locale").eq(locale));
		Long[] idArray = new Long[pairList.size()];
		int k=0;
		for (LLWordPair pair : pairList){
			idArray[k++] = pair.getWordFromId();
		}
		
		wordQuery.add(PropertyFactoryUtil.forName("wordId").in(idArray));
		return LLWordUtil.findWithDynamicQuery(wordQuery);
	}
	
	public List<LLWord> findByLocaleWithPair(String locale,int start, int end) throws SystemException {
		DynamicQuery wordQuery = DynamicQueryFactoryUtil.forClass(LLWord.class);
		List<LLWordPair> pairList = LLWordPairUtil.findAll();
		wordQuery.add(PropertyFactoryUtil.forName("locale").eq(locale));
		Long[] idArray = new Long[pairList.size()];
		int k=0;
		for (LLWordPair pair : pairList){
			idArray[k++] = pair.getWordFromId();
		}
		
		wordQuery.add(PropertyFactoryUtil.forName("wordId").in(idArray));
		return LLWordUtil.findWithDynamicQuery(wordQuery, start, end);
	}
}
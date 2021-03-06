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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;
import ru.psavinov.liferay.langlearn.model.LLWord;
import ru.psavinov.liferay.langlearn.model.LLWordPair;
import ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil;
import ru.psavinov.liferay.langlearn.service.base.LLWordPairLocalServiceBaseImpl;
import ru.psavinov.liferay.langlearn.service.persistence.LLWordPairUtil;

/**
 * The implementation of the LangLearnWordPair local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.psavinov.liferay.langlearn.service.LLWordPairLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pavel Savinov
 * @see ru.psavinov.liferay.langlearn.service.base.LLWordPairLocalServiceBaseImpl
 * @see ru.psavinov.liferay.langlearn.service.LLWordPairLocalServiceUtil
 */
public class LLWordPairLocalServiceImpl extends LLWordPairLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ru.psavinov.liferay.langlearn.service.LLWordPairLocalServiceUtil} to access the LangLearnWordPair local service.
	 */
	public List<LLWordPair> findByWordFrom (long wordFromId) throws SystemException {
		return LLWordPairUtil.findByWordFrom(wordFromId);
	}
	
	public LLWordPair findByWordFromAndLocale(long wordFromId,String locale) throws SystemException {
		List<LLWordPair> list = LLWordPairUtil.findByWordFrom(wordFromId);
		if (!list.isEmpty()) {
			for (LLWordPair pair : list) {
				try {
					LLWord wordTo = LLWordLocalServiceUtil.getLLWord(pair.getWordToId());
					if (wordTo.getLocale().equals(locale)) {
						return pair;
					}
				} catch (PortalException e) {
					e.printStackTrace();
				}
				
			}
		}
		return null;
	}
	
	public LLWordPair findByWords(long wordFromId, long wordToId) throws SystemException, NoSuchLLWordPairException {
		return LLWordPairUtil.findByWords(wordFromId,wordToId);
	}
}
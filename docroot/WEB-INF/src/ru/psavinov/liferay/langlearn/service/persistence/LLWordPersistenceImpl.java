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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.psavinov.liferay.langlearn.NoSuchLLWordException;
import ru.psavinov.liferay.langlearn.model.LLWord;
import ru.psavinov.liferay.langlearn.model.impl.LLWordImpl;
import ru.psavinov.liferay.langlearn.model.impl.LLWordModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the LangLeardWord service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPersistence
 * @see LLWordUtil
 * @generated
 */
public class LLWordPersistenceImpl extends BasePersistenceImpl<LLWord>
	implements LLWordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LLWordUtil} to access the LangLeardWord persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LLWordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_WORDANDLOCALE = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, LLWordImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWordAndLocale",
			new String[] { String.class.getName(), String.class.getName() },
			LLWordModelImpl.WORD_COLUMN_BITMASK |
			LLWordModelImpl.LOCALE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORDANDLOCALE = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWordAndLocale",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALE = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, LLWordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocale",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE =
		new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, LLWordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocale",
			new String[] { String.class.getName() },
			LLWordModelImpl.LOCALE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCALE = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocale",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, LLWordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, LLWordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the LangLeardWord in the entity cache if it is enabled.
	 *
	 * @param llWord the LangLeardWord
	 */
	public void cacheResult(LLWord llWord) {
		EntityCacheUtil.putResult(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordImpl.class, llWord.getPrimaryKey(), llWord);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
			new Object[] { llWord.getWord(), llWord.getLocale() }, llWord);

		llWord.resetOriginalValues();
	}

	/**
	 * Caches the LangLeardWords in the entity cache if it is enabled.
	 *
	 * @param llWords the LangLeardWords
	 */
	public void cacheResult(List<LLWord> llWords) {
		for (LLWord llWord : llWords) {
			if (EntityCacheUtil.getResult(
						LLWordModelImpl.ENTITY_CACHE_ENABLED, LLWordImpl.class,
						llWord.getPrimaryKey()) == null) {
				cacheResult(llWord);
			}
			else {
				llWord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all LangLeardWords.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LLWordImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LLWordImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the LangLeardWord.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LLWord llWord) {
		EntityCacheUtil.removeResult(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordImpl.class, llWord.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(llWord);
	}

	@Override
	public void clearCache(List<LLWord> llWords) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LLWord llWord : llWords) {
			EntityCacheUtil.removeResult(LLWordModelImpl.ENTITY_CACHE_ENABLED,
				LLWordImpl.class, llWord.getPrimaryKey());

			clearUniqueFindersCache(llWord);
		}
	}

	protected void clearUniqueFindersCache(LLWord llWord) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
			new Object[] { llWord.getWord(), llWord.getLocale() });
	}

	/**
	 * Creates a new LangLeardWord with the primary key. Does not add the LangLeardWord to the database.
	 *
	 * @param wordId the primary key for the new LangLeardWord
	 * @return the new LangLeardWord
	 */
	public LLWord create(long wordId) {
		LLWord llWord = new LLWordImpl();

		llWord.setNew(true);
		llWord.setPrimaryKey(wordId);

		return llWord;
	}

	/**
	 * Removes the LangLeardWord with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wordId the primary key of the LangLeardWord
	 * @return the LangLeardWord that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord remove(long wordId)
		throws NoSuchLLWordException, SystemException {
		return remove(Long.valueOf(wordId));
	}

	/**
	 * Removes the LangLeardWord with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the LangLeardWord
	 * @return the LangLeardWord that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLWord remove(Serializable primaryKey)
		throws NoSuchLLWordException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LLWord llWord = (LLWord)session.get(LLWordImpl.class, primaryKey);

			if (llWord == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLLWordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(llWord);
		}
		catch (NoSuchLLWordException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LLWord removeImpl(LLWord llWord) throws SystemException {
		llWord = toUnwrappedModel(llWord);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, llWord);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(llWord);

		return llWord;
	}

	@Override
	public LLWord updateImpl(
		ru.psavinov.liferay.langlearn.model.LLWord llWord, boolean merge)
		throws SystemException {
		llWord = toUnwrappedModel(llWord);

		boolean isNew = llWord.isNew();

		LLWordModelImpl llWordModelImpl = (LLWordModelImpl)llWord;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, llWord, merge);

			llWord.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LLWordModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((llWordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { llWordModelImpl.getOriginalLocale() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE,
					args);

				args = new Object[] { llWordModelImpl.getLocale() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE,
					args);
			}
		}

		EntityCacheUtil.putResult(LLWordModelImpl.ENTITY_CACHE_ENABLED,
			LLWordImpl.class, llWord.getPrimaryKey(), llWord);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
				new Object[] { llWord.getWord(), llWord.getLocale() }, llWord);
		}
		else {
			if ((llWordModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WORDANDLOCALE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						llWordModelImpl.getOriginalWord(),
						
						llWordModelImpl.getOriginalLocale()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORDANDLOCALE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
					new Object[] { llWord.getWord(), llWord.getLocale() },
					llWord);
			}
		}

		return llWord;
	}

	protected LLWord toUnwrappedModel(LLWord llWord) {
		if (llWord instanceof LLWordImpl) {
			return llWord;
		}

		LLWordImpl llWordImpl = new LLWordImpl();

		llWordImpl.setNew(llWord.isNew());
		llWordImpl.setPrimaryKey(llWord.getPrimaryKey());

		llWordImpl.setWordId(llWord.getWordId());
		llWordImpl.setLocale(llWord.getLocale());
		llWordImpl.setWord(llWord.getWord());
		llWordImpl.setCompanyId(llWord.getCompanyId());
		llWordImpl.setUserId(llWord.getUserId());
		llWordImpl.setUserName(llWord.getUserName());
		llWordImpl.setCreateDate(llWord.getCreateDate());
		llWordImpl.setModifiedDate(llWord.getModifiedDate());

		return llWordImpl;
	}

	/**
	 * Returns the LangLeardWord with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLeardWord
	 * @return the LangLeardWord
	 * @throws com.liferay.portal.NoSuchModelException if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLWord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLeardWord with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordException} if it could not be found.
	 *
	 * @param wordId the primary key of the LangLeardWord
	 * @return the LangLeardWord
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord findByPrimaryKey(long wordId)
		throws NoSuchLLWordException, SystemException {
		LLWord llWord = fetchByPrimaryKey(wordId);

		if (llWord == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + wordId);
			}

			throw new NoSuchLLWordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				wordId);
		}

		return llWord;
	}

	/**
	 * Returns the LangLeardWord with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLeardWord
	 * @return the LangLeardWord, or <code>null</code> if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLWord fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLeardWord with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wordId the primary key of the LangLeardWord
	 * @return the LangLeardWord, or <code>null</code> if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord fetchByPrimaryKey(long wordId) throws SystemException {
		LLWord llWord = (LLWord)EntityCacheUtil.getResult(LLWordModelImpl.ENTITY_CACHE_ENABLED,
				LLWordImpl.class, wordId);

		if (llWord == _nullLLWord) {
			return null;
		}

		if (llWord == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				llWord = (LLWord)session.get(LLWordImpl.class,
						Long.valueOf(wordId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (llWord != null) {
					cacheResult(llWord);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LLWordModelImpl.ENTITY_CACHE_ENABLED,
						LLWordImpl.class, wordId, _nullLLWord);
				}

				closeSession(session);
			}
		}

		return llWord;
	}

	/**
	 * Returns the LangLeardWord where word = &#63; and locale = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordException} if it could not be found.
	 *
	 * @param word the word
	 * @param locale the locale
	 * @return the matching LangLeardWord
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord findByWordAndLocale(String word, String locale)
		throws NoSuchLLWordException, SystemException {
		LLWord llWord = fetchByWordAndLocale(word, locale);

		if (llWord == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("word=");
			msg.append(word);

			msg.append(", locale=");
			msg.append(locale);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLLWordException(msg.toString());
		}

		return llWord;
	}

	/**
	 * Returns the LangLeardWord where word = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param word the word
	 * @param locale the locale
	 * @return the matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord fetchByWordAndLocale(String word, String locale)
		throws SystemException {
		return fetchByWordAndLocale(word, locale, true);
	}

	/**
	 * Returns the LangLeardWord where word = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param word the word
	 * @param locale the locale
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord fetchByWordAndLocale(String word, String locale,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { word, locale };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
					finderArgs, this);
		}

		if (result instanceof LLWord) {
			LLWord llWord = (LLWord)result;

			if (!Validator.equals(word, llWord.getWord()) ||
					!Validator.equals(locale, llWord.getLocale())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LLWORD_WHERE);

			if (word == null) {
				query.append(_FINDER_COLUMN_WORDANDLOCALE_WORD_1);
			}
			else {
				if (word.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_WORD_3);
				}
				else {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_WORD_2);
				}
			}

			if (locale == null) {
				query.append(_FINDER_COLUMN_WORDANDLOCALE_LOCALE_1);
			}
			else {
				if (locale.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_LOCALE_3);
				}
				else {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_LOCALE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (word != null) {
					qPos.add(word);
				}

				if (locale != null) {
					qPos.add(locale);
				}

				List<LLWord> list = q.list();

				result = list;

				LLWord llWord = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
						finderArgs, list);
				}
				else {
					llWord = list.get(0);

					cacheResult(llWord);

					if ((llWord.getWord() == null) ||
							!llWord.getWord().equals(word) ||
							(llWord.getLocale() == null) ||
							!llWord.getLocale().equals(locale)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
							finderArgs, llWord);
					}
				}

				return llWord;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDANDLOCALE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (LLWord)result;
			}
		}
	}

	/**
	 * Returns all the LangLeardWords where locale = &#63;.
	 *
	 * @param locale the locale
	 * @return the matching LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWord> findByLocale(String locale) throws SystemException {
		return findByLocale(locale, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the LangLeardWords where locale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locale the locale
	 * @param start the lower bound of the range of LangLeardWords
	 * @param end the upper bound of the range of LangLeardWords (not inclusive)
	 * @return the range of matching LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWord> findByLocale(String locale, int start, int end)
		throws SystemException {
		return findByLocale(locale, start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLeardWords where locale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param locale the locale
	 * @param start the lower bound of the range of LangLeardWords
	 * @param end the upper bound of the range of LangLeardWords (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWord> findByLocale(String locale, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE;
			finderArgs = new Object[] { locale };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALE;
			finderArgs = new Object[] { locale, start, end, orderByComparator };
		}

		List<LLWord> list = (List<LLWord>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LLWord llWord : list) {
				if (!Validator.equals(locale, llWord.getLocale())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_LLWORD_WHERE);

			if (locale == null) {
				query.append(_FINDER_COLUMN_LOCALE_LOCALE_1);
			}
			else {
				if (locale.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LOCALE_LOCALE_3);
				}
				else {
					query.append(_FINDER_COLUMN_LOCALE_LOCALE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (locale != null) {
					qPos.add(locale);
				}

				list = (List<LLWord>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first LangLeardWord in the ordered set where locale = &#63;.
	 *
	 * @param locale the locale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching LangLeardWord
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord findByLocale_First(String locale,
		OrderByComparator orderByComparator)
		throws NoSuchLLWordException, SystemException {
		LLWord llWord = fetchByLocale_First(locale, orderByComparator);

		if (llWord != null) {
			return llWord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locale=");
		msg.append(locale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLLWordException(msg.toString());
	}

	/**
	 * Returns the first LangLeardWord in the ordered set where locale = &#63;.
	 *
	 * @param locale the locale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord fetchByLocale_First(String locale,
		OrderByComparator orderByComparator) throws SystemException {
		List<LLWord> list = findByLocale(locale, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last LangLeardWord in the ordered set where locale = &#63;.
	 *
	 * @param locale the locale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching LangLeardWord
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord findByLocale_Last(String locale,
		OrderByComparator orderByComparator)
		throws NoSuchLLWordException, SystemException {
		LLWord llWord = fetchByLocale_Last(locale, orderByComparator);

		if (llWord != null) {
			return llWord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locale=");
		msg.append(locale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLLWordException(msg.toString());
	}

	/**
	 * Returns the last LangLeardWord in the ordered set where locale = &#63;.
	 *
	 * @param locale the locale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching LangLeardWord, or <code>null</code> if a matching LangLeardWord could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord fetchByLocale_Last(String locale,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocale(locale);

		List<LLWord> list = findByLocale(locale, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the LangLeardWords before and after the current LangLeardWord in the ordered set where locale = &#63;.
	 *
	 * @param wordId the primary key of the current LangLeardWord
	 * @param locale the locale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next LangLeardWord
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordException if a LangLeardWord with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord[] findByLocale_PrevAndNext(long wordId, String locale,
		OrderByComparator orderByComparator)
		throws NoSuchLLWordException, SystemException {
		LLWord llWord = findByPrimaryKey(wordId);

		Session session = null;

		try {
			session = openSession();

			LLWord[] array = new LLWordImpl[3];

			array[0] = getByLocale_PrevAndNext(session, llWord, locale,
					orderByComparator, true);

			array[1] = llWord;

			array[2] = getByLocale_PrevAndNext(session, llWord, locale,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LLWord getByLocale_PrevAndNext(Session session, LLWord llWord,
		String locale, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LLWORD_WHERE);

		if (locale == null) {
			query.append(_FINDER_COLUMN_LOCALE_LOCALE_1);
		}
		else {
			if (locale.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALE_LOCALE_3);
			}
			else {
				query.append(_FINDER_COLUMN_LOCALE_LOCALE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (locale != null) {
			qPos.add(locale);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(llWord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LLWord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the LangLeardWords.
	 *
	 * @return the LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWord> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<LLWord> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLeardWords.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of LangLeardWords
	 * @param end the upper bound of the range of LangLeardWords (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWord> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LLWord> list = (List<LLWord>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LLWORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LLWORD;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LLWord>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LLWord>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the LangLeardWord where word = &#63; and locale = &#63; from the database.
	 *
	 * @param word the word
	 * @param locale the locale
	 * @return the LangLeardWord that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public LLWord removeByWordAndLocale(String word, String locale)
		throws NoSuchLLWordException, SystemException {
		LLWord llWord = findByWordAndLocale(word, locale);

		return remove(llWord);
	}

	/**
	 * Removes all the LangLeardWords where locale = &#63; from the database.
	 *
	 * @param locale the locale
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLocale(String locale) throws SystemException {
		for (LLWord llWord : findByLocale(locale)) {
			remove(llWord);
		}
	}

	/**
	 * Removes all the LangLeardWords from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LLWord llWord : findAll()) {
			remove(llWord);
		}
	}

	/**
	 * Returns the number of LangLeardWords where word = &#63; and locale = &#63;.
	 *
	 * @param word the word
	 * @param locale the locale
	 * @return the number of matching LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public int countByWordAndLocale(String word, String locale)
		throws SystemException {
		Object[] finderArgs = new Object[] { word, locale };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORDANDLOCALE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LLWORD_WHERE);

			if (word == null) {
				query.append(_FINDER_COLUMN_WORDANDLOCALE_WORD_1);
			}
			else {
				if (word.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_WORD_3);
				}
				else {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_WORD_2);
				}
			}

			if (locale == null) {
				query.append(_FINDER_COLUMN_WORDANDLOCALE_LOCALE_1);
			}
			else {
				if (locale.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_LOCALE_3);
				}
				else {
					query.append(_FINDER_COLUMN_WORDANDLOCALE_LOCALE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (word != null) {
					qPos.add(word);
				}

				if (locale != null) {
					qPos.add(locale);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORDANDLOCALE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLeardWords where locale = &#63;.
	 *
	 * @param locale the locale
	 * @return the number of matching LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLocale(String locale) throws SystemException {
		Object[] finderArgs = new Object[] { locale };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCALE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LLWORD_WHERE);

			if (locale == null) {
				query.append(_FINDER_COLUMN_LOCALE_LOCALE_1);
			}
			else {
				if (locale.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LOCALE_LOCALE_3);
				}
				else {
					query.append(_FINDER_COLUMN_LOCALE_LOCALE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (locale != null) {
					qPos.add(locale);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCALE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLeardWords.
	 *
	 * @return the number of LangLeardWords
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LLWORD);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the LangLeardWord persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ru.psavinov.liferay.langlearn.model.LLWord")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LLWord>> listenersList = new ArrayList<ModelListener<LLWord>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LLWord>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LLWordImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LLSettingsPersistence.class)
	protected LLSettingsPersistence llSettingsPersistence;
	@BeanReference(type = LLStatPersistence.class)
	protected LLStatPersistence llStatPersistence;
	@BeanReference(type = LLWordPersistence.class)
	protected LLWordPersistence llWordPersistence;
	@BeanReference(type = LLWordPairPersistence.class)
	protected LLWordPairPersistence llWordPairPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LLWORD = "SELECT llWord FROM LLWord llWord";
	private static final String _SQL_SELECT_LLWORD_WHERE = "SELECT llWord FROM LLWord llWord WHERE ";
	private static final String _SQL_COUNT_LLWORD = "SELECT COUNT(llWord) FROM LLWord llWord";
	private static final String _SQL_COUNT_LLWORD_WHERE = "SELECT COUNT(llWord) FROM LLWord llWord WHERE ";
	private static final String _FINDER_COLUMN_WORDANDLOCALE_WORD_1 = "llWord.word IS NULL AND ";
	private static final String _FINDER_COLUMN_WORDANDLOCALE_WORD_2 = "llWord.word = ? AND ";
	private static final String _FINDER_COLUMN_WORDANDLOCALE_WORD_3 = "(llWord.word IS NULL OR llWord.word = ?) AND ";
	private static final String _FINDER_COLUMN_WORDANDLOCALE_LOCALE_1 = "llWord.locale IS NULL";
	private static final String _FINDER_COLUMN_WORDANDLOCALE_LOCALE_2 = "llWord.locale = ?";
	private static final String _FINDER_COLUMN_WORDANDLOCALE_LOCALE_3 = "(llWord.locale IS NULL OR llWord.locale = ?)";
	private static final String _FINDER_COLUMN_LOCALE_LOCALE_1 = "llWord.locale IS NULL";
	private static final String _FINDER_COLUMN_LOCALE_LOCALE_2 = "llWord.locale = ?";
	private static final String _FINDER_COLUMN_LOCALE_LOCALE_3 = "(llWord.locale IS NULL OR llWord.locale = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "llWord.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LLWord exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LLWord exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LLWordPersistenceImpl.class);
	private static LLWord _nullLLWord = new LLWordImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LLWord> toCacheModel() {
				return _nullLLWordCacheModel;
			}
		};

	private static CacheModel<LLWord> _nullLLWordCacheModel = new CacheModel<LLWord>() {
			public LLWord toEntityModel() {
				return _nullLLWord;
			}
		};
}
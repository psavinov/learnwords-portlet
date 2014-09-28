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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;
import ru.psavinov.liferay.langlearn.model.LLWordPair;
import ru.psavinov.liferay.langlearn.model.impl.LLWordPairImpl;
import ru.psavinov.liferay.langlearn.model.impl.LLWordPairModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the LangLearnWordPair service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLWordPairPersistence
 * @see LLWordPairUtil
 * @generated
 */
public class LLWordPairPersistenceImpl extends BasePersistenceImpl<LLWordPair>
	implements LLWordPairPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LLWordPairUtil} to access the LangLearnWordPair persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LLWordPairImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORDFROM = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, LLWordPairImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWordFrom",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORDFROM =
		new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, LLWordPairImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWordFrom",
			new String[] { Long.class.getName() },
			LLWordPairModelImpl.WORDFROMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORDFROM = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWordFrom",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_WORDS = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, LLWordPairImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWords",
			new String[] { Long.class.getName(), Long.class.getName() },
			LLWordPairModelImpl.WORDFROMID_COLUMN_BITMASK |
			LLWordPairModelImpl.WORDTOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORDS = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWords",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, LLWordPairImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, LLWordPairImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the LangLearnWordPair in the entity cache if it is enabled.
	 *
	 * @param llWordPair the LangLearnWordPair
	 */
	public void cacheResult(LLWordPair llWordPair) {
		EntityCacheUtil.putResult(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairImpl.class, llWordPair.getPrimaryKey(), llWordPair);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDS,
			new Object[] {
				Long.valueOf(llWordPair.getWordFromId()),
				Long.valueOf(llWordPair.getWordToId())
			}, llWordPair);

		llWordPair.resetOriginalValues();
	}

	/**
	 * Caches the LangLearnWordPairs in the entity cache if it is enabled.
	 *
	 * @param llWordPairs the LangLearnWordPairs
	 */
	public void cacheResult(List<LLWordPair> llWordPairs) {
		for (LLWordPair llWordPair : llWordPairs) {
			if (EntityCacheUtil.getResult(
						LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
						LLWordPairImpl.class, llWordPair.getPrimaryKey()) == null) {
				cacheResult(llWordPair);
			}
			else {
				llWordPair.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all LangLearnWordPairs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LLWordPairImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LLWordPairImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the LangLearnWordPair.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LLWordPair llWordPair) {
		EntityCacheUtil.removeResult(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairImpl.class, llWordPair.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(llWordPair);
	}

	@Override
	public void clearCache(List<LLWordPair> llWordPairs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LLWordPair llWordPair : llWordPairs) {
			EntityCacheUtil.removeResult(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
				LLWordPairImpl.class, llWordPair.getPrimaryKey());

			clearUniqueFindersCache(llWordPair);
		}
	}

	protected void clearUniqueFindersCache(LLWordPair llWordPair) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDS,
			new Object[] {
				Long.valueOf(llWordPair.getWordFromId()),
				Long.valueOf(llWordPair.getWordToId())
			});
	}

	/**
	 * Creates a new LangLearnWordPair with the primary key. Does not add the LangLearnWordPair to the database.
	 *
	 * @param wordPairId the primary key for the new LangLearnWordPair
	 * @return the new LangLearnWordPair
	 */
	public LLWordPair create(long wordPairId) {
		LLWordPair llWordPair = new LLWordPairImpl();

		llWordPair.setNew(true);
		llWordPair.setPrimaryKey(wordPairId);

		return llWordPair;
	}

	/**
	 * Removes the LangLearnWordPair with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wordPairId the primary key of the LangLearnWordPair
	 * @return the LangLearnWordPair that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair remove(long wordPairId)
		throws NoSuchLLWordPairException, SystemException {
		return remove(Long.valueOf(wordPairId));
	}

	/**
	 * Removes the LangLearnWordPair with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the LangLearnWordPair
	 * @return the LangLearnWordPair that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLWordPair remove(Serializable primaryKey)
		throws NoSuchLLWordPairException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LLWordPair llWordPair = (LLWordPair)session.get(LLWordPairImpl.class,
					primaryKey);

			if (llWordPair == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLLWordPairException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(llWordPair);
		}
		catch (NoSuchLLWordPairException nsee) {
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
	protected LLWordPair removeImpl(LLWordPair llWordPair)
		throws SystemException {
		llWordPair = toUnwrappedModel(llWordPair);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, llWordPair);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(llWordPair);

		return llWordPair;
	}

	@Override
	public LLWordPair updateImpl(
		ru.psavinov.liferay.langlearn.model.LLWordPair llWordPair, boolean merge)
		throws SystemException {
		llWordPair = toUnwrappedModel(llWordPair);

		boolean isNew = llWordPair.isNew();

		LLWordPairModelImpl llWordPairModelImpl = (LLWordPairModelImpl)llWordPair;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, llWordPair, merge);

			llWordPair.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LLWordPairModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((llWordPairModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORDFROM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(llWordPairModelImpl.getOriginalWordFromId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORDFROM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORDFROM,
					args);

				args = new Object[] {
						Long.valueOf(llWordPairModelImpl.getWordFromId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORDFROM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORDFROM,
					args);
			}
		}

		EntityCacheUtil.putResult(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
			LLWordPairImpl.class, llWordPair.getPrimaryKey(), llWordPair);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDS,
				new Object[] {
					Long.valueOf(llWordPair.getWordFromId()),
					Long.valueOf(llWordPair.getWordToId())
				}, llWordPair);
		}
		else {
			if ((llWordPairModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WORDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(llWordPairModelImpl.getOriginalWordFromId()),
						Long.valueOf(llWordPairModelImpl.getOriginalWordToId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORDS, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDS, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDS,
					new Object[] {
						Long.valueOf(llWordPair.getWordFromId()),
						Long.valueOf(llWordPair.getWordToId())
					}, llWordPair);
			}
		}

		return llWordPair;
	}

	protected LLWordPair toUnwrappedModel(LLWordPair llWordPair) {
		if (llWordPair instanceof LLWordPairImpl) {
			return llWordPair;
		}

		LLWordPairImpl llWordPairImpl = new LLWordPairImpl();

		llWordPairImpl.setNew(llWordPair.isNew());
		llWordPairImpl.setPrimaryKey(llWordPair.getPrimaryKey());

		llWordPairImpl.setWordPairId(llWordPair.getWordPairId());
		llWordPairImpl.setWordFromId(llWordPair.getWordFromId());
		llWordPairImpl.setWordToId(llWordPair.getWordToId());
		llWordPairImpl.setCompanyId(llWordPair.getCompanyId());
		llWordPairImpl.setUserId(llWordPair.getUserId());
		llWordPairImpl.setUserName(llWordPair.getUserName());
		llWordPairImpl.setCreateDate(llWordPair.getCreateDate());
		llWordPairImpl.setModifiedDate(llWordPair.getModifiedDate());

		return llWordPairImpl;
	}

	/**
	 * Returns the LangLearnWordPair with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLearnWordPair
	 * @return the LangLearnWordPair
	 * @throws com.liferay.portal.NoSuchModelException if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLWordPair findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLearnWordPair with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordPairException} if it could not be found.
	 *
	 * @param wordPairId the primary key of the LangLearnWordPair
	 * @return the LangLearnWordPair
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair findByPrimaryKey(long wordPairId)
		throws NoSuchLLWordPairException, SystemException {
		LLWordPair llWordPair = fetchByPrimaryKey(wordPairId);

		if (llWordPair == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + wordPairId);
			}

			throw new NoSuchLLWordPairException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				wordPairId);
		}

		return llWordPair;
	}

	/**
	 * Returns the LangLearnWordPair with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLearnWordPair
	 * @return the LangLearnWordPair, or <code>null</code> if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLWordPair fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLearnWordPair with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wordPairId the primary key of the LangLearnWordPair
	 * @return the LangLearnWordPair, or <code>null</code> if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair fetchByPrimaryKey(long wordPairId)
		throws SystemException {
		LLWordPair llWordPair = (LLWordPair)EntityCacheUtil.getResult(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
				LLWordPairImpl.class, wordPairId);

		if (llWordPair == _nullLLWordPair) {
			return null;
		}

		if (llWordPair == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				llWordPair = (LLWordPair)session.get(LLWordPairImpl.class,
						Long.valueOf(wordPairId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (llWordPair != null) {
					cacheResult(llWordPair);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LLWordPairModelImpl.ENTITY_CACHE_ENABLED,
						LLWordPairImpl.class, wordPairId, _nullLLWordPair);
				}

				closeSession(session);
			}
		}

		return llWordPair;
	}

	/**
	 * Returns all the LangLearnWordPairs where wordFromId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @return the matching LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWordPair> findByWordFrom(long wordFromId)
		throws SystemException {
		return findByWordFrom(wordFromId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the LangLearnWordPairs where wordFromId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param wordFromId the word from ID
	 * @param start the lower bound of the range of LangLearnWordPairs
	 * @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	 * @return the range of matching LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWordPair> findByWordFrom(long wordFromId, int start, int end)
		throws SystemException {
		return findByWordFrom(wordFromId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLearnWordPairs where wordFromId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param wordFromId the word from ID
	 * @param start the lower bound of the range of LangLearnWordPairs
	 * @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWordPair> findByWordFrom(long wordFromId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORDFROM;
			finderArgs = new Object[] { wordFromId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORDFROM;
			finderArgs = new Object[] { wordFromId, start, end, orderByComparator };
		}

		List<LLWordPair> list = (List<LLWordPair>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LLWordPair llWordPair : list) {
				if ((wordFromId != llWordPair.getWordFromId())) {
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

			query.append(_SQL_SELECT_LLWORDPAIR_WHERE);

			query.append(_FINDER_COLUMN_WORDFROM_WORDFROMID_2);

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

				qPos.add(wordFromId);

				list = (List<LLWordPair>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first LangLearnWordPair in the ordered set where wordFromId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching LangLearnWordPair
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair findByWordFrom_First(long wordFromId,
		OrderByComparator orderByComparator)
		throws NoSuchLLWordPairException, SystemException {
		LLWordPair llWordPair = fetchByWordFrom_First(wordFromId,
				orderByComparator);

		if (llWordPair != null) {
			return llWordPair;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wordFromId=");
		msg.append(wordFromId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLLWordPairException(msg.toString());
	}

	/**
	 * Returns the first LangLearnWordPair in the ordered set where wordFromId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair fetchByWordFrom_First(long wordFromId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LLWordPair> list = findByWordFrom(wordFromId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last LangLearnWordPair in the ordered set where wordFromId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching LangLearnWordPair
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair findByWordFrom_Last(long wordFromId,
		OrderByComparator orderByComparator)
		throws NoSuchLLWordPairException, SystemException {
		LLWordPair llWordPair = fetchByWordFrom_Last(wordFromId,
				orderByComparator);

		if (llWordPair != null) {
			return llWordPair;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wordFromId=");
		msg.append(wordFromId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLLWordPairException(msg.toString());
	}

	/**
	 * Returns the last LangLearnWordPair in the ordered set where wordFromId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair fetchByWordFrom_Last(long wordFromId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWordFrom(wordFromId);

		List<LLWordPair> list = findByWordFrom(wordFromId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the LangLearnWordPairs before and after the current LangLearnWordPair in the ordered set where wordFromId = &#63;.
	 *
	 * @param wordPairId the primary key of the current LangLearnWordPair
	 * @param wordFromId the word from ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next LangLearnWordPair
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a LangLearnWordPair with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair[] findByWordFrom_PrevAndNext(long wordPairId,
		long wordFromId, OrderByComparator orderByComparator)
		throws NoSuchLLWordPairException, SystemException {
		LLWordPair llWordPair = findByPrimaryKey(wordPairId);

		Session session = null;

		try {
			session = openSession();

			LLWordPair[] array = new LLWordPairImpl[3];

			array[0] = getByWordFrom_PrevAndNext(session, llWordPair,
					wordFromId, orderByComparator, true);

			array[1] = llWordPair;

			array[2] = getByWordFrom_PrevAndNext(session, llWordPair,
					wordFromId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LLWordPair getByWordFrom_PrevAndNext(Session session,
		LLWordPair llWordPair, long wordFromId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LLWORDPAIR_WHERE);

		query.append(_FINDER_COLUMN_WORDFROM_WORDFROMID_2);

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

		qPos.add(wordFromId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(llWordPair);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LLWordPair> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLWordPairException} if it could not be found.
	 *
	 * @param wordFromId the word from ID
	 * @param wordToId the word to ID
	 * @return the matching LangLearnWordPair
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLWordPairException if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair findByWords(long wordFromId, long wordToId)
		throws NoSuchLLWordPairException, SystemException {
		LLWordPair llWordPair = fetchByWords(wordFromId, wordToId);

		if (llWordPair == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("wordFromId=");
			msg.append(wordFromId);

			msg.append(", wordToId=");
			msg.append(wordToId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLLWordPairException(msg.toString());
		}

		return llWordPair;
	}

	/**
	 * Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wordFromId the word from ID
	 * @param wordToId the word to ID
	 * @return the matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair fetchByWords(long wordFromId, long wordToId)
		throws SystemException {
		return fetchByWords(wordFromId, wordToId, true);
	}

	/**
	 * Returns the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wordFromId the word from ID
	 * @param wordToId the word to ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching LangLearnWordPair, or <code>null</code> if a matching LangLearnWordPair could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair fetchByWords(long wordFromId, long wordToId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { wordFromId, wordToId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WORDS,
					finderArgs, this);
		}

		if (result instanceof LLWordPair) {
			LLWordPair llWordPair = (LLWordPair)result;

			if ((wordFromId != llWordPair.getWordFromId()) ||
					(wordToId != llWordPair.getWordToId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LLWORDPAIR_WHERE);

			query.append(_FINDER_COLUMN_WORDS_WORDFROMID_2);

			query.append(_FINDER_COLUMN_WORDS_WORDTOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wordFromId);

				qPos.add(wordToId);

				List<LLWordPair> list = q.list();

				result = list;

				LLWordPair llWordPair = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDS,
						finderArgs, list);
				}
				else {
					llWordPair = list.get(0);

					cacheResult(llWordPair);

					if ((llWordPair.getWordFromId() != wordFromId) ||
							(llWordPair.getWordToId() != wordToId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORDS,
							finderArgs, llWordPair);
					}
				}

				return llWordPair;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORDS,
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
				return (LLWordPair)result;
			}
		}
	}

	/**
	 * Returns all the LangLearnWordPairs.
	 *
	 * @return the LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWordPair> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<LLWordPair> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLearnWordPairs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of LangLearnWordPairs
	 * @param end the upper bound of the range of LangLearnWordPairs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLWordPair> findAll(int start, int end,
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

		List<LLWordPair> list = (List<LLWordPair>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LLWORDPAIR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LLWORDPAIR;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LLWordPair>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LLWordPair>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the LangLearnWordPairs where wordFromId = &#63; from the database.
	 *
	 * @param wordFromId the word from ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByWordFrom(long wordFromId) throws SystemException {
		for (LLWordPair llWordPair : findByWordFrom(wordFromId)) {
			remove(llWordPair);
		}
	}

	/**
	 * Removes the LangLearnWordPair where wordFromId = &#63; and wordToId = &#63; from the database.
	 *
	 * @param wordFromId the word from ID
	 * @param wordToId the word to ID
	 * @return the LangLearnWordPair that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public LLWordPair removeByWords(long wordFromId, long wordToId)
		throws NoSuchLLWordPairException, SystemException {
		LLWordPair llWordPair = findByWords(wordFromId, wordToId);

		return remove(llWordPair);
	}

	/**
	 * Removes all the LangLearnWordPairs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LLWordPair llWordPair : findAll()) {
			remove(llWordPair);
		}
	}

	/**
	 * Returns the number of LangLearnWordPairs where wordFromId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @return the number of matching LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByWordFrom(long wordFromId) throws SystemException {
		Object[] finderArgs = new Object[] { wordFromId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORDFROM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LLWORDPAIR_WHERE);

			query.append(_FINDER_COLUMN_WORDFROM_WORDFROMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wordFromId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORDFROM,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLearnWordPairs where wordFromId = &#63; and wordToId = &#63;.
	 *
	 * @param wordFromId the word from ID
	 * @param wordToId the word to ID
	 * @return the number of matching LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByWords(long wordFromId, long wordToId)
		throws SystemException {
		Object[] finderArgs = new Object[] { wordFromId, wordToId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LLWORDPAIR_WHERE);

			query.append(_FINDER_COLUMN_WORDS_WORDFROMID_2);

			query.append(_FINDER_COLUMN_WORDS_WORDTOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wordFromId);

				qPos.add(wordToId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORDS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLearnWordPairs.
	 *
	 * @return the number of LangLearnWordPairs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LLWORDPAIR);

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
	 * Initializes the LangLearnWordPair persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ru.psavinov.liferay.langlearn.model.LLWordPair")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LLWordPair>> listenersList = new ArrayList<ModelListener<LLWordPair>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LLWordPair>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LLWordPairImpl.class.getName());
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
	private static final String _SQL_SELECT_LLWORDPAIR = "SELECT llWordPair FROM LLWordPair llWordPair";
	private static final String _SQL_SELECT_LLWORDPAIR_WHERE = "SELECT llWordPair FROM LLWordPair llWordPair WHERE ";
	private static final String _SQL_COUNT_LLWORDPAIR = "SELECT COUNT(llWordPair) FROM LLWordPair llWordPair";
	private static final String _SQL_COUNT_LLWORDPAIR_WHERE = "SELECT COUNT(llWordPair) FROM LLWordPair llWordPair WHERE ";
	private static final String _FINDER_COLUMN_WORDFROM_WORDFROMID_2 = "llWordPair.wordFromId = ?";
	private static final String _FINDER_COLUMN_WORDS_WORDFROMID_2 = "llWordPair.wordFromId = ? AND ";
	private static final String _FINDER_COLUMN_WORDS_WORDTOID_2 = "llWordPair.wordToId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "llWordPair.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LLWordPair exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LLWordPair exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LLWordPairPersistenceImpl.class);
	private static LLWordPair _nullLLWordPair = new LLWordPairImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LLWordPair> toCacheModel() {
				return _nullLLWordPairCacheModel;
			}
		};

	private static CacheModel<LLWordPair> _nullLLWordPairCacheModel = new CacheModel<LLWordPair>() {
			public LLWordPair toEntityModel() {
				return _nullLLWordPair;
			}
		};
}
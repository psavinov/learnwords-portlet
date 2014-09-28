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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import ru.psavinov.liferay.langlearn.NoSuchLLStatException;
import ru.psavinov.liferay.langlearn.model.LLStat;
import ru.psavinov.liferay.langlearn.model.impl.LLStatImpl;
import ru.psavinov.liferay.langlearn.model.impl.LLStatModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the LangLearnStatistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLStatPersistence
 * @see LLStatUtil
 * @generated
 */
public class LLStatPersistenceImpl extends BasePersistenceImpl<LLStat>
	implements LLStatPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LLStatUtil} to access the LangLearnStatistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LLStatImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_STATCOUNTPERDAY = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, LLStatImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStatCountPerDay",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			},
			LLStatModelImpl.USERID_COLUMN_BITMASK |
			LLStatModelImpl.CREATEDATE_COLUMN_BITMASK |
			LLStatModelImpl.STATTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATCOUNTPERDAY = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatCountPerDay",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, LLStatImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, LLStatImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			LLStatModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDTYPE = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, LLStatImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdAndType",
			new String[] { Long.class.getName(), Integer.class.getName() },
			LLStatModelImpl.USERID_COLUMN_BITMASK |
			LLStatModelImpl.STATTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDTYPE = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdAndType",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, LLStatImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, LLStatImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the LangLearnStatistics in the entity cache if it is enabled.
	 *
	 * @param llStat the LangLearnStatistics
	 */
	public void cacheResult(LLStat llStat) {
		EntityCacheUtil.putResult(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatImpl.class, llStat.getPrimaryKey(), llStat);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
			new Object[] {
				Long.valueOf(llStat.getUserId()),
				
			llStat.getCreateDate(), Integer.valueOf(llStat.getStatType())
			}, llStat);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
			new Object[] {
				Long.valueOf(llStat.getUserId()),
				Integer.valueOf(llStat.getStatType())
			}, llStat);

		llStat.resetOriginalValues();
	}

	/**
	 * Caches the LangLearnStatisticses in the entity cache if it is enabled.
	 *
	 * @param llStats the LangLearnStatisticses
	 */
	public void cacheResult(List<LLStat> llStats) {
		for (LLStat llStat : llStats) {
			if (EntityCacheUtil.getResult(
						LLStatModelImpl.ENTITY_CACHE_ENABLED, LLStatImpl.class,
						llStat.getPrimaryKey()) == null) {
				cacheResult(llStat);
			}
			else {
				llStat.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all LangLearnStatisticses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LLStatImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LLStatImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the LangLearnStatistics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LLStat llStat) {
		EntityCacheUtil.removeResult(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatImpl.class, llStat.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(llStat);
	}

	@Override
	public void clearCache(List<LLStat> llStats) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LLStat llStat : llStats) {
			EntityCacheUtil.removeResult(LLStatModelImpl.ENTITY_CACHE_ENABLED,
				LLStatImpl.class, llStat.getPrimaryKey());

			clearUniqueFindersCache(llStat);
		}
	}

	protected void clearUniqueFindersCache(LLStat llStat) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
			new Object[] {
				Long.valueOf(llStat.getUserId()),
				
			llStat.getCreateDate(), Integer.valueOf(llStat.getStatType())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
			new Object[] {
				Long.valueOf(llStat.getUserId()),
				Integer.valueOf(llStat.getStatType())
			});
	}

	/**
	 * Creates a new LangLearnStatistics with the primary key. Does not add the LangLearnStatistics to the database.
	 *
	 * @param statId the primary key for the new LangLearnStatistics
	 * @return the new LangLearnStatistics
	 */
	public LLStat create(long statId) {
		LLStat llStat = new LLStatImpl();

		llStat.setNew(true);
		llStat.setPrimaryKey(statId);

		return llStat;
	}

	/**
	 * Removes the LangLearnStatistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statId the primary key of the LangLearnStatistics
	 * @return the LangLearnStatistics that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat remove(long statId)
		throws NoSuchLLStatException, SystemException {
		return remove(Long.valueOf(statId));
	}

	/**
	 * Removes the LangLearnStatistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the LangLearnStatistics
	 * @return the LangLearnStatistics that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLStat remove(Serializable primaryKey)
		throws NoSuchLLStatException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LLStat llStat = (LLStat)session.get(LLStatImpl.class, primaryKey);

			if (llStat == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLLStatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(llStat);
		}
		catch (NoSuchLLStatException nsee) {
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
	protected LLStat removeImpl(LLStat llStat) throws SystemException {
		llStat = toUnwrappedModel(llStat);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, llStat);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(llStat);

		return llStat;
	}

	@Override
	public LLStat updateImpl(
		ru.psavinov.liferay.langlearn.model.LLStat llStat, boolean merge)
		throws SystemException {
		llStat = toUnwrappedModel(llStat);

		boolean isNew = llStat.isNew();

		LLStatModelImpl llStatModelImpl = (LLStatModelImpl)llStat;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, llStat, merge);

			llStat.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LLStatModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((llStatModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(llStatModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { Long.valueOf(llStatModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(LLStatModelImpl.ENTITY_CACHE_ENABLED,
			LLStatImpl.class, llStat.getPrimaryKey(), llStat);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
				new Object[] {
					Long.valueOf(llStat.getUserId()),
					
				llStat.getCreateDate(), Integer.valueOf(llStat.getStatType())
				}, llStat);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
				new Object[] {
					Long.valueOf(llStat.getUserId()),
					Integer.valueOf(llStat.getStatType())
				}, llStat);
		}
		else {
			if ((llStatModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STATCOUNTPERDAY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(llStatModelImpl.getOriginalUserId()),
						
						llStatModelImpl.getOriginalCreateDate(),
						Integer.valueOf(llStatModelImpl.getOriginalStatType())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATCOUNTPERDAY,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
					new Object[] {
						Long.valueOf(llStat.getUserId()),
						
					llStat.getCreateDate(),
						Integer.valueOf(llStat.getStatType())
					}, llStat);
			}

			if ((llStatModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(llStatModelImpl.getOriginalUserId()),
						Integer.valueOf(llStatModelImpl.getOriginalStatType())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDTYPE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
					new Object[] {
						Long.valueOf(llStat.getUserId()),
						Integer.valueOf(llStat.getStatType())
					}, llStat);
			}
		}

		return llStat;
	}

	protected LLStat toUnwrappedModel(LLStat llStat) {
		if (llStat instanceof LLStatImpl) {
			return llStat;
		}

		LLStatImpl llStatImpl = new LLStatImpl();

		llStatImpl.setNew(llStat.isNew());
		llStatImpl.setPrimaryKey(llStat.getPrimaryKey());

		llStatImpl.setStatId(llStat.getStatId());
		llStatImpl.setStatType(llStat.getStatType());
		llStatImpl.setStatString(llStat.getStatString());
		llStatImpl.setStatInt(llStat.getStatInt());
		llStatImpl.setStatLong(llStat.getStatLong());
		llStatImpl.setCompanyId(llStat.getCompanyId());
		llStatImpl.setUserId(llStat.getUserId());
		llStatImpl.setUserName(llStat.getUserName());
		llStatImpl.setCreateDate(llStat.getCreateDate());
		llStatImpl.setModifiedDate(llStat.getModifiedDate());

		return llStatImpl;
	}

	/**
	 * Returns the LangLearnStatistics with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLearnStatistics
	 * @return the LangLearnStatistics
	 * @throws com.liferay.portal.NoSuchModelException if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLStat findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLearnStatistics with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLStatException} if it could not be found.
	 *
	 * @param statId the primary key of the LangLearnStatistics
	 * @return the LangLearnStatistics
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat findByPrimaryKey(long statId)
		throws NoSuchLLStatException, SystemException {
		LLStat llStat = fetchByPrimaryKey(statId);

		if (llStat == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + statId);
			}

			throw new NoSuchLLStatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				statId);
		}

		return llStat;
	}

	/**
	 * Returns the LangLearnStatistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLearnStatistics
	 * @return the LangLearnStatistics, or <code>null</code> if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLStat fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLearnStatistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statId the primary key of the LangLearnStatistics
	 * @return the LangLearnStatistics, or <code>null</code> if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByPrimaryKey(long statId) throws SystemException {
		LLStat llStat = (LLStat)EntityCacheUtil.getResult(LLStatModelImpl.ENTITY_CACHE_ENABLED,
				LLStatImpl.class, statId);

		if (llStat == _nullLLStat) {
			return null;
		}

		if (llStat == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				llStat = (LLStat)session.get(LLStatImpl.class,
						Long.valueOf(statId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (llStat != null) {
					cacheResult(llStat);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LLStatModelImpl.ENTITY_CACHE_ENABLED,
						LLStatImpl.class, statId, _nullLLStat);
				}

				closeSession(session);
			}
		}

		return llStat;
	}

	/**
	 * Returns the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLStatException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param statType the stat type
	 * @return the matching LangLearnStatistics
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat findByStatCountPerDay(long userId, Date createDate,
		int statType) throws NoSuchLLStatException, SystemException {
		LLStat llStat = fetchByStatCountPerDay(userId, createDate, statType);

		if (llStat == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", createDate=");
			msg.append(createDate);

			msg.append(", statType=");
			msg.append(statType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLLStatException(msg.toString());
		}

		return llStat;
	}

	/**
	 * Returns the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param statType the stat type
	 * @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByStatCountPerDay(long userId, Date createDate,
		int statType) throws SystemException {
		return fetchByStatCountPerDay(userId, createDate, statType, true);
	}

	/**
	 * Returns the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param statType the stat type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByStatCountPerDay(long userId, Date createDate,
		int statType, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, createDate, statType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
					finderArgs, this);
		}

		if (result instanceof LLStat) {
			LLStat llStat = (LLStat)result;

			if ((userId != llStat.getUserId()) ||
					!Validator.equals(createDate, llStat.getCreateDate()) ||
					(statType != llStat.getStatType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LLSTAT_WHERE);

			query.append(_FINDER_COLUMN_STATCOUNTPERDAY_USERID_2);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_STATCOUNTPERDAY_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_STATCOUNTPERDAY_CREATEDATE_2);
			}

			query.append(_FINDER_COLUMN_STATCOUNTPERDAY_STATTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				qPos.add(statType);

				List<LLStat> list = q.list();

				result = list;

				LLStat llStat = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
						finderArgs, list);
				}
				else {
					llStat = list.get(0);

					cacheResult(llStat);

					if ((llStat.getUserId() != userId) ||
							(llStat.getCreateDate() == null) ||
							!llStat.getCreateDate().equals(createDate) ||
							(llStat.getStatType() != statType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
							finderArgs, llStat);
					}
				}

				return llStat;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATCOUNTPERDAY,
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
				return (LLStat)result;
			}
		}
	}

	/**
	 * Returns all the LangLearnStatisticses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLStat> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the LangLearnStatisticses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of LangLearnStatisticses
	 * @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	 * @return the range of matching LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLStat> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLearnStatisticses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of LangLearnStatisticses
	 * @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLStat> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<LLStat> list = (List<LLStat>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LLStat llStat : list) {
				if ((userId != llStat.getUserId())) {
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

			query.append(_SQL_SELECT_LLSTAT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

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

				qPos.add(userId);

				list = (List<LLStat>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first LangLearnStatistics in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching LangLearnStatistics
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLLStatException, SystemException {
		LLStat llStat = fetchByUserId_First(userId, orderByComparator);

		if (llStat != null) {
			return llStat;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLLStatException(msg.toString());
	}

	/**
	 * Returns the first LangLearnStatistics in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LLStat> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last LangLearnStatistics in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching LangLearnStatistics
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLLStatException, SystemException {
		LLStat llStat = fetchByUserId_Last(userId, orderByComparator);

		if (llStat != null) {
			return llStat;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLLStatException(msg.toString());
	}

	/**
	 * Returns the last LangLearnStatistics in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<LLStat> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the LangLearnStatisticses before and after the current LangLearnStatistics in the ordered set where userId = &#63;.
	 *
	 * @param statId the primary key of the current LangLearnStatistics
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next LangLearnStatistics
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a LangLearnStatistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat[] findByUserId_PrevAndNext(long statId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLLStatException, SystemException {
		LLStat llStat = findByPrimaryKey(statId);

		Session session = null;

		try {
			session = openSession();

			LLStat[] array = new LLStatImpl[3];

			array[0] = getByUserId_PrevAndNext(session, llStat, userId,
					orderByComparator, true);

			array[1] = llStat;

			array[2] = getByUserId_PrevAndNext(session, llStat, userId,
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

	protected LLStat getByUserId_PrevAndNext(Session session, LLStat llStat,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LLSTAT_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(llStat);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LLStat> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the LangLearnStatistics where userId = &#63; and statType = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLStatException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param statType the stat type
	 * @return the matching LangLearnStatistics
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLStatException if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat findByUserIdAndType(long userId, int statType)
		throws NoSuchLLStatException, SystemException {
		LLStat llStat = fetchByUserIdAndType(userId, statType);

		if (llStat == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", statType=");
			msg.append(statType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLLStatException(msg.toString());
		}

		return llStat;
	}

	/**
	 * Returns the LangLearnStatistics where userId = &#63; and statType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param statType the stat type
	 * @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByUserIdAndType(long userId, int statType)
		throws SystemException {
		return fetchByUserIdAndType(userId, statType, true);
	}

	/**
	 * Returns the LangLearnStatistics where userId = &#63; and statType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param statType the stat type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching LangLearnStatistics, or <code>null</code> if a matching LangLearnStatistics could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat fetchByUserIdAndType(long userId, int statType,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, statType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
					finderArgs, this);
		}

		if (result instanceof LLStat) {
			LLStat llStat = (LLStat)result;

			if ((userId != llStat.getUserId()) ||
					(statType != llStat.getStatType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LLSTAT_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDTYPE_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDTYPE_STATTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(statType);

				List<LLStat> list = q.list();

				result = list;

				LLStat llStat = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
						finderArgs, list);
				}
				else {
					llStat = list.get(0);

					cacheResult(llStat);

					if ((llStat.getUserId() != userId) ||
							(llStat.getStatType() != statType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
							finderArgs, llStat);
					}
				}

				return llStat;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDTYPE,
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
				return (LLStat)result;
			}
		}
	}

	/**
	 * Returns all the LangLearnStatisticses.
	 *
	 * @return the LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLStat> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<LLStat> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLearnStatisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of LangLearnStatisticses
	 * @param end the upper bound of the range of LangLearnStatisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLStat> findAll(int start, int end,
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

		List<LLStat> list = (List<LLStat>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LLSTAT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LLSTAT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LLStat>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LLStat>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes the LangLearnStatistics where userId = &#63; and createDate = &#63; and statType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param statType the stat type
	 * @return the LangLearnStatistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat removeByStatCountPerDay(long userId, Date createDate,
		int statType) throws NoSuchLLStatException, SystemException {
		LLStat llStat = findByStatCountPerDay(userId, createDate, statType);

		return remove(llStat);
	}

	/**
	 * Removes all the LangLearnStatisticses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (LLStat llStat : findByUserId(userId)) {
			remove(llStat);
		}
	}

	/**
	 * Removes the LangLearnStatistics where userId = &#63; and statType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param statType the stat type
	 * @return the LangLearnStatistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public LLStat removeByUserIdAndType(long userId, int statType)
		throws NoSuchLLStatException, SystemException {
		LLStat llStat = findByUserIdAndType(userId, statType);

		return remove(llStat);
	}

	/**
	 * Removes all the LangLearnStatisticses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LLStat llStat : findAll()) {
			remove(llStat);
		}
	}

	/**
	 * Returns the number of LangLearnStatisticses where userId = &#63; and createDate = &#63; and statType = &#63;.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param statType the stat type
	 * @return the number of matching LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatCountPerDay(long userId, Date createDate, int statType)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, createDate, statType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATCOUNTPERDAY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LLSTAT_WHERE);

			query.append(_FINDER_COLUMN_STATCOUNTPERDAY_USERID_2);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_STATCOUNTPERDAY_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_STATCOUNTPERDAY_CREATEDATE_2);
			}

			query.append(_FINDER_COLUMN_STATCOUNTPERDAY_STATTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				qPos.add(statType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATCOUNTPERDAY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLearnStatisticses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LLSTAT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLearnStatisticses where userId = &#63; and statType = &#63;.
	 *
	 * @param userId the user ID
	 * @param statType the stat type
	 * @return the number of matching LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdAndType(long userId, int statType)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, statType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDANDTYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LLSTAT_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDTYPE_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDTYPE_STATTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(statType);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of LangLearnStatisticses.
	 *
	 * @return the number of LangLearnStatisticses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LLSTAT);

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
	 * Initializes the LangLearnStatistics persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ru.psavinov.liferay.langlearn.model.LLStat")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LLStat>> listenersList = new ArrayList<ModelListener<LLStat>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LLStat>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LLStatImpl.class.getName());
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
	private static final String _SQL_SELECT_LLSTAT = "SELECT llStat FROM LLStat llStat";
	private static final String _SQL_SELECT_LLSTAT_WHERE = "SELECT llStat FROM LLStat llStat WHERE ";
	private static final String _SQL_COUNT_LLSTAT = "SELECT COUNT(llStat) FROM LLStat llStat";
	private static final String _SQL_COUNT_LLSTAT_WHERE = "SELECT COUNT(llStat) FROM LLStat llStat WHERE ";
	private static final String _FINDER_COLUMN_STATCOUNTPERDAY_USERID_2 = "llStat.userId = ? AND ";
	private static final String _FINDER_COLUMN_STATCOUNTPERDAY_CREATEDATE_1 = "llStat.createDate IS NULL AND ";
	private static final String _FINDER_COLUMN_STATCOUNTPERDAY_CREATEDATE_2 = "llStat.createDate = ? AND ";
	private static final String _FINDER_COLUMN_STATCOUNTPERDAY_STATTYPE_2 = "llStat.statType = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "llStat.userId = ?";
	private static final String _FINDER_COLUMN_USERIDANDTYPE_USERID_2 = "llStat.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDTYPE_STATTYPE_2 = "llStat.statType = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "llStat.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LLStat exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LLStat exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LLStatPersistenceImpl.class);
	private static LLStat _nullLLStat = new LLStatImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LLStat> toCacheModel() {
				return _nullLLStatCacheModel;
			}
		};

	private static CacheModel<LLStat> _nullLLStatCacheModel = new CacheModel<LLStat>() {
			public LLStat toEntityModel() {
				return _nullLLStat;
			}
		};
}
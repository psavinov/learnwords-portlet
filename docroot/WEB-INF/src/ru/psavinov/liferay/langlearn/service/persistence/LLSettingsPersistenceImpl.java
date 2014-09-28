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

import ru.psavinov.liferay.langlearn.NoSuchLLSettingsException;
import ru.psavinov.liferay.langlearn.model.LLSettings;
import ru.psavinov.liferay.langlearn.model.impl.LLSettingsImpl;
import ru.psavinov.liferay.langlearn.model.impl.LLSettingsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the LangLearnSettings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pavel Savinov
 * @see LLSettingsPersistence
 * @see LLSettingsUtil
 * @generated
 */
public class LLSettingsPersistenceImpl extends BasePersistenceImpl<LLSettings>
	implements LLSettingsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LLSettingsUtil} to access the LangLearnSettings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LLSettingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsModelImpl.FINDER_CACHE_ENABLED, LLSettingsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			LLSettingsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsModelImpl.FINDER_CACHE_ENABLED, LLSettingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsModelImpl.FINDER_CACHE_ENABLED, LLSettingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the LangLearnSettings in the entity cache if it is enabled.
	 *
	 * @param llSettings the LangLearnSettings
	 */
	public void cacheResult(LLSettings llSettings) {
		EntityCacheUtil.putResult(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsImpl.class, llSettings.getPrimaryKey(), llSettings);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(llSettings.getUserId()) }, llSettings);

		llSettings.resetOriginalValues();
	}

	/**
	 * Caches the LangLearnSettingses in the entity cache if it is enabled.
	 *
	 * @param llSettingses the LangLearnSettingses
	 */
	public void cacheResult(List<LLSettings> llSettingses) {
		for (LLSettings llSettings : llSettingses) {
			if (EntityCacheUtil.getResult(
						LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
						LLSettingsImpl.class, llSettings.getPrimaryKey()) == null) {
				cacheResult(llSettings);
			}
			else {
				llSettings.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all LangLearnSettingses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LLSettingsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LLSettingsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the LangLearnSettings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LLSettings llSettings) {
		EntityCacheUtil.removeResult(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsImpl.class, llSettings.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(llSettings);
	}

	@Override
	public void clearCache(List<LLSettings> llSettingses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LLSettings llSettings : llSettingses) {
			EntityCacheUtil.removeResult(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
				LLSettingsImpl.class, llSettings.getPrimaryKey());

			clearUniqueFindersCache(llSettings);
		}
	}

	protected void clearUniqueFindersCache(LLSettings llSettings) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(llSettings.getUserId()) });
	}

	/**
	 * Creates a new LangLearnSettings with the primary key. Does not add the LangLearnSettings to the database.
	 *
	 * @param settingsId the primary key for the new LangLearnSettings
	 * @return the new LangLearnSettings
	 */
	public LLSettings create(long settingsId) {
		LLSettings llSettings = new LLSettingsImpl();

		llSettings.setNew(true);
		llSettings.setPrimaryKey(settingsId);

		return llSettings;
	}

	/**
	 * Removes the LangLearnSettings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param settingsId the primary key of the LangLearnSettings
	 * @return the LangLearnSettings that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a LangLearnSettings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings remove(long settingsId)
		throws NoSuchLLSettingsException, SystemException {
		return remove(Long.valueOf(settingsId));
	}

	/**
	 * Removes the LangLearnSettings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the LangLearnSettings
	 * @return the LangLearnSettings that was removed
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a LangLearnSettings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLSettings remove(Serializable primaryKey)
		throws NoSuchLLSettingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LLSettings llSettings = (LLSettings)session.get(LLSettingsImpl.class,
					primaryKey);

			if (llSettings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLLSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(llSettings);
		}
		catch (NoSuchLLSettingsException nsee) {
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
	protected LLSettings removeImpl(LLSettings llSettings)
		throws SystemException {
		llSettings = toUnwrappedModel(llSettings);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, llSettings);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(llSettings);

		return llSettings;
	}

	@Override
	public LLSettings updateImpl(
		ru.psavinov.liferay.langlearn.model.LLSettings llSettings, boolean merge)
		throws SystemException {
		llSettings = toUnwrappedModel(llSettings);

		boolean isNew = llSettings.isNew();

		LLSettingsModelImpl llSettingsModelImpl = (LLSettingsModelImpl)llSettings;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, llSettings, merge);

			llSettings.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LLSettingsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
			LLSettingsImpl.class, llSettings.getPrimaryKey(), llSettings);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
				new Object[] { Long.valueOf(llSettings.getUserId()) },
				llSettings);
		}
		else {
			if ((llSettingsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(llSettingsModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
					new Object[] { Long.valueOf(llSettings.getUserId()) },
					llSettings);
			}
		}

		return llSettings;
	}

	protected LLSettings toUnwrappedModel(LLSettings llSettings) {
		if (llSettings instanceof LLSettingsImpl) {
			return llSettings;
		}

		LLSettingsImpl llSettingsImpl = new LLSettingsImpl();

		llSettingsImpl.setNew(llSettings.isNew());
		llSettingsImpl.setPrimaryKey(llSettings.getPrimaryKey());

		llSettingsImpl.setSettingsId(llSettings.getSettingsId());
		llSettingsImpl.setLocaleFrom(llSettings.getLocaleFrom());
		llSettingsImpl.setLocaleTo(llSettings.getLocaleTo());
		llSettingsImpl.setWordsPerDay(llSettings.getWordsPerDay());
		llSettingsImpl.setMode(llSettings.getMode());
		llSettingsImpl.setCompanyId(llSettings.getCompanyId());
		llSettingsImpl.setUserId(llSettings.getUserId());
		llSettingsImpl.setUserName(llSettings.getUserName());
		llSettingsImpl.setCreateDate(llSettings.getCreateDate());
		llSettingsImpl.setModifiedDate(llSettings.getModifiedDate());

		return llSettingsImpl;
	}

	/**
	 * Returns the LangLearnSettings with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLearnSettings
	 * @return the LangLearnSettings
	 * @throws com.liferay.portal.NoSuchModelException if a LangLearnSettings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLSettings findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLearnSettings with the primary key or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLSettingsException} if it could not be found.
	 *
	 * @param settingsId the primary key of the LangLearnSettings
	 * @return the LangLearnSettings
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a LangLearnSettings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings findByPrimaryKey(long settingsId)
		throws NoSuchLLSettingsException, SystemException {
		LLSettings llSettings = fetchByPrimaryKey(settingsId);

		if (llSettings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + settingsId);
			}

			throw new NoSuchLLSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				settingsId);
		}

		return llSettings;
	}

	/**
	 * Returns the LangLearnSettings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the LangLearnSettings
	 * @return the LangLearnSettings, or <code>null</code> if a LangLearnSettings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LLSettings fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the LangLearnSettings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param settingsId the primary key of the LangLearnSettings
	 * @return the LangLearnSettings, or <code>null</code> if a LangLearnSettings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings fetchByPrimaryKey(long settingsId)
		throws SystemException {
		LLSettings llSettings = (LLSettings)EntityCacheUtil.getResult(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
				LLSettingsImpl.class, settingsId);

		if (llSettings == _nullLLSettings) {
			return null;
		}

		if (llSettings == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				llSettings = (LLSettings)session.get(LLSettingsImpl.class,
						Long.valueOf(settingsId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (llSettings != null) {
					cacheResult(llSettings);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LLSettingsModelImpl.ENTITY_CACHE_ENABLED,
						LLSettingsImpl.class, settingsId, _nullLLSettings);
				}

				closeSession(session);
			}
		}

		return llSettings;
	}

	/**
	 * Returns the LangLearnSettings where userId = &#63; or throws a {@link ru.psavinov.liferay.langlearn.NoSuchLLSettingsException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching LangLearnSettings
	 * @throws ru.psavinov.liferay.langlearn.NoSuchLLSettingsException if a matching LangLearnSettings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings findByUserId(long userId)
		throws NoSuchLLSettingsException, SystemException {
		LLSettings llSettings = fetchByUserId(userId);

		if (llSettings == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLLSettingsException(msg.toString());
		}

		return llSettings;
	}

	/**
	 * Returns the LangLearnSettings where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching LangLearnSettings, or <code>null</code> if a matching LangLearnSettings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the LangLearnSettings where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching LangLearnSettings, or <code>null</code> if a matching LangLearnSettings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof LLSettings) {
			LLSettings llSettings = (LLSettings)result;

			if ((userId != llSettings.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_LLSETTINGS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<LLSettings> list = q.list();

				result = list;

				LLSettings llSettings = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					llSettings = list.get(0);

					cacheResult(llSettings);

					if ((llSettings.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, llSettings);
					}
				}

				return llSettings;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
				return (LLSettings)result;
			}
		}
	}

	/**
	 * Returns all the LangLearnSettingses.
	 *
	 * @return the LangLearnSettingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLSettings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the LangLearnSettingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of LangLearnSettingses
	 * @param end the upper bound of the range of LangLearnSettingses (not inclusive)
	 * @return the range of LangLearnSettingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLSettings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the LangLearnSettingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of LangLearnSettingses
	 * @param end the upper bound of the range of LangLearnSettingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of LangLearnSettingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<LLSettings> findAll(int start, int end,
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

		List<LLSettings> list = (List<LLSettings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LLSETTINGS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LLSETTINGS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LLSettings>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LLSettings>)QueryUtil.list(q, getDialect(),
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
	 * Removes the LangLearnSettings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the LangLearnSettings that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public LLSettings removeByUserId(long userId)
		throws NoSuchLLSettingsException, SystemException {
		LLSettings llSettings = findByUserId(userId);

		return remove(llSettings);
	}

	/**
	 * Removes all the LangLearnSettingses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LLSettings llSettings : findAll()) {
			remove(llSettings);
		}
	}

	/**
	 * Returns the number of LangLearnSettingses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching LangLearnSettingses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LLSETTINGS_WHERE);

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
	 * Returns the number of LangLearnSettingses.
	 *
	 * @return the number of LangLearnSettingses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LLSETTINGS);

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
	 * Initializes the LangLearnSettings persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ru.psavinov.liferay.langlearn.model.LLSettings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LLSettings>> listenersList = new ArrayList<ModelListener<LLSettings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LLSettings>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LLSettingsImpl.class.getName());
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
	private static final String _SQL_SELECT_LLSETTINGS = "SELECT llSettings FROM LLSettings llSettings";
	private static final String _SQL_SELECT_LLSETTINGS_WHERE = "SELECT llSettings FROM LLSettings llSettings WHERE ";
	private static final String _SQL_COUNT_LLSETTINGS = "SELECT COUNT(llSettings) FROM LLSettings llSettings";
	private static final String _SQL_COUNT_LLSETTINGS_WHERE = "SELECT COUNT(llSettings) FROM LLSettings llSettings WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "llSettings.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "llSettings.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LLSettings exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LLSettings exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LLSettingsPersistenceImpl.class);
	private static LLSettings _nullLLSettings = new LLSettingsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LLSettings> toCacheModel() {
				return _nullLLSettingsCacheModel;
			}
		};

	private static CacheModel<LLSettings> _nullLLSettingsCacheModel = new CacheModel<LLSettings>() {
			public LLSettings toEntityModel() {
				return _nullLLSettings;
			}
		};
}
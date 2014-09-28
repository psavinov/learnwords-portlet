package ru.psavinov.liferay.langlearn.portlet.helper;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ru.psavinov.liferay.langlearn.NoSuchLLSettingsException;
import ru.psavinov.liferay.langlearn.NoSuchLLStatException;
import ru.psavinov.liferay.langlearn.model.LLSettings;
import ru.psavinov.liferay.langlearn.model.LLStat;
import ru.psavinov.liferay.langlearn.model.impl.LLSettingsImpl;
import ru.psavinov.liferay.langlearn.portlet.LLPortletConst;
import ru.psavinov.liferay.langlearn.portlet.util.ConvertUtil;
import ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil;
import ru.psavinov.liferay.langlearn.service.LLStatLocalServiceUtil;

/**
 * 
 * Helper class, to process Language Learning Portlet actions
 * specific to LLSettings objects, saving and update of user's
 * settings.
 * 
 * @author Pavel Savinov
 *
 */
public class LLSettingsHelper {
	
	public LLSettingsHelper(ActionRequest actionRequest) {
		_debug("in LLSettingsHelper constructor");
		setLocaleFrom(ConvertUtil.toString(
				actionRequest.getParameter("localeFrom")));
		setLocaleTo(ConvertUtil.toString(
				actionRequest.getParameter("localeTo")));
		setMode(ConvertUtil.toInt(
				actionRequest.getParameter("mode")));
		setWordsPerDay(ConvertUtil.toInt(
				actionRequest.getParameter("wordsPerDay")));
		setUserId(ConvertUtil.toLong(
				actionRequest.getParameter("userId")));
		setAction(ConvertUtil.toInt(
				actionRequest.getParameter("actionType")));
		
		PortletPreferences prefs = actionRequest.getPreferences();
		try {
			prefs.setValue("LLTodayCount", "0");
			prefs.store();
		} catch (Exception e) {
			_error("Error occured during preferences saving: "+e);
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Process current action of helper.
	 * Action is defined in the constructor, from the ActionRequest object.
	 * 
	 * @param actionResponse Portlet response object
	 * 
	 * @throws SystemException
	 */
	public void process(ActionResponse actionResponse) throws SystemException {
		_debug("in process(), action = " + getAction());
		switch (getAction()){
		case 0:
			_saveSettings();	
			break;
		}
	}

	public void setLocaleFrom(String localeFrom) {
		this._localeFrom = localeFrom;
	}

	public String getLocaleFrom() {
		return _localeFrom;
	}

	public void setLocaleTo(String localeTo) {
		this._localeTo = localeTo;
	}

	public String getLocaleTo() {
		return _localeTo;
	}

	public void setMode(int mode) {
		this._mode = mode;
	}

	public int getMode() {
		return _mode;
	}

	public void setWordsPerDay(int wordsPerDay) {
		this._wordsPerDay = wordsPerDay;
	}

	public int getWordsPerDay() {
		return _wordsPerDay;
	}

	public void setUserId(long userId) {
		this._userId = userId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setAction(int action) {
		this._action = action;
	}

	public int getAction() {
		return _action;
	}
	
	public static Log getLog() {
		return _log;
	}
	
	private void _debug(Object msg) {
		if (getLog().isDebugEnabled()) {
			getLog().debug(msg);
		}
	}
	
	private void _error(Object msg) {
		if (getLog().isErrorEnabled()) {
			getLog().error(msg);
		}
	} 
	
	private void _saveSettings() throws SystemException {
		_debug("in saveSettings()");
		LLSettings sets = new LLSettingsImpl();
		sets.setLocaleFrom(getLocaleFrom());
		sets.setLocaleTo(getLocaleTo());
		sets.setMode(getMode());
		sets.setWordsPerDay(getWordsPerDay());
		sets.setUserId(getUserId());
		
		try {
			_debug("Trying to get settings for userId = " + getUserId());
			if (LLSettingsLocalServiceUtil.findByUserId(
					getUserId()) != null) {
				_debug("Trying to update settings for userId = " + getUserId());
				LLSettingsLocalServiceUtil.updateLLSettings(sets);
			}
		} catch (NoSuchLLSettingsException e) {
			_debug("Settings for userId = " + getUserId() + " not found");
			long newId = CounterLocalServiceUtil.increment(
					LLSettings.class.getName());
			sets.setSettingsId(newId);
			_debug("Creating new settings for userId = " + getUserId());
			LLSettingsLocalServiceUtil.addLLSettings(sets);
		}	
		
		try {
			_debug("Trying to get statistic for userId = " + getUserId());
			LLStat stat = LLStatLocalServiceUtil.findByUserIdAndType(
					_userId,	LLPortletConst.STATTYPE_TRANS);
			stat.setStatInt(0);
			_debug("Trying to update statistic for userId = " + getUserId());
			LLStatLocalServiceUtil.updateLLStat(stat);
		} catch (NoSuchLLStatException e) {
			_debug("Statistic for userId = " + getUserId() + " not found");
		}
		
	}

	private String _localeFrom;
	private String _localeTo;
	private int _mode;
	private int _wordsPerDay;
	private long _userId;
	private int _action;
	
	private static final Log _log = LogFactoryUtil.getLog(LLSettingsHelper.class);

}

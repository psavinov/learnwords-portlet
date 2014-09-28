package ru.psavinov.liferay.langlearn.portlet.helper;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import ru.psavinov.liferay.langlearn.NoSuchLLWordException;
import ru.psavinov.liferay.langlearn.NoSuchLLWordPairException;
import ru.psavinov.liferay.langlearn.model.LLWord;
import ru.psavinov.liferay.langlearn.model.LLWordPair;
import ru.psavinov.liferay.langlearn.model.impl.LLWordImpl;
import ru.psavinov.liferay.langlearn.model.impl.LLWordPairImpl;
import ru.psavinov.liferay.langlearn.portlet.util.ConvertUtil;
import ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil;
import ru.psavinov.liferay.langlearn.service.LLWordPairLocalServiceUtil;

/**
 * 
 * Helper class, to process Language Learning Portlet actions specific to the
 * LLWord objects, saving and updating words, creation and update of word pairs.
 * 
 * @author Pavel Savinov
 * 
 */
public class LLWordHelper {

	public LLWordHelper(ActionRequest actionRequest) {
		_debug("in LLWordHelper constructor");
		setLanguage(ConvertUtil
				.toString(actionRequest.getParameter("language")));
		setWord(ConvertUtil.toString(actionRequest.getParameter("word")));
		setLanguageTo(ConvertUtil.toString(actionRequest
				.getParameter("languageTo")));
		setWordTo(ConvertUtil.toString(actionRequest.getParameter("wordTo")));
		setTranslated(ConvertUtil.toBoolean(actionRequest
				.getParameter("addTranslation")));
		setAction(ConvertUtil.toInt(actionRequest.getParameter("actionType")));
		_setRequest(actionRequest);
		setWordFromId(ConvertUtil.toLong(actionRequest
				.getParameter("wordFromId")));

		long uId = -1;
		try {
			_debug("Trying to get current userId from request");
			uId = new Long(_getRequest().getRemoteUser()).longValue();
		} catch (Exception e) {
			_error("Error occured during userId conversion: " + e);
		}
		setUserId(uId);
	}

	/**
	 * Process current action of helper. Action is defined in the constructor,
	 * from the ActionRequest object.
	 * 
	 * @param actionResponse
	 *            Portlet response object
	 * 
	 * @throws SystemException
	 */
	public void process(ActionResponse actionResponse) throws SystemException {
		_debug("in process(), action = " + getAction());
		switch (getAction()) {
		case 0:
			_saveWord();
			break;

		case 1:
			_updateWord();
			break;
		}

	}

	public void setAction(int action) {
		this._action = action;
	}

	public int getAction() {
		return _action;
	}

	public void setWordTo(String wordTo) {
		this._wordTo = wordTo;
	}

	public String getWordTo() {
		return _wordTo;
	}

	public void setLanguageTo(String languageTo) {
		this._languageTo = languageTo;
	}

	public String getLanguageTo() {
		return _languageTo;
	}

	public void setWord(String word) {
		this._word = word;
	}

	public String getWord() {
		return _word;
	}

	public void setLanguage(String language) {
		this._language = language;
	}

	public String getLanguage() {
		return _language;
	}

	public void setTranslated(boolean translated) {
		this._translated = translated;
	}

	public boolean isTranslated() {
		return _translated;
	}

	public void setWordFromId(long wordFromId) {
		this._wordFromId = wordFromId;
	}

	public long getWordFromId() {
		return _wordFromId;
	}

	public void setUserId(long userId) {
		this._userId = userId;
	}

	public long getUserId() {
		return _userId;
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

	private void _saveWord() throws SystemException {
		_debug("in _saveWord()");
		LLWord w = null;
		Date now = new Date();

		try {
			_debug("Trying to find word = '" + getWord() + "' for locale = '"
					+ getLanguage());
			w = LLWordLocalServiceUtil.findByWordAndLocale(getWord(),
					getLanguage());
			if (w != null) {
				_debug("Such word already exists in specified locale");
				SessionErrors.add(_getRequest(), "wordAlreadyExists");
			}
		} catch (NoSuchLLWordException e) {
			_debug("Trying to create word = '" + getWord() + "' for locale = '"
					+ getLanguage());
			long newId = CounterLocalServiceUtil.increment(LLWord.class
					.getName());

			PortletPreferences prefs = _getRequest().getPreferences();
			try {
				prefs.setValue("wordToShowId", newId + "");
				prefs.store();
			} catch (Exception e1) {
				_error("Error occured during preferences saving: " + e1);
			}

			w = new LLWordImpl();
			w.setWordId(newId);
			w.setUserId(getUserId());
			w.setCreateDate(now);
			w.setLocale(getLanguage());
			w.setWord(getWord());
			LLWordLocalServiceUtil.addLLWord(w);

			if (isTranslated() && !getWordTo().trim().equals("")) {
				_debug("Trying to save word translation");
				LLWord tw = new LLWordImpl();
				long twid = CounterLocalServiceUtil.increment(LLWord.class
						.getName());
				tw.setWordId(twid);
				tw.setUserId(getUserId());
				tw.setCreateDate(now);
				tw.setLocale(getLanguageTo());
				tw.setWord(getWordTo());
				LLWordLocalServiceUtil.addLLWord(tw);

				_debug("Creating new word pair");
				LLWordPair pair = new LLWordPairImpl();
				pair.setWordFromId(newId);
				pair.setWordToId(twid);
				pair.setUserId(getUserId());
				pair.setCreateDate(now);
				pair.setWordPairId(CounterLocalServiceUtil
						.increment(LLWordPair.class.getName()));
				LLWordPairLocalServiceUtil.addLLWordPair(pair);

				_debug("Creating reversed pair for specified locales");
				LLWordPair rpair = new LLWordPairImpl();
				rpair.setWordFromId(twid);
				rpair.setWordToId(newId);
				rpair.setUserId(getUserId());
				rpair.setCreateDate(now);
				rpair.setWordPairId(CounterLocalServiceUtil
						.increment(LLWordPair.class.getName()));
				LLWordPairLocalServiceUtil.addLLWordPair(rpair);
			}
			_debug("Word '" + getWord() + "' added successfully");
			SessionMessages.add(_getRequest(), "wordAddedSuccessfully");
		}
	}

	private void _updateWord() throws SystemException {
		_debug("in _updateWord()");
		LLWord w = null;
		Date now = new Date();
		PortletPreferences prefs = _getRequest().getPreferences();
		long wordToId = new Long(prefs.getValue("wordToId", "-1")).longValue();

		try {
			_debug("Trying to find word = '" + getWordTo() + "' for locale = '"
					+ getLanguageTo());
			w = LLWordLocalServiceUtil.findByWordAndLocale(getWordTo(),
					getLanguageTo());
		} catch (NoSuchLLWordException e) {
			_debug("Trying to create word = '" + getWordTo()
					+ "' for locale = '" + getLanguageTo());
			if (!getWordTo().trim().equals("")) {
				long newId = CounterLocalServiceUtil.increment(LLWord.class
						.getName());
				w = new LLWordImpl();
				w.setWordId(newId);
				w.setLocale(getLanguageTo());
				w.setWord(getWordTo());
				w.setUserId(getUserId());
				w.setCreateDate(now);
				LLWordLocalServiceUtil.addLLWord(w);
				_debug("Word '" + getWordTo() + "' added successfully");
			}
		}

		try {
			prefs.setValue("wordToShowId", getWordFromId() + "");
			prefs.setValue("wordToId", "-1");
			prefs.setValue("wordFromId", "-1");
			prefs.store();
		} catch (Exception e1) {
			_error("Error occured during preferences saving: " + e1);
		}

		LLWordPair pair = null;
		try {
			_debug("Trying to find word pair with specified words");
			pair = LLWordPairLocalServiceUtil.findByWords(getWordFromId(),
					wordToId);
			pair.setWordToId(w.getWordId());
			pair.setModifiedDate(now);
			_debug("Updating wordPair (id = " + pair.getWordPairId() + ") "
					+ "wordToId = " + w.getWordId() + ", wordFromId = "
					+ getWordFromId());
			LLWordPairLocalServiceUtil.updateLLWordPair(pair);
			_debug("Word pair updated successfully");
		} catch (NoSuchLLWordPairException e) {
			_debug("Creating word pair with wordToId = " + w.getWordId()
					+ ", wordFromId = " + getWordFromId());
			pair = new LLWordPairImpl();
			pair.setWordFromId(getWordFromId());
			pair.setWordToId(w.getWordId());
			pair.setCreateDate(now);
			pair.setUserId(getUserId());
			pair.setWordPairId(CounterLocalServiceUtil
					.increment(LLWordPair.class.getName()));
			LLWordPairLocalServiceUtil.addLLWordPair(pair);
			_debug("Word pair added successfully");
		}

		LLWordPair rpair = null;
		try {
			_debug("Trying to find reversed word pair with specified words");
			rpair = LLWordPairLocalServiceUtil.findByWords(wordToId,
					getWordFromId());
			rpair.setWordFromId(w.getWordId());
			rpair.setModifiedDate(now);
			_debug("Updating wordPair (id = " + pair.getWordPairId() + ") "
					+ "wordToId = " + w.getWordId() + ", wordFromId = "
					+ getWordFromId());
			LLWordPairLocalServiceUtil.updateLLWordPair(rpair);
			_debug("Reversed word pair updated successfully");
		} catch (NoSuchLLWordPairException e) {
			_debug("Creating reversed word pair with wordToId = "
					+ getWordFromId() + ", wordFromId = " + w.getWordId());
			rpair = new LLWordPairImpl();
			rpair.setWordFromId(w.getWordId());
			rpair.setWordToId(getWordFromId());
			rpair.setCreateDate(now);
			rpair.setUserId(getUserId());
			rpair.setWordPairId(CounterLocalServiceUtil
					.increment(LLWordPair.class.getName()));
			LLWordPairLocalServiceUtil.addLLWordPair(rpair);
			_debug("Reversed word pair added successfully");
		}

		SessionMessages.add(_getRequest(), "wordAddedSuccessfully");
	}

	private ActionRequest _getRequest() {
		return this._request;
	}

	private void _setRequest(ActionRequest r) {
		this._request = r;
	}

	private long _wordFromId;
	private String _language;
	private String _word;
	private String _languageTo;
	private String _wordTo;
	private boolean _translated;
	private int _action;
	private ActionRequest _request;
	private long _userId;

	private static final Log _log = LogFactoryUtil.getLog(LLWordHelper.class);

}

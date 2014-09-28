package ru.psavinov.liferay.langlearn.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import ru.psavinov.liferay.langlearn.portlet.helper.LLSettingsHelper;
import ru.psavinov.liferay.langlearn.portlet.helper.LLWordHelper;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class LangLearnPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String option = actionRequest.getParameter("opt") != null ? 
				actionRequest.getParameter("opt") : "-1";
		
		int optInt = -1;
		try {
			optInt = Integer.parseInt(option);
		} catch (Exception e) {
			_error("incorrect option:" + option + ", exception: " + e);
		}
		_debug("in processAction, option = " + optInt);
		
		switch (optInt) {
			case 0:
				LLSettingsHelper setHelper = new LLSettingsHelper(
						actionRequest);
				try {
					setHelper.process(actionResponse);
				} catch (SystemException e) {
					_error("System error occured: "+e);
				}
			break;
			
			case 1:
				LLWordHelper wordHelper = new LLWordHelper(
						actionRequest);
				try {
					wordHelper.process(actionResponse);
				} catch (SystemException e) {
					_error("System error occured: "+e);
				}
			break;
		}
		super.processAction(actionRequest, actionResponse);
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

	private static final Log _log = LogFactoryUtil.getLog(LangLearnPortlet.class); 
}

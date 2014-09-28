<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%
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
%> 

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLWordPairLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLStatLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.portlet.LLPortletConst" %>
<%@ page import="ru.psavinov.liferay.langlearn.NoSuchLLSettingsException" %>
<%@ page import="ru.psavinov.liferay.langlearn.model.LLSettings" %>
<%@ page import="ru.psavinov.liferay.langlearn.model.LLStat" %>
<%@ page import="ru.psavinov.liferay.langlearn.model.impl.LLStatImpl" %>
<%@ page import="ru.psavinov.liferay.langlearn.model.LLWord" %>
<%@ page import="ru.psavinov.liferay.langlearn.model.LLWordPair" %>

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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page
	import="ru.psavinov.liferay.langlearn.portlet.helper.LocaleHelper"%>
<%@ page
	import="ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil"%>
<%@ page
	import="ru.psavinov.liferay.langlearn.NoSuchLLSettingsException"%>
<%@ page import="ru.psavinov.liferay.langlearn.model.LLSettings"%>

<portlet:defineObjects />
<%
	Locale loc = renderRequest.getLocale();
 ResourceBundle res = portletConfig.getResourceBundle(loc);
%>
<portlet:actionURL var="saveSettingsUrl">
	<portlet:param name="mvcPath" value="/settings.jsp" />
</portlet:actionURL>
<portlet:renderURL var="mainViewUrl">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>
<%
	long userId = -1;
String localeFrom = null;
String localeTo = null;
int wordsPerDay = 0;
int mode = 1;
boolean correct = false;

try {
	userId = new Long(request.getRemoteUser()).longValue();
} catch (Exception e) {
	
}
LLSettings settings = null;
if (userId != -1) {		
	try {
		settings = LLSettingsLocalServiceUtil.findByUserId(userId);
		if (settings != null) {
			localeFrom = settings.getLocaleFrom();
			localeTo = settings.getLocaleTo();
			wordsPerDay = settings.getWordsPerDay();
			mode = settings.getMode();
			correct = true;
		}
	} catch (NoSuchLLSettingsException e) {
		settings = null;
	}
}
%>
<%
	if (userId == -1) {
		%>
		<center><%=res.getString("LangLearn.logIn") %></center>
		<%			
	} else {
%>
<aui:form action="${saveSettingsUrl}" onSubmit="return false;"
	method="POST">
	<aui:input type="hidden" name="userId" value="<%=userId%>" />
	<table class="settingsTable">
		<tr>
			<td><%=res.getString("LangLearn.mode")%>:</td>
			<td><aui:select name="mode" id="LLSetMode" label=""
					style="width:100%;">
					<aui:option value="0"><%=res.getString("LangLearn.mode.translation")%></aui:option>
					<aui:option value="1"><%=res.getString("LangLearn.mode.learning")%></aui:option>
				</aui:select> <script>document.getElementById("_LangLearn_WAR_LangLearnportlet_LLSetMode").value = "<%=mode%>";</script>
			</td>
		</tr>
		<tr>
			<td><%=res.getString("LangLearn.nativeLanguage")%>:</td>
			<td><aui:select name="localeFrom" id="LLSetLocaleFrom" label=""
					style="width:100%;">
					<%
						for (Locale locale : LocaleHelper.getSortedLocales()) {
								if (locale.getDisplayCountry().equals("")) {
					%>
					<aui:option value="<%=locale.getLanguage()%>">
						<%=locale.getDisplayLanguage()%>
					</aui:option>
					<%
						}
							}
					%>
				</aui:select> <script>document.getElementById("_LangLearn_WAR_LangLearnportlet_LLSetLocaleFrom").value = "<%=localeFrom%>";</script>
			</td>
		</tr>
		<tr>
			<td><%=res.getString("LangLearn.languageToLearn")%>:</td>
			<td><aui:select name="localeTo" id="LLSetLocaleTo" label=""
					style="width:100%;">
					<%
						for (Locale locale : LocaleHelper.getSortedLocales()) {
								if (locale.getDisplayCountry().equals("")) {
					%>
					<aui:option value="<%=locale.getLanguage()%>">
						<%=locale.getDisplayLanguage()%>
					</aui:option>
					<%
						}
							}
					%>
				</aui:select> <script>document.getElementById("_LangLearn_WAR_LangLearnportlet_LLSetLocaleTo").value = "<%=localeTo%>";
				</script>
			</td>
		</tr>
		<tr>
			<td><%=res.getString("LangLearn.wordsPerDay")%>:</td>
			<td><aui:input name="wordsPerDay" label=""
					value="<%=wordsPerDay%>" style="width:30%; text-align:right;">
					<aui:validator name="required" />
					<aui:validator name="digits" />
					<aui:validator name="range">[1,300]</aui:validator>
				</aui:input></td>
		</tr>
	</table>
	<br />
	<hr />
	<div id="buttonsDiv">
		<aui:button type="submit"
			value='<%=res.getString("LangLearn.save")%>' />
		<aui:button value='<%=res.getString("LangLearn.cancel")%>'
			onClick="document.location='${mainViewUrl}';" />
	</div>
	<aui:input type="hidden" name="opt" value="0" />
	<aui:input type="hidden" name="actionType" value="0" />
</aui:form>
<%
}
%>
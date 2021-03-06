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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="ru.psavinov.liferay.langlearn.portlet.helper.LocaleHelper" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLSettingsLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLWordPairLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.service.LLWordLocalServiceUtil" %>
<%@ page import="ru.psavinov.liferay.langlearn.NoSuchLLSettingsException" %>
<%@ page import="ru.psavinov.liferay.langlearn.model.LLSettings" %>

<portlet:defineObjects />
 <%
 Locale loc = (renderRequest != null && renderRequest.getLocale() != null) ?
		 renderRequest.getLocale() : new Locale("en");
 ResourceBundle res = portletConfig.getResourceBundle(loc);
 %>
<portlet:actionURL var="saveWordUrl">
	<portlet:param name="mvcPath" value="/addWord.jsp"/>
</portlet:actionURL>
<portlet:renderURL var="mainViewUrl">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>
 <%
	long userId = -1L;
	String localeFrom = null;
	String localeTo = null;
	int wordsPerDay = 0;
	boolean correct = false;
	
	try {
		userId = new Long(request.getRemoteUser()).longValue();
	} catch (Exception e) {}
	
	LLSettings settings = null;
	if (userId != -1) {		
		try {
			settings = LLSettingsLocalServiceUtil.findByUserId(userId);
			if (settings != null){
				localeFrom = settings.getLocaleFrom();
				localeTo = settings.getLocaleTo();
				wordsPerDay = settings.getWordsPerDay();
				correct = true;
			}
		} catch (NoSuchLLSettingsException e) {
			settings = null;
		}
	}
%>
<div style="text-align:left;border:1px solid black; padding:3px;border-radius:4px;">
	<%=res.getString("LangLearn.currentMode") %>: <b><%=res.getString("LangLearn.mode.translation")%></b>,
	&nbsp;<b><%= new Locale(localeFrom).getDisplayLanguage() %></b>&nbsp;&lt;-&gt;
	&nbsp;<b><%= new Locale(localeTo).getDisplayLanguage() %></b>
</div><br/>
<aui:form action="${saveWordUrl}" method="POST">
	<table class="settingsTable">
		<tr>
		<td><%=res.getString("LangLearn.language")%>:</td>
		<td>
			<aui:select name="language" id="LLWordLang" label="" style="width:100%;">
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
			</aui:select>
			<script>document.getElementById("_LangLearn_WAR_LangLearnportlet_LLWordLang").value = "<%=localeFrom%>";</script>
		</td>
		</tr>
		<tr>
		<td><%=res.getString("LangLearn.word")%>:</td>
		<td><aui:input name="word" type="text" label="" style="width:100%;">
					<aui:validator name="required"/>
			<aui:validator name="rangeLength">[1,250]</aui:validator>
		</aui:input></td>
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td><aui:input onChange="LangLearn.addTranslationOnChange(this.checked)" label='<%=res.getString("LangLearn.addTranslation") %>' type="checkbox" name="addTranslation"/></td>
		</tr>
		<tr style="display:none;" class="LLTransTR">
		<td><%=res.getString("LangLearn.translateTo")%>:</td>
		<td>
			<aui:select name="languageTo" id="LLWordLangTo" label="" style="width:100%;">
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
			</aui:select>
			<script>document.getElementById("_LangLearn_WAR_LangLearnportlet_LLWordLangTo").value = "<%=localeTo%>";</script>
		</td>
		</tr>
		<tr style="display:none;" class="LLTransTR">
		<td><%=res.getString("LangLearn.mode.translation")%></td>
		<td><aui:input name="wordTo" type="text" label="" style="width:100%;"></aui:input></td>
		</tr>
		
	</table><br/><hr/>
	<div id="buttonsDiv">
		<aui:button type="submit" value='<%=res.getString("LangLearn.save") %>'/>
		<aui:button value='<%=res.getString("LangLearn.cancel")%>' onClick="document.location='${mainViewUrl}';"/>
	</div>
	<aui:input type="hidden" name="opt" value="1"/>
	<aui:input type="hidden" name="actionType" value="0"/>
</aui:form>
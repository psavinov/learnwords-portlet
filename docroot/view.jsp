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

<%@ include file="init.jsp"%>

<portlet:defineObjects />
 <%
 Locale loc = renderRequest.getLocale();
 ResourceBundle res = portletConfig.getResourceBundle(loc);
 %>
<liferay-ui:success key="wordAddedSuccessfully" message='<%=res.getString("LangLearn.wordAddSuccess")%>'/>
<liferay-ui:error key="wordAlreadyExists" message='<%=res.getString("LangLearn.wordAlreadyExists")%>'/>

<portlet:renderURL var="addWordUrl">
    <portlet:param name="mvcPath" value="/addWord.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editWordUrl">
    <portlet:param name="mvcPath" value="/editWord.jsp" />
</portlet:renderURL>
<portlet:renderURL var="settingsUrl">
    <portlet:param name="mvcPath" value="/settings.jsp" />
</portlet:renderURL>
<portlet:renderURL var="prevWordUrl">
    <portlet:param name="mvcPath" value="/view.jsp" />
    <portlet:param name="direction" value="prev"/>
</portlet:renderURL>
<portlet:renderURL var="nextWordUrl">
    <portlet:param name="mvcPath" value="/view.jsp" />
    <portlet:param name="direction" value="next"/>
</portlet:renderURL>

<%
	long userId = -1L;
	String localeFrom = null;
	String localeTo = null;
	int wordsPerDay = 0;
	int mode = 0;
	boolean correct = false;
	boolean wordFromExists = false;
	boolean wordToExists = false;
	
	try {
		userId = request.getRemoteUser() != null ? new Long(request.getRemoteUser()).longValue() : -1;
	} catch (Exception e) {}
	LLSettings settings = null;
	if (userId != -1) {		
		try {
			settings = LLSettingsLocalServiceUtil.findByUserId(userId);
			if (settings != null) {
				localeFrom = settings.getLocaleFrom();
				localeTo = settings.getLocaleTo();
				mode = settings.getMode();
				wordsPerDay = settings.getWordsPerDay();
				correct = true;
			}
		} catch (NoSuchLLSettingsException e) {
			settings = null;
		}
	}
%>
<div id="langLearnDiv">
<%
	if (userId == -1) {
		%>
		<center><%=res.getString("LangLearn.logIn") %></center>
		<%			
	}
	else if (!correct) {
		%>
		<center><%=res.getString("LangLearn.notConfigured") %></center>
		<%	
	} else {
		switch (mode) {
		case 1:
				%>
					<div style="text-align:left;border:1px solid black; border-radius:4px; padding:3px;">
					<%=res.getString("LangLearn.currentMode") %>: <b><%=res.getString("LangLearn.mode.learning")%></b>,
					&nbsp;<b><%= new Locale(localeFrom).getDisplayLanguage() %></b>&nbsp;&lt;-&gt;
					&nbsp;<b><%= new Locale(localeTo).getDisplayLanguage() %></b>
					</div><br/>
				<%
				if (LLWordPairLocalServiceUtil.getLLWordPairsCount() == 0) {
					%>
					<center>
						<%=res.getString("LangLearn.noWordPairs")%>
						
						<br/>
						<%=res.getString("LangLearn.addWordPair")
							.replaceFirst("\\$1",settingsUrl)%>					
					</center>
					<%
				} else {
					LLStat lstat = null;
					PortletPreferences pp = renderRequest.getPreferences();
					int todayCount = new Integer(pp.getValue("LLTodayCount","0")).intValue();
					int wordsCount = LLWordLocalServiceUtil.findByLocaleWithPair(localeFrom).size();
					int savedPos = -1;  
					Date statDate = new Date();
					if (wordsCount > 0) { 
						int wordStartPos = 0;
						try {
							lstat = LLStatLocalServiceUtil.findByUserIdAndType(userId,
								LLPortletConst.STATTYPE_LEARN);
							savedPos = lstat.getStatInt() > 0 ? lstat.getStatInt() : 0;
							if ((wordsCount-savedPos)<wordsPerDay) {
								savedPos = 0;
							} 
							wordStartPos = new Integer(pp.getValue("LLWP",String.valueOf(savedPos))).intValue() >= savedPos ?
								new Integer(pp.getValue("LLWP",String.valueOf(savedPos))).intValue() : savedPos;
							statDate = lstat.getCreateDate();
							if (renderRequest.getParameter("direction")!= null &&
									renderRequest.getParameter("direction").equals("prev")) {
								wordStartPos--;
								if (wordStartPos < savedPos) {
									wordStartPos = (savedPos+wordsPerDay-1) < wordsCount-1 ? (savedPos+wordsPerDay-1) : wordsCount-1;
								}								
							} else {
								wordStartPos++;
								if (wordStartPos >= wordsCount) {
									wordStartPos = savedPos;
								} else if (wordStartPos < wordsCount && wordStartPos >= savedPos+wordsPerDay){
									wordStartPos = savedPos;
								} else if (wordStartPos < savedPos) {
									wordStartPos = savedPos+wordsPerDay-1;
								}								
							}
						} catch (Exception e) {}
						

						List<LLWord> wordList = LLWordLocalServiceUtil.findByLocaleWithPair(localeFrom,wordStartPos,wordStartPos+1);

						if (!wordList.isEmpty()) {
							wordFromExists = true;
							PortletPreferences pref = renderRequest.getPreferences();
							long idFromPrefs = new Long(pref.getValue("wordToShowId","-1")).longValue();
							LLWord wrd = idFromPrefs == -1 ? wordList.get(0) :
								LLWordLocalServiceUtil.getLLWord(idFromPrefs);
							if (idFromPrefs != -1) {
								pref.setValue("wordToShowId","-1");
								pref.store();
							}
							LLWordPair pair = LLWordPairLocalServiceUtil.findByWordFromAndLocale(
									wrd.getWordId(),localeTo);
							
							%>	<center>
								<span style="font-weight:bolder;font-style:italic;font-size:13px;"><%=wrd.getWord()%></span><br/>
								<span style="font-size:14px;padding:4px;">=</span><br/>
							<%
							PortletPreferences prefs = renderRequest.getPreferences();
							prefs.setValue("wordFromId",wrd.getWordId() + "");
							prefs.setValue("wordToId","-1");
							prefs.setValue("LLWP",wordStartPos+"");
							prefs.store();
							if (pair != null){
								LLWord wrdTo = LLWordLocalServiceUtil.getLLWord(pair.getWordToId());
								wordToExists = true;
								prefs.setValue("wordToId",pair.getWordToId() + "");
								prefs.store();
								%>
									<span style="font-weight:bolder;font-style:italic;font-size:13px;"><%=wrdTo.getWord()%></span><br/>
								<%
							} else {
								%>
									<span style="font-style:italic;font-size:13px;"><%=res.getString("LangLearn.noTranslation")%></span><br/>
									<span style="font-style:italic;font-size:13px;"><%=res.getString("LangLearn.addWord").replaceFirst("\\$1",editWordUrl)%></span>
								<%
							}
						}
						todayCount++;
						if (todayCount == wordsPerDay) {
							todayCount = 0;
						}
						Date now = new Date();
						pp.setValue("LLTodayCount",todayCount+"");
						pp.store();
						if (lstat == null) {
							lstat = new LLStatImpl();
							lstat.setStatId(
									CounterLocalServiceUtil.increment(
											LLStat.class.getName()));
							lstat.setStatType(LLPortletConst.STATTYPE_LEARN);
							lstat.setUserId(userId);
							if (now.getDate()==statDate.getDate() &&
									now.getMonth()==statDate.getMonth() &&
									now.getYear()==statDate.getYear()) {
								lstat.setStatInt(savedPos);	
							} else {
								if (savedPos+wordsPerDay<wordsCount)
									lstat.setStatInt(savedPos+wordsPerDay);
								else lstat.setStatInt(0);
							}
							lstat.setCreateDate(now);							
							LLStatLocalServiceUtil.addLLStat(lstat);
						} else {
							if (now.getDate()==statDate.getDate() &&
									now.getMonth()==statDate.getMonth() &&
									now.getYear()==statDate.getYear()) {
								lstat.setStatInt(savedPos);	
							} else {
								if (savedPos+wordsPerDay<wordsCount)
									lstat.setStatInt(savedPos+wordsPerDay);
								else lstat.setStatInt(0);							}
							lstat.setCreateDate(now);
							LLStatLocalServiceUtil.updateLLStat(lstat);
						}					
						%></center><%
					}				
				}
				break;
			default:
				%>
				<div style="text-align:left;border:1px solid black; border-radius:4px;padding:3px;">
				<%=res.getString("LangLearn.currentMode") %>: <b><%=res.getString("LangLearn.mode.translation")%></b>,
				&nbsp;<b><%= new Locale(localeFrom).getDisplayLanguage() %></b>&nbsp;&lt;-&gt;
				&nbsp;<b><%= new Locale(localeTo).getDisplayLanguage() %></b>
				</div><br/><center>
			<%
				int wordsCount = LLWordLocalServiceUtil.findByLocale(localeFrom).size();
				LLStat stat = null;
				if (wordsCount > 0) {
					int wordStartPos = 0;
					try {
						stat = LLStatLocalServiceUtil.findByUserIdAndType(userId,LLPortletConst.STATTYPE_TRANS);
						wordStartPos = stat.getStatInt();
						if (renderRequest.getParameter("direction")!= null &&
								renderRequest.getParameter("direction").equals("prev")) {
							wordStartPos = wordStartPos - 2;
						}
					} catch (Exception e) {}
					if (wordStartPos == wordsCount) {
						wordStartPos = 0;
					} else if (wordStartPos < 0) {
						wordStartPos = wordsCount-1;
					}
					List<LLWord> wordList = LLWordLocalServiceUtil.findByLocale(localeFrom,wordStartPos,wordStartPos+1);
					
					if (!wordList.isEmpty()) {
						wordFromExists = true;
						PortletPreferences pref = renderRequest.getPreferences();
						long idFromPrefs = new Long(pref.getValue("wordToShowId","-1")).longValue();
						LLWord wrd = idFromPrefs == -1 ? wordList.get(0) :
							LLWordLocalServiceUtil.getLLWord(idFromPrefs);
						if (idFromPrefs != -1) {
							pref.setValue("wordToShowId","-1");
							pref.store();
						}
						LLWordPair pair = LLWordPairLocalServiceUtil.findByWordFromAndLocale(
								wrd.getWordId(),localeTo);
						%>
							<span style="font-weight:bolder;font-style:italic;font-size:13px;"><%=wrd.getWord()%></span><br/>
							<span style="font-size:14px;padding:4px;">=</span><br/>
						<%
						PortletPreferences prefs = renderRequest.getPreferences();
						prefs.setValue("wordFromId",wrd.getWordId() + "");
						prefs.setValue("wordToId","-1");
						prefs.store();
						if (pair != null){
							LLWord wrdTo = LLWordLocalServiceUtil.getLLWord(pair.getWordToId());
							wordToExists = true;
							prefs.setValue("wordToId",pair.getWordToId() + "");
							prefs.store();
							%>
								<span style="font-weight:bolder;font-style:italic;font-size:13px;"><%=wrdTo.getWord()%></span><br/>
							<%
						} else {
							%>
								<span style="font-style:italic;font-size:13px;"><%=res.getString("LangLearn.noTranslation")%></span><br/>
								<span style="font-style:italic;font-size:13px;"><%=res.getString("LangLearn.addWord").replaceFirst("\\$1",editWordUrl)%></span>
							<%
						}
					}
					wordStartPos++;
					if (stat == null) {
						stat = new LLStatImpl();
						stat.setStatId(
								CounterLocalServiceUtil.increment(
										LLStat.class.getName()));
						stat.setStatType(LLPortletConst.STATTYPE_TRANS);
						stat.setUserId(userId);
						stat.setStatInt(wordStartPos);
						LLStatLocalServiceUtil.addLLStat(stat);
					} else {
						stat.setStatInt(wordStartPos);
						LLStatLocalServiceUtil.updateLLStat(stat);
					}					
					%></center><%
				} else {
					%>
					<center>
						<%=res.getString("LangLearn.noWords")%>
						<br/>
						<%=res.getString("LangLearn.addWord")
							.replaceFirst("\\$1",addWordUrl)%>							
					</center>
					<%
				}
				break;
		}
	}
%>
</div><br/>
	<%  
	if (wordFromExists) {
	%>
<table style="width:100%;">
	<tr>
	<td style="text-align:left;"><aui:button label="" name="prevWordBtn" onClick="document.location = '${prevWordUrl}';" value="&#9668;"/></td>
	<td style="text-align:right;"><aui:button label="" name="nextWordBtn" onClick="document.location = '${nextWordUrl}';" value="&#9658;"/></td>
	</tr>
</table>
	<% } %>
<div id="buttonsDiv">
	<hr/>
	<%
	if (userId > 0 && mode != 1 && correct) {
	%>
	<aui:button value='<%=res.getString("LangLearn.addWordBtn")%>'  onClick="document.location='${addWordUrl}';"/>
	<% } 
	if (wordFromExists) {
	%>
	<aui:button value='<%=res.getString("LangLearn.editWordBtn")%>' onClick="document.location='${editWordUrl}';"/>
	<% }
	if (userId > 0) {
	%>
	<aui:button value='<%=res.getString("LangLearn.settingsBtn")%>' onClick="document.location='${settingsUrl}';"/>	
	<% } %>
</div>



	

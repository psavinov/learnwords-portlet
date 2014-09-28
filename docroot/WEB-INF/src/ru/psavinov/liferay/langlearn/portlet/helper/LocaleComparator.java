package ru.psavinov.liferay.langlearn.portlet.helper;

import java.util.Comparator;
import java.util.Locale;

public class LocaleComparator implements Comparator<Locale> {

	@Override
	public int compare(Locale o1, Locale o2) {
		return o1.getDisplayLanguage().compareToIgnoreCase(o2.getDisplayLanguage());
	}

}

package ru.psavinov.liferay.langlearn.portlet.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class LocaleHelper {
	
	private static List<Locale> sortedLocales;
	
	
	
	static {
		sortedLocales = new ArrayList<Locale>();
		for (Locale l : Locale.getAvailableLocales()) {
			if (l.getDisplayCountry().equals("")) {
				sortedLocales.add(l);
			}
		}
		Collections.sort(sortedLocales, new LocaleComparator());
	}

	public static List<Locale> getSortedLocales() {
		return sortedLocales;
	}
	

}

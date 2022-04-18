package es.seresco.delincuencia.services;

import java.util.Locale;

public interface MessageSourceDelincuencia {

	String getValue (String key);
	
	String getValue (String key, Locale locale);
	
	String getValueWithParams(String key, Locale locale, Object... params);
	
}

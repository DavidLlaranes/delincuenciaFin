package es.seresco.delincuencia.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContextUtil implements ApplicationContextAware {

	
	private static ApplicationContext ctx;
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}

	
	public static ApplicationContext getAppContext() {
		return ctx;
	}
	
}


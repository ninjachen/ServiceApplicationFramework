package com.wonders.frame.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wonders.frame.security.CurrentUserHolder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInformationSetterInterceptor extends HandlerInterceptorAdapter implements InitializingBean, ApplicationContextAware {

	private DateFormat dateFormat;
	private ApplicationContext applicationContext;
	private String constantBeanName = "constant";
	private String currentDateRequestAttributeName = "currentDate";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		request.setAttribute("currentUser", CurrentUserHolder.get());
		request.setAttribute(currentDateRequestAttributeName, dateFormat.format(new Date()));		
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (dateFormat == null) {
			Properties props = applicationContext.getBean(constantBeanName, Properties.class);
			String pattern = props.getProperty("me.default.dateformat", "yyyy年MM月dd日");
			dateFormat = new SimpleDateFormat(pattern);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void setConstantBeanName(String constantBeanName) {
		this.constantBeanName = constantBeanName;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void setCurrentDateRequestAttributeName(
			String currentDateRequestAttributeName) {
		this.currentDateRequestAttributeName = currentDateRequestAttributeName;
	}

	public void setDateFormatPattern(String pattern) {
		this.dateFormat = new SimpleDateFormat(pattern);
	}
}

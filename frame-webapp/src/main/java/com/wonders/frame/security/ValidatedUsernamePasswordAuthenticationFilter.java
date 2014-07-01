package com.wonders.frame.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.LocaleUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Assert;

public class ValidatedUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private String captchaParameter = "j_captcha";
	private String languageParameter = "lang";

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		Locale locale = obtainLocale(request);
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		List<String> errors = new ArrayList<String>();
		request.setAttribute("loginErrors", errors);
		request.setAttribute("hasErrors", false);
		String msg = null;
		
		if (! username.matches("[a-zA-Z0-9]{4,12}")) {
			msg = super.messages.getMessage("jsr303.login.username", locale);
			errors.add(msg);
		}
		
		if (! password.matches("[a-zA-Z0-9]{4,12}")) {
			msg = super.messages.getMessage("jsr303.login.password", locale);
			errors.add(msg);
		}
		
		if (! errors.isEmpty()) {
			request.setAttribute("hasErrors", true);
			throw new AuthenticationServiceException("Data validation fail.");
		}
		
		Authentication authentication = null;
		try {
			authentication = super.attemptAuthentication(request, response);
		} catch (AuthenticationException e) {
			msg = super.messages.getMessage("jsr303.login.fail", locale);
			errors.add(msg);
			request.setAttribute("hasErrors", true);
			throw e;
		}

		return authentication;
	}

	@Override
	public void afterPropertiesSet() {
		Assert.hasLength(languageParameter);
		Assert.hasLength(captchaParameter);
		super.afterPropertiesSet();
	}

	protected String obtainUsername(HttpServletRequest request) {
		String username = super.obtainUsername(request);
		return username != null ? username.trim() : "";
	}

	protected String obtainPassword(HttpServletRequest request) {
		String password = super.obtainPassword(request);
		return password != null ? password.trim() : "";
	}

	protected String obtainCaptcha(HttpServletRequest request) {
		String captcha = request.getParameter(captchaParameter);
		return captcha != null ? captcha.trim() : "";
	}

	protected Locale obtainLocale(HttpServletRequest request) {
		String language = request.getParameter(languageParameter);
		if (language == null) {
			return request.getLocale();
		} else {
			try {
				return LocaleUtils.toLocale(language);
			} catch (IllegalArgumentException e) {
				return request.getLocale();
			}
		}
	}
}

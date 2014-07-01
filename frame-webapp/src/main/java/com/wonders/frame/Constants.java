package com.wonders.frame;

public interface Constants {

	public static final String CAPTCHA_SESSION_ATTRIBUTE_KEY = Constants.class.getName() + "#CAPTCHA_SESSION_ATTRIBUTE_KEY";

	public static final int DEFAULT_PAGE_SIZE = 20;

	public static interface RoleNames {
		
		public static final String ADMIN = "ROLE_ADMIN";

		public static final String USER = "ROLE_USER";
	}
}

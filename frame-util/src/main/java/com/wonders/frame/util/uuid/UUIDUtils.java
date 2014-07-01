package com.wonders.frame.util.uuid;

import java.util.UUID;

public final class UUIDUtils {

	private UUIDUtils() {}
	
	public static String randomUUID() {
		return randomUUID(false, true);
	}

	public static String randomUUID(boolean lowerCase, boolean noSeparators) {
		String uuid = UUID.randomUUID().toString();
		
		if (! lowerCase) {
			uuid = uuid.toUpperCase();
		}
		
		if (noSeparators) {
			uuid = uuid.replaceAll("-", "");
		}

		return uuid;
	}
}

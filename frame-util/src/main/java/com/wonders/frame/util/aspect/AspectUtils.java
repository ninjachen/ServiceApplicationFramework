package com.wonders.frame.util.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Aspect 鍒囬潰宸ュ叿绫�
 * 
 * @author 搴斿崜
 *
 */
public final class AspectUtils {

	private AspectUtils() {}

	/**
	 * 鑾峰彇琚嫤鎴柟娉�
	 * 
	 * @param jp JoinPoint 瀹炰緥
	 * @return
	 */
	public static Method getMethod(JoinPoint jp) {
		return ((MethodSignature) jp.getSignature()).getMethod();
	}

	public static String getMethodName(JoinPoint jp) {
		return getMethod(jp).getName();
	}

	public static <T extends Annotation> T getAnnotation(JoinPoint jp, Class<T> annotationClass) {
		return getMethod(jp).getAnnotation(annotationClass);
	}
	
	public static int getModifiers(JoinPoint jp) {
		return getMethod(jp).getModifiers();
	}
	
	public static boolean isPublic(JoinPoint jp) {
		return Modifier.isPublic(getModifiers(jp));
	}
	
	public static boolean isProtected(JoinPoint jp) {
		return Modifier.isProtected(getModifiers(jp));
	}
	
	public static boolean isPrivate(JoinPoint jp) {
		return Modifier.isPrivate(getModifiers(jp)); 
	}
	
	public static boolean isStatic(JoinPoint jp) {
		return Modifier.isStatic(getModifiers(jp));
	}
	
	public static boolean isFinal(JoinPoint jp) {
		return Modifier.isFinal(getModifiers(jp));
	}
	
	public static boolean isSynchronized(JoinPoint jp) {
		return Modifier.isSynchronized(getModifiers(jp));
	}
	
	public static boolean isNative(JoinPoint jp) {
		return Modifier.isNative(getModifiers(jp));
	} 
}

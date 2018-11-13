package com.stylefeng.guns.core.support;

import java.util.HashMap;
import java.util.Map;

/**
 * 基本变量类型的枚举
 * @author xiaoleilu
 */
public enum BasicType {
	/**
	 * 字节类型
	 */
	BYTE,
	/**
	 *  短整型
	 */
	SHORT,
	/**
	 * 整型
	 */
	INT,
	/**
	 * 整型包装类型
	 */
	INTEGER,
	/**
	 * 长整型
	 */
	LONG,
	/**
	 * 浮点型， 占内存32位
	 */
	DOUBLE,
	/**
	 * 双精度浮点型，站位64位，即8个字节
	 */
	FLOAT,
	/**
	 * 布尔类型，占用1个字节
	 */
	BOOLEAN,
	/**
	 * 字符型，用于存储单个字符，占16位，即2个字节，默认为/
	 */
	CHAR,
	/**
	 * char的包装类型
	 */
	CHARACTER,
	/**
	 * string 类型
	 */
	STRING;
	
	/** 原始类型为Key，包装类型为Value，例如： int.class -> Integer.class. */
	public static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP = new HashMap<Class<?>, Class<?>>(8);
	/** 包装类型为Key，原始类型为Value，例如： Integer.class -> int.class. */
	public static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_MAP = new HashMap<Class<?>, Class<?>>(8);
	
	static {
		WRAPPER_PRIMITIVE_MAP.put(Boolean.class, boolean.class);
		WRAPPER_PRIMITIVE_MAP.put(Byte.class, byte.class);
		WRAPPER_PRIMITIVE_MAP.put(Character.class, char.class);
		WRAPPER_PRIMITIVE_MAP.put(Double.class, double.class);
		WRAPPER_PRIMITIVE_MAP.put(Float.class, float.class);
		WRAPPER_PRIMITIVE_MAP.put(Integer.class, int.class);
		WRAPPER_PRIMITIVE_MAP.put(Long.class, long.class);
		WRAPPER_PRIMITIVE_MAP.put(Short.class, short.class);

		for (Map.Entry<Class<?>, Class<?>> entry : WRAPPER_PRIMITIVE_MAP.entrySet()) {
			WRAPPER_PRIMITIVE_MAP.put(entry.getValue(), entry.getKey());
		}
	}
}

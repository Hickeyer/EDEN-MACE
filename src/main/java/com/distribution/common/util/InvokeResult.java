package com.distribution.common.util;

import java.io.Serializable;

public class InvokeResult implements Serializable, Cloneable {

	private static final long serialVersionUID = 4934196164318871492L;

	private Object data;
	private String message;
	private boolean success;

	private Integer code;

	public static InvokeResult failure(String message) {
		InvokeResult result = new InvokeResult();
		result.message = message;
		result.success = false;
		result.code=99;
		return result;
	}

	public static InvokeResult success(Object data) {
		InvokeResult result = new InvokeResult();
		result.message = "";
		result.data = data;
		result.success = true;
		result.code=0;
		return result;
	}

	public static InvokeResult success() {
		InvokeResult result = new InvokeResult();
		result.message = "";
		result.data = "success";
		result.success = true;
		result.code=0;
		return result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}

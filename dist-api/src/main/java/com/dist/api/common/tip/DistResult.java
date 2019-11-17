package com.dist.api.common.tip;

import java.io.Serializable;

public class DistResult implements Serializable, Cloneable {

    private static final long serialVersionUID = 8000349409315221668L;
    private Object data;
    private String errorMessage;
    private boolean success;

    public static DistResult failure(String errorMessage) {
        DistResult result = new DistResult();
        result.errorMessage = errorMessage;
        result.success = false;
        return result;
    }

    public static DistResult success(Object data) {
        DistResult result = new DistResult();
        result.errorMessage = "";
        result.data = data;
        result.success = true;
        return result;
    }

    public static DistResult success() {
        DistResult result = new DistResult();
        result.errorMessage = "";
        result.data = "success";
        result.success = true;
        return result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}

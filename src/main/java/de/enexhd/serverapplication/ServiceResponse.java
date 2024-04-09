package de.enexhd.serverapplication;

import org.json.JSONObject;

public class ServiceResponse {

    private int errorClass;
    private String errorInfo;
    private JSONObject data;

    public ServiceResponse(int errorClass, String errorInfo) {
        this.errorClass = errorClass;
        this.errorInfo = errorInfo;
        this.data = new JSONObject();
    }
    public ServiceResponse(int errorClass, String errorInfo, JSONObject data) {
        this.errorClass = errorClass;
        this.errorInfo = errorInfo;
        this.data = data;
    }

    public JSONObject toJSON() {
        return data.put("error-class", errorClass).put("error-info", errorInfo);
    }

    public int getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(int errorClass) {
        this.errorClass = errorClass;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public JSONObject getData() {
        return data;
    }

    public ServiceResponse setData(JSONObject data) {
        this.data = data;
        return this;
    }

}

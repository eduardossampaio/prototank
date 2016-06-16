package com.esampaio.prototank.raspberry.action.request;

import com.esampaio.prototank.raspberry.action.ResultStatus;

public class RequestResult {
	private Request request;
	private Object data;
	private ResultStatus resultStatus;
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultStatus getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	
}

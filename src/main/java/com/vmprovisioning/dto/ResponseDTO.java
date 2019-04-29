package com.vmprovisioning.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class ResponseDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("data")
	@JsonSerialize(typing = JsonSerialize.Typing.DYNAMIC)
	private Object data;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("error_code")
	
	private Integer errorCode = 0;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("error_message")
	
	private String errorMessage = "";

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("status_code")
	
	private Integer statusCode = 0;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("success")
	
	private Boolean success;

	public Object getData() {
		return data;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the status_code
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param status_code the status_code to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
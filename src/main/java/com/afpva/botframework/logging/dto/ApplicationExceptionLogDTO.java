package com.afpva.botframework.logging.dto;

import java.util.Date;


public class ApplicationExceptionLogDTO {

	private long applicationexceptionid;
	public long getApplicationexceptionid() {
		return applicationexceptionid;
	}
	public void setApplicationexceptionid(long applicationexceptionid) {
		this.applicationexceptionid = applicationexceptionid;
	}
	private Date exceptiontimestamp;
	private long conversationId;
	private String errorCode;
	private String errorMessage;
	private String source;
	
	public Date getExceptiontimestamp() {
		return exceptiontimestamp;
	}
	public void setExceptiontimestamp(Date exceptiontimestamp) {
		this.exceptiontimestamp = exceptiontimestamp;
	}
	public long getConversationId() {
		return conversationId;
	}
	public void setConversationId(long conversationId) {
		this.conversationId = conversationId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}

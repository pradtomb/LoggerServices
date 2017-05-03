package com.afpva.botframework.logging.dto;

import java.util.Date;


public class ApplicationLogDTO {

	private long conversationmessageid;	
	private String componentcode;
	private String componentmethod;
	private String input;
	private String output;
	private String logmessage;
	private Date timestamp;
	
	public long getConversationmessageid() {
		return conversationmessageid;
	}
	public void setConversationmessageid(long conversationmessageid) {
		this.conversationmessageid = conversationmessageid;
	}
	public String getComponentcode() {
		return componentcode;
	}
	public void setComponentcode(String componentcode) {
		this.componentcode = componentcode;
	}
	public String getComponentmethod() {
		return componentmethod;
	}
	public void setComponentmethod(String componentmethod) {
		this.componentmethod = componentmethod;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getLogmessage() {
		return logmessage;
	}
	public void setLogmessage(String logmessage) {
		this.logmessage = logmessage;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}

package com.vsofts.botframework.logging.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicationlog")
public class ApplciationLog implements Serializable{


	

	private static final long serialVersionUID = -1304479854132847154L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "conversationmessageid")
	private long conversationmessageid;

	@Column(name = "componentcode")
	private String componentcode;

	@Column(name = "componentmethod")
	private String componentmethod;

	@Column(name = "input")
	private String input;

	@Column(name = "output")
	private String output;

	@Column(name = "logmessage")
	private String logmessage;
	
	@Column(name = "timestamp")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ApplciationLog(String componentcode,	String componentmethod, String input, String output, String logmessage, Date timestamp ) {
		super();	
		this.componentcode= componentcode;
		this.componentmethod = componentmethod;
		this.input = input;
		this.output = output;
		this.logmessage = logmessage;
		this.timestamp = timestamp;
	}
	
	public ApplciationLog(){};
	
	@Override
	public String toString() {
		return "ApplciationLog [conversationmessageid=" + conversationmessageid + ", componentcode="
				+ componentcode + ", componentmethod=" + componentmethod + ", input=" + input
				+ ", output=" + output + ", logmessage=" + logmessage + ", timestamp=" + timestamp  + " + ]";
	}
	
	

}

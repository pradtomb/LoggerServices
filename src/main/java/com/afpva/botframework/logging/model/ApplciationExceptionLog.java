package com.afpva.botframework.logging.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "applicationexceptionlog")
public class ApplciationExceptionLog implements Serializable{


	

	private static final long serialVersionUID = -1304479854132847154L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationexceptionid")
	private long applicationexceptionid;

	

	public long getApplicationexceptionid() {
		return applicationexceptionid;
	}

	public void setApplicationexceptionid(long applicationexceptionid) {
		this.applicationexceptionid = applicationexceptionid;
	}

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

	@Column(name = "exceptiontimestamp")
	private Date exceptiontimestamp;

	@Column(name = "conversationid")
	private long conversationId;

	@Column(name = "errorcode")
	private String errorCode;

	@Column(name = "errormessage")
	private String errorMessage;

	@Column(name = "source")
	private String source;

	

	public ApplciationExceptionLog( Date exceptiontimestamp, long conversationId, String errorCode,
			String errorMessage, String source) {
		super();
	
		this.exceptiontimestamp = exceptiontimestamp;
		this.conversationId = conversationId;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.source=source;
	}
	
	public ApplciationExceptionLog(){};
	@Override
	public String toString() {
		return "ApplciationExceptionLog [applicationexceptionid=" + applicationexceptionid + ", exceptiontimestamp="
				+ exceptiontimestamp + ", conversationId=" + conversationId + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + ", source=" + source + "]";
	}
	
	

}

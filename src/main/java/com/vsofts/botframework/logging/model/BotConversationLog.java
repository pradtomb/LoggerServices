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
@Table(name = "botconversation")
public class BotConversationLog implements Serializable{
	
	
	private static final long serialVersionUID = -8590495000010815683L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
//@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="botconversationmessageid")
private long botConversationMessageId;

@Column(name="conversationid")
private String conversationId;


@Column(name = "conversationreq")
private String conversationReq;

@Column(name = "conversationres")
private String conversationRes;

@Column(name = "channelid")
private String channelId;

@Column(name = "intentname")
private String intentName;

@Column(name = "intentconfidence")
private double	intentConfidence;

@Column(name = "userid")
private String userId;

@Column(name = "requesttimestamp")
private Date requestTimestamp;

@Column(name = "responsetimestamp")
private Date responseTimestamp;

@Column(name = "requestsentiment")
private String requestSentiment;


public long getBotConversationMessageId() {
	return botConversationMessageId;
}
public void setBotConversationMessageId(long botConversationMessageId) {
	this.botConversationMessageId = botConversationMessageId;
}
public String getConversationId() {
	return conversationId;
}
public void setConversationId(String conversationId) {
	this.conversationId = conversationId;
}
public String getConversationReq() {
	return conversationReq;
}
public void setConversationReq(String conversationReq) {
	this.conversationReq = conversationReq;
}
public String getConversationRes() {
	return conversationRes;
}
public void setConversationRes(String conversationRes) {
	this.conversationRes = conversationRes;
}
public String getChannelId() {
	return channelId;
}
public void setChannelId(String channelId) {
	this.channelId = channelId;
}
public String getIntentName() {
	return intentName;
}
public void setIntentName(String intentName) {
	this.intentName = intentName;
}
public double getIntentConfidence() {
	return intentConfidence;
}
public void setIntentConfidence(double intentConfidence) {
	this.intentConfidence = intentConfidence;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public Date getRequestTimestamp() {
	return requestTimestamp;
}
public void setRequestTimestamp(Date requestTimestamp) {
	this.requestTimestamp = requestTimestamp;
}
public Date getResponseTimestamp() {
	return responseTimestamp;
}
public void setResponseTimestamp(Date responseTimestamp) {
	this.responseTimestamp = responseTimestamp;
}
public String getRequestSentiment() {
	return requestSentiment;
}
public void setRequestSentiment(String requestSentiment) {
	this.requestSentiment = requestSentiment;
}

@Override
public String toString() {
	return "BotConversationLog [botConversationMessageId=" + botConversationMessageId + ", conversationId="
			+ conversationId + ", conversationReq=" + conversationReq + ", conversationRes=" + conversationRes
			+ ", channelId=" + channelId + ", intentName=" + intentName + ", intentConfidence=" + intentConfidence
			+ ", userId=" + userId + ", requestTimestamp=" + requestTimestamp + ", responseTimestamp="
			+ responseTimestamp + ", requestSentiment=" + requestSentiment + "]";
}

public BotConversationLog(String conversationId, String conversationReq,
		String conversationRes, String channelId, String intentName, double intentConfidence, String userId,
		Date requestTimestamp, Date responseTimestamp, String requestSentiment) {
	super();
	
	this.conversationId = conversationId;
	this.conversationReq = conversationReq;
	this.conversationRes = conversationRes;
	this.channelId = channelId;
	this.intentName = intentName;
	this.intentConfidence = intentConfidence;
	this.userId = userId;
	this.requestTimestamp = requestTimestamp;
	this.responseTimestamp = responseTimestamp;
	this.requestSentiment = requestSentiment;
}

public BotConversationLog(){}

}


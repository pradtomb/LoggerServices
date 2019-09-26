package com.vsofts.botframework.logging.dto;

import java.util.Date;


public class BotConversationLogDTO {
	
private long botConversationMessageId;
private String conversationId;
private String conversationReq;
private String conversationRes;
private String channelId;
private String intentName;
private double	intentConfidence;
private String userId;
private Date requestTimestamp;
private Date responseTimestamp;
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
public BotConversationLogDTO(long botConversationMessageId, String conversationRes, Date responseTimestamp) {
	super();
	this.botConversationMessageId = botConversationMessageId;
	this.conversationRes = conversationRes;
	this.responseTimestamp = responseTimestamp;
}
public BotConversationLogDTO() {
	// TODO Auto-generated constructor stub
}




}


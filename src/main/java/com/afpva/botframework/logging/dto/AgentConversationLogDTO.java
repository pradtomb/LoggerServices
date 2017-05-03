package com.afpva.botframework.logging.dto;

import java.util.Date;


public class AgentConversationLogDTO {
	
private long agentConversationMessageID;
private String conversationID;
private String channelUserID;
private String channelSessionID;
private String agentID;
private Date requestTimeStamp;
private String agentCoversationRequest;
private String agentCoversationResponse;
private String channelID;
private Date responseTimeStamp;
private String conversationSentiment;




public long getAgentConversationMessageID() {
	return agentConversationMessageID;
}
public void setAgentConversationMessageID(long agentConversationMessageID) {
	this.agentConversationMessageID = agentConversationMessageID;
}
public String getConversationID() {
	return conversationID;
}
public void setConversationID(String conversationID) {
	this.conversationID = conversationID;
}
public String getChannelUserID() {
	return channelUserID;
}
public void setChannelUserID(String channelUserID) {
	this.channelUserID = channelUserID;
}
public String getChannelSessionID() {
	return channelSessionID;
}
public void setChannelSessionID(String channelSessionID) {
	this.channelSessionID = channelSessionID;
}
public String getAgentID() {
	return agentID;
}
public void setAgentID(String agentID) {
	this.agentID = agentID;
}
public String getAgentCoversationRequest() {
	return agentCoversationRequest;
}
public void setAgentCoversationRequest(String agentCoversationRequest) {
	this.agentCoversationRequest = agentCoversationRequest;
}
public String getAgentCoversationResponse() {
	return agentCoversationResponse;
}
public void setAgentCoversationResponse(String agentCoversationResponse) {
	this.agentCoversationResponse = agentCoversationResponse;
}
public String getChannelID() {
	return channelID;
}
public void setChannelID(String channelID) {
	this.channelID = channelID;
}
public Date getRequestTimeStamp() {
	return requestTimeStamp;
}
public void setRequestTimeStamp(Date requestTimeStamp) {
	this.requestTimeStamp = requestTimeStamp;
}
public Date getResponseTimeStamp() {
	return responseTimeStamp;
}
public void setResponseTimeStamp(Date responseTimeStamp) {
	this.responseTimeStamp = responseTimeStamp;
}
public String getConversationSentiment() {
	return conversationSentiment;
}
public void setConversationSentiment(String conversationSentiment) {
	this.conversationSentiment = conversationSentiment;
}





}


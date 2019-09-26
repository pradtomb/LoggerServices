package com.vsofts.botframework.logging.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "agentconversation")
public class AgentConversationLog implements Serializable{
	
	private static final long serialVersionUID = -6959280275742520424L;
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="agentconversationmessageid")
private long agentConversationMessageID;

@Column(name="conversationid")
private String conversationID;


@Column(name = "channeluserid")
private String channelUserID;

@Column(name = "channelsessionid")
private String channelSessionID;

@Column(name = "agentid")
private String agentID;

@Column(name = "requesttimestamp")
private Date requestTimeStamp;

@Column(name = "agentcoversationrequest")
private String agentCoversationRequest;

@Column(name = "agentcoversationresponse")
private String agentCoversationResponse;

@Column(name = "channelid")
private String channelID;

@Column(name = "responsetimestamp")
private Date responseTimeStamp;

@Column(name = "conversationsentiment")
private String conversationSentiment;

public AgentConversationLog() {
}

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

public static long getSerialversionuid() {
	return serialVersionUID;
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

@Override
public String toString() {
	return "AgentConversationLog [agentConversationMessageID=" + agentConversationMessageID + ", conversationID="
			+ conversationID + ", channelUserID=" + channelUserID + ", channelSessionID=" + channelSessionID
			+ ", agentID=" + agentID + ", requestTimeStamp=" + requestTimeStamp +", responseTimeStamp=" + responseTimeStamp + ", conversationSentiment=" + conversationSentiment + ", agentCoversationRequest=" + agentCoversationRequest
			+ ", agentCoversationResponse=" + agentCoversationResponse + ", channelID=" + channelID + "]";
}

public AgentConversationLog(String conversationID, String channelUserID,
		String channelSessionID, String agentID,Date requestTimeStamp, String agentCoversationRequest,String channelID,String conversationSentiment) {
	super();
	this.conversationID = conversationID;
	this.channelUserID = channelUserID;
	this.channelSessionID = channelSessionID;
	this.agentID = agentID;
	this.channelID = channelID;
	
	if(agentCoversationRequest.length() > 200){
		
		this.conversationSentiment = agentCoversationRequest.substring(0,199);
	}else{
		
		this.conversationSentiment = agentCoversationRequest;
	}
	
	if(conversationSentiment == null || conversationSentiment.length() == 0){
		
		this.conversationSentiment = "NEUTRAL";
	}else{
		
		this.conversationSentiment = conversationSentiment.toUpperCase();
	}

	if(requestTimeStamp == null){
        Date date = new Date();
		this.requestTimeStamp = new Timestamp(date.getTime());		
	}else{
		
		this.requestTimeStamp = requestTimeStamp;

	}
}



}


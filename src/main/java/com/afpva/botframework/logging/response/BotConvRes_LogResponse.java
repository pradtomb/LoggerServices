package com.afpva.botframework.logging.response;

import java.util.Date;

public class BotConvRes_LogResponse {
	
	private long botConversationMessageId;
	private String conversationRes;
	private Date responseTimestamp;
	
	
	
	public long getBotConversationMessageId() {
		return botConversationMessageId;
	}
	public void setBotConversationMessageId(long botConversationMessageId) {
		this.botConversationMessageId = botConversationMessageId;
	}
	public String getConversationRes() {
		return conversationRes;
	}
	public void setConversationRes(String conversationRes) {
		this.conversationRes = conversationRes;
	}
	public Date getResponseTimestamp() {
		return responseTimestamp;
	}
	public void setResponseTimestamp(Date responseTimestamp) {
		this.responseTimestamp = responseTimestamp;
	}
	
	public BotConvRes_LogResponse(long botConversationMessageId, String conversationRes, Date responseTimestamp) {
		super();
		this.botConversationMessageId = botConversationMessageId;
		this.conversationRes = conversationRes;
		this.responseTimestamp = responseTimestamp;
	}
}


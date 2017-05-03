package com.afpva.botframework.logging.response;

import java.util.Date;

public class BotConvRes_LogRequest {
	private long botConversationMessageId;
	private String conversationReq;
	private Date requestTimestamp;
	public long getBotConversationMessageId() {
		return botConversationMessageId;
	}
	public void setBotConversationMessageId(long botConversationMessageId) {
		this.botConversationMessageId = botConversationMessageId;
	}
	public String getConversationReq() {
		return conversationReq;
	}
	public void setConversationReq(String conversationReq) {
		this.conversationReq = conversationReq;
	}
	public Date getRequestTimestamp() {
		return requestTimestamp;
	}
	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}
	public BotConvRes_LogRequest(long botConversationMessageId, String conversationReq, Date requestTimestamp) {
		super();
		this.botConversationMessageId = botConversationMessageId;
		this.conversationReq = conversationReq;
		this.requestTimestamp = requestTimestamp;
	}
}

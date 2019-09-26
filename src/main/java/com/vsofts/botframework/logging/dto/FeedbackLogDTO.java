package com.vsofts.botframework.logging.dto;

import java.util.Date;

public class FeedbackLogDTO {
	
private long feedbackLogMessageID;
private String conversationID;
private String feedbackText;
private String feedbackSentiment;
private int feedbackRating;
private Date feedbacktTimestamp;
public long getFeedbackLogMessageID() {
	return feedbackLogMessageID;
}
public void setFeedbackLogMessageID(long feedbackLogMessageID) {
	this.feedbackLogMessageID = feedbackLogMessageID;
}
public String getConversationID() {
	return conversationID;
}
public void setConversationID(String conversationID) {
	this.conversationID = conversationID;
}
public String getFeedbackText() {
	return feedbackText;
}
public void setFeedbackText(String feedbackText) {
	this.feedbackText = feedbackText;
}
public String getFeedbackSentiment() {
	return feedbackSentiment;
}
public void setFeedbackSentiment(String feedbackSentiment) {
	this.feedbackSentiment = feedbackSentiment;
}
public int getFeedbackRating() {
	return feedbackRating;
}
public void setFeedbackRating(int feedbackRating) {
	this.feedbackRating = feedbackRating;
}
public Date getFeedbacktTimestamp() {
	return feedbacktTimestamp;
}
public void setFeedbacktTimestamp(Date feedbacktTimestamp) {
	this.feedbacktTimestamp = feedbacktTimestamp;
}


}


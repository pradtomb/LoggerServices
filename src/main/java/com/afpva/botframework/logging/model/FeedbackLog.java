package com.afpva.botframework.logging.model;

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
@Table(name = "feedbacklog")
public class FeedbackLog implements Serializable{
	
	private static final long serialVersionUID = -6959280275742520424L;
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="feedbacklogmessageid")
private long feedbackLogMessageID;

@Column(name="conversationid")
private String conversationID;


@Column(name = "feedbacktext")
private String feedbackText;

@Column(name = "feedbacksentiment")
private String feedbackSentiment;

@Column(name = "feedbackrating")
private int feedbackRating;

@Column(name = "feedbacktimestamp")
private Date feedbackTimestamp;


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


public Date getFeedbackTimestamp() {
	return feedbackTimestamp;
}


public void setFeedbackTimestamp(Date feedbackTimestamp) {
	this.feedbackTimestamp = feedbackTimestamp;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public FeedbackLog() {
}


@Override
public String toString() {
	return "FeedbackLog [feedbackLogMessageID=" + feedbackLogMessageID + ", conversationID="
			+ conversationID + ", feedbackText=" + feedbackText + ", feedbackSentiment=" + feedbackSentiment
			+ ", feedbackRating=" + feedbackRating + ", feedbackTimestamp=" + feedbackTimestamp  + "]";
}

public FeedbackLog(String conversationID, String feedbackText,
		String feedbackSentiment, int feedbackRating,Date feedbackTimestamp) {
	super();
	this.conversationID = conversationID;
	this.feedbackText = feedbackText;
	this.feedbackSentiment = feedbackSentiment;
	this.feedbackRating = feedbackRating;
	
	if(feedbackSentiment == null || feedbackSentiment.length() == 0){
		
		this.feedbackSentiment = "NEUTRAL";
	}else{
		
		this.feedbackSentiment = feedbackSentiment.toUpperCase();
	}
	
	if(feedbackTimestamp == null){
        Date date = new Date();
		this.feedbackTimestamp = new Timestamp(date.getTime());		
	}else{
		
		this.feedbackTimestamp = feedbackTimestamp;

	}
}


}


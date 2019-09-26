package com.vsofts.botframework.logging.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsofts.botframework.logging.dao.FeedbackLogRepository;
import com.vsofts.botframework.logging.dto.FeedbackLogDTO;
import com.vsofts.botframework.logging.model.FeedbackLog;

@Service
public class FeedbackLogService {

	@Autowired
	FeedbackLogRepository feedbackLogRepository;
	
	//Insert The Data
	public FeedbackLogDTO logRequest(FeedbackLogDTO feedbackLogDTO)
	{
		FeedbackLog feedbackLog = new FeedbackLog(feedbackLogDTO.getConversationID(),
				                                    feedbackLogDTO.getFeedbackText(),
				                                    feedbackLogDTO.getFeedbackSentiment(),
				                                    feedbackLogDTO.getFeedbackRating(),
				                                    feedbackLogDTO.getFeedbacktTimestamp());
		
		feedbackLogRepository.save(feedbackLog);
		feedbackLogDTO.setFeedbackLogMessageID(feedbackLog.getFeedbackLogMessageID());
		return feedbackLogDTO;
		
	}
	
	
}

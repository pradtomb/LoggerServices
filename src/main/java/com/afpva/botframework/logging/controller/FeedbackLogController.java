package com.afpva.botframework.logging.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afpva.botframework.logging.dto.FeedbackLogDTO;
import com.afpva.botframework.logging.service.FeedbackLogService;

@RestController
@RequestMapping("/feedbacklog")
public class FeedbackLogController {

	@Autowired
	FeedbackLogService feedbackLogService; 
	
	@RequestMapping(method=RequestMethod.POST,produces="application/json",value = "/logrequest")
	public Map<String,Object> saveFeedbackLogRequest(@RequestBody FeedbackLogDTO feedbackLogDTO){
		
		List<String> validationResult = validateRequest(feedbackLogDTO);
		Map<String,Object> result=new HashMap<String, Object>();

		if(validationResult.isEmpty()){
			feedbackLogService.logRequest(feedbackLogDTO);
			result.put("operation_result", "success");
		    result.put("response", feedbackLogDTO);
		}else{
			result.put("operation_result", "fail");
			result.put("response", validationResult);
		}
				
		return result;
	
	}

	 
		List<String> validateRequest(FeedbackLogDTO feedbackLogDTO){
			
			
			List<String> errors = new ArrayList<String>();
			
				
			if(isNullOrEmpty(feedbackLogDTO.getConversationID())) {

				errors.add("Conversation ID Field should not be empty");
			}
			
			
			if(!isNullOrEmpty(feedbackLogDTO.getFeedbackSentiment())) {
				
	            if(!("POSITIVE".equalsIgnoreCase(feedbackLogDTO.getFeedbackSentiment()) 
	            		|| "NEGATIVE".equalsIgnoreCase(feedbackLogDTO.getFeedbackSentiment())
	            		|| "NEUTRAL".equalsIgnoreCase(feedbackLogDTO.getFeedbackSentiment()))){
	            	
	    			errors.add("Feedback Sentiment value should be POSITIVE/NAGATIVE/NEUTRAL");

	            	
	            }
			}
			
			
			if(isNullOrEmpty(feedbackLogDTO.getFeedbackText())) {
				errors.add("Feedback Text Field should not be empty");
			  
			}
			
			if(!(feedbackLogDTO.getFeedbackRating() >=1 && feedbackLogDTO.getFeedbackRating() <=5)) {
				errors.add("Feedback Rating should between 1 to 5");
			  
			}
			
						
			return errors;
			
		}
		
		

		 public static boolean isNullOrEmpty(String s) {
			    return s == null || s.length() == 0 || s.trim().length() == 0;
		}
		 		

}

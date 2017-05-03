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

import com.afpva.botframework.logging.dto.AgentConversationLogDTO;
import com.afpva.botframework.logging.service.AgentConversationService;


@RestController
@RequestMapping("/agentconversationlog")
public class AgentConversationLogController {

	@Autowired
	AgentConversationService agentConversationService; 
	
	@RequestMapping(method=RequestMethod.POST,produces="application/json",value = "/logrequest")
	public Map<String,Object> saveAgentConversationLogRequest(@RequestBody AgentConversationLogDTO agentConvDTO){
		
		List<String> validationResult = validateRequest(agentConvDTO);
		Map<String,Object> result=new HashMap<String, Object>();

		if(validationResult.isEmpty()){
		    agentConversationService.logRequest(agentConvDTO);
		    result.put("operation_result", "success");
		    result.put("response", agentConvDTO);
		}else{
			result.put("operation_result", "fail");
			result.put("response", validationResult);
		}
				
		return result;
	}
	
	
	List<String> validateRequest(AgentConversationLogDTO agentConvDTO){
		
	
		List<String> errors = new ArrayList<String>();
		
			
		if(isNullOrEmpty(agentConvDTO.getConversationID())) {

			errors.add("Conversation ID Field should not be empty");
		}
		
		if(isNullOrEmpty(agentConvDTO.getChannelUserID())) {
			errors.add("Channel User ID Field should not be empty");
		  
		}
		
		if(isNullOrEmpty(agentConvDTO.getChannelSessionID())) {
			errors.add("Channel Session ID Field should not be empty");
		  
		}
		
		if(isNullOrEmpty(agentConvDTO.getAgentID())) {
			errors.add("Agent ID Field should not be empty");
		  
		}
		
		if(isNullOrEmpty(agentConvDTO.getAgentCoversationRequest())) {
			errors.add("Agent Conversation request Field should not be empty");
		  
		}
		
		if(!isNullOrEmpty(agentConvDTO.getConversationSentiment())) {
			
            if(!("POSITIVE".equalsIgnoreCase(agentConvDTO.getConversationSentiment()) 
            		|| "NEGATIVE".equalsIgnoreCase(agentConvDTO.getConversationSentiment())
            		|| "NEUTRAL".equalsIgnoreCase(agentConvDTO.getConversationSentiment()))){
            	
    			errors.add("Conversation Sentiment value should be POSITIVE/NAGATIVE/NEUTRAL");

            	
            }
		}

		
		return errors;
		
	}
	
	    
	@RequestMapping(method=RequestMethod.POST,produces="application/json",value = "/logresponse")
	public Map<String,Object> saveAgentConversationLogResponse(@RequestBody AgentConversationLogDTO agentConvDTO){
		
			
		System.out.println("Got AgentConversationMessageID from application"+agentConvDTO.getAgentConversationMessageID());
	
		
		List<String> validationResult = validateResponse(agentConvDTO);
		Map<String,Object> result=new HashMap<String, Object>();
		if(validationResult.isEmpty()){
		 
			agentConversationService.logResponse(agentConvDTO);			
    		result.put("operation_result", "success");
			result.put("response", agentConvDTO);
			
			
		}else{
			
			result.put("operation_result", "fail");
			result.put("response", validationResult);
		}
		
		return result;
	}
	
	List<String> validateResponse(AgentConversationLogDTO agentConvDTO){
		
		
		List<String> errors = new ArrayList<String>();
		
		if(agentConvDTO.getAgentConversationMessageID() == 0){
			
			errors.add("AgentConversationMessageID Field should not be empty");

		}
			
		if(isNullOrEmpty(agentConvDTO.getAgentCoversationResponse())) {

			errors.add("Agent Conversation Response Field should not be empty");
		}
		
		return errors;
		
	}
	
	 public static boolean isNullOrEmpty(String s) {
		    return s == null || s.length() == 0 || s.trim().length() == 0;
	}

}

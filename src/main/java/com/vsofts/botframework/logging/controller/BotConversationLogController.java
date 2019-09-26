package com.vsofts.botframework.logging.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vsofts.botframework.logging.dto.BotConversationLogDTO;
import com.vsofts.botframework.logging.response.BotConvRes_LogRequest;
import com.vsofts.botframework.logging.response.BotConvRes_LogResponse;
import com.vsofts.botframework.logging.service.BotConversationServices;



@RestController
@RequestMapping("/botconversationlog")
public class BotConversationLogController {

	@Autowired
	BotConversationServices botConversationService; 
	/*POST method used Inserts the request data into the database 
	 * Expected save of entity A ConversationMessageId generateion and requestTimestamp with systime updae
	 * 
	 * */
	@RequestMapping(value = "/logRequest",method=RequestMethod.POST,produces="application/json")
	public Map<String,Object> saveLog(@RequestBody BotConversationLogDTO botConvDTO){
		List<String> validationResult = validateRequest(botConvDTO);
		
		/*
		 * BotConvRes_LogResponse responseDto = new BotConvRes_LogResponse(botCovDto.getBotConversationMessageId(), botCovDto.getConversationRes(), botCovDto.getResponseTimestamp());
		Map<String,Object> result=new HashMap<String, Object>();
		result.put("result", "sucess"); 
		result.put("response", responseDto);
		 * */
		
		Map<String,Object> result=new HashMap<String, Object>();
		if(validationResult.isEmpty()){
			
			botConversationService.logRequest(botConvDTO);
			BotConvRes_LogRequest requestDto = new BotConvRes_LogRequest(botConvDTO.getBotConversationMessageId(), botConvDTO.getConversationReq(), botConvDTO.getRequestTimestamp());
			result.put("operation_result", "sucess"); 
			result.put("response", requestDto);
		}
		else
		{
				result.put("operation_result", "fail");
				result.put("response", validationResult);
		}
		return result;
	}
	
	/*
	 * A GET Response will generate the json response with all data into the database
	 * */
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public Map<String,Object> getAllLog(){
		List<BotConversationLogDTO> botConversationList=botConversationService.getAllLog();
		
		Map<String,Object> result=new HashMap<String, Object>();
		result.put("operation_result", "sucess"); 
		result.put("response", botConversationList);
		return result;
	}
	/* A POST method requested
	 * A request contening convestationMessageId and responseMessage will be updated
	 * responding with updated value on responseTimeStamp field
	 * */
	@RequestMapping(value = "/logResponse",method=RequestMethod.POST,produces="application/json")
	public Map<String,Object>logResponse(@RequestBody BotConversationLogDTO botConvDTO){
		BotConversationLogDTO botCovDto = botConversationService.logResponse(botConvDTO);
		BotConvRes_LogResponse responseDto = new BotConvRes_LogResponse(botCovDto.getBotConversationMessageId(), botCovDto.getConversationRes(), botCovDto.getResponseTimestamp());
		Map<String,Object> result=new HashMap<String, Object>();
		result.put("operation_result", "sucess"); 
		result.put("response", responseDto);
	return result;
	}
	
	/* A GET method requested
	 * A request contening convestationMessageId to find record
	 * 
	 * */
	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
	public Map<String,Object>  getConversation(@PathVariable("id") long id) {
		
		BotConversationLogDTO botCovDto = botConversationService.findById(id);
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("operation_result", "sucess"); 
			result.put("response", botCovDto);
		return result;
		
	}

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public Map<String,Object>  getHello() {
		
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("operation_result", "sucess"); 
			result.put("response", "HELLO!!");
		return result;
		
	}
	
	List<String> validateRequest(BotConversationLogDTO botConvDTO)
	{
		List<String> errors = new ArrayList<String>();
		
		if(isNullOrEmpty(botConvDTO.getConversationId())) {

			errors.add("Conversation ID Field should not be empty");
		}
		
		if(isNullOrEmpty(botConvDTO.getConversationReq())) {

			errors.add("Conversation request Field should not be empty");
		}
		

		if(isNullOrEmpty(botConvDTO.getConversationRes())) {

			errors.add("Conversation response Field should not be empty");
		}
		
		
		if(isNullOrEmpty(botConvDTO.getChannelId())) {

			errors.add("Channel Id Field should not be empty");
		}
		
		if(isNullOrEmpty(botConvDTO.getChannelId())) {

			errors.add("Channel Id Field should not be empty");
		}
		
		if(isNullOrEmpty(botConvDTO.getUserId())) {

			errors.add("User Id Field should not be empty");
		}
		
		if(!isNullOrEmpty(botConvDTO.getRequestSentiment())) {
			
            if(!("POSITIVE".equalsIgnoreCase(botConvDTO.getRequestSentiment()) 
            		|| "NEGATIVE".equalsIgnoreCase(botConvDTO.getRequestSentiment())
            		|| "NEUTRAL".equalsIgnoreCase(botConvDTO.getRequestSentiment()))){
            	
    			errors.add("Sentiment value should be POSITIVE/NAGATIVE/NEUTRAL");

            	
            }
		}
		
		return errors;
	}
	 public static boolean isNullOrEmpty(String s) {
		    return s == null || s.length() == 0 || s.trim().length() == 0;
	}
	

}

package com.afpva.botframework.logging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afpva.botframework.logging.dao.BotConversationLogRepository;
import com.afpva.botframework.logging.dto.BotConversationLogDTO;
import com.afpva.botframework.logging.model.BotConversationLog;


@Service
public class BotConversationServices {

	@Autowired
	BotConversationLogRepository botConversationRepository;
	
	//Insert The Data
	public BotConversationLogDTO logRequest(BotConversationLogDTO botconLogDTO)
	{
		BotConversationLog botConveLog = new BotConversationLog( botconLogDTO.getConversationId(), botconLogDTO.getConversationReq(), botconLogDTO.getConversationRes(), botconLogDTO.getChannelId(), botconLogDTO.getIntentName(), botconLogDTO.getIntentConfidence(), botconLogDTO.getUserId(), new Date(),new Date(), botconLogDTO.getRequestSentiment());
		
		botConversationRepository.save(botConveLog);
		botconLogDTO.setRequestTimestamp(botConveLog.getRequestTimestamp());
		botconLogDTO.setResponseTimestamp(botConveLog.getResponseTimestamp());
		botconLogDTO.setBotConversationMessageId(botConveLog.getBotConversationMessageId());
		return botconLogDTO;
		
	}
	
	public BotConversationLogDTO logResponse(BotConversationLogDTO botconLogDTO)
	{
	
		BotConversationLog conversationLog =botConversationRepository.findOne(botconLogDTO.getBotConversationMessageId());
		
		if(botConversationRepository.exists(conversationLog.getBotConversationMessageId()))
		{
		
		//conversationLog.setConversationId(botconLogDTO.getConversationId());
		//conversationLog.setConversationReq(botconLogDTO.getConversationReq());
		conversationLog.setConversationRes(botconLogDTO.getConversationRes());
		//conversationLog.setChannelId(botconLogDTO.getChannelId());
		//conversationLog.setIntentName(botconLogDTO.getIntentName());
		//conversationLog.setIntentConfidence(botconLogDTO.getIntentConfidence());
		//conversationLog.setUserId(botconLogDTO.getUserId());
		//conversationLog.setRequestTimestamp(botconLogDTO.getRequestTimestamp());
		botconLogDTO.setResponseTimestamp(new Date());
		conversationLog.setResponseTimestamp(botconLogDTO.getResponseTimestamp());
		//conversationLog.setRequestSentiment(botconLogDTO.getRequestSentiment());
			botConversationRepository.save(conversationLog);	
		}
		BotConversationLogDTO responseDTO = new BotConversationLogDTO(botconLogDTO.getBotConversationMessageId(), botconLogDTO.getConversationRes(), botconLogDTO.getResponseTimestamp());
		return responseDTO;
		
	}
	
	public List<BotConversationLogDTO>  getAllLog()
	{
		List<BotConversationLogDTO> botConversationDTOList=new ArrayList<BotConversationLogDTO>();
		List<BotConversationLog> botConversationList=botConversationRepository.findAll();
		if(botConversationList!=null){
			for (BotConversationLog conversationLog : botConversationList) {
				BotConversationLogDTO conversationDTO=new BotConversationLogDTO();
				conversationDTO.setBotConversationMessageId(conversationLog.getBotConversationMessageId());
				conversationDTO.setConversationId(conversationLog.getConversationId());
				conversationDTO.setConversationReq(conversationLog.getConversationReq());
				conversationDTO.setConversationRes(conversationLog.getConversationRes());
				conversationDTO.setChannelId(conversationLog.getChannelId());
				conversationDTO.setIntentName(conversationLog.getIntentName());
				conversationDTO.setIntentConfidence(conversationLog.getIntentConfidence());
				conversationDTO.setUserId(conversationLog.getUserId());
				conversationDTO.setRequestTimestamp(conversationLog.getRequestTimestamp());
				conversationDTO.setResponseTimestamp(conversationLog.getResponseTimestamp());
				conversationDTO.setRequestSentiment(conversationLog.getRequestSentiment());
				botConversationDTOList.add(conversationDTO);
			
			}
		}
		return botConversationDTOList;
		
	}
	
	public BotConversationLogDTO findById(long botConversationMessageId) {
		//No null check because it doesn't matter in this example
		BotConversationLog conversationLog =botConversationRepository.findOne(botConversationMessageId);
		BotConversationLogDTO conversationDTO=new BotConversationLogDTO();
		conversationDTO.setBotConversationMessageId(conversationLog.getBotConversationMessageId());
		conversationDTO.setConversationId(conversationLog.getConversationId());
		conversationDTO.setConversationReq(conversationLog.getConversationReq());
		conversationDTO.setConversationRes(conversationLog.getConversationRes());
		conversationDTO.setChannelId(conversationLog.getChannelId());
		conversationDTO.setIntentName(conversationLog.getIntentName());
		conversationDTO.setIntentConfidence(conversationLog.getIntentConfidence());
		conversationDTO.setUserId(conversationLog.getUserId());
		conversationDTO.setRequestTimestamp(conversationLog.getRequestTimestamp());
		conversationDTO.setResponseTimestamp(conversationLog.getResponseTimestamp());
		conversationDTO.setRequestSentiment(conversationLog.getRequestSentiment());
		
		return conversationDTO;
	}
	
	
	
	
	
	/*public  logResponse (update)
	 public getConversationScript
	 public getBotConversationScript
	 public getConversationListWithFilter
	 public getConversationCountWithFilter
*/
	/*public List<BotConversationLogDTO> getConversationScript() {
		List<BotConversationLogDTO> botConversationDTOList=new ArrayList<>();
		List<BotConversationLog> customerList=customerRepository.findAll();
		if(customerList!=null){
			for (Customer customer : customerList) {
				CustomerDTO customerDTO=new CustomerDTO();
				customerDTO.setId(customer.getId());
				customerDTO.setFirstName(customer.getFirstName());
				customerDTO.setLastName(customer.getLastName());
				customerDTOList.add(customerDTO);
			}
		}
		return customerDTOList;
	}*/
}

package com.afpva.botframework.logging.service;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afpva.botframework.logging.dao.AgentConversationLogRepository;
import com.afpva.botframework.logging.dto.AgentConversationLogDTO;
import com.afpva.botframework.logging.model.AgentConversationLog;

@Service
public class AgentConversationService {

	@Autowired
	AgentConversationLogRepository agentConversationRepository;
	
	//Insert The Data
	public AgentConversationLogDTO logRequest(AgentConversationLogDTO agentconLogDTO)
	{
		AgentConversationLog agentConveLog = new AgentConversationLog(agentconLogDTO.getConversationID(),
				                                                      agentconLogDTO.getChannelUserID(),
				                                                      agentconLogDTO.getChannelSessionID(),
				                                                      agentconLogDTO.getAgentID(),
				                                                      agentconLogDTO.getResponseTimeStamp(),
				                                                      agentconLogDTO.getAgentCoversationRequest(),
				                                                      agentconLogDTO.getConversationSentiment(),
				                                                      agentconLogDTO.getChannelID());
		
		agentConversationRepository.save(agentConveLog);
		agentconLogDTO.setAgentConversationMessageID(agentConveLog.getAgentConversationMessageID());
		return agentconLogDTO;
		
	}
	
	public AgentConversationLogDTO logResponse(AgentConversationLogDTO agentconLogDTO)
	{
		
		AgentConversationLog agentConveLog = agentConversationRepository.findOne(agentconLogDTO.getAgentConversationMessageID());
		
		System.out.println("the entity from DB==>"+agentConveLog.toString());
		
		if(agentconLogDTO.getAgentCoversationResponse().length() > 200){
			
			agentConveLog.setAgentCoversationResponse(agentconLogDTO.getAgentCoversationResponse().substring(0,199));

		}else{
			
			agentConveLog.setAgentCoversationResponse(agentconLogDTO.getAgentCoversationResponse());

		}
		
		if(agentconLogDTO.getResponseTimeStamp() == null){
	        Date date = new Date();
	        agentConveLog.setResponseTimeStamp(new Timestamp(date.getTime()));		
		}else{
			
			agentConveLog.setResponseTimeStamp(agentconLogDTO.getResponseTimeStamp());

		}
		
		agentConversationRepository.save(agentConveLog);
		agentconLogDTO.setAgentConversationMessageID(agentConveLog.getAgentConversationMessageID());
		return agentconLogDTO;
		
	}
	
	
}

package com.afpva.botframework.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afpva.botframework.logging.dao.ApplicationLogRepository;
import com.afpva.botframework.logging.dto.ApplicationLogDTO;
import com.afpva.botframework.logging.model.ApplciationLog;


@Service
public class ApplicationLogServices {

	@Autowired
	ApplicationLogRepository applicationLogRepository;
	
	
	public ApplicationLogDTO logException(ApplicationLogDTO appLogDTO)
	{
		ApplciationLog appLog = new ApplciationLog(appLogDTO.getComponentcode(), appLogDTO.getComponentmethod(), appLogDTO.getInput(), appLogDTO.getOutput(), appLogDTO.getLogmessage(), appLogDTO.getTimestamp());  
		applicationLogRepository.save(appLog);
		appLogDTO.setConversationmessageid(appLog.getConversationmessageid());
		return appLogDTO;
		
	}
}

package com.vsofts.botframework.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsofts.botframework.logging.dao.ApplicationExceptionLogRepository;
import com.vsofts.botframework.logging.dto.ApplicationExceptionLogDTO;
import com.vsofts.botframework.logging.model.ApplciationExceptionLog;


@Service
public class ApplicationExceptionLogServices {

	@Autowired
	ApplicationExceptionLogRepository applicationExceptionRepository;
	
	
	public ApplicationExceptionLogDTO logException(ApplicationExceptionLogDTO appExceptinoDTO)
	{
		ApplciationExceptionLog appExceptinoLog = new ApplciationExceptionLog(appExceptinoDTO.getExceptiontimestamp(), appExceptinoDTO.getConversationId(), appExceptinoDTO.getErrorCode(), appExceptinoDTO.getErrorMessage(), appExceptinoDTO.getSource());  
		applicationExceptionRepository.save(appExceptinoLog);
		appExceptinoDTO.setApplicationexceptionid(appExceptinoLog.getApplicationexceptionid());
		return appExceptinoDTO;
		
	}
}

package com.afpva.botframework.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.afpva.botframework.logging.dto.BotConversationLogDTO;
import com.afpva.botframework.logging.service.BotConversationServices;

/*import com.springjpa.dto.CustomerDTO;
import com.springjpa.service.CustomerService;*/


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BotConversationLogTest {

	@Autowired
	BotConversationServices botConversationService;
	
	@Test
	public void contextLoads() {
		int searchId= 12;
				
		
	 BotConversationLogDTO botConvLogDTO = botConversationService.findById(searchId);
	 assertEquals(searchId, botConvLogDTO.getBotConversationMessageId());
		
	
	}
	
	@Test
	public void testLogResponse()
	{
			int searchId= 12;
			String responseString = "TestResponse13";
			BotConversationLogDTO botConvLogDTO = botConversationService.findById(searchId);
			Date responseTimestampBefore = botConvLogDTO.getResponseTimestamp();
			botConvLogDTO.setBotConversationMessageId(searchId);
			botConvLogDTO.setConversationRes(responseString);
			botConversationService.logResponse(botConvLogDTO);
			
			assertEquals(responseString,botConvLogDTO.getConversationRes());
			assertFalse(responseTimestampBefore.equals(botConvLogDTO.getResponseTimestamp()));
	}
	
	@Test
	public void testLogRequest()
	{
		int previousSize = botConversationService.getAllLog().size();
		BotConversationLogDTO botConvLogDTO  = new BotConversationLogDTO();
				
		botConvLogDTO.setChannelId("slack01");
		botConvLogDTO.setConversationId("112");
		botConvLogDTO.setConversationReq("TestRequest_112");
		botConvLogDTO.setConversationRes("");
		botConvLogDTO.setIntentConfidence(1);
		botConvLogDTO.setIntentName("Greet");
		botConvLogDTO.setUserId("User00112");
		botConvLogDTO.setRequestSentiment("POSITIVE");
		
		BotConversationLogDTO instBotConveDTO = botConversationService.logRequest(botConvLogDTO);
		System.out.println("Test Record Updated");
		assertFalse(previousSize== botConversationService.getAllLog().size());
		 
		BotConversationLogDTO botConvLogDTOTest = botConversationService.findById(instBotConveDTO.getBotConversationMessageId());
		System.out.println("Test Is TimeStapm Updated");
		assertNotNull(botConvLogDTOTest.getRequestTimestamp());
		assertNotNull(botConvLogDTOTest.getRequestTimestamp());
		
	}
	

}

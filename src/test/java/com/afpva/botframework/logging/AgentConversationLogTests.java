package com.afpva.botframework.logging;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vsofts.botframework.logging.dao.AgentConversationLogRepository;
import com.vsofts.botframework.logging.model.AgentConversationLog;
import com.vsofts.botframework.logging.service.AgentConversationService;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class AgentConversationLogTests {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	AgentConversationLogRepository agentConversationLogRepository;

	@Autowired
	AgentConversationService agentConversationService;
	
			
	@Test
	public void contextLoads()  throws Exception{
	}
	
	@Test
	public void should_find_no_agentconversationlog_if_repository_is_empty() {
		Iterable<AgentConversationLog> applciationLogObj = agentConversationLogRepository.findAll();
		assertThat(applciationLogObj).isEmpty();
	}
	
	@Test
	public void should_store_a_agentconversationlog() {
		AgentConversationLog agentConversationLogObjs = agentConversationLogRepository.save(new AgentConversationLog("conversationID", "channelUserID", "channelSessionID", "agentID",
				null , "conversationSentiment", "conversationSentiment", "requestTimeStamp"));

		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("conversationID", "conversationID01");
		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("channelUserID", "channelUserID01");
		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("channelSessionID", "channelSessionID01");
		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("agentID", "agentID01");
		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("timestamp", null);	
		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("conversationSentiment", "conversationSentiment01");
		assertThat(agentConversationLogObjs).hasFieldOrPropertyWithValue("requestTimeStamp", "requestTimeStamp");			
	}
}

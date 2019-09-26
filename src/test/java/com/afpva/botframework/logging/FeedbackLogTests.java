package com.afpva.botframework.logging;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vsofts.botframework.logging.dao.FeedbackLogRepository;
import com.vsofts.botframework.logging.model.FeedbackLog;
import com.vsofts.botframework.logging.service.FeedbackLogService;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class FeedbackLogTests {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	FeedbackLogRepository feedbackLogRepository;

	@Autowired
	FeedbackLogService feedbackLogService;
	
			
	@Test
	public void contextLoads()  throws Exception{
	}
	
	@Test
	public void should_find_no_feedbacklog_if_repository_is_empty() {
		Iterable<FeedbackLog> applciationLogObj = feedbackLogRepository.findAll();
		assertThat(applciationLogObj).isEmpty();
	}
	
	@Test
	public void should_store_a_agentconversationlog() {
		FeedbackLog feedbackLogObj = feedbackLogRepository.save(new FeedbackLog("conversationID", "feedbackText", "feedbackSentiment", 
						0 , null));

		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("conversationID", "conversationID01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("feedbackText", "feedbackText01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("feedbackSentiment", "channelSessionID01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("agentID", "agentID01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("timestamp", null);	
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("conversationSentiment", "conversationSentiment01");
		assertThat(feedbackLogObj).hasFieldOrPropertyWithValue("requestTimeStamp", "requestTimeStamp");
		
			
	}
	
	

}

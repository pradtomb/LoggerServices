package com.afpva.botframework.logging;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.afpva.botframework.logging.dao.ApplicationExceptionLogRepository;
import com.afpva.botframework.logging.model.ApplciationExceptionLog;
import com.afpva.botframework.logging.service.ApplicationExceptionLogServices;




@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ApplicationExceptionLogTests {
	
	
	@Autowired
	ApplicationExceptionLogRepository  applicationExceptionLogRepository;

	@Autowired
	ApplicationExceptionLogServices applicationExceptionLogServices;
	
			
	@Test
	public void contextLoads()  throws Exception{
		
		
	}
	
	@Test
	public void should_find_no_applicationexceptionlog_if_repository_is_empty() {
		Iterable<ApplciationExceptionLog> applciationLogObj = applicationExceptionLogRepository.findAll();
		assertThat(applciationLogObj).isEmpty();
	}
	
	@Test
	public void should_store_a_applicationexceptionlog() {
		ApplciationExceptionLog applciationExceptionLogObjs = applicationExceptionLogRepository.save(new ApplciationExceptionLog(null , 1234567891, "errorCode01",
				 "errorMessage01", "source01"));

		assertThat(applciationExceptionLogObjs).hasFieldOrPropertyWithValue("componentcode", "compCode01");
		assertThat(applciationExceptionLogObjs).hasFieldOrPropertyWithValue("componentmethod", "compMethod01");
		assertThat(applciationExceptionLogObjs).hasFieldOrPropertyWithValue("input", "input01");
		assertThat(applciationExceptionLogObjs).hasFieldOrPropertyWithValue("output", "output01");
		assertThat(applciationExceptionLogObjs).hasFieldOrPropertyWithValue("logmessage", "logmessage");
		assertThat(applciationExceptionLogObjs).hasFieldOrPropertyWithValue("timestamp", null);		
	}
	
	

}

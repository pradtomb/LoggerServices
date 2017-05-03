package com.afpva.botframework.logging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afpva.botframework.logging.model.AgentConversationLog;

public interface AgentConversationLogRepository extends JpaRepository<AgentConversationLog, Long>{
	List<AgentConversationLog> conversationID(String conversationID);
}

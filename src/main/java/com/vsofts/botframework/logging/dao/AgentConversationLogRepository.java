package com.vsofts.botframework.logging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsofts.botframework.logging.model.AgentConversationLog;

public interface AgentConversationLogRepository extends JpaRepository<AgentConversationLog, Long>{
	List<AgentConversationLog> conversationID(String conversationID);
}

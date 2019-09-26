package com.vsofts.botframework.logging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsofts.botframework.logging.model.BotConversationLog;

public interface BotConversationLogRepository extends JpaRepository<BotConversationLog, Long>{
	List<BotConversationLog> conversationId(String conversationId);
}

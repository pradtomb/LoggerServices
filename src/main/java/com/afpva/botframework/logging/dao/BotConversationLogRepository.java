package com.afpva.botframework.logging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afpva.botframework.logging.model.BotConversationLog;

public interface BotConversationLogRepository extends JpaRepository<BotConversationLog, Long>{
	List<BotConversationLog> conversationId(String conversationId);
}

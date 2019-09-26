package com.vsofts.botframework.logging.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vsofts.botframework.logging.model.ApplciationLog;

public interface ApplicationLogRepository extends JpaRepository<ApplciationLog, Long>{
	List<ApplciationLog> conversationmessageid(String conversationmessageid);
}
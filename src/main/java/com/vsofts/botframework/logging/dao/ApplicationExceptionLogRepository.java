package com.vsofts.botframework.logging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsofts.botframework.logging.model.ApplciationExceptionLog;

public interface ApplicationExceptionLogRepository extends JpaRepository<ApplciationExceptionLog, Long>{
	List<ApplciationExceptionLog> applicationexceptionid(String applicationexceptionid);
}
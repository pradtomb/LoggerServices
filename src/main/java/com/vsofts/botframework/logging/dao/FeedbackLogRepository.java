package com.vsofts.botframework.logging.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vsofts.botframework.logging.model.FeedbackLog;

public interface FeedbackLogRepository extends JpaRepository<FeedbackLog, Long>{

}

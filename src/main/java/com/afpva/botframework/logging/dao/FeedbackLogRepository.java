package com.afpva.botframework.logging.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.afpva.botframework.logging.model.FeedbackLog;

public interface FeedbackLogRepository extends JpaRepository<FeedbackLog, Long>{

}

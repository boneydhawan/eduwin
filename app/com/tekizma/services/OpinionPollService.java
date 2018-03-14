package com.tekizma.services;

import com.tekizma.entity.UserOpinionPoll;
import com.tekizma.modals.OpinionPollBean;

/**
*
* @author boney dhawan
*/
public interface OpinionPollService {
    
	public OpinionPollBean getActiveOpinionPoll(String localeId);
	public UserOpinionPoll getUserOpinionSubmittedPollList(Long opinionPollId,String userId);
  
}

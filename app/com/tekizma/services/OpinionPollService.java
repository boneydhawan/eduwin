package com.tekizma.services;

import com.tekizma.entity.UserOpinionPoll;
import com.tekizma.modals.OpinionPollBean;

/**
*
* @author boney dhawan
*/
public interface OpinionPollService {
    
	public OpinionPollBean getActiveOpinionPoll(String localeId);
	public UserOpinionPoll getUserOpinionSubmittedPollList(String opinionPollKey,String userId);
	
	public UserOpinionPoll saveUserOpinionPoll(Long userId,String opinionPollKey,String votedOption,String opinionFeedback);
  
}

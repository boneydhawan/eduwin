package com.eduwin.services;

import com.eduwin.entity.UserOpinionPoll;
import com.eduwin.modals.OpinionPollBean;

/**
*
* @author boney dhawan
*/
public interface OpinionPollService {
    
	public OpinionPollBean getActiveOpinionPoll(String localeId);
	public UserOpinionPoll getUserOpinionSubmittedPollList(String opinionPollKey,String userId);
	
	public UserOpinionPoll saveUserOpinionPoll(Long userId,String opinionPollKey,String votedOption,String opinionFeedback);
  
}

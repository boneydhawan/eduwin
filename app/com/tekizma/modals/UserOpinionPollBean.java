package com.tekizma.modals;

import javax.persistence.Column;

public class UserOpinionPollBean {
	
	private long userId;
    private String votedOption;
    private String opinionFeedback;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getVotedOption() {
		return votedOption;
	}
	public void setVotedOption(String votedOption) {
		this.votedOption = votedOption;
	}
	public String getOpinionFeedback() {
		return opinionFeedback;
	}
	public void setOpinionFeedback(String opinionFeedback) {
		this.opinionFeedback = opinionFeedback;
	}
	

}

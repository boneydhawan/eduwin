package com.tekizma.modals;

import javax.persistence.Column;

public class UserOpinionPollBean {
	
	private long userId;
    private String opinionPollId;
    private String votedOption;
    private int opinionFeedback;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getOpinionPollId() {
		return opinionPollId;
	}
	public void setOpinionPollId(String opinionPollId) {
		this.opinionPollId = opinionPollId;
	}
	public String getVotedOption() {
		return votedOption;
	}
	public void setVotedOption(String votedOption) {
		this.votedOption = votedOption;
	}
	public int getOpinionFeedback() {
		return opinionFeedback;
	}
	public void setOpinionFeedback(int opinionFeedback) {
		this.opinionFeedback = opinionFeedback;
	}
	

}

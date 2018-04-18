package com.eduwin.modals;

public class OpinionPollBean {
	
	private Long id;
    private String opinionQuestion;
    private String opinionPollKey;
    private UserOpinionPollBean opinionPollBean;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpinionQuestion() {
		return opinionQuestion;
	}
	public void setOpinionQuestion(String opinionQuestion) {
		this.opinionQuestion = opinionQuestion;
	}
	public UserOpinionPollBean getOpinionPollBean() {
		return opinionPollBean;
	}
	public void setOpinionPollBean(UserOpinionPollBean opinionPollBean) {
		this.opinionPollBean = opinionPollBean;
	}
	public String getOpinionPollKey() {
		return opinionPollKey;
	}
	public void setOpinionPollKey(String opinionPollKey) {
		this.opinionPollKey = opinionPollKey;
	}
	
	


}

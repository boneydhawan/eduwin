package com.tekizma.modals;

public class OpinionPollBean {
	
	private Long id;
    private String opinionQuestion;
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
	


}

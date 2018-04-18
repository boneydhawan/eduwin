package com.eduwin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.eduwin.coreServices.Persistent;

@Entity
@Table(name = "User_Opinion_Poll")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "UserOpinionPoll.findAll", query = "SELECT b FROM UserOpinionPoll b"),
		@NamedQuery(name = "UserOpinionPoll.findById", query = "SELECT b FROM UserOpinionPoll b WHERE b.id = :id"),
		@NamedQuery(name = "UserOpinionPoll.findByUserIdAndPollKEY", query = "SELECT b FROM UserOpinionPoll b WHERE b.opinionPollKey = :opinionPollKey and b.userId = :userId")})
public class UserOpinionPoll extends Persistent{
	
	public String getOpinionPollKey() {
		return opinionPollKey;
	}

	public void setOpinionPollKey(String opinionPollKey) {
		this.opinionPollKey = opinionPollKey;
	}

	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="User_Opinion_Poll_seq", sequenceName="User_Opinion_Poll_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="User_Opinion_Poll_seq")
	private Long id;

	@Column(name = "User_Id")
    private long userId;
     
    @Column(name = "opinion_poll_key")
    private String opinionPollKey;
    
    @Column(name = "Voted_Option")
    private String votedOption;
    
    @Column(name = "Opinion_FeedBack")
    private String opinionFeedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

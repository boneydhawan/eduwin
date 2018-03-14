package com.tekizma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "User_Opinion_Poll")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "UserOpinionPoll.findAll", query = "SELECT b FROM UserOpinionPoll b"),
		@NamedQuery(name = "UserOpinionPoll.findById", query = "SELECT b FROM UserOpinionPoll b WHERE b.id = :id"),
		@NamedQuery(name = "UserOpinionPoll.findByUserIdAndPollId", query = "SELECT b FROM UserOpinionPoll b WHERE b.opinionPollId = :opinionPollId and b.userId = :userId")})
public class UserOpinionPoll {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="User_Opinion_Poll_seq", sequenceName="User_Opinion_Poll_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="User_Opinion_Poll_seq")
	private Long id;

	@Column(name = "User_Id")
    private long userId;
     
    @Column(name = "opinion_poll_id")
    private String opinionPollId;
    
    @Column(name = "Voted_Option")
    private String votedOption;
    
    @Column(name = "Opinion_FeedBack")
    private int opinionFeedback;

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
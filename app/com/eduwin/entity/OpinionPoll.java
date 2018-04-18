package com.eduwin.entity;

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
@Table(name = "opinion_poll_details")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "OpinionPoll.findAll", query = "SELECT b FROM OpinionPoll b"),
		@NamedQuery(name = "OpinionPoll.findById", query = "SELECT b FROM OpinionPoll b WHERE b.id = :id"),
		@NamedQuery(name = "OpinionPoll.findByLocaleId", query = "select o from OpinionPoll o where o.isActive=1 and o.locale.id=:localeId")})
public class OpinionPoll {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="opinion_poll_details_seq", sequenceName="opinion_poll_details_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="opinion_poll_details_seq")
	private Long id;

	@Column(name = "Opinion_Question")
    private String opinionQuestion;
	
	@Column(name = "opinion_poll_key")
    private String opinionPollKey;
    
    @Column(name = "Active_Flag")
    private long isActive;
    
    @JoinColumn(name="locale_id", referencedColumnName="id")
	@ManyToOne(optional=false)
    private Locale locale;

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

	public long getIsActive() {
		return isActive;
	}

	public void setIsActive(long isActive) {
		this.isActive = isActive;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getOpinionPollKey() {
		return opinionPollKey;
	}

	public void setOpinionPollKey(String opinionPollKey) {
		this.opinionPollKey = opinionPollKey;
	}
         
}

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

@Entity
@Table(name = "locale")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Locale.findAll", query = "SELECT b FROM Locale b"),
		@NamedQuery(name = "Locale.findById", query = "SELECT b FROM Locale b WHERE b.id = :id"),
		@NamedQuery(name = "Locale.findNameCode", query = "SELECT b FROM Locale b WHERE b.nameCode=:nameCode")})
public class Locale {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="locale_seq", sequenceName="locale_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="locale_seq")
	private Long id;

	@Column(name = "name_code")
    private String nameCode;
     
    @Column(name = "desc")
    private String desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    
    
            
}

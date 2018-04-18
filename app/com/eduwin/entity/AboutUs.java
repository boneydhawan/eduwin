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
@Table(name = "about_us")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "AboutUs.findAll", query = "SELECT b FROM AboutUs b"),
		@NamedQuery(name = "AboutUs.findById", query = "SELECT b FROM AboutUs b WHERE b.id = :id"),
		@NamedQuery(name = "AboutUs.findByLocaleId", query = "select a from AboutUs a where a.isActive='1' and  a.locale.id=:localeId")})
public class AboutUs {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="about_us_seq", sequenceName="about_us_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="about_us_seq")
	private Long id;

	@Column(name = "teacher_name")
    private String teacherName;
     
    @Column(name = "teacher_position")
    private String teacherPosition;
    
    @Column(name = "teacher_field")
    private String teacherField;
    
    @Column(name = "teacher_exp_in_years")
    private int teacherExpInYears;
    
    @Column(name = "teacher_desc")
    private String teacherDesc;
    
    @Column(name = "is_active")
    private long isActive;
    
    @Column(name = "quote")
    private String quote;
    
    public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@JoinColumn(name="locale_id", referencedColumnName="id")
	@ManyToOne(optional=false)
    private Locale locale;
    

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPosition() {
		return teacherPosition;
	}

	public void setTeacherPosition(String teacherPosition) {
		this.teacherPosition = teacherPosition;
	}


	public String getTeacherField() {
		return teacherField;
	}

	public void setTeacherField(String teacherField) {
		this.teacherField = teacherField;
	}

	public int getTeacherExpInYears() {
		return teacherExpInYears;
	}

	public void setTeacherExpInYears(int teacherExpInYears) {
		this.teacherExpInYears = teacherExpInYears;
	}

	public String getTeacherDesc() {
		return teacherDesc;
	}

	public void setTeacherDesc(String teacherDesc) {
		this.teacherDesc = teacherDesc;
	}

	public long getIsActive() {
		return isActive;
	}

	public void setIsActive(long isActive) {
		this.isActive = isActive;
	}
   
            
}

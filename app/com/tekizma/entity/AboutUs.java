package com.tekizma.entity;

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
@Table(name = "about_us")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "AboutUs.findAll", query = "SELECT b FROM AboutUs b"),
		@NamedQuery(name = "AboutUs.findById", query = "SELECT b FROM AboutUs b WHERE b.id = :id"),
		@NamedQuery(name = "AboutUs.findActiveAboutUs", query = "SELECT b FROM AboutUs b WHERE b.isActive='1'")})
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
    private Long teacherField;
    
    @Column(name = "teacher_exp_in_years")
    private int teacherExpInYears;
    
    @Column(name = "teacher_desc")
    private String teacherDesc;
    
    @Column(name = "is_active")
    private Long isActive;

	public Long getId() {
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

	public Long getTeacherField() {
		return teacherField;
	}

	public void setTeacherField(Long teacherField) {
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

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}
   
            
}

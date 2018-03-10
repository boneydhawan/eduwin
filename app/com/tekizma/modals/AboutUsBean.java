package com.tekizma.modals;

import javax.persistence.Column;

public class AboutUsBean {
	private Long id;
    private String teacherName;
    private String teacherPosition;
    private Long teacherField;
    private int teacherExpInYears;
    private String teacherDesc;
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

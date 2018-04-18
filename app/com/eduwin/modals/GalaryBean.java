package com.eduwin.modals;

import java.util.Date;

public class GalaryBean {
	
	private Long id;
    private String galaryType;
    private String galaryTitle;
    private String galaryDetailDesc;
    private String shortPath;
    private String longPath;
    private Date updatedDate;
    private String pdfPath;
    
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGalaryType() {
		return galaryType;
	}
	public void setGalaryType(String galaryType) {
		this.galaryType = galaryType;
	}
	public String getGalaryTitle() {
		return galaryTitle;
	}
	public void setGalaryTitle(String galaryTitle) {
		this.galaryTitle = galaryTitle;
	}
	public String getGalaryDetailDesc() {
		return galaryDetailDesc;
	}
	public void setGalaryDetailDesc(String galaryDetailDesc) {
		this.galaryDetailDesc = galaryDetailDesc;
	}
	public String getShortPath() {
		return shortPath;
	}
	public void setShortPath(String shortPath) {
		this.shortPath = shortPath;
	}
	public String getLongPath() {
		return longPath;
	}
	public void setLongPath(String longPath) {
		this.longPath = longPath;
	}
	public String getPdfPath() {
		return pdfPath;
	}
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
	
    
    

	
}

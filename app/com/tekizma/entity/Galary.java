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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "client_gallery_detail")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Galary.findAll", query = "SELECT g FROM Galary g"),
		@NamedQuery(name = "Galary.findById", query = "SELECT g FROM Galary g WHERE g.id = :id"),
		@NamedQuery(name = "Galary.findByTypeAndLocale", query = "SELECT g FROM Galary g WHERE g.galaryType=:galaryType and g.locale.id=:localeId and isActive='1'")})
public class Galary {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="galary_seq", sequenceName="galary_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="galary_seq")
	private Long id;

	@Column(name = "Gallery_Type")
    private String galaryType;
     
    @Column(name = "Gallery_Title")
    private String galaryTitle;
    
    @Column(name = "Gallery_Detail_Desc")
    private String galaryDetailDesc;
    
    @Column(name = "Gallery_Image_Path", length=65535, columnDefinition="TEXT")
    @Type(type="text")
    private String galaryImagePath;
    
    @Column(name = "Gallery_Video_Path", columnDefinition="TEXT")
    @Type(type="text")
    private String galaryVideoPath;
    
    @Column(name = "Gallery_Audio_Path", columnDefinition="TEXT")
    @Type(type="text")
    private String galaryAudioPath;
    
    @Column(name = "Active_Flag")
    private int isActive;
    
    @JoinColumn(name="locale_id", referencedColumnName="id")
	@ManyToOne(optional=false)
    private Locale locale;

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

	public String getGalaryImagePath() {
		return galaryImagePath;
	}

	public void setGalaryImagePath(String galaryImagePath) {
		this.galaryImagePath = galaryImagePath;
	}

	public String getGalaryVideoPath() {
		return galaryVideoPath;
	}

	public void setGalaryVideoPath(String galaryVideoPath) {
		this.galaryVideoPath = galaryVideoPath;
	}

	public String getGalaryAudioPath() {
		return galaryAudioPath;
	}

	public void setGalaryAudioPath(String galaryAudioPath) {
		this.galaryAudioPath = galaryAudioPath;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
    
    
    
    

            
}

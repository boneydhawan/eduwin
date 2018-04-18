package com.eduwin.services;

import java.util.List;

import com.eduwin.modals.GalaryBean;

/**
*
* @author boney dhawan
*/
public interface GalaryService {
    
	public List<GalaryBean> getGalaryListBasedOnLocaleAndType(String localeId,String galaryType);
  
}

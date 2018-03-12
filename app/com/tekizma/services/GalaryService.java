package com.tekizma.services;

import java.util.List;

import com.tekizma.modals.GalaryBean;

/**
*
* @author boney dhawan
*/
public interface GalaryService {
    
	public List<GalaryBean> getGalaryListBasedOnLocaleAndType(String localeId,String galaryType);
  
}

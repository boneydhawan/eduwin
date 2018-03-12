package com.tekizma.services;

import java.util.List;

import com.tekizma.entity.Locale;
import com.tekizma.modals.AboutUsBean;

/**
*
* @author boney dhawan
*/
public interface AboutUsService {
    
	public AboutUsBean getAboutUsInfo(String localeCode);
	public List<Locale> getLocaleList();
	public Locale getLocaleBasedOnNameCode(String localeId);
  
}

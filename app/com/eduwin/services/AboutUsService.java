package com.eduwin.services;

import java.util.List;

import com.eduwin.entity.Locale;
import com.eduwin.modals.AboutUsBean;

/**
*
* @author boney dhawan
*/
public interface AboutUsService {
    
	public AboutUsBean getAboutUsInfo(String localeCode);
	public List<Locale> getLocaleList();
	public Locale getLocaleBasedOnNameCode(String localeId);
	public String getQuoteBasedonLocaleId(String localeId);
  
}

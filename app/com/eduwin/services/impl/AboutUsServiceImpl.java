package com.eduwin.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;

import com.tekizma.coreServices.CommonDao;
import com.tekizma.coreUtils.CommonUtils;
import com.tekizma.entity.AboutUs;
import com.tekizma.entity.Locale;
import com.tekizma.entity.Users;
import com.tekizma.modals.AboutUsBean;
import com.tekizma.modals.UserBean;
import com.tekizma.services.AboutUsService;
import com.tekizma.services.LoginService;
import play.db.jpa.Transactional;
import play.Logger;

import play.db.jpa.JPAApi;
/**
*
* @author boney dhawan
*/


public class AboutUsServiceImpl implements AboutUsService{
	
    private CommonDao commonDao;
    

    @Inject
    public AboutUsServiceImpl(JPAApi jpaApi, CommonDao commonDao){
        this.commonDao = commonDao;
    }


	@Override
	public AboutUsBean getAboutUsInfo(String localeId) {
		
		//String query="select a from AboutUs a, Locale l where a.isActive='1' and l.nameCode="+localeCode;

		Map<String, Object> params = new HashMap<String,Object>();
		params.put("localeId", Long.parseLong(localeId));

		AboutUs aboutUsDetail = (AboutUs) commonDao.findObjectByNamedQuery("AboutUs.findByLocaleId",params);
		
		AboutUsBean aboutUsBean = new AboutUsBean();
		if(aboutUsDetail != null){
			Logger.debug("About Us Detail not null");
			BeanUtils.copyProperties(aboutUsDetail, aboutUsBean);
		}else
			Logger.debug("About Us Detail empty");
			

		return aboutUsBean;

	}
	
	@Override
	public List<Locale> getLocaleList(){
		List<Locale> localeList = commonDao.findByNamedQuery("Locale.findAll");
		return localeList;
	}
	
	@Override
	public Locale getLocaleBasedOnNameCode(String localeNameCode){
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("nameCode", localeNameCode);
		Locale locale = (Locale) commonDao.findObjectByNamedQuery("Locale.findNameCode",params);
		return locale;
	}
	  
    

}

package com.eduwin.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;

import com.tekizma.coreServices.CommonDao;
import com.tekizma.coreUtils.CommonUtils;
import com.tekizma.entity.AboutUs;
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
	public AboutUsBean getAboutUsInfo() {
		//GET LOCALE ID
		List<AboutUs> aboutUsDetail = commonDao.findByNamedQuery("AboutUs.findActiveAboutUs");
		AboutUsBean aboutUsBean = new AboutUsBean();
		if(!aboutUsDetail.isEmpty())
			BeanUtils.copyProperties(aboutUsDetail.get(0), aboutUsBean);

		return aboutUsBean;

	}
   
    

}

package com.eduwin.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;

import com.tekizma.coreServices.CommonDao;
import com.tekizma.coreUtils.CommonUtils;
import com.tekizma.entity.AboutUs;
import com.tekizma.entity.Galary;
import com.tekizma.entity.Locale;
import com.tekizma.entity.Users;
import com.tekizma.modals.AboutUsBean;
import com.tekizma.modals.GalaryBean;
import com.tekizma.modals.UserBean;
import com.tekizma.services.AboutUsService;
import com.tekizma.services.GalaryService;
import com.tekizma.services.LoginService;
import play.db.jpa.Transactional;
import play.Logger;

import play.db.jpa.JPAApi;
/**
*
* @author boney dhawan
*/


public class GalaryServiceImpl implements GalaryService{
	
    private CommonDao commonDao;
    

    @Inject
    public GalaryServiceImpl(JPAApi jpaApi, CommonDao commonDao){
        this.commonDao = commonDao;
    }


	@Override
	public List<GalaryBean> getGalaryListBasedOnLocaleAndType(String localeId,String galaryType){
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("localeId", Long.parseLong(localeId));
		params.put("galaryType", galaryType);
		
		List<Galary>  galaryDetail= (List<Galary>) commonDao.findByNamedQuery("Galary.findByTypeAndLocale",params);
		List<GalaryBean> galaryBeanList = new ArrayList<GalaryBean>();
		if(!galaryDetail.isEmpty()){
			for (int i=0;i<galaryDetail.size();i++){
				GalaryBean galaryBean = new GalaryBean();
				galaryBean.setId(galaryDetail.get(i).getId());
				galaryBean.setGalaryType(galaryDetail.get(i).getGalaryType());
				galaryBean.setGalaryTitle(galaryDetail.get(i).getGalaryTitle());
				galaryBean.setGalaryDetailDesc(galaryDetail.get(i).getGalaryDetailDesc());
				if(galaryDetail.get(i).getGalaryType().equals("IMAGE")){
					galaryBean.setLongPath(galaryDetail.get(i).getGalaryImagePath());
				}else if(galaryDetail.get(i).getGalaryType().equals("VIDEO")){
					galaryBean.setLongPath(galaryDetail.get(i).getGalaryVideoPath());
				}else if(galaryDetail.get(i).getGalaryType().equals("AUDIO")){
					galaryBean.setLongPath(galaryDetail.get(i).getGalaryAudioPath());
				}
				galaryBeanList.add(galaryBean);
				
	        }
		}
		return galaryBeanList;

	}
	    

}

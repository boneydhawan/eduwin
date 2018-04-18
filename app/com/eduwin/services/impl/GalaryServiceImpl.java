package com.eduwin.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.eduwin.coreServices.CommonDao;
import com.eduwin.entity.Galary;
import com.eduwin.modals.GalaryBean;
import com.eduwin.services.GalaryService;

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
				if(galaryDetail.get(i).getGalaryType().equals("IMAGE") || galaryDetail.get(i).getGalaryType().equals("WORKSPACE")){
					galaryBean.setLongPath(galaryDetail.get(i).getGalaryImagePath());
					galaryBean.setPdfPath(galaryDetail.get(i).getPdfPath());
				}else if(galaryDetail.get(i).getGalaryType().equals("VIDEO")){
					galaryBean.setLongPath(galaryDetail.get(i).getGalaryVideoPath());
					if(galaryDetail.get(i).getGalaryVideoPath().contains("youtube.com")){
						String videoId=StringUtils.substringAfter(galaryDetail.get(i).getGalaryVideoPath(), "watch?v=");
						galaryBean.setShortPath(videoId);
					}else{
						galaryBean.setShortPath(galaryBean.getLongPath());
					}
				}else if(galaryDetail.get(i).getGalaryType().equals("AUDIO")){
					galaryBean.setLongPath(galaryDetail.get(i).getGalaryAudioPath());
				}
				galaryBean.setUpdatedDate(galaryDetail.get(i).getUpdatedDate());
				galaryBeanList.add(galaryBean);
	        }
		}
		return galaryBeanList;

	}
	    

}

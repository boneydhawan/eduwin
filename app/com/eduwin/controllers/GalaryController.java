package com.eduwin.controllers;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.eduwin.entity.Locale;
import com.eduwin.modals.GalaryBean;
import com.eduwin.services.AboutUsService;
import com.eduwin.services.GalaryService;

import play.db.jpa.Transactional;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.*;
import static play.libs.Json.toJson;

import java.util.List;


/**
*
* @author boney dhawan
*/
public class GalaryController extends Controller {


	private final FormFactory formFactory;
    private final JPAApi jpaApi;
    private final GalaryService galaryService;
    private final AboutUsService aboutUsService;


    
    @Inject
    public GalaryController(FormFactory formFactory, JPAApi jpaApi,GalaryService galaryService,AboutUsService aboutUsService) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
        this.galaryService = galaryService;
        this.aboutUsService = aboutUsService;
    }
    
    @Transactional
    public Result getGalryList() {
        Logger.debug("------Start : Inside getGalryList");
        try{
        	String localeId = request().getQueryString("localeId");
        	if(StringUtils.isEmpty(localeId)){
        		Locale locale = aboutUsService.getLocaleBasedOnNameCode("en");
        		localeId = String.valueOf(locale.getId());
        	}
        	String galaryType = request().getQueryString("galaryType");
        	if(StringUtils.isEmpty(galaryType))
        		galaryType="IMAGE";
        	List<GalaryBean> galaryList = galaryService.getGalaryListBasedOnLocaleAndType(localeId,galaryType);
    		return  ok(toJson(galaryList));
        }
        catch(Exception e){
        	e.printStackTrace();
        	return status(500,"Error while fetching galaryList");
        }
 
    }
    
   
}


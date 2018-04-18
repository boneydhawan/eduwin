package com.tekizma.controllers;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import com.tekizma.entity.Locale;
import com.tekizma.modals.AboutUsBean;
import com.tekizma.services.AboutUsService;
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
public class AboutUsController extends Controller {


	private final FormFactory formFactory;
    private final JPAApi jpaApi;
    private final AboutUsService aboutUsService;
   

    
    @Inject
    public AboutUsController(FormFactory formFactory, JPAApi jpaApi,AboutUsService aboutUsService) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
        this.aboutUsService = aboutUsService;
    }
    
    @Transactional
    public Result getAboutUsInfo() {
        Logger.debug("------Start : Inside getAboutUsInfo");
        try{
        	String localeId = request().getQueryString("localeId");
        	if(StringUtils.isEmpty(localeId)){
        		Locale locale = aboutUsService.getLocaleBasedOnNameCode("en");
        		localeId = String.valueOf(locale.getId());
        	}
        	Logger.debug("Locale Id "+localeId);
        	AboutUsBean aboutUsDetails=aboutUsService.getAboutUsInfo(localeId);
    		return  ok(toJson(aboutUsDetails));
        }
        catch(Exception e){
        	e.printStackTrace();
        	return status(500,"Error while fetching AboutUsDetails");
        }
 
    }
    
    @Transactional
    public Result getLocaleList() {
    	Logger.debug("------Start : Inside getlocaleList");
    	List<Locale> localeList = aboutUsService.getLocaleList();
    	return  ok(toJson(localeList));
    }
    
    @Transactional
    public Result getQuote() {
    	Logger.debug("------Start : Inside getQuote");
    	String quote = null;
    	try{
    		String localeId = request().getQueryString("localeId");
    		if(StringUtils.isEmpty(localeId)){
        		Locale locale = aboutUsService.getLocaleBasedOnNameCode("en");
        		localeId = String.valueOf(locale.getId());
        	}
        	Logger.debug("Locale Id "+localeId);
        	quote = aboutUsService.getQuoteBasedonLocaleId(localeId);
    	}catch(Exception e){
        	e.printStackTrace();
        	return status(500,"Error while fetching quote");
        }
    	return  ok(toJson(quote));
    }
    	
    
    
}


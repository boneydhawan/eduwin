package com.tekizma.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.tekizma.entity.Locale;
import com.tekizma.entity.UserOpinionPoll;
import com.tekizma.entity.Users;
import com.tekizma.modals.AboutUsBean;
import com.tekizma.modals.OpinionPollBean;
import com.tekizma.modals.UserBean;
import com.tekizma.modals.UserOpinionPollBean;
import com.tekizma.services.AboutUsService;
import com.tekizma.services.LoginService;
import com.tekizma.services.OpinionPollService;

import play.db.jpa.Transactional;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.*;
import views.html.*;
import static play.libs.Json.toJson;


/**
*
* @author boney dhawan
*/
public class OpinionPollController extends Controller {


	private final FormFactory formFactory;
    private final JPAApi jpaApi;
    private final OpinionPollService opinionPollService;
    private final AboutUsService aboutUsService;

    
    @Inject
    public OpinionPollController(FormFactory formFactory, JPAApi jpaApi,OpinionPollService opinionPollService,AboutUsService aboutUsService) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
        this.opinionPollService = opinionPollService;
        this.aboutUsService = aboutUsService;
    }
    
    @Transactional
    public Result getOpinionPollDetail() {
    	Logger.debug("Inside getOpinionPollDetail");
    	try{
        	String localeId = request().getQueryString("localeId");
        	String userId = request().getQueryString("userId");
        	if(StringUtils.isEmpty(localeId)){
        		Locale locale = aboutUsService.getLocaleBasedOnNameCode("en");
        		localeId = String.valueOf(locale.getId());
        	}
        	OpinionPollBean opinionPollBean=opinionPollService.getActiveOpinionPoll(localeId);
        	if(opinionPollBean.getId() != null && !StringUtils.isEmpty(userId)){
        		UserOpinionPoll userOpinionSubmittedPollList = opinionPollService.getUserOpinionSubmittedPollList(opinionPollBean.getOpinionPollKey(),userId);
        		if(userOpinionSubmittedPollList != null){
        			UserOpinionPollBean userOpinionPollBean = new UserOpinionPollBean();
        			BeanUtils.copyProperties(userOpinionSubmittedPollList, userOpinionPollBean);
        			opinionPollBean.setOpinionPollBean(userOpinionPollBean);
        		}        			
        	}
    		return  ok(toJson(opinionPollBean));
        }
        catch(Exception e){
        	e.printStackTrace();
        	return status(500,"Error while fetching Opinion Detail");
        }
 
    }
    
    
}


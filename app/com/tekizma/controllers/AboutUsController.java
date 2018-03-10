package com.tekizma.controllers;

import javax.inject.Inject;

import com.tekizma.modals.AboutUsBean;
import com.tekizma.modals.UserBean;
import com.tekizma.services.AboutUsService;
import com.tekizma.services.LoginService;

import play.db.jpa.Transactional;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.*;
import static play.libs.Json.toJson;


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
        	AboutUsBean aboutUsDetails=aboutUsService.getAboutUsInfo();
    		return  ok(toJson(aboutUsDetails));
        }
        catch(Exception e){
        	e.printStackTrace();
        	return status(500,"Error while fetching AboutUsDetails");
        }
 
    }
    
    
}


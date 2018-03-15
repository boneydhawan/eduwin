package com.tekizma.controllers;

import javax.inject.Inject;

import com.tekizma.modals.UserBean;
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
public class LoginController extends Controller {


	private final FormFactory formFactory;
    private final JPAApi jpaApi;
    private final LoginService loginService;
   

    
    @Inject
    public LoginController(FormFactory formFactory, JPAApi jpaApi,LoginService loginService) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
        this.loginService = loginService;
    }
    
    @Transactional
    public Result addUser() {
        Logger.debug("------Start : Inside addUser");
        try{
        	String name = request().getQueryString("name");
            String place = request().getQueryString("place");
            Long contactNumber = Long.parseLong((request().getQueryString("contactNumber")));
        	UserBean userBean=loginService.addUserDetails(name,place,contactNumber);
    		return  ok(toJson(userBean));
        }
        catch(Exception e){
        	e.printStackTrace();
        	return status(500,"Error while adding user");
        }
 
    }
    
    
}


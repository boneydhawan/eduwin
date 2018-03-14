package com.eduwin.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;

import com.tekizma.coreServices.CommonDao;
import com.tekizma.coreUtils.CommonUtils;
import com.tekizma.entity.Users;
import com.tekizma.modals.UserBean;
import com.tekizma.services.LoginService;
import play.db.jpa.Transactional;
import play.Logger;

import play.db.jpa.JPAApi;
/**
*
* @author boney dhawan
*/


public class LoginServiceImpl implements LoginService{
	
    private CommonDao commonDao;
    

    @Inject
    public LoginServiceImpl(JPAApi jpaApi, CommonDao commonDao){
        this.commonDao = commonDao;
    }
   
    @Override
	public UserBean addUserDetails(String userName,String place,Long contactNumber){
    	if(!(CommonUtils.isEmpty(userName) || CommonUtils.isEmpty(place) || contactNumber == null)){
    		Map<String, Object> params = new HashMap<String,Object>();
    		params.put("phoneNumber", contactNumber);
    		UserBean userBean = new UserBean();
    		Users user = (Users) commonDao.findObjectByNamedQuery("Users.findByPhoneNumber", params);
    		if(user == null){
    			Users addUser = new Users();
    			addUser.setName(userName);
    			addUser.setPhoneNumber(contactNumber);
    			addUser.setPlace(place);
    			Users addedData= (Users) commonDao.create(addUser);
    			BeanUtils.copyProperties(addedData, userBean);
    			userBean.setOldUser(false);
    			Logger.info("create new user successfully with phoneNumber"+contactNumber);
    			return userBean;		
    		}else{
    			Logger.info("User already exist with phoneNumber"+contactNumber);
    			user.setName(userName);
    			user.setPlace(place);
    			Users updatedData= (Users) commonDao.update(user);
    			BeanUtils.copyProperties(updatedData, userBean);
        		userBean.setOldUser(true);
    		}
    		return userBean;
    	}
    	Logger.info("Invalid Params received during signup");
    	return null;
	}

}

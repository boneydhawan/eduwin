package com.tekizma.services;

import java.util.HashMap;
import java.util.List;

import com.tekizma.entity.Users;
import com.tekizma.modals.UserBean;

/**
*
* @author boney dhawan
*/
public interface LoginService {
    
	public UserBean addUserDetails(String userName,String place,Long contactNumber);
  
}

package com.eduwin.services;

import com.eduwin.modals.UserBean;

/**
*
* @author boney dhawan
*/
public interface LoginService {
    
	public UserBean addUserDetails(String userName,String place,Long contactNumber);
  
}

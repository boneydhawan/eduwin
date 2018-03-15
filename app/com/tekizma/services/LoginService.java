package com.tekizma.services;

import com.tekizma.modals.UserBean;

/**
*
* @author boney dhawan
*/
public interface LoginService {
    
	public UserBean addUserDetails(String userName,String place,Long contactNumber);
  
}

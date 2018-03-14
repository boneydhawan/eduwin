package com.eduwin.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;

import com.tekizma.coreServices.CommonDao;
import com.tekizma.entity.AboutUs;
import com.tekizma.entity.OpinionPoll;
import com.tekizma.entity.UserOpinionPoll;
import com.tekizma.modals.AboutUsBean;
import com.tekizma.modals.OpinionPollBean;

import com.tekizma.services.OpinionPollService;

import play.db.jpa.Transactional;
import play.Logger;

import play.db.jpa.JPAApi;
/**
*
* @author boney dhawan
*/


public class OpinionPollServiceImpl implements OpinionPollService{
	
    private CommonDao commonDao;
    

    @Inject
    public OpinionPollServiceImpl(JPAApi jpaApi, CommonDao commonDao){
        this.commonDao = commonDao;
    }


	@Override
	public OpinionPollBean getActiveOpinionPoll(String localeId) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("localeId", Long.parseLong(localeId));

		List<OpinionPoll> opinionPoll = (List<OpinionPoll>) commonDao.findByNamedQuery("OpinionPoll.findByLocaleId",params);
		
		OpinionPollBean opinionPollBean = new OpinionPollBean();
		if(!opinionPoll.isEmpty()){
			opinionPollBean.setId(opinionPoll.get(0).getId());
			opinionPollBean.setOpinionQuestion(opinionPoll.get(0).getOpinionQuestion());
			opinionPollBean.setOpinionPollKey(opinionPoll.get(0).getOpinionPollKey());
		}
		
		return opinionPollBean;
	}


	@Override
	public UserOpinionPoll getUserOpinionSubmittedPollList(String opinionPollKey, String userId) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("opinionPollKey", opinionPollKey);
		params.put("userId", Long.parseLong(userId));

		List<UserOpinionPoll> opinionPoll = (List<UserOpinionPoll>) commonDao.findByNamedQuery("UserOpinionPoll.findByUserIdAndPollKEY",params);
		if(!opinionPoll.isEmpty()){
			return opinionPoll.get(0);
		}
		return null;
	}


	
}

package com.sven.dream.commonservice.service;

import com.sven.dream.common.query.UserQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.user.UserDo; 

public interface UserOperationService extends DreamBo<UserDo>{
	
	/**
	 * 根据登录名获取用户信息
	 * 
	 * @param loginName
	 * @return
	 */
	public UserDo getLoginDreamUser(String loginName);
	
	/**
	 * 判断当前的用户信息是否可以登录
	 * 
	 * @param query
	 * @return
	 */
	public ResultBaseDo<UserDo> checkLoginSuccessful(UserQuery query);
}

package com.sven.dream.commonservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import com.sven.dream.common.query.UserQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.service.UserOperationService; 
import com.sven.dream.dal.user.UserDo; 
import com.sven.dream.dal.user.mapper.UserDoMapperExt;

public class UserOperationServiceImpl extends
			AbstractDreamServiceImpl<UserDo, UserDoMapperExt> implements UserOperationService{

	@Autowired
    public void setBaseMapper(UserDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public UserDo getLoginDreamUser(String loginName) {
		return null;
		//return mapper.getLoginDreamUser(loginName);
	}

	@Override
	public ResultBaseDo<UserDo> checkLoginSuccessful(UserQuery query) { 
		ResultBaseDo<UserDo> result = new ResultBaseDo<UserDo>();
		result.setSuccess(false);
		
		List<UserDo> userList = new ArrayList<UserDo>();
		//List<UserDo> userList =  mapper.getUserListByQuery(query);
		
		if(userList == null || userList.size() == 0){
			result.setSuccess(false);
			result.setErrorMessages("请输入正确的用户名密码");
			return result;
		}
		
		// 这是一种很奇葩的场景,根据用户名密码搜出了多个用户
		if(userList.size() > 1){
			result.setSuccess(false);
			result.setErrorMessages("系统异常，请稍后再试");
			return result;
		}
		
		result.setSuccess(true);
		result.setModule(userList.get(0));
		return result;
	}
}

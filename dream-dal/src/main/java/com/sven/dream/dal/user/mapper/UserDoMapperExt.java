package com.sven.dream.dal.user.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.common.query.UserQuery;
import com.sven.dream.dal.user.UserDo;
 
@Resource
public interface UserDoMapperExt extends UserDoMapper{
	
	/**
	 * 根据登录名获得用户对象
	 * 
	 * @param email
	 * @return
	 */
	public UserDo getUserByLoginName(String loginName);
	
	/**
	 * 动态查询用户列表
	 * 
	 * @param query
	 * @return
	 */
	public List<UserDo> getUserListByQuery(UserQuery query);
}
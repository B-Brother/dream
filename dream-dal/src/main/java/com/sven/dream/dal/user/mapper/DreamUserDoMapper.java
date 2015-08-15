package com.sven.dream.dal.user.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.base.entity.DreamMapper;
import com.sven.dream.common.query.UserQuery;
import com.sven.dream.dal.user.DreamUserDo;

@Resource
public interface DreamUserDoMapper extends DreamMapper<DreamUserDo>{
	
	/**
	 * 根据登录名获取用户信息
	 * 
	 * @param loginName
	 * @return
	 */
	public DreamUserDo getLoginDreamUser(String loginName);
	
	/**
	 * 根据查询组装对象获取用户列表，目前只在登录场景使用。
	 * 
	 * @param query
	 * @return
	 */
	public List<DreamUserDo> getUserListByQuery(UserQuery query);
}
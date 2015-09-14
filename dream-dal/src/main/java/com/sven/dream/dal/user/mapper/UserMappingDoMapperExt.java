package com.sven.dream.dal.user.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.user.UserMappingDo;
 
@Resource
public interface UserMappingDoMapperExt extends UserMappingDoMapper{
    
	/**
	 * 获得用户的关注列表
	 * 
	 * @return
	 */
	public List<UserMappingDo> getUserMappingList(Long followerId);
}
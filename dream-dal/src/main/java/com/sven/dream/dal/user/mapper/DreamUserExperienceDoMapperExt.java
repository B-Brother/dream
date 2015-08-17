package com.sven.dream.dal.user.mapper;
		 
import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.user.DreamUserExperienceDo;

@Resource
public interface DreamUserExperienceDoMapperExt extends DreamUserExperienceDoMapper{
	
	/**
	 * 根据用户ID获取用户的经验列表
	 * 
	 * @param userId
	 */
	public List<DreamUserExperienceDo> getExperienceListByUser(long userId);
}
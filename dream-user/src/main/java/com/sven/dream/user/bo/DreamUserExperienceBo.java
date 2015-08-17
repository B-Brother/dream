package com.sven.dream.user.bo;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.user.DreamUserExperienceDo;

public interface DreamUserExperienceBo extends DreamBo<DreamUserExperienceDo>{
	
	/**
	 * 根据用户ID获取用户的经验列表
	 * 
	 * @param userId
	 */
	public List<DreamUserExperienceDo> getExperienceListByUser(long userId);
}

package com.sven.dream.user.bo;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.user.UserMappingDo;
import com.sven.dream.user.vo.UserMappingVo;

public interface UserMappingBo extends DreamBo<UserMappingDo>{
	
	/**
	 * 获得关注的人的列表
	 * 
	 * @return
	 */
	public List<UserMappingVo> getUserMappingVoList(Long followerId);
}

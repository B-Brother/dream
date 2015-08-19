package com.sven.dream.dal.order.mapper;

import java.util.List;

import javax.annotation.Resource;
 
import com.sven.dream.dal.order.DreamRateDo;
 
@Resource
public interface DreamRateDoMapperExt extends DreamRateDoMapper{
	
	/**
	 * 根据技能id获取评价列表
	 * 
	 * @param skillId
	 * @return
	 */
	public List<DreamRateDo> getRateBySkillId(long skillId);
}
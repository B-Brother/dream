package com.sven.dream.dal.order.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.order.DreamSkillSkuDo; 

@Resource
public interface DreamSkillSkuDoMapperExt extends DreamSkillSkuDoMapper{
   
	/**
	 * 根据技能id获取到其下的SKU列表
	 * 
	 * @param skillId
	 * @return
	 */
	public List<DreamSkillSkuDo> getSkuBySkillId(long skillId);
}
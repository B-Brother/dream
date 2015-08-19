package com.sven.dream.order.bo;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.order.DreamSkillSkuDo;

public interface DreamSkillSkuBo extends DreamBo<DreamSkillSkuDo>{
	
	/**
	 * 根据技能id获取到其下的SKU列表
	 * 
	 * @param skillId
	 * @return
	 */
	public List<DreamSkillSkuDo> getSkuBySkillId(long skillId);
}

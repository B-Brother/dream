package com.sven.dream.order.bo;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.order.DreamRateDo;

public interface DreamRateBo extends DreamBo<DreamRateDo>{

	/**
	 * 根据技能信息获取评价数据列表。
	 * 
	 * @param skillId
	 * @return
	 */
	public List<DreamRateDo> getRateBySkillId(long skillId);
}

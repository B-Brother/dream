package com.sven.dream.order.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.order.DreamSkillSkuDo;
import com.sven.dream.dal.order.mapper.DreamSkillSkuDoMapperExt;
import com.sven.dream.order.bo.DreamSkillSkuBo;

public class DreamSkillSkuBoImpl 
	extends AbstractDreamServiceImpl<DreamSkillSkuDo, DreamSkillSkuDoMapperExt>
	implements DreamSkillSkuBo{

	@Autowired
    public void setBaseMapper(DreamSkillSkuDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<DreamSkillSkuDo> getSkuBySkillId(long skillId) {
		return mapper.getSkuBySkillId(skillId);
	} 
}

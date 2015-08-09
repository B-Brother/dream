package com.sven.dream.order.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.order.DreamRateDo;
import com.sven.dream.dal.order.mapper.DreamRateDoMapper;
import com.sven.dream.order.bo.DreamRateBo;

public class DreamRateBoImpl extends AbstractDreamServiceImpl<DreamRateDo, DreamRateDoMapper> implements DreamRateBo{
 
	@Autowired
    public void setBaseMapper(DreamRateDoMapper mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<DreamRateDo> getRateBySkillId(long skillId) {
		return mapper.getRateBySkillId(skillId);
	}  
}

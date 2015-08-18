package com.sven.dream.order.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.order.DreamSkillDo; 
import com.sven.dream.dal.order.mapper.DreamSkillDoMapperExt;
import com.sven.dream.order.bo.DreamSkillBo;

public class DreamSkillBoImpl extends AbstractDreamServiceImpl<DreamSkillDo, DreamSkillDoMapperExt> implements DreamSkillBo{

	@Autowired
    public void setBaseMapper(DreamSkillDoMapperExt mapper) {
        setMapper(mapper);
    }
}

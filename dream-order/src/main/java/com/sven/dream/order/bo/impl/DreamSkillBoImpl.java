package com.sven.dream.order.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.order.mapper.DreamSkillDoMapper;
import com.sven.dream.order.bo.DreamSkillBo;

public class DreamSkillBoImpl extends AbstractDreamServiceImpl<DreamSkillDo, DreamSkillDoMapper> implements DreamSkillBo{

	@Autowired
    public void setBaseMapper(DreamSkillDoMapper mapper) {
        setMapper(mapper);
    }
}

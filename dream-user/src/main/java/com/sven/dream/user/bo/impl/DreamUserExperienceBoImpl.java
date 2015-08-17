package com.sven.dream.user.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.user.DreamUserExperienceDo;
import com.sven.dream.dal.user.mapper.DreamUserExperienceDoMapperExt;
import com.sven.dream.user.bo.DreamUserExperienceBo;

public class DreamUserExperienceBoImpl
	extends AbstractDreamServiceImpl<DreamUserExperienceDo, DreamUserExperienceDoMapperExt>
	implements DreamUserExperienceBo{
 
	@Autowired
    public void setBaseMapper(DreamUserExperienceDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<DreamUserExperienceDo> getExperienceListByUser(long userId) { 
		return mapper.getExperienceListByUser(userId);
	} 
}

package com.sven.dream.user.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.user.UserMappingDo;
import com.sven.dream.dal.user.mapper.UserMappingDoMapperExt;
import com.sven.dream.user.bo.UserMappingBo;

public class UserMappingBoImpl extends
	AbstractDreamServiceImpl<UserMappingDo, UserMappingDoMapperExt> implements UserMappingBo{

	@Autowired
    public void setBaseMapper(UserMappingDoMapperExt mapper) {
        setMapper(mapper);
    }
}

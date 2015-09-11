package com.sven.dream.user.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.user.UserEventDo;
import com.sven.dream.dal.user.mapper.UserEventDoMapperExt; 
import com.sven.dream.user.bo.UserEventBo;

public class UserEventBoImpl extends
	AbstractDreamServiceImpl<UserEventDo, UserEventDoMapperExt> implements UserEventBo{

	@Autowired
    public void setBaseMapper(UserEventDoMapperExt mapper) {
        setMapper(mapper);
    }
}

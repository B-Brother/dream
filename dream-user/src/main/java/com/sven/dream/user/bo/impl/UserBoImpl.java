package com.sven.dream.user.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.user.UserDo; 
import com.sven.dream.dal.user.mapper.UserDoMapperExt;
import com.sven.dream.user.bo.UserBo;

public class UserBoImpl extends
	AbstractDreamServiceImpl<UserDo, UserDoMapperExt> implements UserBo{

	@Autowired
    public void setBaseMapper(UserDoMapperExt mapper) {
        setMapper(mapper);
    }
}

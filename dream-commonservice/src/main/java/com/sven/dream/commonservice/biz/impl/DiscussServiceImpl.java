package com.sven.dream.commonservice.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.DiscussService;
import com.sven.dream.dal.common.DiscussDo;
import com.sven.dream.dal.common.mapper.DiscussDoMapperExt;

public class DiscussServiceImpl extends
	AbstractDreamServiceImpl<DiscussDo, DiscussDoMapperExt> implements DiscussService{

	@Autowired
    public void setBaseMapper(DiscussDoMapperExt mapper) {
        setMapper(mapper);
    }
}

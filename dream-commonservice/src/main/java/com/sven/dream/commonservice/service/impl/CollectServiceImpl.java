package com.sven.dream.commonservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.service.CollectService;
import com.sven.dream.dal.common.CollectDo;
import com.sven.dream.dal.common.mapper.CollectDoMapperExt;

public class CollectServiceImpl extends
	AbstractDreamServiceImpl<CollectDo, CollectDoMapperExt> implements CollectService{

	@Autowired
    public void setBaseMapper(CollectDoMapperExt mapper) {
        setMapper(mapper);
    }
}

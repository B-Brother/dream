package com.sven.dream.commonservice.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.MessageService;
import com.sven.dream.dal.common.MessageDo;
import com.sven.dream.dal.common.mapper.MessageDoMapperExt;

public class MessageServiceImpl extends
	AbstractDreamServiceImpl<MessageDo, MessageDoMapperExt> implements MessageService{

	@Autowired
    public void setBaseMapper(MessageDoMapperExt mapper) {
        setMapper(mapper);
    }
}

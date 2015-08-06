package com.sven.dream.user.bo.impl;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.user.DreamUserDo;
import com.sven.dream.dal.user.mapper.DreamUserDoMapper;
import com.sven.dream.user.bo.DreamUserBo;

public class DreamUserBoImpl extends AbstractDreamServiceImpl<DreamUserDo, DreamUserDoMapper> implements DreamUserBo{
 
	@Override
	public String sayHello() {
		return "hello,world";
	}

}

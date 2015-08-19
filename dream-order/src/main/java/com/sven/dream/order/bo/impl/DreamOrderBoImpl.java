package com.sven.dream.order.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.order.DreamOrderDo; 
import com.sven.dream.dal.order.mapper.DreamOrderDoMapperExt;
import com.sven.dream.order.bo.DreamOrderBo;

public class DreamOrderBoImpl extends AbstractDreamServiceImpl<DreamOrderDo, DreamOrderDoMapperExt>
							implements DreamOrderBo{

	@Autowired
    public void setBaseMapper(DreamOrderDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public DreamOrderDo getOrderByOrderId(long orderId) {
		return mapper.getOrderByOrderId(orderId);
	}

}

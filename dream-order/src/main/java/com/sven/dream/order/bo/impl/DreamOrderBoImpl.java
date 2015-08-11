package com.sven.dream.order.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.order.DreamOrderDo;
import com.sven.dream.dal.order.mapper.DreamOrderDoMapper;
import com.sven.dream.order.bo.DreamOrderBo;

public class DreamOrderBoImpl extends AbstractDreamServiceImpl<DreamOrderDo, DreamOrderDoMapper>
							implements DreamOrderBo{

	@Autowired
    public void setBaseMapper(DreamOrderDoMapper mapper) {
        setMapper(mapper);
    }
	
	@Override
	public DreamOrderDo getOrderByOrderId(long orderId) {
		return mapper.getOrderByOrderId(orderId);
	}

}

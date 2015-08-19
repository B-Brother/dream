package com.sven.dream.dal.order.mapper;

import javax.annotation.Resource;
 
import com.sven.dream.dal.order.DreamOrderDo;

@Resource
public interface DreamOrderDoMapperExt extends DreamOrderDoMapper{
	
	/**
	 * 根据订单ID获取订单
	 * 
	 * @param orderId
	 * @return
	 */
    public DreamOrderDo getOrderByOrderId(long orderId);
}
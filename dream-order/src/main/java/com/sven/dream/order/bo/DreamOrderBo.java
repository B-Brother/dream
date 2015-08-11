package com.sven.dream.order.bo;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.order.DreamOrderDo;

public interface DreamOrderBo extends DreamBo<DreamOrderDo>{

	/**
	 * 根据订单ID获取订单
	 * 
	 * @param orderId
	 * @return
	 */
    public DreamOrderDo getOrderByOrderId(long orderId);
}

package com.sven.dream.order.bo;

import java.util.List;

import com.sven.dream.common.query.OrderQuery;
import com.sven.dream.common.result.ResultBaseDo;
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
    
    /**
     * 分页查询获取订单列表
     * 
     * @param query
     * @return
     */
    public ResultBaseDo<List<DreamOrderDo>> getOrderListByQuery(OrderQuery query);
}

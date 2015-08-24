package com.sven.dream.dal.order.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.common.query.OrderQuery;
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
    
    /**
     * 条件查询订单列表
     * 
     * @param query
     * @return
     */
    public List<DreamOrderDo> getOrderListByQuery(OrderQuery query);
    
    /**
     * 条件查询订单的总数目
     * 
     * @param query
     * @return
     */
    public int countOrderListByQuery(OrderQuery query);
}
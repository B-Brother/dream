package com.sven.dream.manage.module.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.OrderConstants;
import com.sven.dream.dal.order.DreamOrderDo;
import com.sven.dream.order.bo.DreamOrderBo;

/**
 * 
 * 订单状态变化action
 * 
 * @author beckham
 *
 */
public class OrderStateChangeAction extends BaseRender{
	
	@Autowired
	private DreamOrderBo orderBo;
	
	/**
	 *  卖家确认订单
	 */
	public void doSellerSureSuccess(Navigator nav){
		long orderId = getLongParamValue("orderId");
		
		DreamOrderDo order = orderBo.getOrderByOrderId(orderId);
		if(order == null || order.getPayStatus() != OrderConstants.STATUS_PAY_WAITING_SURE){ 
			// 去错误页面
			return;
		}
		
		order.setPayStatus(OrderConstants.STATUS_PAY_SURE);
		orderBo.update(order);
	}
}








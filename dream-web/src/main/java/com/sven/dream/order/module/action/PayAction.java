package com.sven.dream.order.module.action;
 
import org.springframework.beans.factory.annotation.Autowired; 
 
import com.alibaba.citrus.turbine.Navigator; 
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.OrderConstants; 
import com.sven.dream.dal.order.DreamOrderDo; 
import com.sven.dream.order.bo.DreamOrderBo; 

public class PayAction extends BaseRender{
	 
	@Autowired
	private DreamOrderBo dreamOrderBo;
	 
	public void doPay(Navigator nav) {
         long orderId = getLongParamValue("orderId");
         
         // 更改状态为待付款
         DreamOrderDo order = dreamOrderBo.getOrderByOrderId(orderId);
         order.setPayStatus(OrderConstants.STATUS_PAY_WAITING_PAID);
         dreamOrderBo.update(order);
         
         // 买家付款完成。需要通知行者，你有新订单了
         nav.redirectToLocation("/order/paySuccess.htm");
    }
}















package com.sven.dream.order.module.screen;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;  
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.dal.order.DreamOrderDo;
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.order.DreamSkillSkuDo;
import com.sven.dream.order.bo.DreamOrderBo;
import com.sven.dream.order.bo.DreamSkillBo;
import com.sven.dream.order.bo.DreamSkillSkuBo;

public class Buy extends BaseRender{
	
	@Autowired
	private DreamOrderBo dreamOrderBo;
	
	@Autowired
	private DreamSkillBo dreamSkillBo;
	
	@Autowired
	private DreamSkillSkuBo dreamSkillSkuBo;
	
	public void execute(Context context, Navigator nav){
		Long orderId = Long.parseLong(request.getParameter("orderId"));
		
		DreamOrderDo order = dreamOrderBo.getOrderByOrderId(orderId);
		context.put("order", order);
		
		DreamSkillDo skill = dreamSkillBo.selectByPrimaryKey(order.getSkillId());
		context.put("skill", skill);
		
		DreamSkillSkuDo sku = dreamSkillSkuBo.selectByPrimaryKey(order.getSkuId());
		context.put("sku", sku);
	}
}

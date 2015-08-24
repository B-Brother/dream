package com.sven.dream.manage.module.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;  
import com.alibaba.citrus.turbine.Navigator;

import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.OrderConstants;
import com.sven.dream.common.query.OrderQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.dal.order.DreamOrderDo;
import com.sven.dream.order.bo.DreamOrderBo;

/**
 * 
 * 订单确认列表
 * 
 * @author beckham
 *
 */
public class OrderConfirm extends BaseRender{
	
	@Autowired
	private DreamOrderBo orderBo;
	
	public void execute(Context context, Navigator nav){
		Integer currentPage = getIntegerParamValue("p");
		if(currentPage == null){
			currentPage = 1;
		}
		
		OrderQuery query = new OrderQuery();
		query.setCurrentPage(currentPage);
		query.setPageSize(10);  
		query.setSellerId(getUser().getId());
		query.setPayStatus(OrderConstants.STATUS_PAY_INIT);
		
		ResultBaseDo<List<DreamOrderDo>> orderResult = orderBo.getOrderListByQuery(query);
		context.put("orderResult", orderResult);
	}
}

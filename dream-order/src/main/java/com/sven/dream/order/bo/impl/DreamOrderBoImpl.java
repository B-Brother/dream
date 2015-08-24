package com.sven.dream.order.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.common.query.OrderQuery;
import com.sven.dream.common.result.ResultBaseDo;
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

	@Override
	public ResultBaseDo<List<DreamOrderDo>> getOrderListByQuery(OrderQuery query) { 
		ResultBaseDo<List<DreamOrderDo>> result = new ResultBaseDo<List<DreamOrderDo>>();
		
		
		int count = mapper.countOrderListByQuery(query);
		
		query.setTotalCount(count);
		query.init();
		
		result.setSuccess(true);
		result.setQ(query);
		result.setModule(mapper.getOrderListByQuery(query)); 
		return result;
	}

}

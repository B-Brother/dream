package com.sven.dream.order.module.action;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired; 

import static com.sven.dream.common.constants.OrderConstants.*;

import com.alibaba.citrus.turbine.Navigator; 
import com.sven.dream.base.BaseRender;
import com.sven.dream.commonservice.service.UserOperationService;
import com.sven.dream.dal.order.DreamOrderDo;
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.user.DreamUserDo;
import com.sven.dream.order.bo.DreamOrderBo;
import com.sven.dream.order.bo.DreamSkillBo;

public class PayAction extends BaseRender{
	 
	@Autowired
	private DreamOrderBo dreamOrderBo;
	
	@Autowired
	private DreamSkillBo dreamSkillBo;
	
	@Autowired
	private UserOperationService userOperationService;
	 
	public void doReady(Navigator nav) {
        Long skillId = Long.parseLong(request.getParameter("skillId")); 
        String amount = request.getParameter("amount");
        Long buyerId = Long.parseLong(request.getParameter("amount"));
        
        DreamOrderDo order = new DreamOrderDo(); 
        order.setAmount(Integer.parseInt(amount));
        order.setBizType(BIZ_TYPE_NORMAL); 
        order.setBuyerId(buyerId);
        
        DreamUserDo buyer = userOperationService.selectByPrimaryKey(buyerId);
        order.setBuyerNick(buyer.getLastName());
        order.setMeetingType(1);
        order.setOrderId(new Random().nextLong());
        order.setPayStatus(STATUS_PAY_WAITING_SURE); 
        
        DreamSkillDo dreamSkillDo = dreamSkillBo.selectByPrimaryKey(skillId);
        order.setSellerId(dreamSkillDo.getSellerId());
        order.setSkillId(skillId);
        order.setSkillName(dreamSkillDo.getTitle());
        
        DreamUserDo seller = userOperationService.selectByPrimaryKey(dreamSkillDo.getSellerId());
        
        order.setSellerNick(seller.getLastName());
        
        order.setVisibleStatus(STATUS_VISIBLE_YES);
        
        int isOrderSuccess = dreamOrderBo.insert(order);
         
        if(isOrderSuccess > 0){
        	nav.redirectToLocation("");
        }
    }
}















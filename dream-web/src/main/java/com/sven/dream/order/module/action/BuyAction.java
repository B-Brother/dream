package com.sven.dream.order.module.action;

import static com.sven.dream.common.constants.OrderConstants.*;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.commonservice.service.UserOperationService;
import com.sven.dream.dal.order.DreamOrderDo;
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.user.DreamUserDo;
import com.sven.dream.order.bo.DreamOrderBo;
import com.sven.dream.order.bo.DreamSkillBo;

public class BuyAction extends BaseRender{
	
	@Autowired
	private DreamOrderBo dreamOrderBo;
	
	@Autowired
	private DreamSkillBo dreamSkillBo;
	
	@Autowired
	private UserOperationService userOperationService;
	
	/**
	 * 提交订单
	 * 
	 * @param nav
	 */
	public void doBuy(Navigator nav) {
        Long skillId = Long.parseLong(request.getParameter("skillId")); 
        String amount = request.getParameter("amount"); 
         
        DreamOrderDo order = new DreamOrderDo(); 
        order.setAmount(Integer.parseInt(amount));
        order.setBizType(BIZ_TYPE_NORMAL); 
        
        DreamUserDo buyer = getUser();
        order.setBuyerId((long)buyer.getId());
         
        order.setBuyerNick(buyer.getNick());
        order.setMeetingType(1);
        
        long orderId = new Random().nextLong();
        order.setOrderId(orderId);
        order.setPayStatus(STATUS_PAY_WAITING_SURE); 
        
        DreamSkillDo dreamSkillDo = dreamSkillBo.selectByPrimaryKey(skillId);
        order.setSellerId(dreamSkillDo.getSellerId());
        order.setSkillId(skillId);
        order.setSkillName(dreamSkillDo.getTitle());
        
        DreamUserDo seller = userOperationService.selectByPrimaryKey(dreamSkillDo.getSellerId());
        
        order.setSellerNick(seller.getNick());
        
        order.setVisibleStatus(STATUS_VISIBLE_YES);
        
        int isOrderSuccess = dreamOrderBo.insert(order);
         
        if(isOrderSuccess > 0){
        	nav.redirectToLocation("/order/buy.htm?orderId=" + orderId);
        }
    }
}

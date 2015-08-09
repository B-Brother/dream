package com.sven.dream.order.module.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired; 

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.TurbineRunDataInternal; 
import com.alibaba.citrus.turbine.util.TurbineUtil;

public class PayAction {
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 得到运行时数据rundta
	 * 
	 * @return
	 */
	protected TurbineRunDataInternal getRundata(){
		return (TurbineRunDataInternal)TurbineUtil.getTurbineRunData(request); 
	}
	
	public void doReady(Navigator nav) {
        String skillId = request.getParameter("skillId"); 
        String amount = request.getParameter("amount");
        
        System.out.println(skillId + "," + amount);
        
    }
}

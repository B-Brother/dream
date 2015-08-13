package com.sven.dream.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.TurbineRunDataInternal;
import com.alibaba.citrus.turbine.util.TurbineUtil;
import com.sven.dream.dal.user.DreamUserDo;

public class BaseRender {
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	/**
	 * 得到运行时数据rundta
	 * 
	 * @return
	 */
	protected TurbineRunDataInternal getRundata(){
		return (TurbineRunDataInternal)TurbineUtil.getTurbineRunData(request); 
	}
	
	/**
	 * mock
	 * 
	 * @return
	 */
	protected DreamUserDo getUser(){
		DreamUserDo user = new DreamUserDo();
		user.setId(1);
		user.setName("fuckme");
		user.setNick("ok.");
		return user;
	}
}












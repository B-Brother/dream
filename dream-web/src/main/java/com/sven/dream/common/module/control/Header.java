package com.sven.dream.common.module.control; 

import com.alibaba.citrus.turbine.Context;  
import com.sven.dream.base.BaseRender;  

/**
 * 
 * 头部banner，这里需要说明。能进入到header顶栏的这个页面必然有权限。否则同意拦截到登录页面
 * 
 * @author beckham
 *
 */
public class Header extends BaseRender{
	 
	public void execute(Context context){  
		context.put("user", getUser());  
	}
}

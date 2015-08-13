package com.sven.dream.user.module.action;

import org.apache.commons.codec.digest.DigestUtils; 
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.CommonConstants;
import com.sven.dream.commonservice.service.UserOperationService;
import com.sven.dream.dal.user.DreamUserDo;

public class RegisterAction extends BaseRender{
	 
	@Autowired
	private UserOperationService userOperationService;
	
	public void doRegister(Navigator nav){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nick = request.getParameter("nick"); 
		String prov = request.getParameter("prov");
		String dist = request.getParameter("dist");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String introduce = request.getParameter("introduce");
		String sex = request.getParameter("sex");
		
		DreamUserDo user = new DreamUserDo();
		user.setCityCode(dist);
		user.setEmail(email);
		user.setIntroduce(introduce);
		user.setMobilePhone(mobile);
		user.setName(username);
		user.setNick(nick);  
		user.setPassword(DigestUtils.md5Hex(password + CommonConstants.SALT));
		user.setProvinceCode(prov);
		user.setSex(sex);
		user.setTag(0L);
		userOperationService.insert(user);
		
		nav.redirectToLocation("/user/registerSuccess.htm");
	} 
}









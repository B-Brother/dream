package com.sven.dream.user.module.action;

import java.io.IOException; 

import com.alibaba.citrus.turbine.Context;  

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator; 
import com.sven.dream.base.BaseRender;

import static com.sven.dream.common.constants.CommonConstants.*;

import com.sven.dream.common.query.UserQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.service.UserOperationService;
import com.sven.dream.dal.user.DreamUserDo;

public class LoginAction extends BaseRender{
	
	@Autowired
	private UserOperationService userOperationService;
	
	/*
	 * 登录
	 */
	public void doLogin(Context context, Navigator nav) throws IOException{  
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		
		UserQuery query = new UserQuery();
		query.setLoginName(loginName);
		query.setPassword(DigestUtils.md5Hex(password + SALT));
		
		// 0.登录
		ResultBaseDo<DreamUserDo> userResult = userOperationService.checkLoginSuccessful(query);
		
		// 1.登录结果返回到前台
		context.put("result", buildJsonResult(userResult.isSuccess(), null, userResult.getErrorMessages()));
	} 
}










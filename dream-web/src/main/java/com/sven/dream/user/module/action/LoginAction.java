package com.sven.dream.user.module.action;

import static com.sven.dream.common.constants.CommonConstants.*;
import static com.sven.dream.common.constants.ErrorMessageConstatns.*;

import java.io.IOException; 

import com.alibaba.citrus.turbine.Context;  

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator; 
import com.sven.dream.base.BaseRender;

import com.sven.dream.common.constants.CommonConstants;
import com.sven.dream.common.query.UserQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.common.util.CookieUtil; 
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.dal.user.UserDo; 

public class LoginAction extends BaseRender{
	
	@Autowired
	private UserOperationService userOperationService; 
	
	/**
	 * 登录
	 * 
	 * @param context
	 * @param nav
	 * @throws IOException
	 */
	public void doLogin(Context context, Navigator nav) throws IOException{   
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		
		// 参数校验不通过直接返回
		if(!checkParameter(context, loginName, password)){
			return;
		}
		
		UserQuery query = new UserQuery();
		query.setLoginName(loginName);
		query.setPassword(DigestUtils.md5Hex(password + SALT));
		
		// 0.登录
		ResultBaseDo<UserDo> userResult = userOperationService.checkLoginSuccessful(query);
		 
		if(userResult.isSuccess()){
			// 登录成功，写入用户cookie，并且页面跳转到首页
			CookieUtil.addCookie(CommonConstants.COOKIE_USER_KEY, String.valueOf(userResult.getModule().getId()), 14400, true, response);
			
			nav.redirectToLocation("/common/index.htm");
		} else {
			// 登录失败，说明原因
			context.put("errorMessage", userResult.getErrorMessages());
		} 
	} 
	 
	/**
	 * 注销
	 * 
	 * @param context
	 * @param nav
	 * @throws IOException
	 */
	public void doLogout(Context context, Navigator nav) throws IOException{  
		// 1. 先删除cookie
		CookieUtil.removeCookie(CommonConstants.COOKIE_USER_KEY, response);
		
		// 2. 记录之前跳转过来的路径，再反跳回去
		// String refer = request.getHeader("Referer");

		// 3. 先跳转到首页，后边肯定是智能跳转
		//nav.redirectToLocation("/user/index.htm");
	}
	
	
	// ------------------ private --------------------------
	
	/**
	 * 1. 首先校验当前的昵称是否有反动的词语
	 * 
	 * 2. 其次校验email是否已近系统存在
	 * 
	 * @param nick
	 * @param email
	 * @return
	 */
	private boolean checkParameter(Context context, String loginName, String password){ 
		
 		boolean isLoginNameBlank = StringUtils.isBlank(loginName);
 		boolean isPasswordBlank = StringUtils.isBlank(password);
		if(isLoginNameBlank || isPasswordBlank){
			context.put("errorMessage", ERROR_MESSAGE_USER_REGISTER_EXISTS);
			return false;
		}
		
		return true;
	}
}










//package com.sven.dream.user.module.action;
//
//import java.io.IOException; 
//
//import com.alibaba.citrus.turbine.Context;  
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.alibaba.citrus.turbine.Navigator; 
//import com.sven.dream.base.BaseRender;
//
//import static com.sven.dream.common.constants.CommonConstants.*;
//
//import com.sven.dream.common.constants.CommonConstants;
//import com.sven.dream.common.query.UserQuery;
//import com.sven.dream.common.result.ResultBaseDo;
//import com.sven.dream.common.util.CookieUtil;
//import com.sven.dream.commonservice.service.UserOperationService;
//import com.sven.dream.dal.user.DreamUserDo;
//
//public class LoginAction extends BaseRender{
//	
//	@Autowired
//	private UserOperationService userOperationService;
//	
//	/**
//	 * 登录
//	 * 
//	 * @param context
//	 * @param nav
//	 * @throws IOException
//	 */
//	public void doLogin(Context context, Navigator nav) throws IOException{  
//		String loginName = request.getParameter("loginName");
//		String password = request.getParameter("password");
//		
//		UserQuery query = new UserQuery();
//		query.setLoginName(loginName);
//		query.setPassword(DigestUtils.md5Hex(password + SALT));
//		
//		// 0.登录
//		ResultBaseDo<DreamUserDo> userResult = userOperationService.checkLoginSuccessful(query);
//		
//		// 1.登录结果返回到前台
//		context.put("result", buildJsonResult(userResult.isSuccess(), null, userResult.getErrorMessages()));
//		
//		// 2.如果成功写cookie
//		if(userResult.isSuccess()){
//			CookieUtil.addCookie(CommonConstants.COOKIE_USER_KEY, String.valueOf(userResult.getModule().getId()), response);
//		}
//		
//		// 3.登录成功回跳首页
//		nav.redirectToLocation("/user/index.htm");
//	} 
//	
//	/**
//	 * 注销
//	 * 
//	 * @param context
//	 * @param nav
//	 * @throws IOException
//	 */
//	public void doLogout(Context context, Navigator nav) throws IOException{  
//		// 1. 先删除cookie
//		CookieUtil.removeCookie(CommonConstants.COOKIE_USER_KEY, response);
//		
//		// 2. 记录之前跳转过来的路径，再反跳回去
//		// String refer = request.getHeader("Referer");
//
//		// 3. 先跳转到首页，后边肯定是智能跳转
//		//nav.redirectToLocation("/user/index.htm");
//	}
//}
//
//
//
//
//
//
//
//
//

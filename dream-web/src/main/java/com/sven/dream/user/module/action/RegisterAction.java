package com.sven.dream.user.module.action;

import static com.sven.dream.common.constants.ErrorMessageConstatns.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired; 

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.CommonConstants;
import com.sven.dream.common.util.CookieUtil;
import com.sven.dream.commonservice.analysis.TextFilterService;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.dal.user.UserDo; 

public class RegisterAction extends BaseRender{
	 
    private UserOperationService userOperationService;
	 
	private TextFilterService textFilterService;
	
	public void doSimpleRegister(Context context, Navigator nav){
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String nick = request.getParameter("nick");  
		
		if(!checkParameter(context, nick, loginName, password)){
			return;
		}
		
		UserDo user = new UserDo(); 
		user.setLoginName(loginName); 
		user.setNick(nick);  
		user.setPassword(DigestUtils.md5Hex(password + CommonConstants.SALT)); 
		
		// 用户新增
		userOperationService.insert(user);
		
		// 获取到刚才新增的用户
		UserDo currentUser = userOperationService.getLoginDreamUser(loginName);
		
		// 用户ID写缓存，半小时生效
		CookieUtil.addCookie(CommonConstants.COOKIE_USER_KEY, String.valueOf(currentUser.getId()), 1800, true, response);
		
		nav.redirectToLocation("/user/registerSuccess.htm");
	} 
	
	// ------------------ private --------------------------
	
	/**
	 * 1. 首先校验当前的昵称是否有反动的词语(登录名是邮箱不用校验是否有非法字符)
	 * 
	 * 2. 其次校验email是否已近系统存在
	 * 
	 * @param nick
	 * @param email
	 * @return
	 */
	private boolean checkParameter(Context context, String nick, String loginName, String password){
		boolean isNickBlank = StringUtils.isBlank(nick);
		boolean isLoginNameBlank = StringUtils.isBlank(loginName);
		boolean isPasswordBlank = StringUtils.isBlank(password);
		
		// 服务端再次检查参数，不能为空
		if(isNickBlank || isLoginNameBlank || isPasswordBlank){
			context.put("errorMessage", ERROR_MESSAGE_USER_REGISTER_ALL_FILL);
			return false;
		}
		
		// 昵称反动违法
		if(textFilterService.isContainIllegalWords(nick)){ 
			context.put("errorMessage", ERROR_MESSAGE_ILLEGAL);
			return false;
		}
		
		// 用户是否存在
		UserDo user = userOperationService.getLoginDreamUser(loginName);
		if(user != null){
			context.put("errorMessage", ERROR_MESSAGE_USER_REGISTER_EXISTS);
			return false;
		}
		
		// 密码长度要大于6位
		if(password.length() < 6){
			context.put("errorMessage", ERROR_MESSAGE_USER_PASSWORD_TOO_SHORT);
			return false;
		}
		
		return true;
	}
}









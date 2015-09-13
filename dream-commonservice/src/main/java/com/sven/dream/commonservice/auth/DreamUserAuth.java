package com.sven.dream.commonservice.auth;

import static com.alibaba.citrus.util.Assert.*;
import static com.alibaba.citrus.util.StringUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie; 

import com.alibaba.citrus.service.uribroker.URIBrokerService; 
import com.alibaba.citrus.springext.support.BeanSupport;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.pipeline.valve.PageAuthorizationValve.Callback; 
import com.sven.dream.common.constants.CommonConstants;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.commonservice.vo.UserInformationVo; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DreamUserAuth extends BeanSupport implements Callback<DreamUserAuth.Status> {
	
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(DreamUserAuth.class);
     
    @Autowired
    private URIBrokerService uriBrokerService;

    @Autowired
    private UserOperationService userOperationService;
    
    private String cookieUserKey; 
    
    private List<String> whiteUriList = new ArrayList<String>();
    
    public void setCookieUserKey(String cookieUserKey) {
        this.cookieUserKey = trimToNull(cookieUserKey);
    } 

    @Override
    public void init() {
        assertNotNull(uriBrokerService, "could not get URIBrokerService");

        if (cookieUserKey == null) {
        	cookieUserKey = CommonConstants.COOKIE_USER_KEY;
        }
 
        whiteUriList.add("/user/login.htm");
        whiteUriList.add("/user/register.htm");
        whiteUriList.add("/user/registerSuccess.htm");
        whiteUriList.add("/common/404.htm"); 
    }

    public Status onStart(TurbineRunData rundata) {  
        Cookie[] cookies = rundata.getRequest().getCookies();
        
        DreamUser user = null;
        boolean isLogin = false;
        if(cookies != null){
	        for(Cookie cookie : cookies){
	        	if(cookie.getName().equals(cookieUserKey)){
	        		String userId = cookie.getValue();
	        		
	        		UserInformationVo currentUser = userOperationService.getUserInformation(new Long(userId));
	        		if(currentUser != null){
	        			DreamUser.setCurrentUser(currentUser);
	        			isLogin = true;
	        		}
	        	}
	        }
        }  
        
        // 如果未登录并且访问的页面不在白名单, 统一去登录页面
        if(!isLogin && !whiteUriList.contains(rundata.getRequest().getRequestURI())){
        	rundata.setRedirectLocation("/user/login.htm"); 
        }

        return new Status(rundata, user);
    }

    public String[] getActions(Status status) {
        return null;
    }

    public void onAllow(Status status) throws Exception {
    	System.out.println("on allow");
    }

    public void onDeny(Status status) throws Exception {
        System.out.println("on deny");
    }

    @SuppressWarnings("unused")
    static class Status {
        private final TurbineRunData rundata;
        private       DreamUser   user;

        public Status(TurbineRunData rundata, DreamUser user) {
            this.rundata = rundata;
            this.user = user;
        }
    }

	@Override
	public String getUserName(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRoleNames(Status status) {
		// TODO Auto-generated method stub
		return null;
	}
}

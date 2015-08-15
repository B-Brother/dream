package com.sven.dream.commonservice.auth;

import static com.alibaba.citrus.util.Assert.*;
import static com.alibaba.citrus.util.StringUtil.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import com.alibaba.citrus.service.uribroker.URIBrokerService;
import com.alibaba.citrus.service.uribroker.uri.URIBroker;
import com.alibaba.citrus.springext.support.BeanSupport;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.pipeline.valve.PageAuthorizationValve.Callback; 
import com.sven.dream.common.constants.CommonConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DreamUserAuth extends BeanSupport implements Callback<DreamUserAuth.Status> {
	
    private static final Logger log = LoggerFactory.getLogger(DreamUserAuth.class);
 
    /** Login页面返回URL的key。 */
    String LOGIN_RETURN_KEY = "return";

    /** 如果未指定return，登录以后就跳到该URL。 */
    String LOGIN_RETURN_DEFAULT_LINK = "petstoreHomeLink";

    /** 登录URL的名字。 */
    String PETSTORE_LOGIN_LINK = "loginUri";

    /** 登记用户URL的名字。 */
    String PETSTORE_REGISTER_LINK = "petstoreRegisterLink";

    /** 登记用户信息URL的名字。 */
    String PETSTORE_REGISTER_ACCOUNT_LINK = "petstoreRegisterAccountLink";

    /** 查看用户信息URL的名字。 */
    String PETSTORE_ACCOUNT_LINK = "petstoreAccountLink";
    
    @Autowired
    private URIBrokerService uriBrokerService;

    private String cookieUserKey;
    private String brokerId;
    private String returnKey;

    public void setCookieUserKey(String cookieUserKey) {
        this.cookieUserKey = trimToNull(cookieUserKey);
    }

    public void setRedirectURI(String brokerId) {
        this.brokerId = trimToNull(brokerId);
    }

    public void setReturnKey(String returnKey) {
        this.returnKey = trimToNull(returnKey);
    }

    @Override
    public void init() {
        assertNotNull(uriBrokerService, "could not get URIBrokerService");

        if (cookieUserKey == null) {
        	cookieUserKey = CommonConstants.COOKIE_USER_KEY;
        }

        if (brokerId == null) {
            brokerId = PETSTORE_LOGIN_LINK;
        }

        if (returnKey == null) {
            returnKey = LOGIN_RETURN_KEY;
        }
    }

    public Status onStart(TurbineRunData rundata) {  
        Cookie[] cookies = rundata.getRequest().getCookies();
        
        DreamUser user = null;
        if(cookies != null){
	        for(Cookie cookie : cookies){
	        	if(cookie.getName().equals(cookieUserKey)){
	        		String userId = cookie.getValue();
	        		user = new DreamUser(userId);
	        	}
	        }
        } 
        
        if (user == null) {
            // 创建匿名用户，匿名用户只能有特殊的权限
        	user = new DreamUser(); 
        }

        // 将user设置到rundata中，以便其它程序使用。
        DreamUser.setCurrentUser(user);

        return new Status(rundata, user);
    }

    public String getUserName(Status status) {
        return status.user.getId();
    }

    public String[] getRoleNames(Status status) {
        return status.user.getRoles();
    }

    public String[] getActions(Status status) {
        return null;
    }

    public void onAllow(Status status) throws Exception {
    }

    public void onDeny(Status status) throws Exception {
        HttpServletRequest request = status.rundata.getRequest();
        HttpServletResponse response = status.rundata.getResponse();
        URIBroker redirectURI = uriBrokerService.getURIBroker(brokerId);

        assertNotNull(redirectURI, "no URI broker found: %s", brokerId);

        StringBuffer buf = request.getRequestURL();
        String queryString = trimToNull(request.getQueryString());

        if (queryString != null) {
            buf.append('?').append(queryString);
        }

        String returnURL = buf.toString();

        response.sendRedirect(redirectURI.addQueryData(returnKey, returnURL).render());
    }

    static class Status {
        private final TurbineRunData rundata;
        private       DreamUser   user;

        public Status(TurbineRunData rundata, DreamUser user) {
            this.rundata = rundata;
            this.user = user;
        }
    }
}

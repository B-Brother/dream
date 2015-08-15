package com.sven.dream.commonservice.auth;

import static com.alibaba.citrus.util.Assert.*;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.citrus.util.ObjectUtil;

public class DreamUser implements Serializable {
	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	
    private static final long serialVersionUID = -7507510429755382596L;
    private static final ThreadLocal<DreamUser> userHolder = new ThreadLocal<DreamUser>();
    private String   userId;
    private String[] roles;

    public static final DreamUser getCurrentUser() {
        return userHolder.get();
    }

    public static final void setCurrentUser(DreamUser user) {
        userHolder.set(user);
    }

    /** 创建匿名用户。 */
    public DreamUser() {
    }

    /** 创建用户。 */
    public DreamUser(String userId) {
        this.userId = StringUtils.trimToNull(userId);
    }

    public String getId() {
        return userId;
    }

    public String[] getRoles() {
        return ObjectUtil.defaultIfNull(roles, EMPTY_STRING_ARRAY);
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void upgrade(String userId, String[] roles) {
        assertTrue(!hasLoggedIn(), ExceptionType.ILLEGAL_STATE, "already logged in");

        userId = assertNotNull(StringUtils.trimToNull(userId), "no user id");

        this.userId = userId;
        this.roles = roles;
    }

    public boolean hasLoggedIn() {
        return userId != null;
    }

    @Override
    public String toString() {
        return "PetstoreUser[" + ObjectUtil.defaultIfNull(userId, "anonymous") + ", roles=" + StringUtils.join(getRoles(), ":") + "]";
    }
}

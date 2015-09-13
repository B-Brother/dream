package com.sven.dream.commonservice.auth; 

import java.io.Serializable;

import com.sven.dream.commonservice.vo.UserInformationVo; 

public class DreamUser implements Serializable {
	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	
    private static final long serialVersionUID = -7507510429755382596L;
    private static final ThreadLocal<UserInformationVo> userHolder = new ThreadLocal<UserInformationVo>(); 

    public static final UserInformationVo getCurrentUser() {
        return userHolder.get();
    }

    public static final void setCurrentUser(UserInformationVo user) {
        userHolder.set(user);
    }
}

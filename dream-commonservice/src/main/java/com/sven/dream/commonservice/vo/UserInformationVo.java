package com.sven.dream.commonservice.vo;

import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.user.UserDo;

/**
 *  
 * 用户信息对象。包括了用户和头像信息。
 * 
 * @author beckham
 *
 */
public class UserInformationVo {
	private UserDo userDo;
	
	private FileDo userPicDo;

	public UserDo getUserDo() {
		return userDo;
	}

	public void setUserDo(UserDo userDo) {
		this.userDo = userDo;
	}

	public FileDo getUserPicDo() {
		return userPicDo;
	}

	public void setUserPicDo(FileDo userPicDo) {
		this.userPicDo = userPicDo;
	} 
}

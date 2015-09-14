package com.sven.dream.user.vo;

import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.user.UserDo;

public class UserMappingVo {
	private UserDo follower;
	
	private UserDo followerWho; 
	
	// 关注的人的地点
	private String followerWhoPosition;
	
	// 关注的人的用户主图
	private FileDo followerWhoUserPic; 

	public UserDo getFollower() {
		return follower;
	}

	public void setFollower(UserDo follower) {
		this.follower = follower;
	}

	public String getFollowerWhoPosition() {
		return followerWhoPosition;
	}

	public void setFollowerWhoPosition(String followerWhoPosition) {
		this.followerWhoPosition = followerWhoPosition;
	}

	public UserDo getFollowerWho() {
		return followerWho;
	}

	public void setFollowerWho(UserDo followerWho) {
		this.followerWho = followerWho;
	}

	public FileDo getFollowerWhoUserPic() {
		return followerWhoUserPic;
	}

	public void setFollowerWhoUserPic(FileDo followerWhoUserPic) {
		this.followerWhoUserPic = followerWhoUserPic;
	} 
}

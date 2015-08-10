package com.sven.dream.commonservice.vo;
 
import com.sven.dream.dal.common.UploadFileDo;
import com.sven.dream.dal.order.DreamRateDo;
import com.sven.dream.dal.user.DreamUserDo;

/**
 * 用户信息和评价信息的集合体
 * 
 * @author beckham
 *
 */
public class DreamUserRateVo{
	private DreamRateDo rate;
	
	private DreamUserDo user;
	 
	private UploadFileDo userPic;
	 
	public DreamRateDo getRate() {
		return rate;
	}

	public void setRate(DreamRateDo rate) {
		this.rate = rate;
	}
	 
	public UploadFileDo getUserPic() {
		return userPic;
	}

	public void setUserPic(UploadFileDo userPic) {
		this.userPic = userPic;
	}

	public DreamUserDo getUser() {
		return user;
	}

	public void setUser(DreamUserDo user) {
		this.user = user;
	} 
}

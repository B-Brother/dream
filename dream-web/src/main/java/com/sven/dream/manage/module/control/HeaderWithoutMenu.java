package com.sven.dream.manage.module.control;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;  
import com.sven.dream.base.BaseRender;
import com.sven.dream.commonservice.service.UserOperationService;
import com.sven.dream.dal.user.DreamUserDo;

public class HeaderWithoutMenu extends BaseRender{
	
	@Autowired
	private UserOperationService userOperationService;
	
	public void execute(Context context){
		DreamUserDo user = getUser();
		
		if(user != null){
			DreamUserDo currentUser = userOperationService.selectByPrimaryKey(user.getId());
			if(currentUser != null){
				context.put("isLogin", true);
				context.put("user", currentUser);
			}
		}
	}
}


package com.sven.dream.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import static com.sven.dream.common.constants.CommonConstants.*;

import com.alibaba.citrus.turbine.TurbineRunDataInternal;
import com.alibaba.citrus.turbine.util.TurbineUtil;
import com.alibaba.fastjson.JSONObject;
import com.sven.dream.commonservice.auth.DreamUser;
import com.sven.dream.dal.user.DreamUserDo;

public class BaseRender {
	
	protected final String AJAX_ISSUCCESS_TAG = "code";
	
	protected final String AJAX_RESULT_TAG = "result";
	
	protected final String AJAX_ERROR_MESSAGE_TAG = "errorMessage";
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	/**
	 * 得到运行时数据rundta
	 * 
	 * @return
	 */
	protected TurbineRunDataInternal getRundata(){
		return (TurbineRunDataInternal)TurbineUtil.getTurbineRunData(request); 
	}
	
	/**
	 * 成功: {"code":"success", result:{data}}
	 * 失败: {"code":"error", errorMessage:text}
	 * 
	 * 
	 * @param success
	 * @param data
	 * @return
	 */
	protected String buildJsonResult(boolean success, Object data, String errorText){
		JSONObject result = new JSONObject();
		if(success){
			result.put(AJAX_ISSUCCESS_TAG, STATUS_SUCCESS);
			result.put(AJAX_RESULT_TAG, JSONObject.toJSONString(data));
		} else {
			result.put(AJAX_ISSUCCESS_TAG, STATUS_ERROR);
			result.put(AJAX_ERROR_MESSAGE_TAG, errorText);
		}
		
		return result.toJSONString();
	}
	
	/**
	 * 返回当前登录用户信息
	 * 
	 * @return
	 */
	protected DreamUserDo getUser(){
		DreamUser currentUser = DreamUser.getCurrentUser();
		if(currentUser.getId() != null){
			DreamUserDo user = new DreamUserDo();
			user.setId(Long.parseLong(currentUser.getId()));
			user.setName("fuckme");
			user.setNick("ok.");
			return user;
		}
		
		return null;
	}
}












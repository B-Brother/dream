package com.sven.dream.common.module.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.commonservice.service.UploadFileService;

public class FileAction extends BaseRender{
	
	@Autowired
	private UploadFileService fileService;
	
	public void doUpload(Navigator nav){
		
	}
}	
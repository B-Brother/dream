package com.sven.dream.dal.common.mapper;
  
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.common.UploadFileDo; 

@Resource
public interface UploadFileDoMapperExt extends UploadFileDoMapper{

	/**
	 * 根据业务场景和对应的业务ID获取到附件列表。
	 * 
	 * @param type			附件类型
	 * @param businessId	业务ID
	 * @return
	 */
	public List<UploadFileDo> getFileListByType(HashMap<String, String> paramMap);
}
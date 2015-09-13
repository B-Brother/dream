package com.sven.dream.commonservice.biz.impl;
  
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.common.mapper.FileDoMapperExt; 

public class UploadFileServiceImpl extends
	AbstractDreamServiceImpl<FileDo, FileDoMapperExt> implements UploadFileService{

	// 附件前缀 
	private String diskPrefix;
	
	// http前缀
	private String httpPrefix;
	
	public void setDiskPrefix(String diskPrefix) {
		this.diskPrefix = diskPrefix;
	}
	
	public void setHttpPrefix(String httpPrefix) {
		this.httpPrefix = httpPrefix;
	}
	
	
	@Autowired
    public void setBaseMapper(FileDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<FileDo> getFileListByBusiness(String businessType, Long businessId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("businessId", String.valueOf(businessId));
		map.put("businessType", businessType);
		
		List<FileDo> fileList = mapper.getFileListByBusiness(map);
		for(FileDo file : fileList){
			file.setUrl(httpPrefix + file.getUrl());
		}
		
		return mapper.getFileListByBusiness(map);
	}
 
}









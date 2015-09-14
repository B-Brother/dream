package com.sven.dream.commonservice.biz.impl;
  
import java.util.ArrayList;
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
		
		List<FileDo> resultList = new ArrayList<FileDo>(); 
		FileDo fileResultDo = null;
		for(FileDo file : fileList){
			fileResultDo = new FileDo();
			fileResultDo.setBusinessId(businessId);
			fileResultDo.setBusinessType(businessType);
			fileResultDo.setFileName(file.getFileName());
			fileResultDo.setId(file.getId());
			fileResultDo.setIsDeleted(fileResultDo.getIsDeleted());
			fileResultDo.setStatus(file.getStatus());
			fileResultDo.setStorageType(file.getStorageType());
			fileResultDo.setUrl(file.getUrl()); 
			fileResultDo.setUrl(httpPrefix + file.getUrl());
			
			resultList.add(fileResultDo);
		}
		
		return resultList;
	}
 
}









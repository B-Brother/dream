package com.sven.dream.commonservice.service.impl;
 
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.service.UploadFileService;
import com.sven.dream.dal.common.UploadFileDo;
import com.sven.dream.dal.common.mapper.UploadFileDoMapper;

public class UploadFileServiceImpl extends
	AbstractDreamServiceImpl<UploadFileDo, UploadFileDoMapper> implements UploadFileService{

	@Autowired
    public void setBaseMapper(UploadFileDoMapper mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<UploadFileDo> getFileListByType(String businessType, Long businessId) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("businessType", businessType);
		paramMap.put("businessId", String.valueOf(businessId));
		return mapper.getFileListByType(paramMap);
	}

	@Override
	public UploadFileDo getFileListByTypeAndSpec(String type,
			Long businessId, String spec) {
		List<UploadFileDo> fileList = getFileListByType(type, businessId);

		UploadFileDo returnFile = null;
		for(UploadFileDo file : fileList){
			if(file.getSizeType().equals(spec)){
				returnFile = file;
				break;
			}
		}
		
		return returnFile; 
	} 
}

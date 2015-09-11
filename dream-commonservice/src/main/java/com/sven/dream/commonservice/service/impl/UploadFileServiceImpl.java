package com.sven.dream.commonservice.service.impl;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.service.UploadFileService;
import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.common.mapper.FileDoMapperExt; 

public class UploadFileServiceImpl extends
	AbstractDreamServiceImpl<FileDo, FileDoMapperExt> implements UploadFileService{

	// 附件前缀
	@SuppressWarnings("unused")
	private String prefix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	
	@Autowired
    public void setBaseMapper(FileDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<FileDo> getFileListByType(String businessType, Long businessId) {
		return null;
	}
 
}

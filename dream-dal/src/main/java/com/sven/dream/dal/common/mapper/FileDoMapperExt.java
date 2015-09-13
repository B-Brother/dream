package com.sven.dream.dal.common.mapper;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.sven.dream.dal.common.FileDo;
 
@Resource
public interface FileDoMapperExt extends FileDoMapper{
	
	/**
	 * 根据业务ID和业务类型获取附件列表
	 * 
	 * @param map
	 * @return
	 */
	public List<FileDo> getFileListByBusiness(Map<String, String> map);
}
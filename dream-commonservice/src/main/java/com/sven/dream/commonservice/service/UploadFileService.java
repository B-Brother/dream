package com.sven.dream.commonservice.service;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.common.UploadFileDo;

/**
 * 附件处理公共服务
 * 
 * @author beckham
 *
 */
public interface UploadFileService extends DreamBo<UploadFileDo>{
	
	/**
	 * 根据业务场景和对应的业务ID获取到附件列表。
	 * 
	 * @param type			附件类型
	 * @param businessId	业务ID
	 * @return
	 */
	public List<UploadFileDo> getFileListByType(String type, Long businessId);
}

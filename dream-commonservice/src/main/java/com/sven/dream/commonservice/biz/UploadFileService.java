package com.sven.dream.commonservice.biz;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.common.FileDo; 

/**
 * 附件处理公共服务
 * 
 * @author beckham
 *
 */
public interface UploadFileService extends DreamBo<FileDo>{
	
	/**
	 * 根据业务场景和对应的业务ID获取到附件列表。
	 * 
	 * @param type			附件类型
	 * @param businessId	业务ID
	 * @return
	 */
	public List<FileDo> getFileListByBusiness(String businessType, Long businessId); 
	
	/**
	 * 写文件到磁盘
	 * 
	 * @param file
	 * @return
	 */
	public FileDo writeFile2Disk(FileItem fileItem);
}

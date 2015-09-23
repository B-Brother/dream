package com.sven.dream.commonservice.biz.impl;
  
import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.common.constants.UploadConstants;
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
	
	public String getHttpPrefix() {
		return httpPrefix;
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
			
			if(StringUtils.isBlank(file.getUrl())){
				file.setUrl("nopic.gif");
			}
			fileResultDo.setUrl(httpPrefix + file.getUrl());
			
			resultList.add(fileResultDo);
		}
		
		return resultList;
	}

	@Override
    public FileDo writeFile2Disk(FileItem fileItem) { 
        FileOutputStream os = null;
        InputStream input = null;
        FileDo uploadFile = new FileDo();
        String name; 
        try {
            name = createFile(fileItem.getName());
            input = fileItem.getInputStream();
        } catch (IOException e) {
            // 如果文件名称都创建不了，就没有走下去的必要，异常直接抛出
            throw new RuntimeException("创建disk目录异常！", e);
        } 
         
        try {
            os = new FileOutputStream(diskPrefix + name);  
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0)
                os.write(buffer, 0, length);

        } catch (IOException e) {
            // IO EXCEPTION
        } finally { 
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                	// IO EXCEPTION
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                	// IO EXCEPTION
                }
            }
        }

        uploadFile.setBusinessId(0L);
        uploadFile.setBusinessType(UploadConstants.BIZ_UNDENFINED);
        uploadFile.setFileName(fileItem.getName()); 
        uploadFile.setUrl(name);
        uploadFile.setStatus(UploadConstants.USE_UPLOAD);
        uploadFile.setStorageType(UploadConstants.TYPE_DISK);
        
        insert(uploadFile);
        return uploadFile;
    }
 
	//--------private--------
    private String createFile(String fileName) throws IOException {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        int year = 0;
        int month = 0;
        int day = 0;

        File nasDirectory = new File(diskPrefix);
        if (!nasDirectory.exists()) {
            nasDirectory.mkdirs();
        }

        year = today.get(Calendar.YEAR);
        File yearDirectory = new File(nasDirectory.getAbsolutePath(), String.valueOf(year));
        if (!yearDirectory.exists()) {
            yearDirectory.mkdir();
        }

        month = today.get(Calendar.MONTH) + 1;
        File monthDirectory = new File(yearDirectory.getAbsolutePath(), String.valueOf(month));
        if (!monthDirectory.exists()) {
            monthDirectory.mkdir();
        }

        day = today.get(Calendar.DAY_OF_MONTH);
        File dayDirectory = new File(monthDirectory.getAbsolutePath(), String.valueOf(day));
        if (!dayDirectory.exists()) {
            dayDirectory.mkdir();
        }

        File file = new File(dayDirectory.getAbsolutePath(), fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        return File.separator + year + File.separator + month + File.separator + day + File.separator + fileName;
    } 
}









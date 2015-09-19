package com.sven.dream.common.module.screen;

import java.io.PrintWriter; 

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.requestcontext.parser.ParameterParser;
import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.service.requestcontext.util.RequestContextUtil;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.fastjson.JSONObject;
import com.sven.dream.base.BaseRender; 
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.dal.common.FileDo; 

public class Upload extends BaseRender{
	
	@Autowired
	private UploadFileService uploadFileService;

	public void execute(Context context) throws Exception {
		ParserRequestContext parserRequestContext =
                RequestContextUtil.findRequestContext(request, ParserRequestContext.class);

		ParameterParser params = parserRequestContext.getParameters();
		FileItem fileItem = params.getFileItem("file"); 
 		
		FileDo file = uploadFileService.writeFile2Disk(fileItem);
		
		response.addHeader("Cache-Control", "no-cache");  
        response.setContentType("application/json");  
        PrintWriter out = response.getWriter();  
        

        JSONObject fileJson = new JSONObject();
        fileJson.put("id", file.getId());
        out.write(fileJson.toJSONString());
	}
}

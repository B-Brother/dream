package com.sven.dream.common.module.screen;

import java.io.PrintWriter;

import org.apache.commons.fileupload.FileItem;

import com.alibaba.citrus.service.requestcontext.parser.ParameterParser;
import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.service.requestcontext.util.RequestContextUtil;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.fastjson.JSONObject;
import com.sven.dream.base.BaseRender;

public class Upload extends BaseRender{

	public void execute(Context context) throws Exception {
		ParserRequestContext parserRequestContext =
                RequestContextUtil.findRequestContext(request, ParserRequestContext.class);

		ParameterParser params = parserRequestContext.getParameters();
		FileItem fileItem = params.getFileItem("file"); 
		
		response.addHeader("Cache-Control", "no-cache");  
        response.setContentType("application/json");  
        PrintWriter out = response.getWriter();  
        out.write(new JSONObject().toJSONString());
	}
}

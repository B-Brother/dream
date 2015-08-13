package com.sven.dream.common.module.screen;
 
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;  
import com.sven.dream.base.BaseRender;
import com.sven.dream.commonservice.cache.GeographyCache;

public class GeographyData extends BaseRender{
	
	@Autowired
	private GeographyCache geographyCache;
	
	public void execute(Context context) throws Exception{
		response.addHeader("Cache-Control", "no-cache");  
        response.setContentType("application/json");  
        PrintWriter out = response.getWriter();  
        out.write(geographyCache.getResult().toJSONString());
	}
}

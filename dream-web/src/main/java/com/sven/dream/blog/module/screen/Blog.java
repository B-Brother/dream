package com.sven.dream.blog.module.screen;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.sven.dream.base.BaseRender;
import com.sven.dream.blog.bo.BlogBo;
import com.sven.dream.dal.blog.BlogDo;

public class Blog extends BaseRender{
	
	@Autowired
	private BlogBo blogBo;
	
	public void execute(Context context) throws Exception {
		long id = getLongParamValue("id");
		BlogDo blog = blogBo.selectByPrimaryKey(id);
		if(blog == null){
			response.sendRedirect("/common/404.htm");
			return;
		}
		
		context.put("blog", blog);
	} 
}

package com.sven.dream.blog.module.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.sven.dream.base.BaseRender;
import com.sven.dream.blog.bo.BlogBo;
import com.sven.dream.blog.vo.BlogVo; 

public class Blog extends BaseRender{
	
	@Autowired
	private BlogBo blogBo;
	
	public void execute(Context context) throws Exception {
		/**
		 * 如果blog页面不带参数，说明看到是自己，否则看的是其他人
		 */
		List<BlogVo> blogVoList = blogBo.getBlogListByUser(getUser().getUserDo().getId());
		 
		context.put("blogList", blogVoList);
	} 
}

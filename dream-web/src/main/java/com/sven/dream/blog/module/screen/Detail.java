package com.sven.dream.blog.module.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.sven.dream.base.BaseRender;
import com.sven.dream.blog.bo.BlogBo;
import com.sven.dream.blog.vo.BlogVo;
import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.common.util.DateUtil;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.dal.blog.BlogDo;
import com.sven.dream.dal.common.FileDo;

public class Detail extends BaseRender{
	
	@Autowired
	private BlogBo blogBo;
	
	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	public void execute(Context context) throws Exception {
		Long id = getLongParamValue("id");
		if(id == null || id <= 0L){
			response.sendRedirect("/common/404.htm");
			return;
		}
		
		BlogDo blog = blogBo.selectByPrimaryKey(id);
		if(blog == null){
			response.sendRedirect("/common/404.htm");
			return;
		}
		
		context.put("blog", buildBlogVo(blog));
	} 
	
	private BlogVo buildBlogVo(BlogDo blog){
		BlogVo blogVo = new BlogVo();
		blogVo.setCategoryId(blog.getCategoryId());
		blogVo.setContent(blog.getContent());
		blogVo.setId(blog.getId());
		blogVo.setKeyword(blog.getKeyword());
		blogVo.setPublishTime(DateUtil.formateDate(blog.getPublishTime()));
		blogVo.setTitle(blog.getTitle());
		blogVo.setUser(userOperationService.selectByPrimaryKey(blog.getUserId())); 
		
		List<FileDo> blogBgFileList = uploadFileService.getFileListByBusiness(
				UploadConstants.BIZ_BLOG_MAIN_BG, blog.getId());
		if(blogBgFileList != null && blogBgFileList.size() == 1){
			blogVo.setBlogBgPic(blogBgFileList.get(0));
			blogVo.setHasBlogBgPic(true);
		}
		
		return blogVo;
	}
}

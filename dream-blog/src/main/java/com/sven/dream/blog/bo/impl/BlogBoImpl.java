package com.sven.dream.blog.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.blog.bo.BlogBo;
import com.sven.dream.blog.vo.BlogVo;
import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.common.util.DateUtil;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.dal.blog.BlogDo; 
import com.sven.dream.dal.blog.mapper.BlogDoMapperExt;
import com.sven.dream.dal.common.FileDo;

public class BlogBoImpl extends
	AbstractDreamServiceImpl<BlogDo, BlogDoMapperExt> implements BlogBo{

	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Autowired
    public void setBaseMapper(BlogDoMapperExt mapper) {
        setMapper(mapper);
    }

	@Override
	public List<BlogVo> getBlogListByUser(long userId) {
		List<BlogDo> blogList = mapper.getBlogListByUser(userId);
		
		List<BlogVo> blogVoList = new ArrayList<BlogVo>();
		BlogVo blogVo = null;
		for(BlogDo blog : blogList){
			blogVo = new BlogVo();
			blogVo.setCategoryId(blog.getCategoryId());
			blogVo.setContent(blog.getContent());
			blogVo.setId(blog.getId());
			blogVo.setKeyword(blog.getKeyword());
			blogVo.setPublishTime(DateUtil.formateDate(blog.getPublishTime()));
			blogVo.setTitle(blog.getTitle());
			blogVo.setUser(userOperationService.selectByPrimaryKey(userId));
			blogVo.setUserFilePic(uploadFileService.getFileListByBusiness(
					UploadConstants.BIZ_USER_MAIN_PIC, userId).get(0));
			
			List<FileDo> blogBgFileList = uploadFileService.getFileListByBusiness(
					UploadConstants.BIZ_BLOG_MAIN_BG, blog.getId());
			if(blogBgFileList != null && blogBgFileList.size() == 1){
				blogVo.setBlogBgPic(blogBgFileList.get(0));
				blogVo.setHasBlogBgPic(true);
			}
			
			blogVoList.add(blogVo);
		}
		
		return blogVoList;
	}
}

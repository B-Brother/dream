package com.sven.dream.blog.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.blog.bo.BlogCategoryBo;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.blog.BlogCategoryDo;
import com.sven.dream.dal.blog.mapper.BlogCategoryDoMapperExt;

public class BlogCategoryBoImpl 
	extends AbstractDreamServiceImpl<BlogCategoryDo, BlogCategoryDoMapperExt> implements BlogCategoryBo{

	@Autowired
    public void setBaseMapper(BlogCategoryDoMapperExt mapper) {
        setMapper(mapper);
    }	
}

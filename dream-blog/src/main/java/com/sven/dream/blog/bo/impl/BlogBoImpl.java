package com.sven.dream.blog.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.blog.bo.BlogBo;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.blog.BlogDo; 
import com.sven.dream.dal.blog.mapper.BlogDoMapperExt;

public class BlogBoImpl extends
	AbstractDreamServiceImpl<BlogDo, BlogDoMapperExt> implements BlogBo{

	@Autowired
    public void setBaseMapper(BlogDoMapperExt mapper) {
        setMapper(mapper);
    }
}

package com.sven.dream.dal.blog.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.blog.BlogDo;

@Resource
public interface BlogDoMapperExt extends BlogDoMapper{
	
	/**
	 * 根据用户ID获取blog列表
	 * 
	 * @param userId
	 * @return
	 */
    public List<BlogDo> getBlogListByUser(long userId);
}
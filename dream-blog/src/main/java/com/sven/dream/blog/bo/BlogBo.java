package com.sven.dream.blog.bo;

import java.util.List;

import com.sven.dream.blog.vo.BlogVo;
import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.blog.BlogDo;

public interface BlogBo extends DreamBo<BlogDo>{

	/**
	 * 根据用户ID返回blog列表。
	 * 
	 * @param userId
	 * @return
	 */
	public List<BlogVo> getBlogListByUser(long userId);
}

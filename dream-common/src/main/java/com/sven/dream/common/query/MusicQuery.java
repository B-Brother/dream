package com.sven.dream.common.query;

import com.sven.dream.common.query.base.PaginationQuery;

public class MusicQuery extends PaginationQuery{
	
	public MusicQuery(int pageSize, int currentPage) {
		super(pageSize, currentPage); 
	}

	// 分类
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	} 
}

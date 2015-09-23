package com.sven.dream.common.query;

import com.sven.dream.common.query.base.PaginationQuery;

public class AlbumQuery extends PaginationQuery{
	
	public AlbumQuery(int pageSize, int currentPage) {
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

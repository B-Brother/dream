package com.sven.dream.common.query.base;

/**
 * 
 * 所有需要分页的对象来继承我
 * 
 * @author beckham
 *
 */
public class PaginationQuery {
	
	// 当前页
	protected int currentPage = 1;
 
	// 每页多少条记录
	protected int pageSize = 10;
 	
	// 总记录数
	protected int totalCount; 
 	
	// 总共多少页
	protected int totalPage;
	 
	
	// ====================== 计算头index开始 ========================
	
	private int startIndex = 0; 
	
	// ====================== 计算头尾index结束 ========================
	
	public void init(){
		// 首先计算总共多少页
		
		// 不允许pageSize小于10
		if(pageSize > 10){
			pageSize = 10;
		}
		
		// 计算一共有多少页
		if(totalCount == 0){
			totalPage = 1;
		}else{
			if(totalCount % pageSize == 0){
				totalPage = totalCount/pageSize;
			}else{
				totalPage = totalCount/pageSize + 1;
			} 
		}
		
		
		// 异常情况，当前页码小于等于0
		if(currentPage <= 0){
			startIndex = 0; 
		}else{
			startIndex = (currentPage - 1) * pageSize; 
		}
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if(currentPage <= 0){
			this.currentPage = 1;
		}else{
			this.currentPage = currentPage;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	} 
}

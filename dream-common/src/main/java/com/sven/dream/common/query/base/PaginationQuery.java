package com.sven.dream.common.query.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 所有需要分页的对象来继承我
 * 
 * @author beckham
 *
 */
public class PaginationQuery {
	
	// 是否初始化的标记
	private boolean isInit = false;
	
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
	
	
	
	// ====================== 给velocity使用的分页插件开始 ========================
	
	// 页码list，给页面的分页组件使用，这个List最多10个元素，如果太多铺在页面上就不好看了
	// 举个栗子。
	// 如果当前是第1,2,3,4,5,6页, 则这个list是1-10.
	// 如果到第7页了，这个list对应的就要调整下。始终让当前页处于可选范围的中间或者偏向于中间。
	// 这个偏向值我们暂时定为3
	private List<Integer> paginationList4VM = new ArrayList<Integer>();
	  
	// 上一页
	private int prevPage;
	
	// 下一页
	private int nextPage;
	
	// ====================== 给velocity使用的分页插件结束 ========================
	
	public PaginationQuery(int pageSize, int currentPage){
		// 异常情况，当前页码小于等于0
		if(currentPage <= 0){
			startIndex = 0; 
		}else{
			startIndex = (currentPage - 1) * pageSize; 
		}
	}
	
	
	public void init(){
		if(isInit){
			return;
		}
		
		// 首先计算总共多少页 
		
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
		
		// 计算上一页和下一页
		if(currentPage <= 1){
			prevPage = 1;
		}else{
			prevPage = currentPage - 1;
		}
		
		if(currentPage == totalPage){
			nextPage = currentPage;
		}else{
			nextPage = currentPage + 1;
		}
		
		
		// 计算给vm显示的页码列表
		// a.先判断当前页码的位置在哪个区间
		    // a.1 如果页面不足10页，有多少显示多少
		if(totalPage <= 10){
			for (int i = 1; i <= totalPage; i++) {
				paginationList4VM.add(i);
			}
		}else if(currentPage <= 7){
			// a.2 如果当前页面数量大于10页，但是当前页还龟缩在前7页，那就显示前10页
			for (int i = 1; i <= 10; i++) {
				paginationList4VM.add(i);
			}
		}else{
			// 正常情况，左边补6个，右边补3个
			// b.1 左边先补上6个。加上自己一共是7个
			for (int i = currentPage - 6; i <= currentPage; i++) {
				paginationList4VM.add(i);
			}
			
			// 如果末尾已经不够3页，则有多少显示多少
			if(currentPage + 3 >= totalPage){
				for (int i = currentPage + 1; i <= totalPage; i++) {
					paginationList4VM.add(i);
				}
			}else{
				// 如果满足，则显示剩下的3项
				for (int i = currentPage + 1; i <= currentPage + 3; i++) {
					paginationList4VM.add(i);
				}
			}
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
	 
	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
	public List<Integer> getPaginationList4VM() {
		return paginationList4VM;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	} 
}

package com.sven.dream.common.query;

import com.sven.dream.common.query.base.PaginationQuery;

/**
 * 
 * 订单查询对象
 * 
 * @author beckham
 *
 */
public class OrderQuery extends PaginationQuery{
	
	// 卖家ID
	private long sellerId;
	
	// 订单状态
	private int payStatus;

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	} 
}

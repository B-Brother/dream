package com.sven.dream.common.util;

import java.util.Date;

/**
 * 订单ID生成工具
 * 
 * @author beckham
 *
 */
public class OrderIDGenerator {
	
	/**
	 * 使用以下公式来生成订单ID
	 * 
	 * @return
	 */
	public static long newOrderId(){
		return new Date().getTime() - 1440000000000L;
	} 
}

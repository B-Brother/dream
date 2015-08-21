package com.sven.dream.common.constants;

/**
 * 订单、交易常量
 * 
 * @author beckham
 *
 */
public class OrderConstants {
	
	// =================================================
	// ========            交易类型            ==========
	// =================================================
	
	public static final String BIZ_TYPE_NORMAL = "200";
	
	
	// =================================================
	// ========         订单是否可见状态         ==========
	// =================================================

	public static final int STATUS_VISIBLE_YES = 1;
	
	public static final int STATUS_VISIBLE_NO = 0;
	
	
	
	// =================================================
	// ===========         付款状态         =============
	// =================================================

	// 等待付款
	public static final int STATUS_PAY_WAITING_PAID = 1;
	
	// 等待确认
	public static final int STATUS_PAY_WAITING_SURE = 2;
	
	// 已退款，交易关闭
	public static final int STATUS_PAY_REFUND = 3;
	
	// 交易成功
	public static final int STATUS_PAY_SUCCESS = 4;
	
	// 系统关闭
	public static final int STATUS_PAY_SYSTEM_CLOSE = 5;
	
	// 不可付款
	public static final int STATUS_PAY_CANNOT = 6;
	
	
	
	// =================================================
	// ===========         服务状态         =============
	// =================================================

	// 等待技能发布者确认  技能发布者操作
	public static final int STATUS_METTING_WAITING_SKILLER_CONFIRM = 1;
	
	// 等待服务     用户操作
	public static final int STATUS_METTING_WAITING_DOING = 2;
	
	// 服务完成     用户操作
	public static final int STATUS_METTING_FINISH = 3;
	
	
	// =================================================
	// ===========      服务实施见面地点         ==========
	// =================================================
	
	// 在我家进行订单实施
	public static final int MEETING_MY_HOME = 1;
	
	// 在行者加进行订单实施
	public static final int MEETING_SKILLER_HOME = 2;
}











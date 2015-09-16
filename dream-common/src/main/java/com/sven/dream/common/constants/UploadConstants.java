package com.sven.dream.common.constants;

/**
 * 附件上传常量
 * 
 * @author beckham
 *
 */
public class UploadConstants {
	// =================================================
	// ===========        附件存储类型       =============
	// ================================================= 
	
	// CDN节点保存文件
	public static final String TYPE_CDN = "CDN";
	
	// 磁盘保存文件
	public static final String TYPE_DISK = "DISK"; 
	
	// =================================================
	// ===========       附件生效情况         ============
	// =================================================
	
	// 处于上传状态。暂时没有和对应业务表关联
	public static final String USE_UPLOAD = "UPLOAD";
			
	// 已经和业务关联了
	public static final String USE_EFFECT = "EFFECT";
	
	// =================================================
	// ===========       业务场景         ============
	// =================================================
	 
	// 用户主图
	public static final String BIZ_USER_MAIN_PIC = "USER_MAIN"; 
	
	// 专辑主图
	public static final String BIZ_ALBUM_MAIN_PIC = "ALBUM_MAIN";
	
	// 专辑主图
	public static final String BIZ_MUSIC_MAIN_PIC = "MUSIC_MAIN";
	
	// 博客主背景顶图，如果有的话
	public static final String BIZ_BLOG_MAIN_BG = "BLOG_BG";
}





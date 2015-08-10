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
	// ===========         业务类型         =============
	// ================================================= 
	
	// 技能信息场景
	public static final String BIZ_TYPE_SKILL = "SKILL";
	
	// 用户图像
	public static final String BIZ_TYPE_USER_PIC = "USER_PIC";
	
	
	// =================================================
	// ===========       附件规格(图片)         ==========
	// ================================================= 
	
	// 48*48的图片大小。一般是用户评论这里的小图
	public static final String SPEC_PIC_48_48 = "48*48";
	
	// 无规格图片以及非图片附件。
	public static final String SPEC_NO = "NO_SPEC";
}

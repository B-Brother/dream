package com.sven.dream.common.enums;

import java.util.ArrayList;

public class MusicConstants {
	
	// =================================================
	// ===========       音乐类型         ============
	// =================================================
	
	public static final ArrayList<String> TYPELIST = new ArrayList<String>();
	
	// 流行
	public static final String TYPE_MUSIC_POP = "POP"; 
	 
	// 摇滚
	public static final String TYPE_MUSIC_ROCK = "ROCK";
			
	// 民谣
	public static final String TYPE_MUSIC_FOLK = "FOLK";		
	
	// 电子
	public static final String TYPE_MUSIC_ELECTRONIC = "ELECTRONIC";
	 
	// R&B
	public static final String TYPE_MUSIC_RB = "RB";
			
	// 爵士
	public static final String TYPE_MUSIC_JAZZ = "JAZZ";
			
	// 轻音乐
	public static final String TYPE_MUSIC_EASY_LISTENING = "EASY_LISTENING";
	
	// 嘻哈
	public static final String TYPE_MUSIC_HIP_HOP = "HIP_HOP";
	
	// 布鲁斯
	public static final String TYPE_MUSIC_BLUES = "BLUES";
	
	// 金属
	public static final String TYPE_MUSIC_METAL = "METAL";
	 
	// 乡村
	public static final String TYPE_MUSIC_COUNTRY = "COUNTRY";
	 
	// 雷鬼
	public static final String TYPE_MUSIC_REGGAE = "REGGAE";
	
	// 古典
	public static final String TYPE_MUSIC_CLASSICAL = "CLASSICAL";
	 
	// 拉丁
	public static final String TYPE_MUSIC_LATIN = "LATIN";
	 
	// 儿童
	public static final String TYPE_MUSIC_CHILDREN = "CHILDREN";
 
	// 世界音乐
	public static final String TYPE_MUSIC_WORLD = "WORLD"; 
	
	// 其他
	public static final String TYPE_MUSIC_OTHER = "OTHER";

	static{
		TYPELIST.add(TYPE_MUSIC_POP);
		TYPELIST.add(TYPE_MUSIC_ROCK);
		TYPELIST.add(TYPE_MUSIC_FOLK);
		TYPELIST.add(TYPE_MUSIC_ELECTRONIC);
		TYPELIST.add(TYPE_MUSIC_RB);
		TYPELIST.add(TYPE_MUSIC_JAZZ);
		TYPELIST.add(TYPE_MUSIC_EASY_LISTENING);
		TYPELIST.add(TYPE_MUSIC_HIP_HOP);
		TYPELIST.add(TYPE_MUSIC_BLUES);
		TYPELIST.add(TYPE_MUSIC_METAL);
		TYPELIST.add(TYPE_MUSIC_COUNTRY);
		TYPELIST.add(TYPE_MUSIC_REGGAE);
		TYPELIST.add(TYPE_MUSIC_CLASSICAL);
		TYPELIST.add(TYPE_MUSIC_LATIN);
		TYPELIST.add(TYPE_MUSIC_CHILDREN);
		TYPELIST.add(TYPE_MUSIC_WORLD);
		TYPELIST.add(TYPE_MUSIC_OTHER); 
	}
	 
}

package com.sven.dream.commonservice.analysis;

/**
 * 
 * 文字安全过滤器
 * 
 * @author beckham
 *
 */
public interface TextFilterService {

	public boolean isContainIllegalWords(String text);
}

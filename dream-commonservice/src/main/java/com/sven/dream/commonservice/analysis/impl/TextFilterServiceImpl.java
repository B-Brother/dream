package com.sven.dream.commonservice.analysis.impl;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.sven.dream.commonservice.analysis.TextFilterService;

public class TextFilterServiceImpl implements TextFilterService{

	public List<String> illegalWord = loadFilterWords();
	
	public List<String> loadFilterWords(){
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("filterwords.txt");
		
		byte[] bytes = new byte[65536];
		try {
			IOUtils.read(is, bytes);
		} catch (IOException e) { 
			throw new RuntimeException("读取过滤词发生异常!", e);
		}
		
		List<String> result = new ArrayList<String>();
		
		String words = new String(bytes);
		String[] wordArray = words.split(",");
		for(String word : wordArray){
			result.add(word);
		} 
		
		return result;
	} 
	
	@Override
	public boolean isContainIllegalWords(String text) {
		for (String illegal : illegalWord) {
			if(text.contains(illegal)){
				return true;
			}
		}
		
		return false;
	}

}

package com.sven.dream.user.module.screen;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration; 

import com.alibaba.citrus.turbine.Context; 

public class Index {
	public void execute(Context context) throws Exception {
		// 获取优质的供应商解决方案
		
		// 获取新入住的解决方案商
		 
	}
	
	public static void main(String[] args) throws IOException {
		Enumeration<URL> resourceUrls = Index.class.getClassLoader().getResources("/com"); 
		while (resourceUrls.hasMoreElements()) {
			URL url = resourceUrls.nextElement();
			System.out.println(url);
		}
		System.out.println("DONE.");
	}
}

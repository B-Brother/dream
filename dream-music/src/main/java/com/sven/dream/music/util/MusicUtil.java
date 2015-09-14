package com.sven.dream.music.util;

public class MusicUtil {
	
	/**
	 * 得到页面输出的歌曲耗时显示格式
	 * 
	 * @param second 歌曲的时长，单位为秒
	 * @return
	 */
	public static String convertViewSongTime(int second){
		if(second <= 0){
			return "0:00";
		}
		
		int hour = second / 3600;
		int min = (second - (hour * 3600)) / 60;
		int sec = second - (hour * 3600) - (min * 60);
		
		if(hour == 0){
			return fillZeroFirst(min) + ":" + fillZeroFirst(sec);
		}
		
		return fillZeroFirst(hour) + ":" + fillZeroFirst(min) + ":" + fillZeroFirst(sec);
	}
	
	/**
	 * 针对一位数, 在第一位补0, 然后返回对应组装完成的字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String fillZeroFirst(int num){
		if(num >= 10 || num < 0){
			return String.valueOf(num);
		}
		
		return "0" + num;
	}
	
	public static void main(String[] args) {
		System.out.println(convertViewSongTime(-10));
		System.out.println(convertViewSongTime(0));
		System.out.println(convertViewSongTime(10));
		System.out.println(convertViewSongTime(100));
		System.out.println(convertViewSongTime(1000));
		System.out.println(convertViewSongTime(10000));
		System.out.println(convertViewSongTime(100000));
	}
}

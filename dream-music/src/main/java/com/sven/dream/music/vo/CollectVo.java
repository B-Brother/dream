package com.sven.dream.music.vo;

import com.sven.dream.dal.music.CollectDo;

/**
 * 
 * 收藏列表视图对象。
 * 
 * 使用场景:
 * 1. listen页面的主音乐收藏
 * 
 * @author beckham
 *
 */
public class CollectVo {
	private CollectDo collectDo;
	
	private MusicVo musicVo;

	public CollectDo getCollectDo() {
		return collectDo;
	}

	public void setCollectDo(CollectDo collectDo) {
		this.collectDo = collectDo;
	}

	public MusicVo getMusicVo() {
		return musicVo;
	}

	public void setMusicVo(MusicVo musicVo) {
		this.musicVo = musicVo;
	} 
}

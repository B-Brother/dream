package com.sven.dream.music.bo;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.music.MusicDo; 
import com.sven.dream.music.vo.MusicVo;

public interface MusicBo extends DreamBo<MusicDo>{
	/**
	 * 给首页提供的最新歌曲列表
	 * 
	 * @return
	 */
	public List<MusicVo> getNewSongList();
	
	/**
	 * 给首页提供的top歌曲列表
	 * 
	 * @return
	 */
	public List<MusicVo> getTopSongList();
}

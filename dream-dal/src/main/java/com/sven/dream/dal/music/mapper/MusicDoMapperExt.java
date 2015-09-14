package com.sven.dream.dal.music.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.music.MusicDo;
 
@Resource
public interface MusicDoMapperExt extends MusicDoMapper{
	
	/**
	 * 拿到新歌列表，专为首页使用
	 * 
	 * @return
	 */
    public List<MusicDo> getNewSongList();	

    /**
     * 拿到top歌曲列表，专为首页使用
     * 
     * @return
     */
    public List<MusicDo> getTopSongList();
}
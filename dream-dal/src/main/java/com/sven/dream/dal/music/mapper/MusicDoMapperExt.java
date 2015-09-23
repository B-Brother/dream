package com.sven.dream.dal.music.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.common.query.MusicQuery;
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
    
    /**
     * 分页获取music列表
     * 
     * @param query
     * @return
     */
    public List<MusicDo> getMusicListPagination(MusicQuery query);
    
    /**
     * 获取和 @getMusicListPagination 相同条件下满足的系统总条数
     * 
     * @param query
     * @return
     */
    public int getMusicListCount(MusicQuery query);
    
    /**
     * 获取专辑下的歌曲根据专辑ID
     * 
     * @param albumId
     * @return
     */
    public List<MusicDo> getMusicListByAlbum(long albumId);
}
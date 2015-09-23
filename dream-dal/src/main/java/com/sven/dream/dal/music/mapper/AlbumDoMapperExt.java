package com.sven.dream.dal.music.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.common.query.AlbumQuery;
import com.sven.dream.dal.music.AlbumDo;

@Resource
public interface AlbumDoMapperExt extends AlbumDoMapper{
	/**
	 * 给首页提供的最新专辑列表
	 * 
	 * @return
	 */
	public List<AlbumDo> getNewAlbumList();
	
	/**
     * 分页获取专辑列表
     * 
     * @param query
     * @return
     */
    public List<AlbumDo> getAlbumListPagination(AlbumQuery query);
    
    /**
     * 获取和 @getAlbumListPagination 相同条件下满足的系统总条数
     * 
     * @param query
     * @return
     */
    public int getAlbumListCount(AlbumQuery query);
}
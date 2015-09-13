package com.sven.dream.dal.music.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.sven.dream.dal.music.AlbumDo;

@Resource
public interface AlbumDoMapperExt extends AlbumDoMapper{
	/**
	 * 给首页提供的最新专辑列表
	 * 
	 * @return
	 */
	public List<AlbumDo> getNewAlbumList();
}
package com.sven.dream.music.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.music.AlbumDo;
import com.sven.dream.dal.music.mapper.AlbumDoMapperExt;
import com.sven.dream.music.bo.AlbumBo;

public class AlbumBoImpl extends
	AbstractDreamServiceImpl<AlbumDo, AlbumDoMapperExt> implements AlbumBo{

	@Autowired
    public void setBaseMapper(AlbumDoMapperExt mapper) {
        setMapper(mapper);
    }
}

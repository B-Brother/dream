package com.sven.dream.music.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.music.MusicDo;
import com.sven.dream.dal.music.mapper.MusicDoMapperExt;
import com.sven.dream.music.bo.MusicBo;

public class MusicBoImpl extends
	AbstractDreamServiceImpl<MusicDo, MusicDoMapperExt> implements MusicBo{

	@Autowired
    public void setBaseMapper(MusicDoMapperExt mapper) {
        setMapper(mapper);
    }
}

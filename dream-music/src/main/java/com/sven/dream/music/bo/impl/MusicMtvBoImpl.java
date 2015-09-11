package com.sven.dream.music.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.music.MusicMtvDo;
import com.sven.dream.dal.music.mapper.MusicMtvDoMapperExt;
import com.sven.dream.music.bo.MusicMtvBo;

public class MusicMtvBoImpl extends
	AbstractDreamServiceImpl<MusicMtvDo, MusicMtvDoMapperExt> implements MusicMtvBo{

	@Autowired
    public void setBaseMapper(MusicMtvDoMapperExt mapper) {
        setMapper(mapper);
    }
}

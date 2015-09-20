package com.sven.dream.music.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.dal.music.CollectDo;
import com.sven.dream.dal.music.mapper.CollectDoMapperExt;
import com.sven.dream.music.bo.CollectBo;
import com.sven.dream.music.bo.MusicBo;
import com.sven.dream.music.vo.CollectVo;
import com.sven.dream.music.vo.MusicVo;

public class CollectBoImpl extends AbstractDreamServiceImpl<CollectDo, CollectDoMapperExt>
	implements CollectBo{
	
	@Autowired
	private MusicBo musicBo;

	@Autowired
    public void setBaseMapper(CollectDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<CollectVo> getCollectListByBusiness(long userId, String businessType) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", String.valueOf(userId)); 
		paramMap.put("businessType", businessType);
		 
		List<CollectDo> collectList = mapper.getCollectListByBusiness(paramMap);
		List<CollectVo> collectVoList = new ArrayList<CollectVo>();
		CollectVo collectVo = null;
		for(CollectDo collect : collectList){ 
			collectVo = new CollectVo();
			collectVo.setCollectDo(collect);
			
			MusicVo musicVo = musicBo.getMusicVoById(collect.getBusinessId());
			collectVo.setMusicVo(musicVo);
			
			collectVoList.add(collectVo);
		}
		
		return collectVoList;
	}

}

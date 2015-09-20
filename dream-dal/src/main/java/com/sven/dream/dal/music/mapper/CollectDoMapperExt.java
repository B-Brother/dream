package com.sven.dream.dal.music.mapper;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.sven.dream.dal.music.CollectDo;
 
@Resource
public interface CollectDoMapperExt extends CollectDoMapper{
    
	/**
	 * 根据业务ID和业务场景来获取收藏列表。
	 * 
	 * @param businessId
	 * @param businessType
	 * @return
	 */
	public List<CollectDo> getCollectListByBusiness(Map<String, String> paramMap);
}
package com.sven.dream.music.bo;

import java.util.List;

import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.music.CollectDo;
import com.sven.dream.music.vo.CollectVo;

public interface CollectBo extends DreamBo<CollectDo>{
	
	/**
	 * 根据业务ID和业务场景来获取收藏列表。
	 * 
	 * @param businessId
	 * @param businessType
	 * @return
	 */
	public List<CollectVo> getCollectListByBusiness(long userId, String businessType);
}

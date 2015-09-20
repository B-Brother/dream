package com.sven.dream.music.module.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.CollectionConstants; 
import com.sven.dream.music.bo.CollectBo;
import com.sven.dream.music.vo.CollectVo;

public class Listen extends BaseRender{
	 
	@Autowired
	private CollectBo collectBo;
	
	public void execute(Context context, Navigator nav) throws Exception { 
		 long userId = getUser().getUserDo().getId();
		 
		 // 收藏的歌曲
		 List<CollectVo> musicCollectList = collectBo.getCollectListByBusiness(userId, CollectionConstants.BIZ_MUSIC);
		 context.put("musicCollectList", musicCollectList);
	
		 // 推荐的歌曲
	} 
}

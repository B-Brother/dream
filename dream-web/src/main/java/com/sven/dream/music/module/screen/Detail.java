package com.sven.dream.music.module.screen;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.dal.music.MusicDo;
import com.sven.dream.music.bo.MusicBo;

public class Detail extends BaseRender{
	 
	@Autowired
	private MusicBo musicBo;
	
	public void execute(Context context, Navigator nav) throws Exception {
		 Long id = getLongParamValue("id");
		 if(id == null || id <= 0L){
			 nav.redirectToLocation("/common/404.htm");
			 return;
		 }
		 
		 MusicDo music = musicBo.selectByPrimaryKey(id);
		 context.put("music", music);
	} 
}

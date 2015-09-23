package com.sven.dream.music.module.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.dal.music.AlbumDo; 
import com.sven.dream.music.bo.AlbumBo;
import com.sven.dream.music.bo.MusicBo;
import com.sven.dream.music.vo.MusicVo;

public class Album extends BaseRender{
	 
		@Autowired
		private MusicBo musicBo;
		
		@Autowired
		private AlbumBo albumBo;
		
		public void execute(Context context, Navigator nav) throws Exception {
			 Long id = getLongParamValue("id");
			 if(id == null || id <= 0L){
				 nav.redirectToLocation("/common/404.htm");
				 return;
			 }
			  
			 AlbumDo albumDo = albumBo.selectByPrimaryKey(id);
			 if(albumDo == null){
				 nav.redirectToLocation("/common/404.htm");
				 return;
			 }
			 
			 context.put("album", albumDo);
			 
			 List<MusicVo> musicList = musicBo.getMusicListByAlbum(id);
			  
			 context.put("musicList", musicList);
		} 
}

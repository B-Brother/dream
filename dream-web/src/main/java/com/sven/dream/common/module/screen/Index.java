package com.sven.dream.common.module.screen;
 
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.sven.dream.base.BaseRender; 
import com.sven.dream.commonservice.vo.UserInformationVo;
import com.sven.dream.music.bo.AlbumBo;
import com.sven.dream.music.bo.MusicBo;
import com.sven.dream.user.bo.UserMappingBo; 

public class Index extends BaseRender{
	
	@Autowired
	private AlbumBo albumBo;
	
	@Autowired
	private MusicBo musicBo; 
	
	@Autowired
	private UserMappingBo userMappingBo;
	
	public void execute(Context context) throws Exception {
//		UserInformationVo user = getUser();
//		
//		context.put("newAlbumList", albumBo.getNewAlbumList());
//		context.put("musicList", musicBo.getNewSongList()); 
//		context.put("topMusicList", musicBo.getTopSongList()); 
//		context.put("mappingList", userMappingBo.getUserMappingVoList(user.getUserDo().getId())); 
	} 
}

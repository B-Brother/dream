package com.sven.dream.common.module.screen;
 

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.sven.dream.commonservice.biz.UserOperationService; 
import com.sven.dream.music.bo.AlbumBo;
import com.sven.dream.music.bo.MusicBo;
import com.sven.dream.user.bo.UserMappingBo; 

public class Index {
	
	@Autowired
	private AlbumBo albumBo;
	
	@Autowired
	private MusicBo musicBo;
	
	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UserMappingBo userMappingBo;
	
	public void execute(Context context) throws Exception {
		context.put("newAlbumList", albumBo.getNewAlbumList());
		 
	} 
}

package com.sven.dream.music.module.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.dal.music.MusicDo;
import com.sven.dream.music.bo.MusicBo;

public class MusicAction extends BaseRender{
	
	@Autowired
	private MusicBo musicBo;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	/**
	 * 音乐创建
	 * 
	 * @param nav
	 */
	public void doCreateMusic(Navigator nav){
		// 歌名
		String songName = getStringParamValue("songName");
		
		// 歌词
		String lyric = getStringParamValue("lyric");
		
		// 音乐时长
		int musicTime = getIntegerParamValue("musicTime");
		
		// 介绍
		String introduce = getStringParamValue("introduce");
		
		// 编曲
		String arranger = getStringParamValue("arranger");
		
		// 作曲
		String compose = getStringParamValue("compose");
		
		// 作词
		String authors = getStringParamValue("authors");
		
		// 封面主图
		long musicPagePicId = getLongParamValue("musicPagePicId");
		
		// 音乐附件
		long musicFileId = getLongParamValue("musicFileId");
		
		MusicDo musicDo = new MusicDo();
		musicDo.setArranger(arranger);
		musicDo.setSongName(songName);
		musicBo.insert(musicDo);
	}
}     





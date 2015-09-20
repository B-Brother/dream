package com.sven.dream.music.module.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.dal.common.FileDo;
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
		
		// 第一步: 插入音乐信息
		MusicDo music = new MusicDo();
		music.setArranger(arranger);
		music.setAuthors(authors);
		music.setClickGood(0);
		music.setCompose(compose);
		music.setIntroduce(introduce);
		music.setMusicTime(musicTime);
		music.setSingerId(getUser().getUserDo().getId());
		music.setSongLyric(lyric);
		music.setSongName(songName);
		musicBo.insert(music);
		 
		// 第二步: 更新音乐图片信息 
		FileDo updateDo = new FileDo();
		updateDo.setId(musicPagePicId);
		updateDo.setBusinessType(UploadConstants.BIZ_MUSIC_MAIN_PIC);
		updateDo.setStatus(UploadConstants.USE_EFFECT);
		updateDo.setBusinessId(music.getId());
		uploadFileService.update(updateDo);
		
		// 第三步: 更新附件信息 
		FileDo songFileDo = new FileDo();
		songFileDo.setId(musicFileId);
		songFileDo.setBusinessType(UploadConstants.BIZ_MUSIC_FILE);
		songFileDo.setStatus(UploadConstants.USE_EFFECT);
		songFileDo.setBusinessId(music.getId());
		uploadFileService.update(songFileDo);
		
		// 完成, 第四步跳转到详情页面
		try {
			response.sendRedirect("/music/detail.html?id=" + music.getId());
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}     





package com.sven.dream.music.vo;

import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.user.UserDo;

/**
 * 
 * 专辑视图对象
 * 
 * @author beckham
 *
 */
public class AlbumVo {
	
	// 专辑名称
    private String albumName;
    
    // 发行日期
    private String publishDateString;

    // 歌手
    private UserDo singer;
    
    // 专辑主图
    private FileDo albumFile;

    // 试听次数
    private Long tryListen;
 
    // 介绍
    private String introduce;

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public FileDo getAlbumFile() {
		return albumFile;
	}

	public void setAlbumFile(FileDo albumFile) {
		this.albumFile = albumFile;
	}

	public String getPublishDateString() {
		return publishDateString;
	}

	public void setPublishDateString(String publishDateString) {
		this.publishDateString = publishDateString;
	}

	public UserDo getSinger() {
		return singer;
	}

	public void setSinger(UserDo singer) {
		this.singer = singer;
	}

	public Long getTryListen() {
		return tryListen;
	}

	public void setTryListen(Long tryListen) {
		this.tryListen = tryListen;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}  
}

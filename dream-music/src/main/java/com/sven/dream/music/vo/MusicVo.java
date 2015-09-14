package com.sven.dream.music.vo;

import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.user.UserDo;

public class MusicVo {
	
	// 歌手
	private UserDo user;
	
	private FileDo userPicFile;
	
	// 歌曲主图
	private FileDo musicFile;
	
	// 歌名
	private String songName;  
	
	// 歌曲时间
	private String musicTime;

	public UserDo getUser() {
		return user;
	}

	public void setUser(UserDo user) {
		this.user = user;
	}

	public FileDo getUserPicFile() {
		return userPicFile;
	}

	public void setUserPicFile(FileDo userPicFile) {
		this.userPicFile = userPicFile;
	}

	public FileDo getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(FileDo musicFile) {
		this.musicFile = musicFile;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(String musicTime) {
		this.musicTime = musicTime;
	} 
}

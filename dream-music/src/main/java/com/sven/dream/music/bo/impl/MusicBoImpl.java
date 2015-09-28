package com.sven.dream.music.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.common.query.MusicQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.music.MusicDo;
import com.sven.dream.dal.music.mapper.MusicDoMapperExt;
import com.sven.dream.dal.user.UserDo;
import com.sven.dream.music.bo.MusicBo;
import com.sven.dream.music.util.MusicUtil; 
import com.sven.dream.music.vo.MusicVo;

public class MusicBoImpl extends
	AbstractDreamServiceImpl<MusicDo, MusicDoMapperExt> implements MusicBo{

	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UploadFileService fileService;
	
	@Autowired
    public void setBaseMapper(MusicDoMapperExt mapper) {
        setMapper(mapper);
    }

	@Override
	public List<MusicVo> getNewSongList() {
		List<MusicDo> musicList = mapper.getNewSongList();
		List<MusicVo> musicVoList = new ArrayList<MusicVo>();
		
		MusicVo musicVo = null;
		for(MusicDo music : musicList){
			musicVo = new MusicVo();
			musicVo.setUser(userOperationService.selectByPrimaryKey(music.getId()));
			musicVo.setSongName(music.getSongName());
			musicVo.setMusicTime(MusicUtil.convertViewSongTime(music.getMusicTime()));
			  
			// 设置附件信息。如果db没有附件，则mock出一个空文件来。
			List<FileDo> fileList = fileService.getFileListByBusiness(UploadConstants.BIZ_MUSIC_MAIN_PIC, music.getId());
			if(fileList == null || fileList.size() == 0){
				FileDo mockFile = new FileDo();
				mockFile.setUrl(fileService.getHttpPrefix() + "nopic.gif");
				musicVo.setMusicFile(mockFile);
			}else{
				musicVo.setMusicFile(fileList.get(0));
			}
			
			musicVoList.add(musicVo);
		}
		
		return musicVoList;
	}

	@Override
	public List<MusicVo> getTopSongList() {
		List<MusicDo> musicList = mapper.getTopSongList();
		
		List<MusicVo> musicVoList = new ArrayList<MusicVo>();
		
		MusicVo musicVo = null;
		for(MusicDo music : musicList){
			musicVo = new MusicVo();
			
			UserDo user = userOperationService.selectByPrimaryKey(music.getSingerId());
			musicVo.setUser(user);
			musicVo.setSongName(music.getSongName());  
			
			// 设置附件信息。如果db没有附件，则mock出一个空文件来。
			List<FileDo> musicFileList = fileService.getFileListByBusiness(UploadConstants.BIZ_MUSIC_MAIN_PIC, music.getId());
			if(musicFileList == null || musicFileList.size() == 0){
				FileDo mockFile = new FileDo();
				mockFile.setUrl(fileService.getHttpPrefix() + "nopic.gif");
				musicVo.setMusicFile(mockFile);
			}else{
				musicVo.setMusicFile(musicFileList.get(0));
			} 
			
			// 设置附件信息。如果db没有附件，则mock出一个空文件来。
			List<FileDo> fileUserPicList = fileService.getFileListByBusiness(UploadConstants.BIZ_MUSIC_MAIN_PIC, music.getId());
			if(fileUserPicList == null || fileUserPicList.size() == 0){
				FileDo mockFile = new FileDo();
				mockFile.setUrl(fileService.getHttpPrefix() + "nopic.gif");
				musicVo.setUserPicFile(mockFile);
			}else{
				musicVo.setUserPicFile(fileUserPicList.get(0));
			}
			
			musicVoList.add(musicVo);
		}
		
		return musicVoList;
	}

	@Override
	public MusicVo getMusicVoById(long id) {
		MusicDo music = selectByPrimaryKey(id);
		if(music == null){
			return null;
		}
		
		MusicVo musicVo = new MusicVo();
		musicVo.setUser(userOperationService.selectByPrimaryKey(music.getId()));
		musicVo.setSongName(music.getSongName());
		musicVo.setMusicTime(MusicUtil.convertViewSongTime(music.getMusicTime()));
		
		// 设置附件信息。如果db没有附件，则mock出一个空文件来。
		List<FileDo> fileList = fileService.getFileListByBusiness(UploadConstants.BIZ_MUSIC_MAIN_PIC, music.getId());
		if(fileList == null || fileList.size() == 0){
			FileDo mockFile = new FileDo();
			mockFile.setUrl(fileService.getHttpPrefix() + "nopic.gif");
			musicVo.setMusicFile(mockFile);
		}else{
			musicVo.setMusicFile(fileList.get(0));
		}
					
		return musicVo;
	}

	@Override
	public ResultBaseDo<List<MusicDo>> getMusicPagination(MusicQuery query) {
		ResultBaseDo<List<MusicDo>> rs = new ResultBaseDo<List<MusicDo>>();
		rs.setSuccess(false);
		  
	    List<MusicDo> musicPaginationList = mapper.getMusicListPagination(query);
	    int count = mapper.getMusicListCount(query);
	    
	    rs.setSuccess(true);
	    rs.setModule(musicPaginationList);
	    
	    query.setTotalCount(count);
	    rs.setQ(query);
	    return rs;
	}

	@Override
	public List<MusicVo> getMusicListByAlbum(long albumId) {
		List<MusicDo> musicList = mapper.getMusicListByAlbum(albumId);
		List<MusicVo> musicVoList = new ArrayList<MusicVo>();
		for(MusicDo music : musicList){
			musicVoList.add(getMusicVoById(music.getId()));
		}
		
		return musicVoList;
	}
}

























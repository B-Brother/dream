package com.sven.dream.music.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.common.query.AlbumQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.music.AlbumDo;
import com.sven.dream.dal.music.mapper.AlbumDoMapperExt;
import com.sven.dream.music.bo.AlbumBo;
import com.sven.dream.music.vo.AlbumVo;

public class AlbumBoImpl extends
	AbstractDreamServiceImpl<AlbumDo, AlbumDoMapperExt> implements AlbumBo{

	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UploadFileService fileService;
	
	@Autowired
    public void setBaseMapper(AlbumDoMapperExt mapper) {
        setMapper(mapper);
    }

	@SuppressWarnings("deprecation")
	@Override
	public List<AlbumVo> getNewAlbumList() {
		List<AlbumDo> albumList = mapper.getNewAlbumList();
		
		List<AlbumVo> albumVoList = new ArrayList<AlbumVo>();
		
		AlbumVo albumVo = null;
		for(AlbumDo album : albumList){
			albumVo = new AlbumVo();
			albumVo.setAlbumName(album.getAlbumName());
			albumVo.setIntroduce(album.getIntroduce());
			albumVo.setPublishDateString(album.getPublishDate().toLocaleString()); 
			albumVo.setSinger(userOperationService.selectByPrimaryKey(album.getSingerId())); 
			
			List<FileDo> fileList = fileService.getFileListByBusiness(UploadConstants.BIZ_ALBUM_MAIN_PIC, album.getId());
			if(fileList == null || fileList.size() == 0){
				// 针对没有主图的情况跳过
				continue;
			}
			albumVo.setAlbumFile(fileList.get(0));
			
			albumVo.setTryListen(album.getTryListen());
			
			albumVoList.add(albumVo);
		}
		
		return albumVoList;
	}

	@Override
	public ResultBaseDo<List<AlbumVo>> getAlbumPagination(AlbumQuery query) {
		ResultBaseDo<List<AlbumVo>> rs = new ResultBaseDo<List<AlbumVo>>();
		rs.setSuccess(false);
		  
	    List<AlbumDo> albumPaginationList = mapper.getAlbumListPagination(query);
	    List<AlbumVo> albumVoList = new ArrayList<AlbumVo>();
	    AlbumVo albumVo = null;
		for(AlbumDo album : albumPaginationList){
			albumVo = new AlbumVo();
			albumVo.setId(album.getId());
			albumVo.setAlbumName(album.getAlbumName());
			albumVo.setIntroduce(album.getIntroduce());
			albumVo.setPublishDateString(album.getPublishDate().toLocaleString()); 
			albumVo.setSinger(userOperationService.selectByPrimaryKey(album.getSingerId())); 
			
			// 设置附件信息。如果db没有附件，则mock出一个空文件来。
			List<FileDo> fileList = fileService.getFileListByBusiness(UploadConstants.BIZ_ALBUM_MAIN_PIC, album.getId());
			if(fileList == null || fileList.size() == 0){
				FileDo mockFile = new FileDo();
				mockFile.setUrl(fileService.getHttpPrefix() + "nopic.gif");
				albumVo.setAlbumFile(mockFile);
			}else{
				albumVo.setAlbumFile(fileList.get(0));
			}
			 
			albumVo.setTryListen(album.getTryListen());
			
			albumVoList.add(albumVo);
		}
		
	    int count = mapper.getAlbumListCount(query);
	    
	    rs.setSuccess(true);
	    rs.setModule(albumVoList);
	    
	    query.setTotalCount(count);
	    rs.setQ(query);
	    return rs;
	}
}










package com.sven.dream.music.bo;

import java.util.List;

import com.sven.dream.common.query.AlbumQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.music.AlbumDo;
import com.sven.dream.music.vo.AlbumVo;

public interface AlbumBo extends DreamBo<AlbumDo>{
 
	/**
	 * 给首页提供的最新专辑列表
	 * 
	 * @return
	 */
	public List<AlbumVo> getNewAlbumList();
	
	 
	/**
	 * 分页查询专辑列表
	 * 
	 * @param query
	 * @return
	 */
	public ResultBaseDo<List<AlbumVo>> getAlbumPagination(AlbumQuery query);
}

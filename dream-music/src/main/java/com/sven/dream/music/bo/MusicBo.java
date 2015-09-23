package com.sven.dream.music.bo;

import java.util.List;

import com.sven.dream.common.query.MusicQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.commonservice.DreamBo;
import com.sven.dream.dal.music.MusicDo; 
import com.sven.dream.music.vo.MusicVo;

public interface MusicBo extends DreamBo<MusicDo>{
	
	/**
	 * 给首页提供的最新歌曲列表
	 * 
	 * @return
	 */
	public List<MusicVo> getNewSongList();
	
	/**
	 * 给首页提供的top歌曲列表
	 * 
	 * @return
	 */
	public List<MusicVo> getTopSongList();
	
	/**
	 * 根据音乐ID拿到对应的vo,vo中还有更完善的信息
	 * 
	 * @param id
	 * @return
	 */
	public MusicVo getMusicVoById(long id);
	 
	/**
	 * 分页查询music列表
	 * 
	 * @param query
	 * @return
	 */
	public ResultBaseDo<List<MusicDo>> getMusicPagination(MusicQuery query);
	
	/**
     * 获取专辑下的歌曲根据专辑ID
     * 
     * @param albumId
     * @return
     */
    public List<MusicVo> getMusicListByAlbum(long albumId);
}

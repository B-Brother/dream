package com.sven.dream.music.module.screen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.enums.MusicConstants;
import com.sven.dream.common.query.AlbumQuery; 
import com.sven.dream.common.result.ResultBaseDo; 
import com.sven.dream.music.bo.AlbumBo;
import com.sven.dream.music.bo.MusicBo;
import com.sven.dream.music.vo.AlbumVo;

public class Find extends BaseRender{
	 
	@Autowired
	private MusicBo musicBo;
	
	@Autowired
	private AlbumBo albumBo;
	
	public void execute(Context context, Navigator nav) throws Exception {
		 String category = getStringParamValue("cg");
		 if(StringUtils.isNotBlank(category) && !MusicConstants.TYPELIST.contains(category)){
			 nav.redirectToLocation("/common/404.htm");
			 return;
		 }
		 
		 context.put("cg", category);
		 
		 Integer currentPage = getIntegerParamValue("cp");
		 if(currentPage == null){
			 currentPage = 1;
		 }
		 
		 context.put("cp", currentPage);
		 
		 AlbumQuery query = new AlbumQuery(18, currentPage);
		 query.setCurrentPage(currentPage);
		 query.setPageSize(18);
		 query.setCategory(category);  
		 
		 ResultBaseDo<List<AlbumVo>> albumPaginationList = albumBo.getAlbumPagination(query);
		 context.put("result", albumPaginationList);
	} 
}

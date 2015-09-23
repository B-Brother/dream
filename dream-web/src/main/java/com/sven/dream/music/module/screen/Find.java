package com.sven.dream.music.module.screen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.enums.MusicConstants;
import com.sven.dream.common.query.MusicQuery;
import com.sven.dream.common.result.ResultBaseDo;
import com.sven.dream.dal.music.MusicDo;
import com.sven.dream.music.bo.MusicBo;

public class Find extends BaseRender{
	 
	@Autowired
	private MusicBo musicBo;
	
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
		 
		 MusicQuery query = new MusicQuery();
		 query.setCurrentPage(currentPage);
		 query.setPageSize(18);
		 query.setCategory(category); 
		 
		 ResultBaseDo<List<MusicDo>> musicPaginationList = musicBo.getMusicPagination(query);
		 context.put("result", musicPaginationList);
	} 
}

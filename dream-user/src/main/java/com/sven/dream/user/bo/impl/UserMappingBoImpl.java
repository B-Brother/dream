package com.sven.dream.user.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.biz.UploadFileService;
import com.sven.dream.commonservice.biz.UserOperationService;
import com.sven.dream.commonservice.cache.GeographyCache;
import com.sven.dream.dal.common.FileDo;
import com.sven.dream.dal.user.UserDo;
import com.sven.dream.dal.user.UserMappingDo;
import com.sven.dream.dal.user.mapper.UserMappingDoMapperExt;
import com.sven.dream.user.bo.UserMappingBo;
import com.sven.dream.user.vo.UserMappingVo;

public class UserMappingBoImpl extends
	AbstractDreamServiceImpl<UserMappingDo, UserMappingDoMapperExt> implements UserMappingBo{

	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Autowired
	private GeographyCache geographyCache;
	
	@Autowired
    public void setBaseMapper(UserMappingDoMapperExt mapper) {
        setMapper(mapper);
    }

	@Override
	public List<UserMappingVo> getUserMappingVoList(Long followerId) {
		List<UserMappingDo> mappingList = mapper.getUserMappingList(followerId);
		
		List<UserMappingVo> mappingVoList = new ArrayList<UserMappingVo>();
		UserMappingVo mappingVo = null;
		for(UserMappingDo mapping : mappingList){
			mappingVo = new UserMappingVo();
			mappingVo.setFollower(userOperationService.selectByPrimaryKey(followerId));
			
			UserDo followerWho = userOperationService.selectByPrimaryKey(mapping.getFollowWho());
			mappingVo.setFollowerWho(followerWho);
			
			List<FileDo> fileList = uploadFileService.getFileListByBusiness(
					UploadConstants.BIZ_USER_MAIN_PIC, mapping.getFollowWho());
			if(fileList == null || fileList.size() == 0){
				// 针对没有主图的情况跳过
				continue;
			} 
			mappingVo.setFollowerWhoUserPic(fileList.get(0));
			
			String prov = geographyCache.getNameByProvinceCode(followerWho.getProvinceCode());
			String dist = geographyCache.getNameByProvinceCodeAndCityCoe(
					followerWho.getProvinceCode(), followerWho.getCityCode());
			mappingVo.setFollowerWhoPosition(prov + "," + dist);
			
			mappingVoList.add(mappingVo);
		}
		return mappingVoList;
	}
}

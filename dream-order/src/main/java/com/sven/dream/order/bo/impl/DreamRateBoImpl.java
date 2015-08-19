package com.sven.dream.order.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static com.sven.dream.common.constants.UploadConstants.*;

import com.sven.dream.commonservice.AbstractDreamServiceImpl;
import com.sven.dream.commonservice.service.UploadFileService;
import com.sven.dream.commonservice.service.UserOperationService; 
import com.sven.dream.commonservice.vo.DreamUserRateVo;
import com.sven.dream.dal.order.DreamRateDo; 
import com.sven.dream.dal.order.mapper.DreamRateDoMapperExt;
import com.sven.dream.order.bo.DreamRateBo;

public class DreamRateBoImpl extends AbstractDreamServiceImpl<DreamRateDo, DreamRateDoMapperExt> implements DreamRateBo{
   
	@Autowired
	private UserOperationService userOperationService;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Autowired
    public void setBaseMapper(DreamRateDoMapperExt mapper) {
        setMapper(mapper);
    }
	
	@Override
	public List<DreamRateDo> getRateBySkillId(long skillId) {
		return mapper.getRateBySkillId(skillId);
	}

	@Override
	public List<DreamUserRateVo> getRateDetailBySkillId(long skillId) {
		List<DreamUserRateVo> rateVoList = new ArrayList<DreamUserRateVo>();
		
		List<DreamRateDo> rateList = getRateBySkillId(skillId); 
		DreamUserRateVo rateVo = null;
		for(DreamRateDo rate : rateList){
			rateVo = new DreamUserRateVo();
			rateVo.setRate(rate); 
			
			rateVo.setUser(userOperationService.selectByPrimaryKey(rate.getUserId()));
			rateVo.setUserPic(uploadFileService.getFileListByTypeAndSpec(BIZ_TYPE_USER_PIC, rate.getUserId(), SPEC_PIC_48_48));
			
			rateVoList.add(rateVo);
		}
		
		return rateVoList;
	}
 
}

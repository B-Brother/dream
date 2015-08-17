package com.sven.dream.order.module.screen;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;  
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.commonservice.service.UploadFileService;
import com.sven.dream.commonservice.vo.DreamUserRateVo;
import com.sven.dream.dal.common.UploadFileDo; 
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.user.DreamUserExperienceDo;
import com.sven.dream.order.bo.DreamRateBo;
import com.sven.dream.order.bo.DreamSkillBo;
import com.sven.dream.user.bo.DreamUserExperienceBo;

public class Detail extends BaseRender{
	
	@Autowired
	private DreamSkillBo dreamSkillBo;
	
	@Autowired
	private DreamRateBo dreamRateBo;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Autowired
	private DreamUserExperienceBo dreamUserExperienceBo;
	
	public void execute(
			@Param("skillId") Long skillId, 
			Context context,
			Navigator nav){
		if(skillId == null || skillId <= 0){
			nav.redirectTo("500");
		}
 		// 技能
		DreamSkillDo skill = dreamSkillBo.selectByPrimaryKey(skillId);
		
		// 评价
		List<DreamUserRateVo> rateList = dreamRateBo.getRateDetailBySkillId(skillId);
		
		// 图片展示层
		List<UploadFileDo> fileList = uploadFileService.getFileListByType(UploadConstants.BIZ_TYPE_SKILL, (long)skill.getId());
		
		// 技能经验
		List<DreamUserExperienceDo> expList = dreamUserExperienceBo.getExperienceListByUser(getUser().getId());
		
		context.put("skill", skill);
		context.put("rateList", rateList);
		context.put("fileList", fileList);
		context.put("expList", expList);
	}
}








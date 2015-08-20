package com.sven.dream.order.module.screen;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;  
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.sven.dream.base.BaseRender;
import com.sven.dream.common.constants.UploadConstants;
import com.sven.dream.commonservice.cache.GeographyCache;
import com.sven.dream.commonservice.service.UploadFileService;
import com.sven.dream.commonservice.vo.AddressVo;
import com.sven.dream.commonservice.vo.DreamUserRateVo;
import com.sven.dream.commonservice.vo.SkillScheduleVo;
import com.sven.dream.dal.common.UploadFileDo; 
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.order.DreamSkillSkuDo;
import com.sven.dream.dal.user.DreamUserExperienceDo;
import com.sven.dream.order.bo.DreamRateBo;
import com.sven.dream.order.bo.DreamSkillBo;
import com.sven.dream.order.bo.DreamSkillSkuBo;
import com.sven.dream.user.bo.DreamUserExperienceBo;

public class Detail extends BaseRender{
	
	@Autowired
	private DreamSkillBo dreamSkillBo;
	
	@Autowired
	private DreamRateBo dreamRateBo;
	
	@Autowired
	private DreamSkillSkuBo dreamSkillSkuBo;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Autowired
	private DreamUserExperienceBo dreamUserExperienceBo;
	
	@Autowired
	private GeographyCache geographyCache;
	
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
		
		long schedule = skill.getSchedule();
		parseSchedule(context, schedule);
		
		// SKU
		List<DreamSkillSkuDo> skuList = dreamSkillSkuBo.getSkuBySkillId(skillId);
		context.put("skuList", skuList);
		
		// 解析详细地址输出
		parseAddress(skill, context); 
	}
	
	private void parseAddress(DreamSkillDo skill, Context context){
		AddressVo address = new AddressVo();
		address.setProvince(geographyCache.getNameByProvinceCode(skill.getProvinceCode()));
		address.setCity(geographyCache.getNameByProvinceCodeAndCityCoe(skill.getProvinceCode(), 
				skill.getCityCode()));
		address.setAddress(skill.getDetailAddress());
		context.put("address",address);
	}
	
	/**
	 * 计算行者什么时候有空
	 * 
	 * @param context
	 * @param schedule
	 */
	private void parseSchedule(Context context, long schedule){
		SkillScheduleVo scheduleVo = new SkillScheduleVo();
		scheduleVo.setSchedule1((schedule & 1) == 1);
		scheduleVo.setSchedule2((schedule & 2) == 2);
		scheduleVo.setSchedule3((schedule & 4) == 4);
		scheduleVo.setSchedule4((schedule & 8) == 8);
		scheduleVo.setSchedule5((schedule & 16) == 16);
		scheduleVo.setSchedule6((schedule & 32) == 32);
		scheduleVo.setSchedule7((schedule & 64) == 64);
		scheduleVo.setSchedule8((schedule & 128) == 128);
		scheduleVo.setSchedule9((schedule & 256) == 256);
		scheduleVo.setSchedule10((schedule & 512) == 512);
		scheduleVo.setSchedule11((schedule & 1024) == 1024);
		scheduleVo.setSchedule12((schedule & 2048) == 2048);
		scheduleVo.setSchedule13((schedule & 4096) == 4096);
		scheduleVo.setSchedule14((schedule & 8192) == 8192);
		scheduleVo.setSchedule15((schedule & 16384) == 16384);
		scheduleVo.setSchedule16((schedule & 32768) == 32768);
		scheduleVo.setSchedule17((schedule & 65536) == 65536);
		scheduleVo.setSchedule18((schedule & 131072) == 131072);
		scheduleVo.setSchedule19((schedule & 262144) == 262144);
		scheduleVo.setSchedule20((schedule & 524288) == 524288);
		scheduleVo.setSchedule21((schedule & 1048576) == 1048576);
		scheduleVo.setSchedule22((schedule & 2097152) == 2097152);
		scheduleVo.setSchedule23((schedule & 4194304) == 4194304);
		scheduleVo.setSchedule24((schedule & 8388608) == 8388608);
		scheduleVo.setSchedule25((schedule & 16777216) == 16777216);
		scheduleVo.setSchedule26((schedule & 33554432) == 33554432);
		scheduleVo.setSchedule27((schedule & 67108864) == 67108864);
		scheduleVo.setSchedule28((schedule & 134217728) == 134217728); 
		
		context.put("schedule", scheduleVo);
	}
}








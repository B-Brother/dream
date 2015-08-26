package com.sven.dream.manage.module.action;

import java.util.ArrayList; 
import java.util.Collections;
 
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator; 
import com.sven.dream.base.BaseRender;
import com.sven.dream.dal.order.DreamSkillDo;
import com.sven.dream.dal.order.DreamSkillSkuDo;
import com.sven.dream.order.bo.DreamSkillBo;
import com.sven.dream.order.bo.DreamSkillSkuBo;

public class SkillAction extends BaseRender{
	
	@Autowired
	private DreamSkillBo skillBo;
	
	@Autowired
	private DreamSkillSkuBo skillSkuBo;
	
	public void doSkillPublish(Navigator nav){
		String title = getStringParamValue("title");
		String subTitle = getStringParamValue("sub_title");
		String per = getStringParamValue("per");
		String introduce = getStringParamValue("introduce");
		String prov = getStringParamValue("prov");
		String city = getStringParamValue("dist"); 
		String address = getStringParamValue("address");
		String comeFee = getStringParamValue("come_fee");
		
		
		String[] skuCodeArray = request.getParameterValues("sku_code"); 
		String[] skuTitleArray = request.getParameterValues("sku_title"); 
		String[] priceArray = request.getParameterValues("price"); 
		
		if(skuCodeArray != null && skuTitleArray != null && priceArray != null){
			if((skuCodeArray.length == skuTitleArray.length) && (skuCodeArray.length == priceArray.length)){ 
				ArrayList<Long> priceList = new ArrayList<Long>();
				for(String ps : priceArray){
					priceList.add((long)(Double.parseDouble(ps) * 100));
				}
				
				Collections.sort(priceList);
				
				// 首先保存处理技能信息
				DreamSkillDo skillDo = new DreamSkillDo();
				skillDo.setCategory("");
				skillDo.setCityCode(city);
				skillDo.setProvinceCode(prov);
				skillDo.setComeFee((long)(Double.parseDouble(comeFee) * 100));
				skillDo.setDetailAddress(address);
				skillDo.setDownBoundPrice(priceList.get(0));
				skillDo.setIntroduce(introduce);
				skillDo.setNormalPrice(0L);   //这个normalPrice是不是在业务上可以废弃？
				skillDo.setOptions(0L);
				skillDo.setPer(per);
				skillDo.setSchedule(0L);
				skillDo.setSellerId(getUser().getId());
				skillDo.setSkillStatus(0);
				skillDo.setSoldQuantity(0L);
				skillDo.setSubTitle(subTitle);
				skillDo.setTitle(title);
				skillDo.setUpBoundPrice(priceList.get(priceList.size() - 1));
				skillBo.insert(skillDo);
				
				// 然后保存SKU 
				for (int i = 0; i < priceList.size(); i++) {
					DreamSkillSkuDo skuDo = new DreamSkillSkuDo();
					skuDo.setPrice(priceList.get(i));
					skuDo.setSellerId(getUser().getId());
					skuDo.setSkillId(skillDo.getId());
					skuDo.setSkuCode(skuCodeArray[i]);
					skuDo.setStatus(0);
					skuDo.setTitle(skuTitleArray[i]);
					skillSkuBo.insert(skuDo);
				}
				
				nav.redirectToLocation("/manage/publishSuccess.htm?id=" + skillDo.getId());
			}
		}  
	}  
	 
}


















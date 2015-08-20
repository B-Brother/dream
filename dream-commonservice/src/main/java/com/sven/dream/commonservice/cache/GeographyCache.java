package com.sven.dream.commonservice.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class GeographyCache {
	
	private final String SPLIT_SYMBOL = "-";
	
	private final String TAG_CITYLIST = "citylist";
	
	private final String TAG_P = "p";
	
	private final String TAG_C = "c";
	
	private final String TAG_N = "n";
	
	private JSONObject result = null;
	
	public JSONObject getResult() {
		return result;
	}
	
	@Resource(name="provinceDistrictMap")
	private LinkedHashMap<String, String> provinceDistrictMap;
	
	/**
	 * 
	 * 类似这样的结构。
	 * {
		    "citylist": [
		        {
		            "p": "北京-xxx",
		            "c": [
		                {
		                    "n": "东城区"
		                },
		                {
		                    "n": "西城区"
		                } 
		            ]
		        },
		        {
		            "p": "天津",
		            "c": [
		                {
		                    "n": "和平区"
		                },
		                {
		                    "n": "河东区"
		                }
		            ]
		        } 
		    ]
		}
	 */
	public void init(){ 
		// 获取省份code
		List<String> provinceList = new ArrayList<String>();
		for(Map.Entry<String, String> entry : provinceDistrictMap.entrySet()){
			String key = entry.getKey(); 
			 
			if(!key.contains(SPLIT_SYMBOL)){
				provinceList.add(key);
			}
		}
		
		// 关联
		Map<String, List<String>> relationMap = new LinkedHashMap<String, List<String>>();
		
		for(String province : provinceList){
			
			List<String> distrctList = new ArrayList<String>();
			for(Map.Entry<String, String> entry : provinceDistrictMap.entrySet()){ 
				String key = entry.getKey(); 
				
				if(key.contains(SPLIT_SYMBOL) && key.startsWith(province)){
					distrctList.add(key.substring(key.lastIndexOf(SPLIT_SYMBOL) + 1));
				}
			}
			
			relationMap.put(province, distrctList);
		} 
		
		// 开始组装我们需要的JSON格式
		JSONObject finallyObject = new JSONObject();
		
		JSONArray lastArray = new JSONArray(); 
		
		/**
		 * "c": [
                [
                    {
                        "n": "昌平-C110100"
                    }
                ],
                [
                    {
                        "n": "朝阳-C110200"
                    }
                ],
		 */
		for(Map.Entry<String, List<String>> entry : relationMap.entrySet()){ 
			  
			JSONObject pcObject = new JSONObject();
			pcObject.put(TAG_P, getValueByKey(entry.getKey()) + SPLIT_SYMBOL + entry.getKey());
			
			JSONArray outObject = new JSONArray();
			for(String val : entry.getValue()){
				JSONObject finalInnerObject = new JSONObject();
				finalInnerObject.put(TAG_N, getValueByKey(val) + SPLIT_SYMBOL + val);
				  
				
				outObject.add(finalInnerObject);
			}
			
			pcObject.put(TAG_C, outObject);
			
			lastArray.add(pcObject);
		} 
		
		finallyObject.put(TAG_CITYLIST, lastArray);
		
		result = finallyObject; 
	} 
	
	private String getValueByKey(String key){
		if(key.contains(SPLIT_SYMBOL)){
			for(Map.Entry<String, String> entry : provinceDistrictMap.entrySet()){
				if(entry.getKey().equals(key)){
					return entry.getValue();
				}
			}
		}else{
			for(Map.Entry<String, String> entry : provinceDistrictMap.entrySet()){
				if(entry.getKey().endsWith(key)){
					return entry.getValue();
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 获取省名称
	 * 
	 * @param provinceCode
	 * @return
	 */
	public String getNameByProvinceCode(String provinceCode){
		return provinceDistrictMap.get(provinceCode);
	}
	
	public String getNameByProvinceCodeAndCityCoe(String provinceCode, String cityCode){
		return provinceDistrictMap.get(provinceCode + SPLIT_SYMBOL + cityCode);
	}
} 
















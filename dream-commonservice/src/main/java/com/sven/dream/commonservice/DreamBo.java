package com.sven.dream.commonservice;
 
import com.sven.dream.base.entity.DreamDo;
 
public interface DreamBo<D extends DreamDo> {
	void insert(D dataObject); 
	  
	int update(D dataObject);
	  
	D selectByPrimaryKey(Long id);
  
	boolean isValidDo(D dataObject);
}

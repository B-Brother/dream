package com.sven.dream.commonservice;
 
import com.sven.dream.base.entity.DreamDo;
 
public interface DreamBo<D extends DreamDo> {
	int insert(D dataObject);

	int delete(Long id);
	  
	int update(D dataObject);
	  
	D selectByPrimaryKey(Long id);
  
	boolean isValidDo(D dataObject);
}

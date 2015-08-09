package com.sven.dream.base.entity;

public interface DreamMapper<D extends DreamDo> {
	  
    int deleteByPrimaryKey(Long id);
 
    int insert(D record);
 
    int insertSelective(D record);
 
    D selectByPrimaryKey(Long id);
 
    int updateByPrimaryKeySelective(D record);
 
    int updateByPrimaryKey(D record);
}

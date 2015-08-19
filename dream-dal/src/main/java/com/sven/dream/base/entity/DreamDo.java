package com.sven.dream.base.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DreamDo {
	 
    private Long id;
 
    private Date gmtCreate;
 
    private String creator;
 
    private Date gmtModified;
 
    private String modifier;
 
    private String isDeleted;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	} 
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}









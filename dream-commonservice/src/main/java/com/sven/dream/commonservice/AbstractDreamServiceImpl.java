package com.sven.dream.commonservice;

import java.util.Date;
 
import com.sven.dream.base.entity.DreamDo;
import com.sven.dream.base.entity.DreamMapper;
 

public class AbstractDreamServiceImpl<D extends DreamDo, K extends DreamMapper<D>> {

    protected K             mapper; 
      
    public void setMapper(K mapper) {
        this.mapper = mapper;
    }

    /**
     * 插入DreamDo对象
     * 
     * @param dataObject
     * @return
     */
    public void insert(D dataObject) {
        if (isValidDo(dataObject)) {
            dataObject.setCreator("system");
            dataObject.setModifier("system");
            dataObject.setIsDeleted("n");
            dataObject.setGmtCreate(new Date());
            dataObject.setGmtModified(new Date());
            mapper.insertSelective(dataObject); 
        } else {
            throw new RuntimeException("Invalid do:" + dataObject.toString());
        }
    } 

    /**
     * 根据主键查询到DreamDo
     * 
     * @param id
     * @return
     */
    public D selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 模糊根据主键id更新DreamDo
     * 
     * @param dataObject
     * @return
     */
    public int update(D dataObject) {
        if (isValidDo(dataObject)) {
            dataObject.setGmtModified(new Date());
            dataObject.setModifier("system");
            int v = mapper.updateByPrimaryKeySelective(dataObject);
            return v;
        } else {
            throw new RuntimeException("Invalid do:" + dataObject.toString());
        }
    }

    public boolean isValidDo(D dataObject) {
        return true;
    }
}
package com.sven.dream.dal.blog;
 
import com.sven.dream.base.entity.DreamDo;

public class BlogCategoryDo extends DreamDo{
     
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_blog_category.USER_ID
     *
     * @mbggenerated Thu Sep 10 23:32:18 CST 2015
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_blog_category.NAME
     *
     * @mbggenerated Thu Sep 10 23:32:18 CST 2015
     */
    private String name;
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_blog_category.USER_ID
     *
     * @return the value of musik_blog_category.USER_ID
     *
     * @mbggenerated Thu Sep 10 23:32:18 CST 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_blog_category.USER_ID
     *
     * @param userId the value for musik_blog_category.USER_ID
     *
     * @mbggenerated Thu Sep 10 23:32:18 CST 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_blog_category.NAME
     *
     * @return the value of musik_blog_category.NAME
     *
     * @mbggenerated Thu Sep 10 23:32:18 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_blog_category.NAME
     *
     * @param name the value for musik_blog_category.NAME
     *
     * @mbggenerated Thu Sep 10 23:32:18 CST 2015
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
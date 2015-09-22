package com.sven.dream.dal.music;

import com.sven.dream.base.entity.DreamDo;

public class CollectDo extends DreamDo{
     
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_collect.BUSINESS_ID
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    private Long businessId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_collect.BUSINESS_TYPE
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    private String businessType;
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_collect.USER_ID
     *
     * @return the value of musik_collect.USER_ID
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_collect.USER_ID
     *
     * @param userId the value for musik_collect.USER_ID
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_collect.BUSINESS_ID
     *
     * @return the value of musik_collect.BUSINESS_ID
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_collect.BUSINESS_ID
     *
     * @param businessId the value for musik_collect.BUSINESS_ID
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_collect.BUSINESS_TYPE
     *
     * @return the value of musik_collect.BUSINESS_TYPE
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_collect.BUSINESS_TYPE
     *
     * @param businessType the value for musik_collect.BUSINESS_TYPE
     *
     * @mbggenerated Sun Sep 20 18:17:53 CST 2015
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}
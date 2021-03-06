package com.sven.dream.dal.user;

import java.util.Date;

import com.sven.dream.base.entity.DreamDo;

public class UserEventDo extends DreamDo{
     
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_event.USER_ID
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_event.EVENT_TYPE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private Integer eventType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_event.BUSINESS_TYPE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private Integer businessType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_event.EVENT_HAPPEN
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private Date eventHappen;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_event.SIMPLE_INTRODUCE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private String simpleIntroduce;
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_event.USER_ID
     *
     * @return the value of musik_user_event.USER_ID
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_event.USER_ID
     *
     * @param userId the value for musik_user_event.USER_ID
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_event.EVENT_TYPE
     *
     * @return the value of musik_user_event.EVENT_TYPE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public Integer getEventType() {
        return eventType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_event.EVENT_TYPE
     *
     * @param eventType the value for musik_user_event.EVENT_TYPE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_event.BUSINESS_TYPE
     *
     * @return the value of musik_user_event.BUSINESS_TYPE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_event.BUSINESS_TYPE
     *
     * @param businessType the value for musik_user_event.BUSINESS_TYPE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_event.EVENT_HAPPEN
     *
     * @return the value of musik_user_event.EVENT_HAPPEN
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public Date getEventHappen() {
        return eventHappen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_event.EVENT_HAPPEN
     *
     * @param eventHappen the value for musik_user_event.EVENT_HAPPEN
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setEventHappen(Date eventHappen) {
        this.eventHappen = eventHappen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_event.SIMPLE_INTRODUCE
     *
     * @return the value of musik_user_event.SIMPLE_INTRODUCE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public String getSimpleIntroduce() {
        return simpleIntroduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_event.SIMPLE_INTRODUCE
     *
     * @param simpleIntroduce the value for musik_user_event.SIMPLE_INTRODUCE
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setSimpleIntroduce(String simpleIntroduce) {
        this.simpleIntroduce = simpleIntroduce == null ? null : simpleIntroduce.trim();
    }
}
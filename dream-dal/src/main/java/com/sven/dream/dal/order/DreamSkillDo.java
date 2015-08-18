package com.sven.dream.dal.order;

import com.sven.dream.base.entity.DreamDo;

public class DreamSkillDo extends DreamDo{ 
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.TITLE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.SUB_TITLE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String subTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.SKILL_STATUS
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Integer skillStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.DOWN_BOUND_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long downBoundPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.UP_BOUND_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long upBoundPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.NORMAL_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long normalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.PER
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String per;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.CATEGORY
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.PROPERTIES
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String properties;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.OPTIONS
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long options;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.SELLER_ID
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long sellerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.INTRODUCE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String introduce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.SOLD_QUANTITY
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long soldQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.PROVINCE_CODE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.CITY_CODE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.COME_FEE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long comeFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_skill.SCHEDULE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    private Long schedule;
  
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.TITLE
     *
     * @return the value of dream_skill.TITLE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.TITLE
     *
     * @param title the value for dream_skill.TITLE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.SUB_TITLE
     *
     * @return the value of dream_skill.SUB_TITLE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.SUB_TITLE
     *
     * @param subTitle the value for dream_skill.SUB_TITLE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.SKILL_STATUS
     *
     * @return the value of dream_skill.SKILL_STATUS
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Integer getSkillStatus() {
        return skillStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.SKILL_STATUS
     *
     * @param skillStatus the value for dream_skill.SKILL_STATUS
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setSkillStatus(Integer skillStatus) {
        this.skillStatus = skillStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.DOWN_BOUND_PRICE
     *
     * @return the value of dream_skill.DOWN_BOUND_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getDownBoundPrice() {
        return downBoundPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.DOWN_BOUND_PRICE
     *
     * @param downBoundPrice the value for dream_skill.DOWN_BOUND_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setDownBoundPrice(Long downBoundPrice) {
        this.downBoundPrice = downBoundPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.UP_BOUND_PRICE
     *
     * @return the value of dream_skill.UP_BOUND_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getUpBoundPrice() {
        return upBoundPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.UP_BOUND_PRICE
     *
     * @param upBoundPrice the value for dream_skill.UP_BOUND_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setUpBoundPrice(Long upBoundPrice) {
        this.upBoundPrice = upBoundPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.NORMAL_PRICE
     *
     * @return the value of dream_skill.NORMAL_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getNormalPrice() {
        return normalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.NORMAL_PRICE
     *
     * @param normalPrice the value for dream_skill.NORMAL_PRICE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setNormalPrice(Long normalPrice) {
        this.normalPrice = normalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.PER
     *
     * @return the value of dream_skill.PER
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getPer() {
        return per;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.PER
     *
     * @param per the value for dream_skill.PER
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setPer(String per) {
        this.per = per == null ? null : per.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.CATEGORY
     *
     * @return the value of dream_skill.CATEGORY
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.CATEGORY
     *
     * @param category the value for dream_skill.CATEGORY
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.PROPERTIES
     *
     * @return the value of dream_skill.PROPERTIES
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getProperties() {
        return properties;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.PROPERTIES
     *
     * @param properties the value for dream_skill.PROPERTIES
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setProperties(String properties) {
        this.properties = properties == null ? null : properties.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.OPTIONS
     *
     * @return the value of dream_skill.OPTIONS
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getOptions() {
        return options;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.OPTIONS
     *
     * @param options the value for dream_skill.OPTIONS
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setOptions(Long options) {
        this.options = options;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.SELLER_ID
     *
     * @return the value of dream_skill.SELLER_ID
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.SELLER_ID
     *
     * @param sellerId the value for dream_skill.SELLER_ID
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.INTRODUCE
     *
     * @return the value of dream_skill.INTRODUCE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.INTRODUCE
     *
     * @param introduce the value for dream_skill.INTRODUCE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.SOLD_QUANTITY
     *
     * @return the value of dream_skill.SOLD_QUANTITY
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.SOLD_QUANTITY
     *
     * @param soldQuantity the value for dream_skill.SOLD_QUANTITY
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.PROVINCE_CODE
     *
     * @return the value of dream_skill.PROVINCE_CODE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.PROVINCE_CODE
     *
     * @param provinceCode the value for dream_skill.PROVINCE_CODE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.CITY_CODE
     *
     * @return the value of dream_skill.CITY_CODE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.CITY_CODE
     *
     * @param cityCode the value for dream_skill.CITY_CODE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.COME_FEE
     *
     * @return the value of dream_skill.COME_FEE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getComeFee() {
        return comeFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.COME_FEE
     *
     * @param comeFee the value for dream_skill.COME_FEE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setComeFee(Long comeFee) {
        this.comeFee = comeFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_skill.SCHEDULE
     *
     * @return the value of dream_skill.SCHEDULE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public Long getSchedule() {
        return schedule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_skill.SCHEDULE
     *
     * @param schedule the value for dream_skill.SCHEDULE
     *
     * @mbggenerated Tue Aug 18 20:51:29 CST 2015
     */
    public void setSchedule(Long schedule) {
        this.schedule = schedule;
    }
}
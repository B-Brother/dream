package com.sven.dream.dal.common;

import com.sven.dream.base.entity.DreamDo;

public class FileDo extends DreamDo{
     
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_file.BUSINESS_ID
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    private Long businessId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_file.BUSINESS_TYPE
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    private String businessType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_file.FILE_NAME
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    private String fileName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_file.URL
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_file.STATUS
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_file.STORAGE_TYPE
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    private String storageType;
  
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_file.BUSINESS_ID
     *
     * @return the value of musik_file.BUSINESS_ID
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_file.BUSINESS_ID
     *
     * @param businessId the value for musik_file.BUSINESS_ID
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_file.BUSINESS_TYPE
     *
     * @return the value of musik_file.BUSINESS_TYPE
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_file.BUSINESS_TYPE
     *
     * @param businessType the value for musik_file.BUSINESS_TYPE
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_file.FILE_NAME
     *
     * @return the value of musik_file.FILE_NAME
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_file.FILE_NAME
     *
     * @param fileName the value for musik_file.FILE_NAME
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_file.URL
     *
     * @return the value of musik_file.URL
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_file.URL
     *
     * @param url the value for musik_file.URL
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_file.STATUS
     *
     * @return the value of musik_file.STATUS
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_file.STATUS
     *
     * @param status the value for musik_file.STATUS
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_file.STORAGE_TYPE
     *
     * @return the value of musik_file.STORAGE_TYPE
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public String getStorageType() {
        return storageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_file.STORAGE_TYPE
     *
     * @param storageType the value for musik_file.STORAGE_TYPE
     *
     * @mbggenerated Thu Sep 10 21:33:08 CST 2015
     */
    public void setStorageType(String storageType) {
        this.storageType = storageType == null ? null : storageType.trim();
    }
}
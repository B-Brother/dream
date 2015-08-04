package com.sven.dream.dal.common;
 
import com.sven.dream.base.entity.DreamDo;

public class UploadFileDo extends DreamDo{

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.BUSINESS_ID
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private Long businessId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.BUSINESS_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private String businessType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.FILE_NAME
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private String fileName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.URL
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.STATUS
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.STORAGE_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private String storageType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UPLOAD_FILE.SIZE_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    private String sizeType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.BUSINESS_ID
     *
     * @return the value of UPLOAD_FILE.BUSINESS_ID
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public Long getBusinessId() {
        return businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.BUSINESS_ID
     *
     * @param businessId the value for UPLOAD_FILE.BUSINESS_ID
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.BUSINESS_TYPE
     *
     * @return the value of UPLOAD_FILE.BUSINESS_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.BUSINESS_TYPE
     *
     * @param businessType the value for UPLOAD_FILE.BUSINESS_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.FILE_NAME
     *
     * @return the value of UPLOAD_FILE.FILE_NAME
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.FILE_NAME
     *
     * @param fileName the value for UPLOAD_FILE.FILE_NAME
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.URL
     *
     * @return the value of UPLOAD_FILE.URL
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.URL
     *
     * @param url the value for UPLOAD_FILE.URL
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.STATUS
     *
     * @return the value of UPLOAD_FILE.STATUS
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.STATUS
     *
     * @param status the value for UPLOAD_FILE.STATUS
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.STORAGE_TYPE
     *
     * @return the value of UPLOAD_FILE.STORAGE_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public String getStorageType() {
        return storageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.STORAGE_TYPE
     *
     * @param storageType the value for UPLOAD_FILE.STORAGE_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setStorageType(String storageType) {
        this.storageType = storageType == null ? null : storageType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UPLOAD_FILE.SIZE_TYPE
     *
     * @return the value of UPLOAD_FILE.SIZE_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public String getSizeType() {
        return sizeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UPLOAD_FILE.SIZE_TYPE
     *
     * @param sizeType the value for UPLOAD_FILE.SIZE_TYPE
     *
     * @mbggenerated Tue Aug 04 17:11:32 CST 2015
     */
    public void setSizeType(String sizeType) {
        this.sizeType = sizeType == null ? null : sizeType.trim();
    }
}
package com.sven.dream.dal.user;
 
import com.sven.dream.base.entity.DreamDo;

public class UserMappingDo extends DreamDo{
     
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_mapping.FOLLOWER
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private Long follower;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column musik_user_mapping.FOLLOW_WHO
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    private Long followWho;
 
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_mapping.FOLLOWER
     *
     * @return the value of musik_user_mapping.FOLLOWER
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public Long getFollower() {
        return follower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_mapping.FOLLOWER
     *
     * @param follower the value for musik_user_mapping.FOLLOWER
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setFollower(Long follower) {
        this.follower = follower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column musik_user_mapping.FOLLOW_WHO
     *
     * @return the value of musik_user_mapping.FOLLOW_WHO
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public Long getFollowWho() {
        return followWho;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column musik_user_mapping.FOLLOW_WHO
     *
     * @param followWho the value for musik_user_mapping.FOLLOW_WHO
     *
     * @mbggenerated Thu Sep 10 21:53:07 CST 2015
     */
    public void setFollowWho(Long followWho) {
        this.followWho = followWho;
    }
}
package com.bt.shopguide.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Malls implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.id
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.name
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.domain
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private String domain;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.logo_image_url
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private String logoImageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.seq
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private Integer seq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.create_time
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MALLS.update_time
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.id
     *
     * @return the value of MALLS.id
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.id
     *
     * @param id the value for MALLS.id
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.name
     *
     * @return the value of MALLS.name
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.name
     *
     * @param name the value for MALLS.name
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.domain
     *
     * @return the value of MALLS.domain
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public String getDomain() {
        return domain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.domain
     *
     * @param domain the value for MALLS.domain
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.logo_image_url
     *
     * @return the value of MALLS.logo_image_url
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.logo_image_url
     *
     * @param logoImageUrl the value for MALLS.logo_image_url
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl == null ? null : logoImageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.seq
     *
     * @return the value of MALLS.seq
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.seq
     *
     * @param seq the value for MALLS.seq
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.create_time
     *
     * @return the value of MALLS.create_time
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.create_time
     *
     * @param createTime the value for MALLS.create_time
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MALLS.update_time
     *
     * @return the value of MALLS.update_time
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MALLS.update_time
     *
     * @param updateTime the value for MALLS.update_time
     *
     * @mbggenerated Wed Sep 27 17:49:16 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private String nation;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
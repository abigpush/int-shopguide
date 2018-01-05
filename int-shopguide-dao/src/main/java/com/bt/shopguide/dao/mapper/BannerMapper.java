package com.bt.shopguide.dao.mapper;

import com.bt.shopguide.dao.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BANNER
     *
     * @mbggenerated Tue Dec 26 11:26:31 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BANNER
     *
     * @mbggenerated Tue Dec 26 11:26:31 CST 2017
     */
    int insert(Banner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BANNER
     *
     * @mbggenerated Tue Dec 26 11:26:31 CST 2017
     */
    int insertSelective(Banner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BANNER
     *
     * @mbggenerated Tue Dec 26 11:26:31 CST 2017
     */
    Banner selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BANNER
     *
     * @mbggenerated Tue Dec 26 11:26:31 CST 2017
     */
    int updateByPrimaryKeySelective(Banner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BANNER
     *
     * @mbggenerated Tue Dec 26 11:26:31 CST 2017
     */
    int updateByPrimaryKey(Banner record);

    List<Banner> getBanner(@Param("type") String type, @Param("n") Integer n);
}
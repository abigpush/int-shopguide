package com.bt.shopguide.dao.mapper;

import com.bt.shopguide.dao.entity.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COUPONS
     *
     * @mbggenerated Thu Nov 23 09:52:30 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COUPONS
     *
     * @mbggenerated Thu Nov 23 09:52:30 CST 2017
     */
    int insert(Coupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COUPONS
     *
     * @mbggenerated Thu Nov 23 09:52:30 CST 2017
     */
    int insertSelective(Coupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COUPONS
     *
     * @mbggenerated Thu Nov 23 09:52:30 CST 2017
     */
    Coupon selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COUPONS
     *
     * @mbggenerated Thu Nov 23 09:52:30 CST 2017
     */
    int updateByPrimaryKeySelective(Coupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COUPONS
     *
     * @mbggenerated Thu Nov 23 09:52:30 CST 2017
     */
    int updateByPrimaryKey(Coupon record);

    List<Coupon> selectPage(Map map);
    int getTotalCount(Map map);
    List<Coupon> selectTodayCoupon();
}
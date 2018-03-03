package com.cch.seckill.dao;

import com.cch.seckill.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 22:02.
 */

@Mapper
@Component(value = "miaoshaUserDao")
public interface MiaoshaUserDao {

    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(@Param("id")long id);
}

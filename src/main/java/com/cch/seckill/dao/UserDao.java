package com.cch.seckill.dao;

import com.cch.seckill.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by 459105408@qq.com
 * 2018-03-03 13:47.
 */
@Mapper
/**
 * 可以不加只是为了 在IDEA中不在提示 找不到userDao
 */
@Component(value = "userDao")
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") int id);
    @Insert("insert into user(id,name)values(#{id},#{name})")
    public int insert(User user);
}

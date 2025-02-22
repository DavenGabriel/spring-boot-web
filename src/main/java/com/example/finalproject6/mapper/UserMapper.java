package com.example.finalproject6.mapper;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    @Select("select * from user where userId=#{userId}")
    User findById(Integer userId);

    @Select("select * from user")
    List<User> getALL();

    @Insert("insert into user(username,password,phoneNumber,address,email,userPic,create_time,update_time)" +
            " values(#{username},#{password},#{phoneNumber},#{address},#{email},'/image/3135715.png',now(),now())")
    void add(String username, String password, String phoneNumber, String address, String email);

    @Update("update user set username=#{username},phoneNumber=#{phoneNumber},address=#{address},email=#{email}, update_time=now()  where userId=#{userId}")
    void update(User user);

    @Delete("delete from user where userId = #{userId}")
    void delete(Integer userId);
}

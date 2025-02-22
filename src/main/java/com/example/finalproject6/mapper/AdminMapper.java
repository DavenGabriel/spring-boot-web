package com.example.finalproject6.mapper;

import com.example.finalproject6.pojo.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from item where username=#{name}")
    Item findByUserName(String name);

    @Select("select * from item where itemId=#{itemId}")
    Item findById(Integer itemId);

    @Select("select * from item where category=#{category}")
    Item findByCategory(String category);

    @Select("select * from item")
    List<Item> getALL();

    @Select("SELECT * FROM item ORDER BY RAND() LIMIT 9")
    List<Item> getAllRandom();

    @Insert("insert into item(name,category,price,itemPic,create_item,update_item)" +
            " values(#{name},#{category},#{price},#{itemPic},now(),now())")
    void add(Item item);

    @Update("update item set name=#{name},category=#{category},price=#{price},itemPic=#{itemPic},update_item=now() " +
            "where itemId=#{itemId}")
    void update(Item item);

    @Delete("delete from item where itemId = #{itemId}")
    void delete(Integer itemId);

    @Select("SELECT * FROM item WHERE category = #{category}")
    List<Item> getItemsByCategory(String category);
}

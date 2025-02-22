package com.example.finalproject6.mapper;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.pojo.Transaction;
import com.example.finalproject6.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Insert("INSERT INTO transaction (userId, itemId, date) VALUES (#{userId}, #{itemId}, now())")
    void addItemToCart(Transaction transaction);

    @Select("select * from item where itemId=#{itemId}")
    Item findById(Integer itemId);

    @Select("select t.transactionId, i.name, i.category, i.price, i.itemPic " +
            "from transaction t join item i on t.itemId = i.itemId join user u on t.userId = u.userId")
    List<Transaction> showCart(Integer userId);

    @Delete("delete from transaction where transactionId = #{transactionId}")
    void delete(Integer transactionId);
}

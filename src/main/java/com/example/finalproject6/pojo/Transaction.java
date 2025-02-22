package com.example.finalproject6.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private Integer transactionId;
    private Integer itemId;
    private Integer userId;
    private String name;
    private String itemPic;
    private String price;
    private String category;

    @DateTimeFormat(pattern = "YYYY-MM-DD ")
    private LocalDateTime date;//创建时间

}

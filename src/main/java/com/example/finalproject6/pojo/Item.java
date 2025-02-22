package com.example.finalproject6.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Item {
    private Integer itemId;
    private String name;
    private String category;
    private String price;
    private String itemPic;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDateTime createItem;//创建时间
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDateTime updateItem;//更新时间
}

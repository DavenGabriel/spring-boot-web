package com.example.finalproject6.pojo;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
public class User {

    private Integer userId;
    private String username;
    private String password;
    private Integer phoneNumber;
    private String address;
    private String email;
    private String userPic;

    @DateTimeFormat(pattern = "YYYY-MM-DD ")
    private LocalDateTime createTime;//创建时间
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDateTime updateTime;//更新时间
}

package com.example.finalproject6.pojo;


import lombok.Data;

@Data
public class UserVo {
    private Integer userId;
    private String username;
    private Integer phoneNumber;
    private String address;
    private String email;
    private String userPic;
    private String createTime;
}

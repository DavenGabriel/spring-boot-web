package com.example.finalproject6.service;

import com.example.finalproject6.DesignPattern.TemplateMethodPattern.AbstractCRUDService;
import com.example.finalproject6.mapper.UserMapper;
import com.example.finalproject6.pojo.User;
import com.example.finalproject6.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractCRUDService<User> {
    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    public void register(String username, String password, String phoneNumber, String address, String email) {
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(username, md5String, phoneNumber, address, email);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getALL();
    }

    @Override
    public User findItemById(Integer userId) {
        User u = userMapper.findById(userId);
        return u;
    }

    @Override
    public void addItem(User entity) {

    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void delete(Integer userId) {
        userMapper.delete(userId);
    }
}

package com.example.finalproject6.service;

import com.example.finalproject6.DesignPattern.BuilderPattern.Item_Builder;
import com.example.finalproject6.DesignPattern.TemplateMethodPattern.AbstractCRUDService;
import com.example.finalproject6.mapper.AdminMapper;
import com.example.finalproject6.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminServiceImpl extends AbstractCRUDService<Item> {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Item findItemById(Integer itemId) {
        return adminMapper.findById(itemId);
    }
    @Override
    public List<Item> getAll() {
        return adminMapper.getALL();
    }

    @Override
    public void addItem(Item item) {
        Item addItem = new Item_Builder()
                .setName(item.getName())
                .setCategory(item.getCategory())
                .setPrice(item.getPrice())
                .setItemPic(item.getItemPic())
                .build();
        item.setCreateItem(LocalDateTime.now());
        item.setUpdateItem(LocalDateTime.now());
        adminMapper.add(addItem);
    }

    @Override
    public void delete(Integer itemId) {
        adminMapper.delete(itemId);
    }

    @Override
    public void update(Item item) {
        adminMapper.update(item);
    }

    public List<Item> getItemsByCategory(String category) {
        return adminMapper.getItemsByCategory(category);
    }

    public List<Item> getAllRandom() {
        return adminMapper.getAllRandom();
    }

    public Item findByUserName(String name) {
        Item i = adminMapper.findByUserName(name);
        return i;
    }

    public Item findByCategory(String category) {
        Item i = adminMapper.findByCategory(category);
        return i;
    }
}

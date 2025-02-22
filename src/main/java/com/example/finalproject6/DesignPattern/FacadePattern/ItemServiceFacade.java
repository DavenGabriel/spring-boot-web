package com.example.finalproject6.DesignPattern.FacadePattern;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceFacade {

    @Autowired
    private AdminServiceImpl adminService;

    public void add(Item item) {
        adminService.addItem(item);
    }

    public void update(Item item) {
        adminService.update(item);
    }

    public void delete(Integer itemId) {
        adminService.delete(itemId);
    }

    public Item findItemById(Integer itemId) {
        return adminService.findItemById(itemId);
    }

    public List<Item> getAll() {
        return adminService.getAll();
    }
}


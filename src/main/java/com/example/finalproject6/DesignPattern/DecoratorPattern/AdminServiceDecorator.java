package com.example.finalproject6.DesignPattern.DecoratorPattern;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.service.AdminServiceImpl;

import java.util.List;

public abstract class AdminServiceDecorator extends AdminServiceImpl {
    protected AdminServiceImpl adminService;

    public AdminServiceDecorator(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @Override
    public Item findItemById(Integer itemId) {
        logBefore("Get Item by Id");
        Item item = adminService.findItemById(itemId);
        logAfter("Get Item by Id");
        return item;
    }

    @Override
    public List<Item> getAll() {
        logBefore("Get All Items");
        List<Item> items = adminService.getAll();
        logAfter("Get All Items");
        return items;
    }

    @Override
    public void addItem(Item item) {
        logBefore("Create Item");
        adminService.addItem(item);
        logAfter("Create Item");
    }

    @Override
    public void update(Item item) {
        logBefore("Update User");
        adminService.update(item);
        logAfter("Update User");
    }

    @Override
    public void delete(Integer itemId) {
        logBefore("Delete User");
        adminService.delete(itemId);
        logAfter("Delete User");
    }

    void logBefore(String operation) {
        System.out.println("Before " + operation);
    }

     void logAfter(String operation) {
        System.out.println("After " + operation);
    }
}

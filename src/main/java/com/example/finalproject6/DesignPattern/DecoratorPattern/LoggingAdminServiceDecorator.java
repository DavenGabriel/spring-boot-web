package com.example.finalproject6.DesignPattern.DecoratorPattern;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.service.AdminServiceImpl;

import java.util.List;

public class LoggingAdminServiceDecorator extends AdminServiceDecorator{
    public LoggingAdminServiceDecorator(AdminServiceImpl adminService) {
        super(adminService);
    }

//    @Override
//    public Item findItemById(Integer itemId) {
//        logBefore("Get Item by Id", itemId);
//        Item item = super.findItemById(itemId);
//        logAfter("Get Item by Id", itemId, item);
//        return item;
//    }
//
//    @Override
//    public List<Item> getAll() {
//        logBefore("Get All Items");
//        List<Item> items = super.getAll();
//        logAfter("Get All Items", items.size());
//        return items;
//    }
//
//    @Override
//    public void addItem(Item item) {
//        logBefore("Create Item", item);
//        super.addItem(item);
//        logAfter("Create Item", item);
//    }
//
//    @Override
//    public void update(Item item) {
//        logBefore("Update Item", item);
//        super.update(item);
//        logAfter("Update Item", item);
//    }
//
//    @Override
//    public void delete(Integer itemId) {
//        logBefore("Delete Item", itemId);
//        super.delete(itemId);
//        logAfter("Delete Item", itemId);
//    }
//
//    @Override
//    public List<Item> getItemsByCategory(String category) {
//        logBefore("Get Items by Category", category);
//        List<Item> items = super.getItemsByCategory(category);
//        logAfter("Get Items by Category", category, items.size());
//        return items;
//    }
//
//    @Override
//    public List<Item> getAllRandom() {
//        logBefore("Get All Random Items");
//        List<Item> items = super.getAllRandom();
//        logAfter("Get All Random Items", items.size());
//        return items;
//    }
//
//    @Override
//    public Item findByUserName(String name) {
//        logBefore("Find Item by Name", name);
//        Item item = super.findByUserName(name);
//        logAfter("Find Item by Name", name, item);
//        return item;
//    }
//
//    @Override
//    public Item findByCategory(String category) {
//        logBefore("Find Item by Category", category);
//        Item item = super.findByCategory(category);
//        logAfter("Find Item by Category", category, item);
//        return item;
//    }
//
//
//    private void logBefore(String operation, Object param) {
//        System.out.println("\nBefore " + operation + " with parameter: " + param);
//    }
//
//    private void logAfter(String operation, Object param) {
//        System.out.println("\nAfter " + operation + " with parameter: " + param );
//    }
//
//    private void logAfter(String operation, Object param, Object result) {
//        System.out.println("\nAfter " + operation + " with parameter: " + param + " and result: " + result);
//    }
}

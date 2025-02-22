package com.example.finalproject6.controller;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.service.AdminServiceImpl;
import com.example.finalproject6.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/useritem")
@Controller
public class ItemController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/list")
    public String itemlist(Model m) {
        List<Item> itemList = adminService.getAllRandom();
        List<List<Item>> item = IntStream.range(0, itemList.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i / 3))
                .values()
                .stream()
                .map(ilist -> ilist.stream().map(itemList::get).collect(Collectors.toList()))
                .collect(Collectors.toList());
        m.addAttribute("item", item);
        return "user/home";
    }
}

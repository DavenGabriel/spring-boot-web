package com.example.finalproject6.controller;

import com.example.finalproject6.DesignPattern.FacadePattern.ItemServiceFacade;
import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.pojo.User;
import com.example.finalproject6.service.AdminServiceImpl;
import com.example.finalproject6.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ItemServiceFacade itemServiceFacade;

    @RequestMapping("/list")
    public String adminlist(Model m) {
        List<Item> items = itemServiceFacade.getAll();
        m.addAttribute("item", items);
        return "admin/adminlist";
    }

    @RequestMapping("/user")
    public String adminlistuser(Model m) {
        List<User> userList = userService.getAll();
        m.addAttribute("item", userList);
        return "admin/adminlistuser";
    }



    @RequestMapping("/addNew")
    public String adminadd(Item item, MultipartFile file) throws IOException {

        System.out.println(item);

        UUID uuid = UUID.randomUUID();
        String filename = uuid + ".png";
        file.transferTo(new File(filename));
        String coverImg = "/img/" + filename;

        item.setItemPic(coverImg);
        itemServiceFacade.add(item);
        return "admin/adminadd";
    }

    @GetMapping("/category/{category}")
    public String byCategory(@PathVariable String category, Model m){
        List<Item> itemList = adminService.getItemsByCategory(category);
        m.addAttribute("item", itemList);
        return "user/product";
    }

//    @RequestMapping("/category")
//    public String update(Model m, String category){
//        List<Item> itemList = adminService.getItemsByCategory(category);
//        m.addAttribute("item", itemList);
//        return "redirect:/user/category";
//    }



    @GetMapping("/update/{itemId}")
    public String updateForm(@PathVariable Integer itemId, Model m){
        Item item = itemServiceFacade.findItemById(itemId);
        m.addAttribute("itemId", item);
        return "admin/adminupdate";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute Item item, MultipartFile file) throws IOException {
        UUID uuid = UUID.randomUUID();
        String filename = uuid + ".png";
        file.transferTo(new File(filename));
        String coverImg = "/img/" + filename;

        item.setItemPic(coverImg);
        itemServiceFacade.update(item);
        return "redirect:/admin/list";
    }

    @GetMapping("/delete/{itemId}")
    public String delete(@PathVariable Integer itemId){
        itemServiceFacade.delete(itemId);
        return "redirect:/admin/list";
    }

    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId){
        itemServiceFacade.delete(userId);
        return "redirect:/admin/user";
    }

    @RequestMapping("/home")
    public String adminhome() {
        return "admin/adminhome";
    }

    @RequestMapping("/add")
    public String adminadd() {
        return "admin/adminadd";
    }


}

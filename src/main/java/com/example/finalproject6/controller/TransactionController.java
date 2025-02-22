package com.example.finalproject6.controller;

import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.pojo.Transaction;
import com.example.finalproject6.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/transaction")
@Controller
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @RequestMapping("/add")
    public String addItemToCart(Transaction transaction) {
        transactionService.addItem(transaction);
        return "redirect:/useritem/list";
    }

    @GetMapping("/add/{itemId}")
    public String getItemIdToTransaction(@PathVariable Integer itemId, Model m){
        Transaction item = transactionService.findItemById(itemId);
        m.addAttribute("itemId", item);
        return "redirect:/transaction/add";
    }

    @RequestMapping("/showCart")
    public String showCart(Model m){
        List<Transaction> t = transactionService.getAll();
        m.addAttribute("tl", t);
        return "user/cart";
    }

    @GetMapping("/delete/{transactionId}")
    public String delete(@PathVariable Integer transactionId){
        transactionService.delete(transactionId);
        return "redirect:/transaction/showCart";
    }

//    @GetMapping("/add")
//    public String addItemToCart(Transaction transaction, @RequestParam("itemId") Integer itemId, Model m) {
//        transactionService.addItemToCart(transaction);
//        Item item = transactionService.findById(itemId);
//        m.addAttribute("itemId", item);
//        return "redirect:/useritem/list";
//    }
}

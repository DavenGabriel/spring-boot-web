package com.example.finalproject6.controller;

import com.example.finalproject6.pojo.UserVo;
import com.example.finalproject6.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APPController {


    @RequestMapping("/")
    public String toIndex(){
        return "user/index";
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        return "user/index";
    }

    @RequestMapping("/toregister")
    public String toReg(){
        return "user/register";
    }

    @RequestMapping("/index")
    public String toLogout(HttpServletRequest request){
        request.getSession().invalidate();
        ThreadLocalUtil.remove();
        return "user/index";
    }

    @RequestMapping("/toadminhome")
    public String toHome(){
        return "admin/adminhome";
    }

    @RequestMapping("/home")
    public String tohome(){
        return "user/home";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Model m){
        UserVo uv = ThreadLocalUtil.get();
        m.addAttribute("userinfo",uv);
        return "user/update";
    }

    @RequestMapping("toCategory")
    public String toCategory(){
        return "category/addNew";
    }
}

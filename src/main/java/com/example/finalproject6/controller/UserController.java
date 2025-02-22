package com.example.finalproject6.controller;


import com.example.finalproject6.pojo.User;
import com.example.finalproject6.pojo.UserVo;
import com.example.finalproject6.service.UserServiceImpl;
import com.example.finalproject6.utils.Md5Util;
import com.example.finalproject6.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/register")
    public String register(String username, String password, String phoneNumber, String confirmPassword, String address, String email, Model m) {
        if (!password.equals(confirmPassword)) {
            m.addAttribute("errmsg", "Passwords do not match.");
            return "user/register";
        }

        User u = userService.findByUserName(username);
        if (u == null) {
            userService.register(username, password, phoneNumber, address, email);
            return "user/index";
        } else {
            m.addAttribute("errmsg","Username already used");
            return "user/register";
        }
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model m, HttpServletRequest request) {
        User loginUser = userService.findByUserName(username);
        if (username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")) {
            return "admin/adminhome";
        }
        if (loginUser == null) {
            m.addAttribute("errmsg", "Username or Password is wrong!");
            return "user/index";
        }
        if (!Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            m.addAttribute("errmsg", "Username or Password is wrong!");
            return "user/index";
        }
        UserVo uv = new UserVo();
        uv.setUserId(loginUser.getUserId());
        uv.setUsername(loginUser.getUsername());
        uv.setUserPic(loginUser.getUserPic());
        uv.setEmail(loginUser.getEmail());
        uv.setPhoneNumber(loginUser.getPhoneNumber());
        uv.setAddress(loginUser.getAddress());
        uv.setCreateTime(String.valueOf(loginUser.getCreateTime()));
        request.getSession().setAttribute("cu", uv);
        ThreadLocalUtil.set(uv);
        System.out.println("masukk");
        System.out.println(uv);
        return "redirect:/useritem/list";
    }

    @RequestMapping("/showInfo")
    public String userInfo(Model m) {
        UserVo uv = ThreadLocalUtil.get();
        if (uv == null) {
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(false);
            if (session != null) {
                uv = (UserVo) session.getAttribute("cu");
                if (uv != null) {
                    ThreadLocalUtil.set(uv);
                }
            }
        }

        if (uv == null) {
            throw new NullPointerException("UserVo is null");
        }
        User user = userService.findByUserName(uv.getUsername());
        m.addAttribute("userinfo", user);
        return "user/account";
    }
}

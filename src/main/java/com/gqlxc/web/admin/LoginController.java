package com.gqlxc.web.admin;

import com.gqlxc.domain.User;
import com.gqlxc.service.UserSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class LoginController {

    @Autowired
    UserSercvice userSercvice;

    @RequestMapping()
    public String loginPage(){
        return "/admin/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
                        RedirectAttributes redirectAttributes){
        User user = userSercvice.checkUser(username, password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }
        else{
            redirectAttributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}

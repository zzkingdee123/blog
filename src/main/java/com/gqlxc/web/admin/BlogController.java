package com.gqlxc.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class BlogController {

    @GetMapping("/bolgs")
    public String blogs(){
        return  "/admin/blogs";
    }
}

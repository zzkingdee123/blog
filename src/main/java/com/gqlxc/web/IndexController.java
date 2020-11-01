package com.gqlxc.web;

import com.gqlxc.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/index")
    public  String index(){
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}

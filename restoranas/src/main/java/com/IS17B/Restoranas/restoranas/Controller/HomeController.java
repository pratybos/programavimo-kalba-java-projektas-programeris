package com.IS17B.Restoranas.restoranas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value="/home")
    public String index(){
        return "home";
    }
}

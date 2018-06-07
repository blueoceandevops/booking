package me.rainking.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Rain
 * @description
 * @date 2018/4/25
 */
@Controller
public class IndexController {
    @GetMapping({"/","/index"})
    public String showIndex(){
        return "index";
    }

}

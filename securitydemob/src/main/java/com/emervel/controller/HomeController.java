package com.emervel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guopm on 04/06/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

}
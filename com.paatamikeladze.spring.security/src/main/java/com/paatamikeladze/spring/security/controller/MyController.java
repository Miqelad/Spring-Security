package com.paatamikeladze.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String getInfoForAllEmps(){

        return "view_for_all_employees";
    }
    @GetMapping("/hr_info")
    public String getInfoOnlyPrincess (){
        return "view_for_princess";
    }
    @GetMapping("/manger_info")
    public String getInfoOnlyMethodist(){
        return "view_for_mehodist";
    }
}

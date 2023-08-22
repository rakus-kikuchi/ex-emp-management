package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//管理者関連機能
@Controller
@RequestMapping("/admin")
public class AdministratorController {

    @GetMapping("")
    private String index(){
        return "";
    }
    
}

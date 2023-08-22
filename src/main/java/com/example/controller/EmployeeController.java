package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//従業員関連
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("")
    private String index() {
        return "";
    }

}

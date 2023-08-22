package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;

//管理者関連機能
@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/toInsert")
    private String toInsert(InsertAdministratorForm form){
        return "administrator/insert";
    }
    

    @PostMapping("/insert")
    private String insert(InsertAdministratorForm form){
        Administrator administrator = new Administrator();
        //formの中身をadministratorにコピー
        BeanUtils.copyProperties(form, administrator);
        //insertメソッドを呼び出し
        administratorService.insert(administrator);
        return "redirect:/";
    }

    @GetMapping("/toLogin")
    public String toLogin(LoginForm form){
        return "administrator/login";

    }
    }

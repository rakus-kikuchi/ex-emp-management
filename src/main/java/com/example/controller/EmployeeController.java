package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    private String index() {
        return "";
    }

    @GetMapping("/showList")
    private String showList(Model model){
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    @GetMapping("/showDetail")
    private String showDetail(Integer id, Model model,UpdateEmployeeForm form){
        Employee employee = employeeService.showDetail((int)id);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

}

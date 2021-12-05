package com.example.newtest.controller;

import com.example.newtest.domain.Employee;
import com.example.newtest.mapper.EmployeeMapper;
import com.example.newtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
// @ResponseBody
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("list")
    public String listPage(Model model){
        List<Employee> employees = employeeService.listAll();
        model.addAttribute("employees",employees);
        return "employee-list";
    }

@RequestMapping("add")
public String addPage(Model model){
        model.addAttribute(new Employee());
        return "employee-edit";
}

@RequestMapping("save")
public String save(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/list";
}

@RequestMapping("edit")
public String edit(@RequestParam("id") Integer id, Model model){
    Employee employee = employeeService.findById(id);
    model.addAttribute("employee", employee);
        return "employee-edit";
}

@RequestMapping("delete")
public String delete(@RequestParam("id") Integer id){
        employeeService.deleteByID(id);
        return "redirect:/employee/list";
}














    @RequestMapping("/hello")
    public String sayHello(){
    return "Spring, MVC";
}
    @RequestMapping("findById/{id}")
    public Employee findByid(@PathVariable("id") Integer id){
        return employeeService.findById(id);
}
}

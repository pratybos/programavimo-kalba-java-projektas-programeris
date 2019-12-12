package com.IS17B.Restoranas.restoranas.Controller;

import com.IS17B.Restoranas.restoranas.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String index(Model mdl){
        mdl.addAttribute("employee", service.findAll());
        return "employee";
    }
}

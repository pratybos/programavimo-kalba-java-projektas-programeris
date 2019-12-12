package com.IS17B.Restoranas.restoranas.Controller;

import com.IS17B.Restoranas.restoranas.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

    @Autowired
    ClientService service;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String index(Model mdl){
        mdl.addAttribute("clients", service.findAll());
        return "clients";
    }
}

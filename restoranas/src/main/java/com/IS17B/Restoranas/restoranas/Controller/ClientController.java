package com.IS17B.Restoranas.restoranas.Controller;

import com.IS17B.Restoranas.restoranas.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping("/clients")
    public String list(Model model){
        model.addAttribute("clients", clientService.showClients());
        return "client";
    }
    @GetMapping("clients/{id}")
    public String client(Model model, @PathVariable Long id){
        model.addAttribute("client", clientService.clientShowId(id));
        return "client";
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World")
                                       String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }
}

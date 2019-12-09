package Controller;

import Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClientController {
    private ClientService clientService;
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("client") // HTTP GET
    public String list(Model model){
        model.addAttribute("client", clientService.showClient());
        return "client";
    }
    @GetMapping("client/{id}")
    public String client(Model model, @PathVariable Long id){
        model.addAttribute("client", clientService.idClient(id));
        return "client";
    }

}
package br.infnet.votum.controller;

import br.infnet.votum.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome() {

        return "home";

    }

    @GetMapping(value = "/login")
    public String login(String error) {

        return "login";
    }

    @PostMapping(value = "/login_validate")
    public String login_validate() {
        return "login";
    }


}

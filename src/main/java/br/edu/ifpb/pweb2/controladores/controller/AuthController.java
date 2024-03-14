package br.edu.ifpb.pweb2.controladores.controller;

import br.edu.ifpb.pweb2.controladores.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {
    @Autowired
    private AuthService authService;


    @GetMapping("/auth")
    public String getLoginForm(){
        return "login";
    }

    @PostMapping("/auth")
    public String validateCredentials(@RequestParam("user") String user,
                                      @RequestParam("senha") String senha,
                                      Model model){

        String proxPagina = "home";
        if(!authService.isValidCredentials(user, senha)){
            model.addAttribute("mensagem", "Usuário ou senha inválido(s)!");
            proxPagina = "login";
        }
        return proxPagina;
    }


}

package com.skgestao.GestaoSK.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.skgestao.GestaoSK.model.Users;
import com.skgestao.GestaoSK.repositorio.UsersRepo;
import com.skgestao.GestaoSK.service.CookieService;

@Controller
public class LoginController {

     @Autowired
    private UsersRepo repo;

    @GetMapping("/login")
    public String index(){        
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Users admParam, String lembrar, HttpServletResponse response) throws IOException{ 
        Users user = this.repo.login(admParam.getEmail(), admParam.getSenha());
        if(user != null){
            int tempoLogado = (60*60*24); //24 horas de cookie
            if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
        CookieService.setCookie(response, "usuariosId", String.valueOf(user.getId()), tempoLogado);
        CookieService.setCookie(response, "nomeUsuario", String.valueOf(user.getNome()), tempoLogado);
           return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha incorretos. Corrija e tente novamente."); 
        return "login/index";
    }

    @GetMapping("/sair")
    public String sair( HttpServletResponse response) throws IOException{ 
        CookieService.setCookie(response, "usuariosId", "", 0);
           return "redirect:/login";
    }

    
}

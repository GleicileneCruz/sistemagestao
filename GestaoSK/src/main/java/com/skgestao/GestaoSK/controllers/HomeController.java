package com.skgestao.GestaoSK.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skgestao.GestaoSK.service.CookieService;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException{
//        model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
//        return "/home/index";
//
//    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        String nomeUsuario = CookieService.getCookie(request, "nomeUsuario");
        model.addAttribute("nome", nomeUsuario != null ? nomeUsuario : "Visitante");
        return "/home/index";
    }
}

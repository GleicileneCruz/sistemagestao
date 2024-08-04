package com.skgestao.GestaoSK.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendaController {

    @GetMapping("/vendas")
    public String index(){            
        return "venda/index";

    }
}

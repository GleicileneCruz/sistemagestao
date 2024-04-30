package com.skgestao.GestaoSK.controllers;

import com.skgestao.GestaoSK.model.Users;
import com.skgestao.GestaoSK.repositorio.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UsersRepo repo;

    @GetMapping("/users")
    public String index(Model model){
        List<Users> user = (List<Users>)repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("user", user);
        return "/user/index";

    }

    @GetMapping("/users/novo")
    public String novo(Model model){
        return "/user/novo";
    }

    @PostMapping("/users/criar")
    public String criar(@ModelAttribute("userForm") Users users, Model model){
        if (repo.findByEmail(users.getEmail()).isPresent()){
            model.addAttribute("erro", "Email já cadastrado. Insira outro email.");
            model.addAttribute("userForm", users);
            return "/user/novo";
        }
        repo.save(users);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String buscar(@PathVariable int id, Model model){ 
        Optional<Users> user = repo.findById(id);
        try{
            model.addAttribute("users", user.get()); 
        }
        catch(Exception err){
             return "redirect:/users";
        }
                   
        return "/user/editar";
    }

    @PostMapping("/users/{id}/atualizar")
    public String atualizar(@ModelAttribute("userForm") @PathVariable int id, Users users, Model model){
        if(!repo.existsById(id)){
            return "redirect:/users";
        }

        String email = users.getEmail().toLowerCase();
        Optional<Users> existingUser = repo.findByEmailIgnoreCaseAndIdNot(email, id);

        if (existingUser.isPresent()) {
            model.addAttribute("erro", "Email já cadastrado. Insira outro email.");
            return "redirect:/users";
        }
        repo.save(users);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/excluir")
    public String excluir(@PathVariable int id){ 
        repo.deleteById(id);            
        return "redirect:/users";
    }
    
}

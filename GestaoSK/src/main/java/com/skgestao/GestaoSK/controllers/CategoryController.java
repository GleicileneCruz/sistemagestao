package com.skgestao.GestaoSK.controllers;

import com.skgestao.GestaoSK.model.Category;
import com.skgestao.GestaoSK.model.exceptions.DatabaseException;
import com.skgestao.GestaoSK.model.exceptions.ResourceNotFoundException;
import com.skgestao.GestaoSK.repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/categories")
    public String index(Model model){
        List<Category> category = (List<Category>)categoryRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("category", category);      
        return "/category/index";

    }

    @GetMapping("/categories/novo")
    public String novo(Model model){             
        return "/category/novo";
    }

    @PostMapping("/categories/criar")
    public String criar(Category category){ 
        categoryRepo.save(category);            
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}")
    public String buscar(@PathVariable int id, Model model){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        try{
            model.addAttribute("category", optionalCategory.get());
        }
        catch(Exception err){
            return "redirect:/categories";
        }
                   
        return "/category/editar";
    }

    @PostMapping("/categories/{id}/atualizar")
    public String atualizar(@PathVariable int id, Category category){
        if(!categoryRepo.existsById(id)){
            return "redirect:/categories"; 
        }
        categoryRepo.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/excluir")
    public String delete(@PathVariable int id){
        try {
            categoryRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violacao Integridade");
        }
        return "redirect:/categories";
    }

}

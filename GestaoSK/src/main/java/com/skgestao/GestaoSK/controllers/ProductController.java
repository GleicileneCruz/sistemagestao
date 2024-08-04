package com.skgestao.GestaoSK.controllers;

import com.skgestao.GestaoSK.model.Category;
import com.skgestao.GestaoSK.model.Products;
import com.skgestao.GestaoSK.repositorio.CategoryRepository;
import com.skgestao.GestaoSK.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products")
    public String index(Model model){
        List<Products> product = (List<Products>)productRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("product", product);      
        return "product/index";

    }

    @GetMapping("/products/novo")
    public String novo(Model model){
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "product/novo";
    }

    @PostMapping("/products/criar")
    public String criar(Products product){
        productRepo.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String buscar(@PathVariable int id, Model model){
        Optional<Products> product = productRepo.findById(id);
        try{
            model.addAttribute("products", product.get());
        }
        catch(Exception err){
             return "redirect:/products";
        }

        return "product/editar";
    }

    @PostMapping("/products/{id}/atualizar")
    public String atualizar(@PathVariable int id, Products products){
        if(!productRepo.existsById(id)){
            return "redirect:/products"; 
        }
        productRepo.save(products);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}/excluir")
    public String excluir(@PathVariable int id){ 
        productRepo.deleteById(id);            
        return "redirect:/products";
    }
    
}

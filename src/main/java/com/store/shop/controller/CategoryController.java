package com.store.shop.controller;

import java.util.List;

import com.store.shop.entity.Category;
import com.store.shop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    //affiche la liste des catégories
    @GetMapping("/categories")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    // ajouter une catégorie
    @PostMapping("/categories")
    public Category add(@RequestBody Category c){
        return categoryService.save(c);
    }

    //supprimer une catégorie
    @DeleteMapping("/categories/{id}")
        public void deleteById(@PathVariable int id){
            categoryService.deleteById(id);
    }

    // modifier une catégorie
    @PutMapping("/categories/{id}")
    public void updateById(@PathVariable int id, @RequestBody Category c){
        c.setCategoryId(id);
        categoryService.save(c);
    }

    // affiche une catégorie avec son id 
    @GetMapping("/categories/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }
    
}

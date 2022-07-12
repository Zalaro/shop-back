package com.store.shop.controller;

import java.util.List;

import com.store.shop.entity.Product;
import com.store.shop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    //affiche la liste des produits
    @GetMapping("/produits")
    public List<Product> findAll(){
        return productService.findAll();
    }

    // ajouter une produit
    @PostMapping("/produits")
    public Product add(@RequestBody Product c){
        return productService.save(c);
    }

    //supprimer une produit
    @DeleteMapping("/produits/{id}")
        public void deleteById(@PathVariable int id){
            productService.deleteById(id);
    }

    // modifier une produit
    @PutMapping("/produits/{id}")
    public void updateById(@PathVariable int id, @RequestBody Product p){
        p.setProductId(id);
        productService.save(p);
    }

    // affiche une produit avec son id 
    @GetMapping("/produits/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }
}

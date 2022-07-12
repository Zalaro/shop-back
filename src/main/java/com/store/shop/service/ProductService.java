package com.store.shop.service;

import java.util.List;

import com.store.shop.dao.ProductRepository;
import com.store.shop.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    //affiche la liste des produits
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    //ajoute ou modifie une produit
    public Product save(Product produit){
        return productRepository.save(produit);
    }

    //affiche une produit avec son id
    public Product findById(Integer id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produit not found" + id));
    }

    //supprime une produit
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }    
}

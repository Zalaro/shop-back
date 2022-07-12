package com.store.shop.service;

import java.util.List;

import com.store.shop.dao.CategoryRepository;
import com.store.shop.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //affiche la liste des catégories
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    //ajoute ou modifie une catégorie
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    //affiche une catégorie avec son id
    public Category findById(Integer id) throws ResourceNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found" + id));
    }

    //supprime une catégorie
    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }
}

package com.store.shop.dao;

import java.util.List;

import com.store.shop.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    public List<Product> findByDesignationContains(String keyword);

    //@Query("SELECT p FROM products p WHERE p.designation like :keyword")
    //public List<Product> rechercheProduit(@Param("keyword") String keyword);

}

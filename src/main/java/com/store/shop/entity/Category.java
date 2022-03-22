package com.store.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="categories")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Category implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;

    // ONE TO MANY RELATION
    @OneToMany(mappedBy="category")
    private Collection<Product> products = new ArrayList<>();
    
}

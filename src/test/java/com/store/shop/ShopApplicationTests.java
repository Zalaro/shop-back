package com.store.shop;

import java.util.List;

import com.store.shop.entity.Category;
import com.store.shop.service.CategoryService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

	@Autowired
	CategoryService categoryService;

	@Test
	public void testFindAll(){
		List<Category> categories = categoryService.findAll();
		for(Category category : categories){
			System.out.println(
				"\n --- TEST FIND ALL --- \n" +
				category.getCategoryName() + "\n\n"
			);
		}
	}

	@Test
	public void testAdd(){
		Category category = new Category();
		category.setCategoryName("Catégorie 4");
		categoryService.save(category);
		System.out.println(
			"\n --- TEST ADD --- \n" +
			category + "\n\n"
		);
	}

	@Test
	public void findById(){
		Category category = categoryService.findById(1);
		System.out.println(
			"\n --- TEST BY ID --- \n" +
			category.getCategoryId() + "\n\n"
		);
	}

	@Test
	public void testUpdateById(){
		Category category = categoryService.findById(1);
		category.setCategoryName("Computers");
		categoryService.save(category);
		System.out.println(
			"\n --- TEST UPDATE BY ID --- \n" +
			category.getCategoryId() + "\n" + 
			category.getCategoryName()
			+ "\n\n"
		);
	}

	@Test
	public void testDeleteById(){
		categoryService.deleteById(4);
	}

}

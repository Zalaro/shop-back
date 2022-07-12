package com.store.shop;

import java.util.Random;

import com.store.shop.dao.CategoryRepository;
import com.store.shop.dao.ProductRepository;
import com.store.shop.entity.Category;
import com.store.shop.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insérer des catégories
        categoryRepository.save(new Category(null, "COMPUTER", null));
        categoryRepository.save(new Category(null, "VIDEO", null));
        categoryRepository.save(new Category(null, "GAME", null));

        // Pour insérer des produits aléatoirement
        Random random = new Random();

        // Ajouter 10 produits pour chaque catégories
        categoryRepository.findAll().forEach(c -> {
            for (int i = 0; i < 10; i++) {
                Product product = new Product();
                product.setDesignation(RandomString.make(15));
                product.setDescription(RandomString.make(25));
                product.setPrice(100 + random.nextInt(10000));
                product.setPromotion(random.nextBoolean());
                product.setSelected(random.nextBoolean());
                product.setPhoto("unknown.png");
                product.setCategory(c);
                productRepository.save(product);
            }
        });
        
    }

}

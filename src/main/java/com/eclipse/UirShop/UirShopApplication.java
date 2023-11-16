package com.eclipse.UirShop;

import com.eclipse.UirShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UirShopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UirShopApplication.class, args);
	}
	@Autowired
	ProductService productService;
	@Override
	public void run(String... args) throws Exception {
//     productService.findProductByCategorie(2L);

	}
}



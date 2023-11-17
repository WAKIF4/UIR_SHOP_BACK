package com.eclipse.UirShop;

import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UirShopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UirShopApplication.class, args);
	}
	@Autowired
	ProductService productService;
	@Override
	public void run(String... args) throws Exception {
		List<ProductDto>pdto=productService.findAllProductsByCat(2L);
		pdto.forEach(p-> System.out.println(p.toString()));

	}
}



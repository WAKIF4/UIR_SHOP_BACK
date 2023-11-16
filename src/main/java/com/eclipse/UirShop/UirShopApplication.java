package com.eclipse.UirShop;

import com.eclipse.UirShop.entities.Payment;
import com.eclipse.UirShop.entitiesDto.OrderDto;
import com.eclipse.UirShop.entitiesDto.PaymentDto;
import com.eclipse.UirShop.enums.ModePayment;
import com.eclipse.UirShop.enums.StatutOrder;
import com.eclipse.UirShop.transformer.PaymentTransformer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class UirShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(UirShopApplication.class, args);
	}

}

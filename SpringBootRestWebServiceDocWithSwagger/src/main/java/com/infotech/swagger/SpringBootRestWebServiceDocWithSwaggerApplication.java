package com.infotech.swagger;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.infotech.swagger.model.Product;
import com.infotech.swagger.repositries.ProductRepository;

@SpringBootApplication
public class SpringBootRestWebServiceDocWithSwaggerApplication implements ApplicationListener<ContextRefreshedEvent> {

	private Logger log = Logger.getLogger(SpringBootRestWebServiceDocWithSwaggerApplication.class);
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestWebServiceDocWithSwaggerApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadProducts();
	}
	
	private void loadProducts() {
		Product samsungGalaxy = new Product();
		samsungGalaxy.setDescription("Samsung");
		samsungGalaxy.setPrice(new BigDecimal("13299.00"));
		samsungGalaxy.setImageUrl("https://www.amazon.in");
		samsungGalaxy.setProductId("23526889931068308");
		productRepository.save(samsungGalaxy);

		log.info("Saved Phone - id: " + samsungGalaxy.getId());

		Product iPhone = new Product();
		iPhone.setDescription("Apple iPhone 7");
		iPhone.setImageUrl("https://www.flipkart.com");
		iPhone.setProductId("198639393495300006");
		iPhone.setPrice(new BigDecimal("47499"));
		productRepository.save(iPhone);

		log.info("Saved Phone - id:" + iPhone.getId());
	}
}

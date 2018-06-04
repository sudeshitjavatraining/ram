package com.infotech.swagger.repositries;

import org.springframework.data.repository.CrudRepository;

import com.infotech.swagger.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}

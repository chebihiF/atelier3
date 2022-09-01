package com.example.atelier3.product.service;

import com.example.atelier3.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts() throws Exception;
}

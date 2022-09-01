package com.example.atelier3.product.service;

import com.example.atelier3.product.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private static final String BASE_URL = "http://localhost:8080/api/products";
    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getProducts() throws Exception {
        ResponseEntity<HashMap> responseEntity =
                restTemplate.getForEntity(BASE_URL, HashMap.class);
        HashMap objects = responseEntity.getBody();
        List<Product> products = (List<Product>) objects.get("content");
        return products ;
    }
}

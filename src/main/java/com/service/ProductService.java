package com.service;

import com.entites.Product;
import com.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showProductList() {
        return productRepository.findAll();
    }

    public List<Product> showFilterList(String filter) {
        switch (filter) {
            case "max":
                return productRepository.MaxPriceQuery();
            case "min":
                return productRepository.MinPriceQuery();
            case "maxAndMin":
                return productRepository.MaxAndMinPriceQuery();
        }
        return showProductList();
    }

    public ProductService() {
    }
}

package com.springboot.hello.data.dao.impl;

import com.springboot.hello.data.dao.ProductDAO;
import com.springboot.hello.data.entity.Product;
import com.springboot.hello.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        return null;
    }

    @Override
    public Product selectProduct(Long number) {
        return null;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        return null;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {

    }
}

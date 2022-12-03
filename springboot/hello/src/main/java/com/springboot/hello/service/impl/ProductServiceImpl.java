package com.springboot.hello.service.impl;

import com.springboot.hello.data.dao.ProductDAO;
import com.springboot.hello.data.dto.ProductDto;
import com.springboot.hello.data.dto.ProductResponseDto;
import com.springboot.hello.data.entity.Product;
import com.springboot.hello.data.repository.ProductRepository;
import com.springboot.hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productRepository.findById(number).get();

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setNumber(productDto.getNumber());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productDto.setNumber(savedProduct.getNumber());
        productDto.setName(savedProduct.getName());
        productDto.setPrice(savedProduct.getPrice());
        productDto.setStock(savedProduct.getStock());

        return  productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {

        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());


        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}

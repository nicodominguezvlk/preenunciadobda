package com.bda.parcial.services;

import com.bda.parcial.models.Product;
import com.bda.parcial.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product entity) {

        return this.productRepository.save(entity);
    }

    @Override
    public Product update(Product entity) {
        return this.productRepository.save(entity);
    }

    @Override
    public Product delete(Long id) {
        Product product = this.getById(id);
        this.productRepository.delete(product);
        return product;
    }

    @Override
    public Product getById(Long id) {
        return this.productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

}

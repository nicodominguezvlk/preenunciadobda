package com.bda.parcial.services;

import com.bda.parcial.dtos.ProductDTO;
import com.bda.parcial.models.Product;
import com.bda.parcial.repositories.ProductRepository;
import com.bda.parcial.services.mappers.ProductDTOMapper;
import com.bda.parcial.services.mappers.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDTOMapper DTOMapper;
    private final ProductMapper entityMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductDTOMapper DTOMapper, ProductMapper entityMapper){
        this.productRepository = productRepository;
        this.DTOMapper = DTOMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public ProductDTO add(ProductDTO entity) {
        Optional<Product> product = Stream.of(entity).map(entityMapper).findFirst();
        product.ifPresent(productRepository::save);
        return product.map(DTOMapper).orElseThrow();
    }

    @Override
    public ProductDTO update(ProductDTO entity) {
        Optional<Product> product = Stream.of(entity).map(entityMapper).findFirst();
        product.ifPresent(productRepository::save);
        return product.map(DTOMapper).orElseThrow();
    }

    @Override
    public ProductDTO delete(Long id) {
        ProductDTO product = this.getById(id);
        if(product != null)
        {
            Optional<Product> entity = Stream.of(product).map(entityMapper).findFirst();
            entity.ifPresent(productRepository::delete);

        }
        return product;
    }

    @Override
    public ProductDTO getById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.map(DTOMapper).orElseThrow();
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products =  this.productRepository.findAll();
        return products.stream().map(DTOMapper).toList();
    }

}

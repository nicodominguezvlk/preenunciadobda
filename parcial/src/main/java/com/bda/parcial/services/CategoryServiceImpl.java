package com.bda.parcial.services;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.repositories.CategoryRepository;
import com.bda.parcial.services.mappers.CategoryDTOMapper;
import com.bda.parcial.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryDTOMapper DTOmapper;
    private final CategoryMapper entityMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryDTOMapper DTOmapper, CategoryMapper entityMapper){
        this.categoryRepository = categoryRepository;
        this.DTOmapper = DTOmapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public CategoryDTO add(CategoryDTO entity) {
        Optional<Category> category = Stream.of(entity).map(entityMapper).findFirst();
        category.ifPresent(categoryRepository::save);
        return category.map(DTOmapper).orElseThrow();
    }

    @Override
    public CategoryDTO update(CategoryDTO entity) {
        Optional<Category> category = Stream.of(entity).map(entityMapper).findFirst();
        category.ifPresent(categoryRepository::save);
        return category.map(DTOmapper).orElseThrow();
    }

    @Override
    public CategoryDTO delete(Long id) {
        CategoryDTO category = this.getById(id);
        if(category != null)
        {
            Optional<Category> entity = Stream.of(category).map(entityMapper).findFirst();
            entity.ifPresent(categoryRepository::delete);

        }
        return category;
    }

    @Override
    public CategoryDTO getById(Long id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        return category.map(DTOmapper).orElseThrow();
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories =  this.categoryRepository.findAll();
        return categories.stream().map(DTOmapper).toList();
    }
}

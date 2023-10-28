package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class CategoryDTOMapper implements Function<Category, CategoryDTO> {
    @Override
    public CategoryDTO apply(Category category)
    {
       return new CategoryDTO(category.getCategoryId(),
                    category.getCategoryName(),
                    category.getDescription(),
                    category.getPicture());
    }
}

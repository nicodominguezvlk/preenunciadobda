package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.models.Category;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.function.Function;

@Service
public class CategoryMapper implements Function<CategoryDTO, Category>{
    public Category apply(CategoryDTO categoryDTO){
        return new Category(categoryDTO.getCategoryId(),
                categoryDTO.getCategoryName(),
                categoryDTO.getDescription(),
                categoryDTO.getPicture(),
                new ArrayList<>());
    }

}

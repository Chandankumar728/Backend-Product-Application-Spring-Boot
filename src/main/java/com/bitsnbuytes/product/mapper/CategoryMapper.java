package com.bitsnbuytes.product.mapper;

import com.bitsnbuytes.product.entity.Category;
import com.bitsnbuytes.product.dto.CategoryDTO;

public class CategoryMapper {

    public static CategoryDTO categoryDTO (Category category){
        if(category == null){
            return null;
        }


        
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts() != null ? 
            category.getProducts().stream()
                .map(ProductMapper::toProductDTO)
                .collect(java.util.stream.Collectors.toList()) : 
            new java.util.ArrayList<>());
        return categoryDTO;
    }

    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }

}

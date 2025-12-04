package com.bitsnbuytes.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsnbuytes.product.dto.CategoryDTO;
import com.bitsnbuytes.product.entity.Category;
import com.bitsnbuytes.product.mapper.CategoryMapper;
import com.bitsnbuytes.product.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.categoryDTO(category);
    }

    //get all category
    public List<CategoryDTO> getAllCategory(){
        return categoryRepository.findAll().stream()
            .map(CategoryMapper::categoryDTO)
            .toList();
    }

    //get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.categoryDTO(category);
    }
    //delete category by id
    public String deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        return "Category Deleted " + id + " successfully";
    }

    //update category by id 
    // public CategoryDTO updateCategoryById(Long id, CategoryDTO categoryDTO){
    //     Category category = categoryRepository.findById(id)
    //         .orElseThrow(() -> new RuntimeException("Category not found"));
    //     category.setName(categoryDTO.getName());
    //     category = categoryRepository.save(category);
    //     return CategoryMapper.categoryDTO(category);
    // }

}

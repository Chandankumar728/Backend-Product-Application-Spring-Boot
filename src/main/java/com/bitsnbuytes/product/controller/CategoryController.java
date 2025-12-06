package com.bitsnbuytes.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bitsnbuytes.product.dto.CategoryDTO;
import com.bitsnbuytes.product.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // create categories
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public Object createCategory(@RequestBody CategoryDTO categoryDTO) {
        
            return categoryService.createCategory(categoryDTO);
       
            
        
    }

    // get all category
    @GetMapping
    public List<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategory();
    }

    //get Category by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    // delete category by id
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
      return  categoryService.deleteCategoryById(id);
    }

    //update category by id 
    // @PostMapping("/{id}")
    // public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
    //     return categoryService.createCategory(categoryDTO);
    // }


    
    
   
    
}

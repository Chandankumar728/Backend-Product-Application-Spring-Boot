package com.bitsnbuytes.product.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bitsnbuytes.product.dto.CategoryDTO;
import com.bitsnbuytes.product.dto.ProductDTO;
import com.bitsnbuytes.product.services.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // create products
    @PostMapping
    public ProductDTO createproduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    // get all products

    @GetMapping
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProduct();
    }

    // get all product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    //delete product 
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    

}

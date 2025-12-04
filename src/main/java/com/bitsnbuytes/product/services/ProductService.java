
//In service package write down the bussiness logic here 
package com.bitsnbuytes.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsnbuytes.product.dto.ProductDTO;
import com.bitsnbuytes.product.entity.Category;
import com.bitsnbuytes.product.entity.Product;
import com.bitsnbuytes.product.mapper.ProductMapper;
import com.bitsnbuytes.product.repository.CategoryRepository;
import com.bitsnbuytes.product.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // create Product
    public ProductDTO createProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        // dto to entity by mapper
        Product product = ProductMapper.toProductEntity(productDTO);
        product.setCategory(category);
        product = productRepository.save(product);
        // entity to dto to return reponse
        return ProductMapper.toProductDTO(product);

    }

    //get all products
    public List<ProductDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::toProductDTO).collect(Collectors.toList());
    }

    //get product by id 
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    //update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // delete product give message product deleted
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
        
    }
 
    

}

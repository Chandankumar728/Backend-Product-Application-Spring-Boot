package com.bitsnbuytes.product.mapper;

import com.bitsnbuytes.product.dto.ProductDTO;
import com.bitsnbuytes.product.entity.Product;

public class ProductMapper {
    // entity to dto
    public static ProductDTO toProductDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryId(product.getCategory() != null ? product.getCategory().getId() : null);
        return productDTO;
    }

    // dto to entity
    public static Product toProductEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return product;
    }

}

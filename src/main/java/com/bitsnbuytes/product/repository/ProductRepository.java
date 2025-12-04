package com.bitsnbuytes.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsnbuytes.product.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //jparepository has inbuild function like findbyid,find etc.

}

package com.bitsnbuytes.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsnbuytes.product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}

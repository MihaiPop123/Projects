package com.example.ProjectSpring.repository;

import com.example.ProjectSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getProductById(Integer id);
}

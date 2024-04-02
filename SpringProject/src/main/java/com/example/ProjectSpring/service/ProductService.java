package com.example.ProjectSpring.service;

import com.example.ProjectSpring.entity.Product;
import com.example.ProjectSpring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) { //injectam un ProductRepository in ProductService la nivel de constructor
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll(); // findAll este o metoda gata implementata pe care o luam din ProductRepository
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductById(Integer id){
//       return productRepository.getProductById(id);
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        } else {
          throw new RuntimeException("Product with id " + id + " not found");
        }
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}

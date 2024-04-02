package com.example.ProjectSpring.controller;

import com.example.ProjectSpring.entity.Product;
import com.example.ProjectSpring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(path = "/product/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping(path = "/product/{id}")
    public Product getProductById1(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping(path = "/product")
    public Product getProductById2(@RequestParam Integer id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}

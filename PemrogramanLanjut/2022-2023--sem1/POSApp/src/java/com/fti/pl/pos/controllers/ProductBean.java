/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fti.pl.pos.controllers;

import com.fti.pl.pos.models.Product;
import com.fti.pl.pos.services.ProductService;
import com.fti.pl.pos.services.ProductServiceInterface;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Septovan D. S. Saian
 */
@Named(value = "productBean")
@RequestScoped
public class ProductBean implements Serializable {
    private Product product;
    private ProductServiceInterface productService;
    
    private boolean isCreateSuccess = false;
    

    public ProductBean() throws IOException {
        product = new Product();
        productService = new ProductService();
    }
    
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isIsCreateSuccess() {
        return isCreateSuccess;
    }

    public void setIsCreateSuccess(boolean isCreateSuccess) {
        this.isCreateSuccess = isCreateSuccess;
    }
    
       
    public void doCreateProduct(){
        int id;
        id = productService.createProduct(product);
        
        if (id != 0) isCreateSuccess = true; 
    }
    
    public List getAllProduct() {
        return productService.getProduct();
    }
}

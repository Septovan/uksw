/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fti.pl.pos.services;

import com.fti.pl.pos.models.Product;
import java.util.List;

/**
 *
 * @author Septovan D. S. Saian
 */
public interface ProductServiceInterface {
    int createProduct(Product product);
    List getProduct();
    Product getProduct(int id);
}

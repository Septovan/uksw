/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fti.pl.pos.services;

import com.fti.pl.pos.configs.DbConn;
import com.fti.pl.pos.models.Product;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author Septovan D. S. Saian
 */
public class ProductService implements ProductServiceInterface {
    
    private SqlSessionFactory sqlSessionFactory;   

    public ProductService() throws IOException {
        sqlSessionFactory = DbConn.getSqlSessionFactory();
    }       

    @Override
    public int createProduct(Product product) {   
        int generatedId = 0;
        
        SqlSession sqlSession = sqlSessionFactory.openSession();
        generatedId = sqlSession.insert("Product.insert", product);
        sqlSession.commit();
        sqlSession.close();
        
        return generatedId;
    }

    @Override
    public List getProduct() {               
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List products = sqlSession.selectList("Product.getAll");
        sqlSession.commit();
        sqlSession.close();
        
        return products;
    }

    @Override
    public Product getProduct(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Product product = sqlSession.selectOne("Product.getById", id);
        sqlSession.commit();
        sqlSession.close();
        
        return product;
    }
    
}

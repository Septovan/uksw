/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fti.pl.pos.configs;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Septovan D. S. Saian
 */
public class DbConn {
    private static SqlSessionFactory sqlSessionFactory;
    
    private DbConn() {}
    
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            Reader reader = Resources.getResourceAsReader("com/fti/pl/pos/configs/ConfigMyBatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }        
        
        return sqlSessionFactory;
    }
}

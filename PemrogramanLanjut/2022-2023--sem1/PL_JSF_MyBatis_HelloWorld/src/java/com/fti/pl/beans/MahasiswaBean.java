/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fti.pl.beans;

import com.fti.pl.models.Mahasiswa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Septovan D. S. Saian
 */
@Named
@SessionScoped
public class MahasiswaBean implements Serializable {

    public MahasiswaBean() {
    }
    
    public void doCreateMahasiswa() throws IOException {
        Reader reader = Resources.getResourceAsReader("com/fti/pl/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Mahasiswa mhs = new Mahasiswa("123456789", "OhMyGood!");
        sqlSession.insert("Mahasiswa.insert", mhs);
        sqlSession.commit();
        sqlSession.close();
    }
}

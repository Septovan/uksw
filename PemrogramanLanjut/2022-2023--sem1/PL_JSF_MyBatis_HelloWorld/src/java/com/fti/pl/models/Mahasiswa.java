/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fti.pl.models;

/**
 *
 * @author Septovan D. S. Saian
 */
public class Mahasiswa {
    private int id;
    private String nim;
    private String nama;
    
    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }
    
    public Mahasiswa() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
}

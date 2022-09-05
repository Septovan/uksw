/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_helloworld;

/**
 *
 * @author Septovan D. S. Saian
 */
public class Animal {
    public int jumlahKaki = 0;
    private int jumlahMata = 0;
    protected int jumlahJari = 0;
    
    public Animal() {
        
    }
    
    public Animal(int kaki) {
        
    }
    
    public void walk() {
        System.out.println("Walk");
    }
    
    public void run() {
        System.out.println("Run");
    }

    public int getJumlahMata() {
        return jumlahMata;
    }

    public void setJumlahMata(int jumlahMata) {
        this.jumlahMata = jumlahMata;
    }
}

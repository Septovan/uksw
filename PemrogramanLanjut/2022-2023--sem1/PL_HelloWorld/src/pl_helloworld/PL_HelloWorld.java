/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl_helloworld;

/**
 *
 * @author Septovan D. S. Saian
 */
public class PL_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        
        AvanzaG13 avanza_aryudha = new AvanzaG13();
        AvanzaG13 avanza_andre = new AvanzaG13();
        
        avanza_aryudha.cetakRoda();
        avanza_andre.cetakRoda();
        
        Cat leon = new Cat();
        leon.jumlahKaki = 4;
        leon.setJumlahMata(5);
        System.out.println("jumlah kaki leon = " + leon.jumlahKaki);
        System.out.println("jumlah mata leon = " + leon.getJumlahMata());
        leon.walk();
        
        Animal cupu = new Animal();
        System.out.println("jumlah kaki cupu = " + cupu.jumlahKaki);
        cupu.walk();
        
        Animal boy = new Cat();
        System.out.println("jumlah kaki boy = " + boy.jumlahKaki);
        boy.walk();
    }
    
}
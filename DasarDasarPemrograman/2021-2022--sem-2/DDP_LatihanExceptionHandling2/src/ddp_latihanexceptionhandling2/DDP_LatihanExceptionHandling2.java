/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ddp_latihanexceptionhandling2;

import java.util.Scanner;

/**
 *
 * @author Septovan D. S. Saian
 */
public class DDP_LatihanExceptionHandling2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String nama;
        int angka, pembagi;
        float hasil;              
            
        System.out.print("Nama = ");
        nama = input.next().toString();

        System.out.print("Masukan Angka = ");
        angka = input.nextInt();

        System.out.print("Masukan Pembagi = ");
        pembagi = input.nextInt();
        
        try {
            System.out.println("==========================");
            System.out.println("Nama = " + nama);
            hasil = angka / pembagi;
            System.out.println("Hasil Pembagian " + angka + "/" + pembagi + " = " + hasil);
        }
        catch (Exception ex) {
            System.out.println("Ada error! " + ex.toString());
        }
        /*catch(java.lang.ArithmeticException ex1) {
            System.out.println("Tidak bisa dibagi 0");
        }*/       
        
        System.out.println("Lanjutan...");
    }
    
}

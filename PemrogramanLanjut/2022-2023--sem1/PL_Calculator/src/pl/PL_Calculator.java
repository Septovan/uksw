/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl;

import java.util.Scanner;

/**
 *
 * @author Septovan D. S. Saian
 */
public class PL_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner _scanner = new Scanner(System.in);
        int result = 0;
        
        System.out.print("Masukkan angka 1: ");
        int angka1 = _scanner.nextInt();
        
        System.out.print("Masukkan angka 2: ");
        int angka2 = _scanner.nextInt();
        
        System.out.print("Masukkan operator: ");
        String operator = _scanner.next();
        
        if (operator.toLowerCase().equals("+")) {
            result = angka1 + angka2;
        }
        
        System.out.println("Hasil: " + result);
    }
    
}

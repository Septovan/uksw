package edu.uksw.fti.pbo.latihan1;

import java.util.Scanner;

public class LatihanSatu {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        int angka1; // deklarasi variable
        angka1 = 10; // inisiasi variable
        int angka2 = 10; // deklarasi + inisiasi variable

        System.out.print("Masukkan nilai angka1: ");
        try {
            angka1 = keyboardInput.nextInt();
            System.out.println("angka1: " + angka1);
        }
        catch (Exception e) {
            System.out.println("Error!");
        }
    }
}

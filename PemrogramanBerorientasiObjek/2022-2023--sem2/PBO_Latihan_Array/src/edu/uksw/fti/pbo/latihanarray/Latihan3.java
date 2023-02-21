package edu.uksw.fti.pbo.latihanarray;

import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlahNama;
        String[] nama; // deklarasi array

        System.out.print("Masukkan jumlah nama: ");
        jumlahNama = scanner.nextInt();

        nama = new String[jumlahNama]; // inisiasi array
        for (int i = 0; i < jumlahNama; i++) {
            System.out.print("Masukkan nama ke-" + (i+1) + ": ");
            nama[i] = scanner.next(); // nama[0] = ... | nama[1] = ... | nama[2] = ... | dst.
        }

        System.out.println();
        for (int i = 0; i < nama.length; i++) {
            System.out.println("Nama ke-" + (i+1) + ": " + nama[i]);
        }
    }
}

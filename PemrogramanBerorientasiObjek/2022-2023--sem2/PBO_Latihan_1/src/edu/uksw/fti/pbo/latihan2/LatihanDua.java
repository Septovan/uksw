package edu.uksw.fti.pbo.latihan2;

import java.util.Scanner;

public class LatihanDua {
    public static void main(String[] args) {
        Scanner keyInput = new Scanner(System.in);
        String nim;

        System.out.print("Masukkan kode nim: ");
        nim = keyInput.next();

        switch (nim) {
            case "70":
                System.out.println("PTIK");
                break;
            case "67":
                System.out.println("TI");
                break;
            default:
                System.out.println("BUKAN MAHASISWA");
        }

        /*if (nim.equals("70")) {
            System.out.println("PTIK");
        } else if (nim == "67") {
            System.out.println("TI");
        } else {
            System.out.println("BUKAN MAHASISWA!");
        }*/
    }
}

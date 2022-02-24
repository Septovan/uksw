/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ddp_latihanflowcontrol;

/**
 *
 * @author Septovan D. S. Saian
 */
public class DDP_LatihanFlowControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Contoh if .. else ...
         */
        /*
        int a, b;
        a = 20;
        b = a / 2;
        
        if (b > 5) {
            System.out.println("Statement(s) di dalam blok if dieksekusi");
        }
        else {
            System.out.println("Statement(s) di dalam blok else dieksekusi");
        }
        */
        
        /**
         * Contoh if .. else .. bertingkat
         */
        /*
        int bulan = 3;
        if (bulan >= 1 && bulan <= 3) {
            System.out.println("Kuartal 1");
        }
        else if (bulan >= 4 && bulan <= 6) {
            System.out.println("Kuartal 2");
        }
        else if (bulan >= 6 && bulan <= 9) {
            System.out.println("Kuartal 3");
        }
        else {
            System.out.println("Kuartal 4");
        }
        */
        
        /**
         * Contoh switch-case
         */
        /*
        int fakultas = 70;
        switch (fakultas) {
            case 67:
                System.out.println("TI");
                break;
            case 68:
                System.out.println("SI");
                break;
            case 69:
                System.out.println("DKV");
                break;
            case 70:
                System.out.println("PTIK");
                break;
            default:
                System.out.println("BUKAN FTI");
                break;
        }
        */
        
        /**
         * Contoh for
         */        
        /*
        System.out.println("Sebelum for");
        for (int i = 0; i < 5; i++) {
            System.out.println("Nilai i = " + i);
        }
        System.out.println("Setelah for");
        */
        
        /**
         * Contoh while
         */
        /*
        int i = 0;
        System.out.println("Sebelum while");
        while (i < 5) {
            System.out.println("Nilai i = " + i);
            i++;
        }
        System.out.println("Setelah while");
        */
        
        /**
         * Contoh do-while
         */        
        /*
        int n = 0;
        System.out.println("Sebelum do-while");
        do {
            System.out.println("Nilai n = " + n);
            n++;
        } while (n < 5);
        System.out.println("Setelah do-while");
        */
        
        /**
         * Contoh jump > break
         */
        /*
        int n = 0;
        System.out.println("Sebelum do-while");
        do {
            System.out.println("Nilai n = " + n);
            
            if (n == 2) {
                break;
            }
            
            n++;
        } while (n < 5);
        System.out.println("Setelah do-while");
        */
        
        /**
         * Contoh jump > continue
         */
        for (int i = 0; i <= 10; i++) {            
            if (i % 2 == 1) {
                continue;
            }
            
            System.out.println("Nilai i = " + i);
        }
    }
    
}

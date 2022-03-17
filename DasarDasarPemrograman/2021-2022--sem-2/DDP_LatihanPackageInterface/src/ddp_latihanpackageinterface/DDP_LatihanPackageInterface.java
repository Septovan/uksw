/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ddp_latihanpackageinterface;

import menu.Soto;
import menu.Indomie;

/**
 *
 * @author Septovan D. S. Saian
 */
public class DDP_LatihanPackageInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Soto sotoAyam = new Soto();
        sotoAyam.setNamaMakanan("Soto Ayam");
        sotoAyam.setHarga(8000);
        
        Soto sotoDaging = new Soto();
        sotoDaging.setNamaMakanan("Soto Daging");
        sotoDaging.setHarga(12000);
        
        Indomie indomieOriginal = new Indomie();
        indomieOriginal.setNamaMakanan("Ayam Goreng");
        indomieOriginal.setHarga(5000);
        
        Indomie indomieRendang = new Indomie();
        indomieRendang.setNamaMakanan("Rendang");
        indomieRendang.setHarga(7000);
        
        System.out.println("=MENU=");
        sotoAyam.info();
        sotoDaging.info();
        indomieOriginal.info();
        indomieRendang.info();
    }
    
}

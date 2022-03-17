/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author Septovan D. S. Saian
 */
public class Soto extends Makanan implements MenuInterface {

    @Override
    public void info() {
        System.out.println(this.getNamaMakanan() + " Harga Rp " + this.getHarga());
    }
    
}

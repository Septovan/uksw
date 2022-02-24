/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ddp_latihanexceptionhandling;

/**
 *
 * @author Septovan D. S. Saian
 */
public class DDP_LatihanExceptionHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int angka, pembagi;
        float hasil;
        
        angka = 10;
        pembagi = 0;
        
        try {
            hasil = angka / pembagi;
            System.out.println("Hasil = " + hasil);                       
        }
        catch (Exception ex) {
            System.out.println("Error!");
        }
        /*catch(java.lang.ArithmeticException exception1) {
            System.out.println("Tidak bisa dibagi 0");
        }
        catch(java.lang.ArrayIndexOutOfBoundsException exception2) {
            System.out.println("Array Index Out Of Bonds");
        }
        catch(java.lang.NumberFormatException exception3) {
            System.out.println("Angka tidak sesuai");
        }*/
    }
    
}

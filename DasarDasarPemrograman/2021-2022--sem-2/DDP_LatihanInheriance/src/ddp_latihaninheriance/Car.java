/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ddp_latihaninheriance;

/**
 *
 * @author Septovan D. S. Saian
 */
public class Car {    
    private String noPolisi;
    private String noMesin;
    
    // ALT + INSERT
    // Getter - Setter    
    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public String getNoMesin() {
        return noMesin;
    }

    public void setNoMesin(String noMesin) {
        this.noMesin = noMesin;
    }
    
    // METHOD
    public void bunyikanKlakson() {
        System.out.println("Tin! Tin!");
    }
}

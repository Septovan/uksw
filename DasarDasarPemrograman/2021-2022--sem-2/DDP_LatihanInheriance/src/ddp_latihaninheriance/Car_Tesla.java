/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ddp_latihaninheriance;

/**
 *
 * @author Septovan D. S. Saian
 */
public class Car_Tesla extends Car {
    private String jenisMobil;

    public String getJenisMobil() {
        return jenisMobil;
    }

    public void setJenisMobil(String jenisMobil) {
        this.jenisMobil = jenisMobil;
    }

    @Override
    public void bunyikanKlakson() {
        System.out.println("Sla! Sla!");
    }

    // OVERLOADING
    public void bunyikanKlakson(boolean tampilkanInfoMobil) {
        System.out.print("Mobil = " + this.getNoPolisi() + " | No Mesin = " + this.getNoMesin());
        System.out.println(" Sla! Sla!");
    }
}

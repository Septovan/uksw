/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ddp_latihaninheriance;

/**
 *
 * @author Septovan D. S. Saian
 */
public class DDP_LatihanInheriance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car_Toyota mobilSamuel = new Car_Toyota();
        mobilSamuel.setNoPolisi("H 123 A");
        mobilSamuel.setNoMesin("TOY-SAM-456");
        
        Car_Toyota mobilDavid = new Car_Toyota();
        mobilDavid.setNoPolisi("H 123 B");
        mobilDavid.setNoMesin("TOY-DAV-456");
        
        Car_Tesla mobilYanuar = new Car_Tesla();
        mobilYanuar.setJenisMobil("Tesla 3");
        mobilYanuar.setNoPolisi("Y 4 NUAR");
        mobilYanuar.setNoMesin("TES-YAN-123456");
        
        mobilSamuel.bunyikanKlakson();  // Tin! Tin!
        mobilDavid.bunyikanKlakson();   // Tin! Tin!
        mobilYanuar.bunyikanKlakson();  // Sla! Sla!
        mobilYanuar.bunyikanKlakson(true); // Mobil = Y 4 NUAR | No Mesin = TES-YAN-123456 Sla! Sla!
    }
    
}

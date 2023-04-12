package edu.uksw.fti.pbo.enkapsulasi;

import edu.uksw.fti.pbo.enkapsulasi.model.April;
import edu.uksw.fti.pbo.enkapsulasi.model.Kalender;

public class Main {

    private static String getTime(Kalender k) {
        return k.getTanggal() + "-" + k.getBulan() + "-" + k.getTahun();
    }

    public static void main(String[] args) {
        Kalender kalender1 = new Kalender(4, 4, 2023);
        System.out.println(getTime(kalender1));
        Kalender.iniStaticMethod();

        April april1 = new April(4, 4, 2023);
        System.out.println(getTime(april1));
    }

}

package edu.uksw.fti.pbo.latihan_oop;

public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa();
        Mahasiswa mhs2 = new Mahasiswa(
                "702021014",
                "Alex ganteng",
                3.74d
            );

        System.out.println("mhs1 nim = " + mhs1.nim); // null
        System.out.println("mhs2 nim = " + mhs2.nim); // 70202104

        mhs1.mengerjakanTugas("PBO");
        mhs2.mengerjakanTugas("SBD");
        System.out.println("mhs1 tugas = " + mhs1.tugas); // PBO
        System.out.println("mhs2 tugas = " + mhs2.tugas); // SBD

        mhs1.nim = "702021017";
        mhs1.tugas = "BAHASA INDONESIA";
        System.out.println("mhs1 nim = " + mhs1.nim); // 702021017
        System.out.println("mhs1 tugas = " + mhs1.tugas); // BAHASA INDONESIA
    }
}

package edu.uksw.fti.pbo.latihan_oop;

public class Mahasiswa {
    // Attribute
    public String nim;
    public String nama;
    public double ipk;
    public String tugas;

    // Constructor
    public Mahasiswa() {} // default dipanggil = tidak diperlu dideklarasikan

    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    // Behavior/Method/Operation
    public void mengerjakanTugas(String tugas) {
        this.tugas = tugas;
    }
}

package edu.uksw.fti.pbo.latihanarray;

public class Latihan1 {
    public static void main(String[] args) {
        int nilai[] = new int[3]; // panjang array? => 3
        nilai[0] = 70;
        nilai[1] = 80;
        nilai[2] = 95;

        // hitung rata-rata?

        // #Cara 1
        float totalNilai = nilai[0] + nilai[1] + nilai[2];
        float rataRata = totalNilai / nilai.length; // => totalNilai / 3;
        System.out.println("Hasil cara 1: " + rataRata);

        // #Cara 2
        float total = 0, rerata;
        for (int i = 0; i < nilai.length; i++) {
            total += nilai[i];
        }
        rerata = total / nilai.length;
        System.out.println("Hasil cara 2: " + rerata);

        // #Cara 3
        float jumlahNilai = 0;
        for (int i = 0; i < nilai.length; i++) {
            jumlahNilai += nilai[i];
        }
        jumlahNilai /= nilai.length;
        System.out.println("Hasil cara 3: " + jumlahNilai);
    }
}

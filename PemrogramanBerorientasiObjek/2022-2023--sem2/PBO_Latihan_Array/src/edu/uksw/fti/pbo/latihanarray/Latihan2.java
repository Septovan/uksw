package edu.uksw.fti.pbo.latihanarray;

public class Latihan2 {
    public static void main(String[] args) {
        int[] arr1 = { 10, 8, 6, 11, 12, 7 };
        int[] arr2 = new int[3];

        System.arraycopy(arr1, 3, arr2, 0, arr2.length);

        System.out.println("Array 1");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " | ");
        }
        System.out.println();

        System.out.println("Array 2");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " | ");
        }
    }
}

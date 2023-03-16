package edu.uksw.fti.pbo.tts.bagian3;

public class Main {
    public static void main(String[] args) {
        String text = "081235689600"; // menjadi = +62 81-235-689-600

        // Cara #1
        String bagA = text.substring(0, 3).replace("0", "+62 ").concat("-");
        String bagB = text.substring(3, 6).concat("-");
        String bagC = text.substring(6, 9).concat("-");
        String bagD = text.substring(9, 12);

        System.out.println(bagA + bagB + bagC + bagD);

        // Cara #2
        char[] textInCharArray = text.toCharArray(); // textInCharArray = [0][8][1][2][3][5][6][8][9][6][0][0]
        int counter = 1;
        String formattedText = "";
        for (int i=0; i < textInCharArray.length; i++){
            if (i == 0) {
                formattedText += "+62 ";
            } else if (counter == 3 && i != (textInCharArray.length-1)) {
                formattedText += textInCharArray[i]+"-";
            } else {
                formattedText += textInCharArray[i];
            }

            counter++;
            if (counter > 3) counter = 1;
        }

        System.out.println(formattedText);
    }
}
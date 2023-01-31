public class ErrorHandling {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        try {
            b = a/0;
        }
        catch (Exception e) { }

        System.out.println("Nilai b: " + b);
    }
}

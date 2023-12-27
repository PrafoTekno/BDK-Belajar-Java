
import java.util.Scanner;

public class Main {

    private static int Fibonacci (int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return Fibonacci (n-1) + Fibonacci (n-2);
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        int suku_ke;

        System.out.print ("Masukan suku ke : ");
        suku_ke = input.nextInt();

        System.out.println ("Suku ke " + suku_ke + " : " + Fibonacci (suku_ke) + "\n");

    }
}
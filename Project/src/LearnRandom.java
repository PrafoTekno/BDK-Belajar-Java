
import java.util.Random;
import java.util.Scanner;

public class LearnRandom {

    public static void main (String[] args) {

        Scanner my_input = new Scanner (System.in);
        Random my_random = new Random();

        int a, b, c, hasil;

        System.out.print ("\nMasukan batas bawah untuk random : ");
        a = my_input.nextInt ();
        System.out.print ("Masukan batas atas untuk random : ");
        b = my_input.nextInt ();
        System.out.print ("Masukan kelipatannya : ");
        c = my_input.nextInt ();

        System.out.println ("\nIni dia 10 angka random mu : \n");

        for (int i = 0; i < 10; i++) {

            hasil = a + c*my_random.nextInt (b-a+1);

            System.out.printf ("Angka ke %d -> %d\n", i+1, hasil);

        }

    }


}

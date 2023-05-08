
import java.util.Scanner;
import java.util.Random;

class Cards {

    static int [][] kartu = new int [2][10];
    static int [] index = new int [11];

    static int [] c1 = new int [10];
    static int [] c2 = new int [10];

    static int sisa_kartu = 0;

    private static int acak () {
        Random rand = new Random();
        return 1 + rand.nextInt (10);
    }

    public static void Jawaban () {

        int tampung;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {

                tampung = 0;
                while (tampung < 1) {
                    kartu[i][j] = acak ();

                    if (index[kartu[i][j]] < 2) {
                        index[kartu[i][j]] ++;
                        tampung++;
                    }
                }

            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf ("[%d]", kartu[i][j]);
            }
            System.out.println ("");
        }

    }

    public static void Soal (int a) {

        int index_x = -1, index_y = -1;

        if (a == 1) {
            sisa_kartu += 1;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < sisa_kartu; k++) {
                    if (c1[k] == kartu[i][j] || c2[k] == kartu[i][j]) {
                        index_y = i;
                        index_x = j;
                    }
                }
                if (i == index_y && j == index_x) {
                    System.out.printf ("[%d]", kartu[index_y][index_x]);
                    continue;
                }

                System.out.print ("[x]");
            }
            System.out.println ("");
        }

    }


}

public class Modul_13_Lego
{
    public static void main (String [] args){

        Scanner input = new Scanner(System.in);
        int mulai;
        int koor1_x, koor1_y;
        int koor2_x, koor2_y;

        Cards.Jawaban();

        System.out.println ("Silahkan tekan 1 untuk mulai ");
        mulai = input.nextInt ();

        int kesempatan = 0;
        int le = 0;

        if (mulai == 1) {

            for (int i = 0; i < 99999; i++) {
                System.out.println ("\n");
            }

            int tes;

            Cards.Soal(le);

            System.out.println ("");

            while (kesempatan < 3 && Cards.sisa_kartu < 10) {

                do {

                    tes = 0;

                    System.out.print ("Masukan kartu 1 (y,x) : ");
                    koor1_y = input.nextInt();
                    koor1_x = input.nextInt();
                    System.out.print ("Masukan kartu 2 (y,x) : ");
                    koor2_y = input.nextInt();
                    koor2_x = input.nextInt();

                    for (int i = 0; i < Cards.sisa_kartu; i++) {
                        if (Cards.c1[i] == Cards.kartu[koor1_y][koor1_x] || Cards.c1[i] == Cards.kartu[koor2_y][koor2_x] || Cards.c2[i] == Cards.kartu[koor1_y][koor1_x] || Cards.c2[i] == Cards.kartu[koor2_y][koor2_x]) {
                            tes++;
                        }
                    }

                    if (tes > 0) {
                        System.out.println("Kamu memilih kartu yang telah dibuka");
                    }

                }
                while (tes > 0);

                if (Cards.kartu[koor1_y][koor1_x] == Cards.kartu[koor2_y][koor2_x]) {
                    System.out.println ("Kamu menjawab dengan benar\n");
                    Cards.c1[Cards.sisa_kartu] = Cards.kartu[koor1_y][koor1_x];
                    Cards.c2[Cards.sisa_kartu] = Cards.kartu[koor2_y][koor2_x];
                    le = 1;
                }
                else {
                    System.out.println ("Kamu menjawab dengan salah\n");
                    le = 0;
                    kesempatan ++;
                }

                Cards.Soal(le);

            }

            if (kesempatan < 3) {
                System.out.println ("\nKamu menang");
            }
            else {
                System.out.println ("\nKamu kalah");
            }

        }

    }
}

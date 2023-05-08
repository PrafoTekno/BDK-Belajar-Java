
import java.util.*;

class Permainan {

    static int [][] card = new int [5][4];
    static int [] index_card = new int [10];
    static int [] kartu_tebak1 = new int [10];
    static int [] kartu_tebak2 = new int [10];
    static int count = 0;

    private static int Acak () {
        Random rand = new Random ();
        return rand.nextInt (10);
    }

    public static void Jawaban () {

        int tampung;

        for (int i = 0; i < 10; i++) {
            kartu_tebak1[i] = -1;
            kartu_tebak2[i] = -1;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {

                tampung = 0;
                while (tampung < 1) {
                    card[i][j] = Acak();
                    if (index_card[card[i][j]] < 2) {
                        index_card[card[i][j]]++;
                        tampung++;
                    }
                }

            }
        }

        // Tmapilkan

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf ("| %d ", card[i][j]);
            }
            System.out.println ("|");
        }

    }

    public static void Tebak (boolean a) {

        int y = -1, x = -1;

        if (a == true) {
            count++;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {

                for (int k = 0; k < count; k++) {  // Buka kartu
                    if (card[i][j] == kartu_tebak1[k] || card[i][j] == kartu_tebak2[k]) { // cek pasangan kartu apa yang benar
                        y = i;
                        x = j;
                    }
                }

                if (i == y && j == x) {
                    System.out.printf ("|   %d   ", card[y][x]);
                    continue;
                }

                System.out.printf ("| (%d,%d) ", i, j);
            }
            System.out.println ("|");
        }

    }

}

public class Tes1 {

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);

        int kartu1_x, kartu1_y;
        int kartu2_x, kartu2_y;
        boolean benar = false;

        System.out.println ("Silahkan mengingat 20 kartu berikut selama 20 detik");

        try {
            Permainan.Jawaban();
            Thread.sleep (2000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < 99999; i++) {
            System.out.println ("\n");
        }

        System.out.println ("Note : pilih kartu (0<y<5; 0<x<4)\n");
        Permainan.Tebak(benar);

        int n_kalah = 0;
        int cek_angka;

        while (n_kalah < 3 && Permainan.count < 10) {

            do {

                cek_angka = 0;

                System.out.print ("\nPilih kartu 1 (y,x) : ");
                kartu1_y = input.nextInt ();
                kartu1_x = input.nextInt ();
                System.out.print ("Pilih kartu 2 (y,x) : ");
                kartu2_y = input.nextInt ();
                kartu2_x = input.nextInt ();

                for (int r = 0; r < Permainan.count; r++) {
                    if (Permainan.kartu_tebak1[r] == Permainan.card[kartu1_y][kartu1_x] || Permainan.kartu_tebak1[r] == Permainan.card[kartu2_y][kartu2_x] || Permainan.kartu_tebak2[r] == Permainan.card[kartu1_y][kartu1_x] || Permainan.kartu_tebak2[r] == Permainan.card[kartu2_y][kartu2_x]) {
                        cek_angka++;
                    }
                }

                if (cek_angka > 0) {
                    System.out.println ("Error 102 : Kamu memilih kartu yang sudah terbuka\n");
                }
            }
            while (cek_angka > 0);

            if (Permainan.card[kartu1_y][kartu1_x] == Permainan.card[kartu2_y][kartu2_x]) {
                benar = true;
                Permainan.count += 1;

                Permainan.kartu_tebak1[Permainan.count] = Permainan.card[kartu1_y][kartu1_x];
                Permainan.kartu_tebak1[Permainan.count] = Permainan.card[kartu2_y][kartu2_x];

                System.out.println ("Kamu benar");
            }
            else {
                benar = false;
                n_kalah += 1;
                System.out.println ("Kamu salah");
            }

            Permainan.Tebak (benar);
        }

        if (n_kalah >= 3) {
            System.out.println ("Kamu Kalah");
        }
        else {
            System.out.println ("Kamu menang");
        }

    }

}
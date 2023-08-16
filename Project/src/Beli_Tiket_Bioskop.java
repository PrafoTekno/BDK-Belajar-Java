
import java.util.Scanner;
import java.util.Random;

class Bioskop {

    static int [][] bangku = new int [5][7];

    static int [] no_bangku_dipilih = new int [28];
    static int n_bangku = -1;
    static int [] index = new int [28];

    public static void Reset () {

        int tampung;

        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {

                tampung = 0;

                while (tampung < 1) {

                    bangku[i][j] = rand.nextInt (28);

                    if (index[bangku[i][j]] < 1) {
                        index[bangku[i][j]]++;
                        tampung++;
                    }

                }

            }

        }
    }

    public static void Bangku () {

        int s = -1, r = -1;

        System.out.println ("");

        for (int i = 0; i < 5; i++) {

            if (i == 0) {
                System.out.print ("| @ | ");
            }

            for (int j = 0; j < 7; j++) {
                if (i < 1) {
                    System.out.printf("%d | ", j + 1);
                    if (j == 0) {
                        continue;
                    }
                }
                if (j < 1) {
                    System.out.printf("| %d | ", i);
                }
                if (i >= 1) {

                    for (int k = 0; k < n_bangku; k++) {
                        if (bangku[i-1][j] == no_bangku_dipilih[k]) { // cek bangku yang udah dipilih
                            s = i-1;
                            r = j;
                        }
                    }

                    if (i-1 == s && r == j) {
                        System.out.printf ("#   ", bangku[s][r]);
                        continue;
                    }

                    System.out.print ("0   ");

                }

            }

            System.out.println (" ");
        }

    }
}

class Tiket {

    int ID;
    int no_kursi_y, no_kursi_x;

    public void Acak_ID () {
        Random rand = new Random ();
        ID = 1000 + rand.nextInt (8999);
    }

    public void Tampilkan () {
        System.out.println ("\n-----------------------");
        System.out.printf ("ID       : %d\n", ID);
        System.out.printf ("No kursi : (%d, %d)\n", no_kursi_y, no_kursi_x);
        System.out.println ("-----------------------\n");
    }

}

public class Beli_Tiket_Bioskop{

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);

        Tiket [] tiket = new Tiket [29];
        for (int i = 0; i < tiket.length; i++) {
            tiket[i] = new Tiket ();
        }

        int beli;
        int n = -1;
        int baris, kolom;
        int cek = 0;

        System.out.println ("\nBIOSKOP AUGIL\n");
        Bioskop.Reset();

        do {

             n++;
             Bioskop.n_bangku++;
             tiket[n].Acak_ID ();
             System.out.println ("================================\n================================             (Layar)\n");

             Bioskop.Bangku();

             do {
                 System.out.print ("Pilih bangku (baris, kolom) : ");
                 baris = input.nextInt ();
                 kolom = input.nextInt ();

                 for (int s = 0; s < Bioskop.n_bangku; s++) {
                     if (Bioskop.no_bangku_dipilih[s] == Bioskop.bangku[baris-1][kolom-1]) {
                         cek = 1;
                     }
                 }

                 if (cek == 1) {
                     System.out.println ("Kursi sudah dibooking\n");
                 }
             }
             while (cek == 1);
             Bioskop.no_bangku_dipilih[Bioskop.n_bangku] = Bioskop.bangku[baris-1][kolom-1];
             tiket[n].no_kursi_y = baris;
             tiket[n].no_kursi_x = kolom;

             System.out.println ("Ini Tiket mu");
             tiket[n].Tampilkan();

            System.out.print("Beli tiket lagi (1 = ya, 0 = no) : ");
            beli = input.nextInt();

        }

        while (beli == 1);

    }

}

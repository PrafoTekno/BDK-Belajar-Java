
import java.util.*;

class Bermain {

    static final int MAX = 20;
    static int [][] angka = new int [MAX/5+1][MAX/4+1];
    static int [] index = new int [10];
    static int [] pasangan1 = new int [MAX];
    static int [] pasangan2 = new int [MAX];

    static int status;

    private static int Acak () {
        Random rand = new Random ();
        return 0 + rand.nextInt (10);
    }

    public static void Arena (int a) {

        int tampung;

        if (a == 0) {
            for (int i = 0; i < (MAX/5); i++) {
                for (int j = 0; j < MAX/4; j++) {

                    tampung = 0;

                    while (tampung < 1) {

                        angka[i][j] = Acak();

                        if (index[angka[i][j]] < 2) {
                            index[angka[i][j]]++;
                            tampung++;
                        }

                    }

                }

            }
        }

        // Tampilkan

        for (int i = 0; i < (MAX/5)+1; i++) {
            if (i == 0) {
                System.out.print ("| $ | ");
            }
            for (int j = 0; j < (MAX/4); j++) {
                if (i < 1) {
                    System.out.printf ("%d | ", j+1);
                    if (j == 0) {
                        continue;
                    }
                }
                if (j < 1) {
                    System.out.printf ("| %d | ", i);
                }
                if (i >= 1) {
                    System.out.printf ("%d---", angka[i-1][j]);
                }

            }
            System.out.println (" ");
        }

    }

    public static void Tutup_Arena (boolean a) {

        int s = -1, r = -1;
        int cek;

        System.out.println ("");

        if (a == true) {
            status ++;
        }

        for (int i = 0; i < (MAX/5)+1; i++) {

           cek = 0;

            if (i == 0) {
                System.out.print ("| $ | ");
            }

            for (int j = 0; j < (MAX/4); j++) {
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

                    for (int k = 0; k < status; k++) {  // Buat buka kartu yang telah benar ditebak
                        if (angka[i-1][j] == pasangan1[k] || angka[i-1][j] == pasangan2[k]) { // cek pasangan kartu apa yang benar
                            s = i-1;
                            r = j;
                        }
                    }

                    if (i-1 == s && r == j) {
                        System.out.printf ("%d---", angka[s][r]);
                        continue;
                    }

                    System.out.print ("#---");

                }

            }

            System.out.println (" ");
        }

    }

}

public class Modul_13_Salfa {

    private static void Jawaban (int delay, int status) {

        try {
            Bermain.Arena (status);
            Thread.sleep (delay);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < 99999; i++) {
            System.out.println ("\n");
        }

    }

    private static void Data_Player (double w, int l, int n, int d) {

        double persen_benar = (w/Bermain.status) * 100;
        String status_player;

        System.out.println ("Ini dia statistik data mu");
        System.out.println ("------------------------------------------------------");
        System.out.printf ("Persentase benar mu %.2f dari 100\n", persen_benar);
        System.out.printf ("Persentase salah mu %.2f dari 100\n", 100-persen_benar);
        System.out.printf ("Kamu salah menjawab sebanyak %d dari %d kali menjawab\n", l, n);
        System.out.println ("------------------------------------------------------");

        if (persen_benar > 100-persen_benar) {
            status_player = "sangat";
        }
        else if (persen_benar == 100-persen_benar) {
            status_player = "cukup";
        }
        else {
            status_player = "kurang";
        }

        System.out.printf ("\nMelihat data yang ada, kamu memiliki ingatan yang %S baik untuk level %d detik\n", status_player, d);

    }

    public static void main (String [] args) {

        Scanner input = new Scanner(System.in);

        int angka_tebak1_x, angka_tebak1_y;
        int angka_tebak2_x, angka_tebak2_y;
        boolean benar = false;
        int salah = 0, bantuan;

        int delay;
        double itung_benar = 0;
        int n = 0;

        System.out.println("\n======= Seberapa Baik Ingatan Mu? =======\n");

        do {
            System.out.print("Butuh waktu berapa detik untuk menghafal 20 kartu (3 - 20 detik) : ");
            delay = input.nextInt();
            if (delay > 20 || delay < 3) {
                System.out.println("Error 115 : Input tidak sesuai\n");
            }
        }
        while (delay > 20 || delay < 3);

        System.out.printf("\nSilahkan perhatikan susunan angka ini baik-baik (selama %d detik)\n\n", delay);
        Jawaban(delay * 1000, 0);

        System.out.print("Note : Pililah angka yang sesuai dengan kartu yang disajikan!");

        Bermain.Tutup_Arena(benar);

        while (Bermain.status < 10) {

            benar = false;
            int cek_angka;
            int cek_kondisi;

            do {  // Cek kesesuaian input

                // Biar error yang kendalikan adalah programmer, bukan system

                cek_angka = 0;
                cek_kondisi = 0;

                System.out.print("\n\nSilahkan pilih koordinat kartu pertama (y,x): ");
                angka_tebak1_y = input.nextInt ();
                angka_tebak1_x = input.nextInt ();
                System.out.print("Silahkan pilih koordinat kartu kedua (y,x): ");
                angka_tebak2_y = input.nextInt ();
                angka_tebak2_x = input.nextInt ();

                for (int s = 0; s < Bermain.status; s++) {
                    if (Bermain.pasangan1[s] == Bermain.angka[angka_tebak1_y-1][angka_tebak1_x-1] || Bermain.pasangan1[s] == Bermain.angka[angka_tebak2_y-1][angka_tebak2_x-1] || Bermain.pasangan2[s] == Bermain.angka[angka_tebak1_y-1][angka_tebak1_x-1] || Bermain.pasangan2[s] == Bermain.angka[angka_tebak2_y-1][angka_tebak2_x-1]) {
                        cek_angka++;
                    }
                }

                if (cek_angka > 0) {
                    System.out.println ("Error 102 : Kamu memilih kartu yang sudah terbuka\n");
                }
                else if (angka_tebak1_x == angka_tebak2_x && angka_tebak1_y == angka_tebak2_y) {
                    System.out.println ("Error 104 : Kamu memilih 1 kartu yang sama\n");
                }
                else if (angka_tebak1_x < 1 || angka_tebak1_x > 5  || angka_tebak1_y < 1 || angka_tebak1_y > 4 || angka_tebak2_x < 1 || angka_tebak2_x > 5  || angka_tebak2_y < 1 || angka_tebak2_y > 4) {
                    System.out.println ("Error 113 : Kartu yang dipilih tidak ada yang sesuai\n");
                }
                else {
                    System.out.println ("");
                    cek_kondisi = 1;
                }

            }
            while (angka_tebak1_x == angka_tebak2_x && angka_tebak1_y == angka_tebak2_y || angka_tebak1_x < 1 || angka_tebak1_x > 5  || angka_tebak1_y < 1 || angka_tebak1_y > 4 || angka_tebak2_x < 1 || angka_tebak2_x > 5  || angka_tebak2_y < 1 || angka_tebak2_y > 4 || cek_angka > 0);

            if (cek_kondisi == 1) {

                if (Bermain.angka[angka_tebak1_y-1][angka_tebak1_x-1] == Bermain.angka[angka_tebak2_y-1][angka_tebak2_x-1]) {

                    benar = true;
                    System.out.println(">> Kamu benar <<");
                    salah = 0;
                    itung_benar += 1;

                    Bermain.pasangan1[Bermain.status] = Bermain.angka[angka_tebak1_y-1][angka_tebak1_x-1];
                    Bermain.pasangan2[Bermain.status] = Bermain.angka[angka_tebak2_y-1][angka_tebak2_x-1];

                }
                else {

                    System.out.println(">> Kamu salah <<");
                    itung_benar -= 0.4;
                    salah++;

                    if (salah % 6 == 0) {
                        System.out.print ("\nPerlu bantuan? (1 = ya) : ");
                        bantuan = input.nextInt ();

                        if (bantuan == 1) {
                            System.out.printf ("\nHanya %d detik untuk mu melihat kembali jawabannya\n\n", delay-2);
                            Jawaban ((delay*1000)-2000, 1);
                            System.out.println ("Note : Pililah angka yang sesuai dengan kartu yang disajikan! ");
                        }
                    }

                }

                Bermain.Tutup_Arena(benar);
                System.out.printf ("\n******************************** %d pasang kartu lagi\n", (Bermain.MAX/2)-Bermain.status);

                n++;
            }

        }

        System.out.println ("\n\n \\^.^/ Selamat kamu telah menyelesaikan permainan ini \\^.^/\n\n");
        Data_Player (itung_benar, n-Bermain.status, n, delay);

    }

}

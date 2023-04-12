
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

class Game {

    static final int MAX = 20;
    static int [] angka = new int[MAX];
    static ArrayList<Integer> index = new ArrayList<>(MAX);
    static int [] index_array = new int [MAX];
    static int status = 0;
    static int [] pasangan1 = new int [MAX];
    static int [] pasangan2 = new int [MAX];

    public static void Arena (int s) {

        for (int i = 0; i < angka.length; i++) {  //isi nilai array 1-10 sebanyak 2 kali
            if (i > 9) {
                angka[i] = (i - 10);
            } else {
                angka[i] = i;
            }
        }

        if (s == 1) {

            for (int i = 0; i < angka.length; i++) {
                index.add (i);
            }

            Collections.shuffle(index);
        }

        index_array = index.stream().mapToInt(Integer::intValue).toArray(); //convert list ke int array

        for (int i = 0; i < angka.length; i++) {
            if (i % 4 == 0) {
                System.out.println("");
            }
            System.out.print(angka[index_array[i]] + " | ");
        }

    }

    public static void Tutup_Arena (boolean a) {

        System.out.println ("");

        if (a == true) {
            status ++;
        }

        for (int i = 0; i < angka.length; i++) {

            int s = -1;

            if (i % 4 == 0) {
                System.out.println ("");
            }

            for (int j = 0; j < status; j++) {
                if (i == pasangan1[j]) {
                    s = pasangan1[j];
                }
                if (i == pasangan2[j]) {
                    s = pasangan2[j];
                }
            }

            if (i == s) {
                System.out.print (" # | ");
                continue;
            }

            if (i < 9) {
                System.out.printf ("0%d | ", i+1);
            }
            else {
                System.out.printf ("%d | ", i+1);
            }

        }

    }

}

public class Modul_11_Salfa {

    private static void Jawaban (int delay, int status) {

        try {
            Game.Arena (status);
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

        double persen_benar = (w/Game.status) * 100;
        String status_player = "";

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

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        int angka_tebak1, angka_tebak2;
        boolean benar = false;
        int salah = 0, bantuan;

        int delay;
        double itung_benar = 0;
        int n = 0;

        System.out.println("\n======= Seberapa Baik Ingatan Mu? =======\n");

        do {
            System.out.print ("Butuh waktu berapa detik untuk menghafal 20 kartu (3 - 20 detik) : ");
            delay = input.nextInt ();
            if (delay > 20 || delay < 3) {
                System.out.println ("Error 115 : Input tidak sesuai\n");
            }
        }
        while (delay > 20 || delay < 3);

        System.out.printf ("\nSilahkan perhatikan susunan angka ini baik-baik (selama %d detik)\n", delay);
        Jawaban (delay*1000, 1);

        System.out.print ("Note : Pililah angka yang sesuai dengan kartu yang disajikan!");
        Game.Tutup_Arena(benar);

        while (Game.status < 10) {

            benar = false;
            int cek_angka;
            int cek_kondisi;

            do {  // Cek kesesuaian input

                // Biar error yang kendalikan adalah programmer, bukan system

                cek_angka = 0;
                cek_kondisi = 0;

                System.out.print("\n\nSilahkan pilih kartu pertama : ");
                angka_tebak1 = input.nextInt();
                System.out.print("Silahkan pilih kartu kedua : ");
                angka_tebak2 = input.nextInt();

                for (int s = 0; s < Game.status; s++) {
                    if (Game.pasangan1[s] == angka_tebak1 - 1 || Game.pasangan2[s] == angka_tebak2 - 1 || Game.pasangan1[s] == angka_tebak2 - 1 || Game.pasangan2[s] == angka_tebak1 - 1) {
                        cek_angka++;
                    }
                }

                if (cek_angka > 0) {
                    System.out.println ("Error 102 : Kamu memilih kartu yang sudah terbuka\n");
                }
                else if (angka_tebak1 == angka_tebak2) {
                    System.out.println ("Error 104 : Kamu memilih kartu 1 kartu yang sama\n");
                }
                else if (angka_tebak1 < 0 || angka_tebak1 > 20  || angka_tebak2 < 0 || angka_tebak2 > 20) {
                    System.out.println ("Error 113 : Kartu yang dipilih tidak ada yang sesuai\n");
                }
                else {
                    System.out.println ("");
                    cek_kondisi = 1;
                }

            }
            while (angka_tebak1 < 0 || angka_tebak1 > 20  || angka_tebak2 < 0 && angka_tebak2 > 20 || cek_angka > 0 || angka_tebak1 == angka_tebak2);

            if (cek_kondisi == 1) {

                if (Game.angka[Game.index_array[angka_tebak1 - 1]] == Game.angka[Game.index_array[angka_tebak2 - 1]]) {

                    benar = true;
                    System.out.println("Kamu benar");
                    salah = 0;
                    itung_benar += 1;

                }
                else {

                    System.out.println("Kamu salah");
                    itung_benar -= 0.4;
                    salah++;

                    if (salah % 6 == 0) {
                        System.out.print ("\nPerlu bantuan? (1 = ya) : ");
                        bantuan = input.nextInt ();

                        if (bantuan == 1) {
                            System.out.printf ("\nHanya %d detik untuk mu melihat kembali jawabannya\n", delay-2);
                            Jawaban ((delay*1000)-2000, 0);
                            System.out.println ("Note : Pililah angka yang sesuai dengan kartu yang disajikan! ");
                        }
                    }

                }

                Game.pasangan1[Game.status] = angka_tebak1 - 1;
                Game.pasangan2[Game.status] = angka_tebak2 - 1;

                Game.Tutup_Arena(benar);
                System.out.printf ("\t\t%d pasang kartu lagi\n", (Game.MAX/2)-Game.status);

                n++;
            }

        }

        System.out.println ("\n\n \\^.^/ Selamat kamu telah menyelesaikan permainan ini \\^.^/\n\n");
        Data_Player (itung_benar, n-Game.status, n, delay);

    }

}

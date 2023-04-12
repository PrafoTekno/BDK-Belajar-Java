
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/*
    Untuk melihat apakah codingan berjalan sesuai atau tidak, silahkan
    aktifkan coment yang diberi tanda //*
 */

class Kelas_Game {

    static int angka1, angka2, hasil;
    int jawaban_pemain;

    public int Acak () {

        Random rand = new Random ();

        angka1 = 1 + rand.nextInt (10);
        angka2 = 1 + rand.nextInt (10);
        hasil = angka1 + angka2;

        return hasil;

    }

    public int Menebak () {

        Scanner input = new Scanner (System.in);

        System.out.print ("Silahkan tebak hasil penjumlahan 2 angka berikut : ");
        jawaban_pemain = input.nextInt ();

        return jawaban_pemain;

    }

}

public class Modul_10_Salfa {

    public static void main(String[] args) {

        final int MAX_array = 20;

        int[] poin_player = new int[MAX_array];
        int[] jawaban_player = new int[MAX_array];
        int[] selisih_jawaban = new int[MAX_array];

        int jawaban_benar;
        int skor_total = 0;
        int pemenang = 0;
        int batas;

        Kelas_Game game = new Kelas_Game();
        Scanner input = new Scanner(System.in);

        System.out.println("\n======== Game Tebakan Angka ========\n");

        System.out.println("Aturan main : \nHanya ada 2 buah bilangan bulat yang diacak antara 1-10");
        System.out.println("Masing masing pemain akan mendapatkan giliran untuk menebak hasil jumlah keddua bilangan tersebut");
        System.out.println("Pemain dengan jawaban yang paling mendekati, akan mendapat 10 poin");
        System.out.println("Pemain dengan jawaban yang paling mendekati kedua, akan mendapat 5 poin");
        System.out.println("Jika terdapat lebih dari 1 player menjawab benar dengan jawaban yang sama, maka poin akan diberikan kepada player yang lebih dulu menjawab");
        System.out.println("Permainan akan berakhir jika, jumlah poin keseluruhan player sudah mencapai 100 poin\n");

        do {
            System.out.print("Berapa banyak player yang akan bermain (MAX 20 orang) : ");
            batas = input.nextInt();
        }
        while (batas > 20);

        System.out.println("\n>>>> Mulai permainan <<<<\n");

        while (skor_total < 100) {

            skor_total = 0;

            jawaban_benar = game.Acak();
            //* System.out.println(jawaban_benar);

            // Tulis jawabannya dulu

            for (int i = 0; i < batas; i++) {
                System.out.printf("..Giliran player %d..\n", i + 1);
                jawaban_player[i] = game.Menebak();
                selisih_jawaban[i] = Math.abs(jawaban_player[i] - jawaban_benar);
                //* System.out.println(selisih_jawaban[i]);
            }

            // Menentukan siapa yang jawabannya paling pertama mendekati benar

            int[] nilai_terdekat = new int[MAX_array];

            int index_nilai_terdekat = 0;

            for (int i = 0; i < batas; i++) {
                nilai_terdekat[i] = 0;
            }

            for (int i = 0; i < batas; i++) {

                for (int j = i + 1; j < batas; j++) {

                    if (selisih_jawaban[i] <= selisih_jawaban[j]) {
                        index_nilai_terdekat = i;
                    } else {
                        index_nilai_terdekat = j;
                    }
                    nilai_terdekat[index_nilai_terdekat]++;
                }

            }

            int tampung = 0;
            int tampung1 = 0;
            int index_nilai_terdekat1 = 0;

            // Cek nilai terdekat mana yang paling dekat

            for (int i = 0; i < batas; i++) { //cari terdekat pertama
                if (nilai_terdekat[i] > tampung) {
                    tampung = nilai_terdekat[i];
                    index_nilai_terdekat = i;
                }
            }

            /* //*
            System.out.println ("");
            for (int i = 0; i < batas; i++) {
                System.out.printf ("banyak nilai terdekat[%d] = %d\n", i, nilai_terdekat[i]);
            }
            */

            System.out.printf ("\nPlayer dengan nilai terdekat pertama = %d\n", index_nilai_terdekat+1);

            for (int i = 0; i < batas; i++) {  //reset
                nilai_terdekat[i] = 0;
            }

            for (int i = 0; i < batas; i++) {

                if (i == index_nilai_terdekat) {
                    continue;
                }

                //* System.out.println(i);

                for (int j = i+1; j < batas; j++) {
                    if (j == index_nilai_terdekat) {
                        continue;
                    }

                    if (selisih_jawaban[i] <= selisih_jawaban[j]) {
                        index_nilai_terdekat1 = i;
                    }
                    else {
                        index_nilai_terdekat1 = j;
                    }
                    nilai_terdekat[index_nilai_terdekat1]++;
                }

            }

            /*
            for (int i = 0; i < batas; i++) {
                if (i == index_nilai_terdekat) {
                    continue;
                }
                System.out.printf ("banyak nilai terdekat[%d] = %d\n", i, nilai_terdekat[i]);
            }

             */

            // Cek nilai terdekat kedua

            for (int i = 0; i < batas; i++) {

                if (i == index_nilai_terdekat) {
                    continue;
                }

                if (nilai_terdekat[i] > tampung1) {
                    tampung1 = nilai_terdekat[i];
                    index_nilai_terdekat1 = i;
                }
            }

            System.out.printf ("Player dengan nilai terdekat kedua = %d\n", index_nilai_terdekat1+1);

            for (int i = 0; i < batas; i++) {
                if (i == index_nilai_terdekat) {
                    poin_player[i] += 10;
                }
                else if (i == index_nilai_terdekat1) {
                    poin_player[i] += 5;
                }
                else {
                    poin_player[i] += 0;
                }
            }

            System.out.printf ("\nJawaban yang benar adalah = %d\n", jawaban_benar);

            // Menampilkan poin sementara

            System.out.println ("\n--- Poin Sementara ---\n");

            for (int i = 0; i < batas; i++) {
                System.out.printf ("Poin player %d = %d\n", i+1, poin_player[i]);
            }

            // Itung skor total

            for (int i = 0; i < batas; i++) {
                skor_total += poin_player[i];
            }

            System.out.println ("\nTotal skor " + skor_total);

            System.out.println ("");

        }

        // Cek siapa yang poinnya paling banyak

        for (int i = 0; i < batas; i++) {
            for (int j = i+1; j < batas; j++) {
                if (poin_player[i] > poin_player[j]) {
                    pemenang = i;
                }
                else {
                    pemenang = j;
                }
            }
        }

        System.out.printf ("\nPermainan selesai, pemenangnya adalah player %d dengan poin = %d\n", pemenang+1, poin_player[pemenang]);

    }

}

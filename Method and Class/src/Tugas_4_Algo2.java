
import java.util.Scanner;

class List_Makanan {

    int harga_kacang = 10000, n_kacang = 150;
    int harga_semprong = 20000, n_semprong = 100;
    int harga_permen = 5000, n_permen = 200;
    int harga_biskuit = 25000, n_biskuit = 100;

    public void Tampilkan () {

        System.out.println ("\n******* Stok makanan yang tersedia *******\n");

        System.out.println ("|   Nama    |   Stok     |   Harga/unit  | Kode |");
        System.out.printf ("|   Kacang  |     %d    |   Rp %d    | 1102 |\n", n_kacang, harga_kacang);
        System.out.printf ("|  Semprong |     %d    |   Rp %d    | 1103 |\n", n_semprong, harga_semprong);
        System.out.printf ("|   Permen  |     %d    |   Rp %d     | 1104 |\n", n_permen, harga_permen);
        System.out.printf ("|  Biskuit  |     %d    |   Rp %d    | 1105 |\n", n_biskuit, harga_biskuit);

    }

}

class List_Minuman {

    int harga_sprite = 12000, n_sprite = 100;
    int harga_coke = 12000, n_coke = 150;
    int harga_fanta = 12000, n_fanta = 100;
    int harga_badak = 15000, n_badak = 100;

    public void Tampilkan () {

        System.out.println ("\n******* Stok minuman yang tersedia *******\n");

        System.out.println ("|   Nama    |   Stok   |   Harga/unit   | Kode |");
        System.out.printf ("|   Sprite   |     %d    |   Rp %d   | 1302 |\n", n_sprite, harga_sprite);
        System.out.printf ("|   Coke     |     %d    |   Rp %d   | 1303 |\n", n_coke, harga_coke);
        System.out.printf ("|   Fanta    |     %d    |   Rp %d   | 1304 |\n", n_fanta, harga_fanta);
        System.out.printf ("|   Badak    |     %d    |   Rp %d   | 1305 |\n", n_badak, harga_badak);

    }

}

class Transaksi {

    List_Makanan food = new List_Makanan ();
    List_Minuman drink = new List_Minuman ();

    int [] harga_produk = new int [8];
    String [] produk = {"Kacang", "Semprong", "Permen", "Biskuit", "Sprite", "Coke", "Fanta", "Badak"};
    int [] banyak_produk = new int [8];
    boolean [] habis = new boolean [8];

    public void Bayar (int kode, int n) {

        for (int i = 0; i < habis.length; i++) {
            habis[i] = false;
        }

        // Cek Stok produk
        if (food.n_kacang <= 0) {
            habis[0] = true;
        }
        if (food.n_semprong <= 0) {
            habis[1] = true;
        }
        if (food.n_permen <= 0) {
            habis[2] = true;
        }
        if (food.n_biskuit <= 0) {
            habis[3] = true;
        }
        if (drink.n_sprite <= 0) {
            habis[4] = true;
        }
        if (drink.n_coke <= 0) {
            habis[5] = true;
        }
        if (drink.n_fanta <= 0) {
            habis[6] = true;
        }
        if (drink.n_badak <= 0) {
            habis[7] = true;
        }

        // Pengurangan jumlah stok sesuai pesanan
        if (kode == 1102 && habis[0] == false) {
            food.n_kacang -= n;
        }
        else if (kode == 1103 && habis[1] == false) {
            food.n_semprong -= n;
        }
        else if (kode == 1104 && habis[2] == false) {
            food.n_permen -= n;
        }
        else if (kode == 1105 && habis[3] == false) {
            food.n_biskuit -= n;
            System.out.println (food.n_biskuit);
        }
        else if (kode == 1302 && habis[4] == false) {
            drink.n_sprite -= n;
        }
        else if (kode == 1303 && habis[5] == false) {
            drink.n_coke -= n;
        }
        else if (kode == 1304 && habis[6] == false) {
            drink.n_fanta -= n;
        }
        else if (kode == 1305 && habis[7] == false) {
            drink.n_badak -= n;
        }
        else {
            if (habis[0] == true || habis[1] == true || habis[2] == true || habis[3] == true || habis[4] == true || habis[5] == true || habis[6] == true || habis[7] == true) {
                System.out.println ("Maaf Stok habis");
            }
            else {
                System.out.println ("Maaf input yang dimasukan salah");
            }

        }

        // operasi transaksi
        banyak_produk[0] = 150-food.n_kacang;
        banyak_produk[1] = 100-food.n_semprong;
        banyak_produk[2] = 200-food.n_permen;
        banyak_produk[3] = 100-food.harga_biskuit;

        banyak_produk[4] = 100-drink.n_sprite;
        banyak_produk[5] = 150-drink.n_coke;
        banyak_produk[6] = 100-drink.n_fanta;
        banyak_produk[7] = 100-drink.n_badak;

        harga_produk[0] = banyak_produk[0] * food.harga_kacang;
        harga_produk[1] = banyak_produk[1] * food.harga_permen;
        harga_produk[2] = banyak_produk[2] * food.harga_semprong;
        harga_produk[3] = banyak_produk[3] * food.harga_biskuit;

        harga_produk[4] = banyak_produk[4] * drink.harga_sprite;
        harga_produk[5] = banyak_produk[5] * drink.harga_coke;
        harga_produk[6] = banyak_produk[6] * drink.harga_fanta;
        harga_produk[7] = banyak_produk[7] * drink.harga_badak;

    }

    public void Tampilkan () {

        System.out.println ("\n^^^^^^^^ List Belanjaan Kamu ^^^^^^^^\n");
        System.out.println ("|  Produk  |   Jumlah  |   Harga   |   Jenis   |");

        String jenis_produk = "";
        int total_belanjaan = 0;

        for (int i = 0; i < harga_produk.length; i++) {
            if (i < 4) {
                jenis_produk = "Makanan";
            }
            else {
                jenis_produk = "Minuman";
            }

            if (banyak_produk[i] < 1) {
                continue;
            }
            // Menampilkan rincian belanjaan
            System.out.printf ("| %s    |     %d    |   Rp %d    |   %s  |\n",produk[i], banyak_produk[i], harga_produk[i], jenis_produk);
            total_belanjaan = total_belanjaan + harga_produk[i];
        }

        // Menampilkan Total Belanjaan
        System.out.printf ("Total harga semua belanjaan kamu adalah sebesar Rp %d", total_belanjaan);
    }
}

public class Tugas_4_Algo2 {

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);
        List_Makanan menu_makanan = new List_Makanan ();
        List_Minuman menu_minuman = new List_Minuman ();
        Transaksi pembayaran = new Transaksi ();

        int menu;
        int banyak;
        int lanjut = 0;
        int kode;

        System.out.println ("\n^^^^^^^^^^^ Selamat Datang di SukaMart ^^^^^^^^^^^");

        while (lanjut != 2) {

            System.out.println ("\nMenu untuk memesan :");
            System.out.println ("1 = makanan\n2 = minuman");

            System.out.print ("Masukan pilihan mu : ");
            menu = input.nextInt();

            if (menu != 1 && menu != 2) {
                System.out.println ("\nError 202 : Input tidak sesuai");
            }
            else {
                if (menu == 1) {
                    menu_makanan.Tampilkan ();

                    System.out.print ("\nMasukan kode makanan : ");
                    kode = input.nextInt();

                    System.out.print ("Berapa banyak : ");
                    banyak = input.nextInt();

                    pembayaran.Bayar (kode, banyak);
                }
                else {
                    menu_minuman.Tampilkan ();

                    System.out.print ("\nMasukan kode minuman : ");
                    kode = input.nextInt();

                    System.out.print ("Berapa banyak : ");
                    banyak = input.nextInt();

                    pembayaran.Bayar (kode, banyak);
                }
            }

            System.out.print ("\nLanjut belanja (1), bayar (2) : ");
            lanjut = input.nextInt ();

            if (lanjut != 1 && lanjut != 2) {
                System.out.println ("Error 202 : Input yang dimasukan salah\n");
            }

        }

        pembayaran.Tampilkan ();
        System.out.println ("\n");

    }

}

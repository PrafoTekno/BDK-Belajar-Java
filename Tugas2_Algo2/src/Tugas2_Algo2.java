
import java.util.Scanner;

public class Tugas2_Algo2 {

    public static void main (String[] args) {

        System.out.println ("\n\t========= Selamat Datang di IndoApril ========\n");

        //Daftar produk yang dijual

        System.out.println ("Berikut adalah produk-produk yang kami jual : ");
        System.out.println (" --> Susu Kental Madu : Rp 250.000,00");
        System.out.println (" --> Popok Bayi Sehat : Rp 50.000,00");

        System.out.println ("\n-----------------------------------------------");

        int produk, lanjut, kuantiti;
        int susu = 0, popok = 0, harga_susu = 0, harga_popok = 0;  //Akumulasi belanjaan
        boolean status = true; //Cek looping
        Scanner myInput = new Scanner (System.in); //Deklarasi varible buat manggil fungsi input

        while (status == true) {

            System.out.print ("\nMasukan nama barang yang hendak dibeli (1 = susu, 2 = popok) : ");
            produk = myInput.nextInt ();

            if (produk == 1) {
                System.out.print ("Masukan banyaknya susu yang hendak dibeli : ");
                kuantiti = myInput.nextInt ();
                susu += kuantiti;
                harga_susu = susu * 250000;
            }
            else if (produk == 2) {
                System.out.print ("Masukan banyaknya popok yang hendak dibeli : ");
                kuantiti = myInput.nextInt ();
                popok += kuantiti;
                harga_popok = popok * 50000;
            }
            else {
                System.out.println ("Error Code : 121 'Input tidak sesuai'");
            }

            System.out.print ("\nIngin menambahkan belanjaan (1) atau ingin membayar (2) : ");
            lanjut = myInput.nextInt ();

            if (lanjut == 2) {
                status = false;
            }

        }

        System.out.println ("\n-----------------------------------------------");

        System.out.print ("\n  Produk   |   Quantity   |   Harga  \n");
        System.out.printf ("   Susu    |     %d        | %d     \n", susu, harga_susu);
        System.out.printf ("   Popok   |     %d        | %d      \n", popok, harga_popok);

        System.out.printf ("\nTotal harga yang harus kamu bayar adalah Rp %d\n", harga_susu + harga_popok);

    }

}
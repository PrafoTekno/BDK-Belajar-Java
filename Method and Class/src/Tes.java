
import java.util.Scanner;

class Drink {
    int stock_sprite  = 20 ;
    int stock_coke    = 22 ;
    int stock_badak   = 10 ;
    int stock_fanta   = 15 ;

    public void Display_drink () {
        System.out.printf("\n1. Sprite -Rp.10.000  (Stock tersisa %d)\n",stock_sprite);
        System.out.printf("2. Coke   -Rp.20.000  (Stock tersisa %d)\n",stock_coke);
        System.out.printf("3. Badak  -Rp.5.000   (Stock tersisa %d)\n",stock_badak);
        System.out.printf("4. Fanta  -Rp.25.000 (Stock tersisa %d)\n\n",stock_fanta);
    }
}

class Food {
    int stock_kacang  = 10 ;
    int stock_semprong = 15 ;
    int stock_permen  = 25 ;
    int stock_biskuit = 8  ;

    public void Display_food () {
        System.out.printf("\n1. Kacang   -Rp.10.000  (Stock tersisa %d)\n",stock_kacang);
        System.out.printf("2. Semprong -Rp.20.000  (Stock tersisa %d)\n",stock_semprong);
        System.out.printf("3. Permen   -Rp.5.000   (Stock tersisa %d)\n",stock_permen);
        System.out.printf("4. Biskuit  -Rp.25.000 (Stock tersisa %d)\n\n",stock_biskuit);
    }
}

class Payment {

    int bayar_kacang, bayar_semprong, bayar_permen, bayar_biskuit;
    int bayar_sprite, bayar_coke, bayar_badak, bayar_fanta;
    int total_belanjaan;

    public void Total (int a, int b, int c, int d, int e, int f, int g, int h){

        // Pembayaran ke kasir

        bayar_kacang = (10-a) * 10000;
        bayar_semprong = (15-b) * 20000;
        bayar_permen = (25-c) * 5000;
        bayar_biskuit = (8-d) * 25000;

        bayar_sprite = (20-e) * 10000;
        bayar_coke = (22-f) * 20000;
        bayar_badak = (10-g) * 5000;
        bayar_fanta = (15-h) * 25000;

        total_belanjaan = bayar_badak + bayar_fanta + bayar_coke + bayar_biskuit + bayar_permen + bayar_kacang + bayar_sprite + bayar_semprong;

        System.out.println("Ini dia list belanjaan kamu : \n");

        System.out.printf ("\nKamu membeli %d kacang seharga Rp %d\n", 10-a, bayar_kacang);
        System.out.printf ("Kamu membeli %d semprong seharga Rp %d\n", 15-b, bayar_semprong);
        System.out.printf ("Kamu membeli %d permen seharga Rp %d\n", 25-c, bayar_permen);
        System.out.printf ("Kamu membeli %d biskuit seharga Rp %d\n", 8-d, bayar_biskuit);

        System.out.println ("\n---------------------------------------------------------------");

        System.out.printf ("\nKamu membeli %d sprite seharga Rp %d\n", 20-e, bayar_sprite);
        System.out.printf ("Kamu membeli %d coke seharga Rp %d\n", 22-f, bayar_coke);
        System.out.printf ("Kamu membeli %d badak seharga Rp %d\n", 10-g, bayar_badak);
        System.out.printf ("Kamu membeli %d fanta seharga Rp %d\n", 15-h, bayar_fanta);

        System.out.printf("\nTotal harga belanjaan kamu adalah Rp %d\n\n", total_belanjaan);

    }

}

public class Tes {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        Food makanan = new Food();
        Drink minuman = new Drink();
        Payment bayar = new Payment();

        System.out.println ("\n********* Selamat datang di TimoMart *********");

        int status = 1;
        int menu, pilih;

        while (status == 1 && status != 2) { // Memulai belanja

            System.out.println ("\nMenu melihat daftar\n");
            System.out.println ("1. Makanan\n2. Minuman");
            System.out.print ("Pilihan mu : ");
            menu = input.nextInt();

            if (menu != 1 && menu != 2) {
                System.out.println ("Input yang anda masukan salah!\n");
            }
            else {

                if (menu == 1) {
                    makanan.Display_food();
                    System.out.print ("Pilih yang mana : ");
                    pilih = input.nextInt();

                    if (pilih == 1) {
                        makanan.stock_kacang -= 1;
                    }
                    else if (pilih == 2) {
                        makanan.stock_semprong -= 1;
                    }
                    else if (pilih == 3) {
                        makanan.stock_permen -= 1;
                    }
                    else if (pilih == 4) {
                        makanan.stock_biskuit -= 1;
                    }
                    else {
                        System.out.println ("Input yang dimasukan tidak sesuai\n");
                    }

                }
                else {
                    minuman.Display_drink();
                    System.out.print ("Pilih yang mana : ");
                    pilih = input.nextInt();

                    if (pilih == 1) {
                        minuman.stock_sprite -= 1;
                    }
                    else if (pilih == 2) {
                        minuman.stock_coke -= 1;
                    }
                    else if (pilih == 3) {
                        minuman.stock_badak -= 1;
                    }
                    else if (pilih == 4) {
                        minuman.stock_fanta -= 1;
                    }
                    else {
                        System.out.println ("Input yang dimasukan tidak sesuai\n");
                    }

                }

                System.out.print ("\nLanjut belanja (1), bayar belanjaan (2) : ");
                status = input.nextInt();

                if (status != 2 && status != 1) {
                    System.out.println ("\nInput yang anda masukan salah!");
                }

            }

        }

        bayar.Total(makanan.stock_kacang, makanan.stock_semprong, makanan.stock_permen, makanan.stock_biskuit, minuman.stock_sprite, minuman.stock_coke, minuman.stock_badak, minuman.stock_fanta);

    }

}
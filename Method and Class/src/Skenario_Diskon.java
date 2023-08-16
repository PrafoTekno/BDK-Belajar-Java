import java.util.Scanner;

public class Skenario_Diskon {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // membuat 3 object untuk 3 customer
        Point customer1 = new Point(10000000, 200);
        Point customer2 = new Point(750000, 100);
        Point customer3 = new Point(5000000, 100);

        // menampilkan point awal dan saldo awal semua customer
        customer1.getPoint_and_saldo(1);
        customer2.getPoint_and_saldo(2);
        customer3.getPoint_and_saldo(3);

        // menambahkan point ke customer yang diinginkan dengan menginput no ID customer dan nominal belanja customer
        int id = 5;
        int belanjaan_ke = 1;

        while (id != 0) {  //Melakukan looping

            System.out.print("Input ID customer (0 untuk selesai): ");
            id = input.nextInt();

            if (id == 1) {
                System.out.print("\nInput nominal belanja customer: ");
                int belanja = input.nextInt();
                customer1.tambahPoint(belanja, belanjaan_ke);

            } else if (id == 2) {
                System.out.print("\nInput nominal belanja customer: ");
                int belanja = input.nextInt();
                customer2.tambahPoint(belanja, belanjaan_ke);

            } else if (id == 3) {
                System.out.print("\nInput nominal belanja customer: ");
                int belanja = input.nextInt();
                customer3.tambahPoint(belanja, belanjaan_ke);

            } else if (id != 0) { // menangani input yang tidak valid
                System.out.println("\nID tidak terdeteksi");
            }

            System.out.println ("Status costumer terkini\n");
            customer1.getPoint_and_saldo(1);
            customer2.getPoint_and_saldo(2);
            customer3.getPoint_and_saldo(3);

            System.out.println ("\n");
            belanjaan_ke++;

        }

        System.out.println("Terima kasih!");

    }

}

class Point {

    // method untuk menambahkan point berdasarkan nominal belanja
    private int saldo;
    private int point;
    private int tambah = 0;

    //Constructor
    Point (int saldo_awal, int poin_awal) {
        this.point = poin_awal;
        this.saldo = saldo_awal;
    }

    //Menambahkan point belanjaan
    public int tambahPoint(int belanja, int n) {

        if (belanja > this.saldo) {  //Kalo saldo tidak cukup
            System.out.println ("\nMaaf saldo kamu tidak cukup");
            tambah = 0;
        }
        else {

            this.saldo -= belanja;

            if (n <= 1) {
                if (belanja > 5000000) {
                    tambah = 200;
                } else {
                    tambah = 100;
                }
            }
            else {
                if (belanja > 1000000) {
                    tambah = 50;
                } else {
                    tambah = 5;
                }
            }
        }

        this.point += tambah;
        return this.point;
    }

    // method untuk menghasilkan nilai point
    public void getPoint_and_saldo (int costumer) {
        // Menampilkan point dan saldo costumer
        System.out.printf ("Saldo costumer %d Rp %d | point %d\n", costumer, this.saldo, this.point);
    }
}
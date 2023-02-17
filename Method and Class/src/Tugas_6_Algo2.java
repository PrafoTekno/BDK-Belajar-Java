
import java.util.Scanner;

class Belanjaan {

    int point;
    int nominal;
    String nama;
    String PIN;

    Belanjaan (int nominal,String nama, String PIN) {

        this.point = 0;
        this.nama = nama;
        this.PIN = PIN;
        this.nominal = nominal;

    }

    public void Signup_account (int ke_i) {

        System.out.println ("\n==================================================");
        System.out.printf ("Akun ke %d <-> Silahkan buat di sini\n\n", ke_i);

        Scanner input = new Scanner (System.in);

        System.out.print ("Buat nama ID : ");
        this.nama = input.nextLine ();
        System.out.print ("Buat PIN : ");
        this.PIN = input.nextLine ();
        System.out.print ("Masukan nominal awal mu : ");
        this.nominal = input.nextInt ();

        System.out.println ("\nBaik, akun mu sudah dibuat!");
        System.out.println ("==================================================\n");

    }

    public void Tampilkan () {
        System.out.printf ("\nID : %s\n", this.nama);
        System.out.printf ("Saldo : %d\n", this.nominal);
        System.out.printf ("Point : %d\n", this.point);
    }

    public int Transaksi (int n, int belanja_ke) {

        if (this.nominal > n) {

            this.nominal -= n;

            if (belanja_ke <= 1) {
                if (n >= 5000000) {
                    this.point += 200;
                }
                else {
                    this.point += 100;
                }
            }
            else {
                if (n >= 1000000) {
                    this.point += 50;
                }
                else {
                    this.point += 5;
                }
            }

            return this.point;
        }

        else {
            System.out.println ("\nSaldo tidak memenuhi\n");
            return 0;
        }
    }

}

public class Tugas_6_Algo2 {

    public static void main (String[] args) {

        final int MAX = 3;

        Scanner input = new Scanner (System.in);
        Belanjaan [] costumer = new Belanjaan [MAX];

        String ID, PIN;
        int belanja, status = 1, putaran = 0;
        int cek = 0;

        for (int i = 0; i < MAX; i++) {
            costumer[i] = new Belanjaan (0, "", "");
            costumer[i].Signup_account (i+1);
        }

        while (status == 1) {

            System.out.println ("\n>>>>>> Masukan akun <<<<<<\n");

            System.out.print ("ID : ");
            ID = input.next ();
            System.out.print ("PIN : ");
            PIN = input.next ();

            for (int i = 0; i < MAX; i++) {

                if (!(costumer[i].nama.equals(ID) && costumer[i].PIN.equals(PIN))) {
                    cek += 1;
                    continue;
                }

                System.out.print ("Masukan nominal belanja : ");
                belanja = input.nextInt();
                costumer[i].Transaksi (belanja, putaran);

                cek = 0;

            }

            if (cek < MAX) {

                System.out.print ("\nHasil transaksi\n");
                for (int i = 0; i < MAX; i++) {
                    costumer[i].Tampilkan();
                }

                putaran++;

                System.out.print ("\nKetik selain 1 untuk mengakhiri program : ");
                status = input.nextInt();

            }
            else {
                System.out.println ("\nPesan error : ID atau PIN salah\n");
            }

        }

        System.out.println ("\n\n=========== Terima kasih ===========\n");

    }

}

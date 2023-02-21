import java.util.Scanner;

class Bonus {

    int saldo;
    int point;
    int tambah_point = 0;
    String nama_pembeli;

    //Constructor
    Bonus (int saldo_awal, int poin_awal, String nama_pembeli) {
        this.point = poin_awal;
        this.saldo = saldo_awal;
        this.nama_pembeli = nama_pembeli;
    }

    public int tambahPoint (int nominal_belanja, int belanja_ke_n) {

        if (nominal_belanja > this.saldo) {
            System.out.println ("\nMaaf saldo kamu tidak cukup");
            tambah_point = 0;
        }
        else {

            this.saldo = this.saldo - nominal_belanja;

            if (belanja_ke_n <= 1) {
                if (nominal_belanja > 5000000) {
                    tambah_point = 200;
                } else {
                    tambah_point = 100;
                }
            }
            else {
                if (nominal_belanja > 1000000) {
                    tambah_point = 50;
                } else {
                    tambah_point = 5;
                }
            }
        }

        this.point = point + tambah_point;
        return this.point;
    }

    public void Status_saat_ini (String pembeli) {
        System.out.printf ("Saldo %s adalah Rp %d ---- point %d\n", pembeli, this.saldo, this.point);
    }
}

public class Riv {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Bonus pembeli1 = new Bonus(10000000, 200, "Agus");
        Bonus pembeli2 = new Bonus(750000, 100, "Joni");
        Bonus pembeli3 = new Bonus(5000000, 100, "Stephen");

        pembeli1.Status_saat_ini("Agus");
        pembeli2.Status_saat_ini("Joni");
        pembeli3.Status_saat_ini("Stephen");
        String pembeli;
        int putaran = 1;
        int nominal_belanja;
        int status = 1;

        while (status != 0) {
            System.out.print("Input nama pembeli : ");
            pembeli = input.next();

            if (pembeli.equals("Agus")) {
                System.out.print("\nInput nominal belanja : ");
                nominal_belanja = input.nextInt();
                pembeli1.tambahPoint (nominal_belanja, putaran);
            }
            else if (pembeli.equals("Joni")) {
                System.out.print("\nInput nominal belanja customer: ");
                nominal_belanja = input.nextInt();
                pembeli2.tambahPoint(nominal_belanja, putaran);
            }
            else if (pembeli.equals("Stephen")) {
                System.out.print("\nInput nominal belanja customer: ");
                nominal_belanja = input.nextInt();
                pembeli3.tambahPoint(nominal_belanja, putaran);
            }
            else {
                System.out.println("\nPembeli tidak ditemukan");
            }
            putaran = putaran + 1;
            System.out.println ("\nKlik selain 0 untuk lihat status, klik 0 untuk selesai : ");
            status = input.nextInt();
            if (status != 0) {
                System.out.println ("Ini status saat ini\n");
                pembeli1.Status_saat_ini("Agus");
                pembeli2.Status_saat_ini("Joni");
                pembeli3.Status_saat_ini("Stephen");
            }

        }

        System.out.println("Terima kasih!");

    }

}

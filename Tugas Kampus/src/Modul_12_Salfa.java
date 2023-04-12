
import java.util.*;

class Costumer {

    double poin = 0;
    int saldo = 3000000;
    String ID = "", PIN = "";

    public void Tampilkan () {

        System.out.println ("\nIni dia profil mu\n");

        System.out.println ("=======================");
        System.out.printf ("ID member : %S\n", ID);
        System.out.printf ("Saldo member : Rp %d\n", saldo);
        System.out.printf ("Poin member : %.2f\n", poin);
        System.out.println ("=======================\n");

    }

    public double Tambah_Poin (int transaksi) {

        double penambahan;

        if (transaksi < saldo) {
            if (transaksi > 1000000) {
                penambahan = (transaksi * 0.03);
            }
            else {
                penambahan = 2.5;
            }

            return penambahan;

        }
        else {
            System.out.println ("\nSaldo tidak cukup\n");
            return 0;
        }

    }

    public double Penukaran_Poin (double penarikan) {

        double tarik;

        if (poin < penarikan) {
            System.out.println ("\nPoint tidak cukup\n");
            tarik = 0;
        }
        else {
            tarik = penarikan;
        }

        return tarik;

    }

}

public class Modul_12_Salfa {

    static final int MAX = 9999;
    static String [][] aktivitas = new String [MAX][MAX];
    static int [] bill = new int [MAX];

    private static void Menu (int pilih, Costumer orang, int orang_ke) {

        Scanner input = new Scanner(System.in);
        int s;
        double r;

        switch (pilih) {

            case 1:
                orang.Tampilkan();
                break;

            case 2:

                System.out.print("Masukan nominal belanja : Rp ");
                s = input.nextInt();
                orang.poin += orang.Tambah_Poin(s);
                orang.saldo -= s;

                if (orang.Tambah_Poin(s) > 0) {
                    System.out.printf("Saldo mu menjadi %d\nPoin mu menjadi %.2f\n", orang.saldo, orang.poin);
                    bill[orang_ke]++;
                    aktivitas[orang_ke][bill[orang_ke]] = orang.ID + " belanja sebesar Rp " + s;
                }

                break;

            case 3:

                System.out.print("Masukan besar poin yang hendak di tukar : ");
                r = input.nextDouble();
                orang.poin -= orang.Penukaran_Poin(r);
                orang.saldo += r;

                if (orang.Penukaran_Poin(r) > 0) {
                    System.out.printf("Saldo mu menjadi %d\nPoin mu menjadi %.2f\n", orang.saldo, orang.poin);
                    bill[orang_ke]++;
                    aktivitas[orang_ke][bill[orang_ke]] = orang.ID + " menarik poin sebesar " + r;
                }

                break;

        }

    }

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);
        Costumer[] member = new Costumer [MAX];
        for (int i = 0; i < member.length; i++) {
            member[i] = new Costumer ();
        }

        int pilihan;
        String ID_user, PIN_user;
        int n = -1, banyak_member = 0, menu, lanjut = 1;
        int cek = 0, ganti_akun = 0;
        int test = 0;

        System.out.println ("\n======= Mari Belanja di IndoApril =======");

        while (lanjut == 1) {

           if (test == 0) {

               if (n < 0) {
                   pilihan = 0;
               }
               else {
                   do {
                       System.out.print ("\nSudah punya akun IndoExpress ? (1/0) : ");
                       pilihan = input.nextInt ();
                       if (pilihan != 1 && pilihan != 0) {
                           System.out.println ("Error 104 : Input tidak sesuai\n");
                       }
                   }
                   while (pilihan != 1 && pilihan != 0);
               }

               if (pilihan == 1) {

                   System.out.print ("\nMasukan ID : ");
                   ID_user = input.next ();
                   System.out.print ("Masukan PIN : ");
                   PIN_user = input.next ();

                   for (int i = 0; i < banyak_member; i++) {
                       if (ID_user.equals(member[i].ID) && PIN_user.equals(member[i].PIN)) {
                           cek = 0;
                           n = i;
                           break;
                       }
                       else {
                           cek ++;
                       }
                   }

                   if (cek > 0) {
                       System.out.println ("Error 203 : ID atau PIN salah!\n");
                   }
                   else {
                       System.out.println ("\nAkun ditemukan\n");
                       test = 1;
                   }
               }
               else {

                   banyak_member++;
                   n++;
                   int t = 0;

                   System.out.println ("\n<<<< Ayo buat akun >>>>\n");

                   if (banyak_member > 1) {
                       do {
                           System.out.print ("Buat ID : ");
                           member[n].ID = input.next ();
                           System.out.print ("Buat PIN : ");
                           member[n].PIN = input.next ();

                           for (int i = 0; i < banyak_member-1; i++) {
                               if (member[n].ID.equals(member[i].ID) || member[n].PIN.equals(member[i].PIN)) {
                                   t = 0;
                                   break;
                               }
                               else {
                                   t++;
                               }
                           }

                           if (t == 0) {
                               System.out.println ("Error 304 : ID atau PIN telah digunakan\n");
                           }

                       }
                       while (t == 0);
                   }

                   else {
                       System.out.print ("Buat ID : ");
                       member[n].ID = input.next ();
                       System.out.print ("Buat PIN : ");
                       member[n].PIN = input.next ();
                   }

                   test = 1;
               }
           }

           if (test == 1) {

                System.out.println ("\n------- Menu -------\n");
                System.out.println ("1. Tampilkan status");
                System.out.println ("2. Belanja");
                System.out.println ("3. Tukar poin");
                System.out.println ("-------------------\n");

                System.out.printf ("Costumer %s silahkan memilih menu: ", member[n].ID);
                menu = input.nextInt ();
                Menu (menu, member[n], n);

                do {
                    System.out.print ("\nLanjut belanja (1), Keluar (0) : ");
                    lanjut = input.nextInt ();
                    if (lanjut == 1) {
                        System.out.print ("Ganti akun (1), Tidak (0) : ");
                        ganti_akun = input.nextInt ();
                    }
                    if (lanjut != 1 && lanjut != 0 || ganti_akun != 1 && ganti_akun != 0) {
                        System.out.println ("Error 104 : Input tidak sesuai\n");
                    }
                }
                while (lanjut != 1 && lanjut != 0 || ganti_akun != 1 && ganti_akun != 0);
            }

            if (ganti_akun == 1) {
                test = 0;
            }
        }

        if (bill[n] > 0) {
            System.out.printf ("\n*** History Belanja %s ***\n\n", member[n].ID);
            for (int i = 0; i < bill[n]+1; i++) {
                System.out.println (aktivitas[n][i]);
            }
        }

        System.out.println ("\n---- Terima Kasih Sudah Berbelanja ----\n");

    }

}

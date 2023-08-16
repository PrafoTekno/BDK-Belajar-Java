
import java.util.Scanner;
import java.util.Random;

class Library {

    static String [] judul_buku = new String [10];
    static String [] penulis = new String [10];
    static int [] n_buku = new int [10];
    final static int [] n_buku_total = new int [10];

    static public void Daftar_Buku () {

        judul_buku[0] = "The Great Gatsby";
        judul_buku[1] = "To Kill a Mockingbird";
        judul_buku[2] = "The Catcher in the Rye";
        judul_buku[3] = "The Origin of Species";
        judul_buku[4] = "A Brief History of Time";
        judul_buku[5] = "The Art of War";
        judul_buku[6] = "The Prince";
        judul_buku[7] = "The Republic";
        judul_buku[8] = "The Iliad";
        judul_buku[9] = "The Odyssey";

        n_buku[0] = 5;
        n_buku[1] = 3;
        n_buku[2] = 2;
        n_buku[3] = 1;
        n_buku[4] = 4;
        n_buku[5] = 2;
        n_buku[6] = 1;
        n_buku[7] = 3;
        n_buku[8] = 2;
        n_buku[9] = 2;

        n_buku_total[0] = 5;
        n_buku_total[1] = 3;
        n_buku_total[2] = 2;
        n_buku_total[3] = 1;
        n_buku_total[4] = 4;
        n_buku_total[5] = 2;
        n_buku_total[6] = 1;
        n_buku_total[7] = 3;
        n_buku_total[8] = 2;
        n_buku_total[9] = 2;

        penulis[0] = "F. Scott Fitzgerald";
        penulis[1] = "Harper Lee";
        penulis[2] = "J.D. Salinger";
        penulis[3] = "Charles Darwin";
        penulis[4] = "Stephen Hawking";
        penulis[5] = "Sun Tzu";
        penulis[6] = "Niccolo Machiavelli";
        penulis[7] = "Plato";
        penulis[8] = "Homer";
        penulis[9] = "Homer";

    }


}

class User {

    int ID;
    String nama;
    String alamat_rumah;
    int [] index_buku_pinjaman = new int [10];
    int n_pinjaman;

    public void Tampilkan () {
        System.out.println ("\n---- Data pribadi user ----\n");
        System.out.printf ("Nama         : %s\n", nama);
        System.out.printf ("Alamat rumah : %s\n", alamat_rumah);
        System.out.printf ("ID           : %d\n\n", ID);
    }

    public void Buku_Pinjaman () {

        System.out.println ("\nIni daftar buku yang ada di kamu\n");

        for (int i = 0; i < n_pinjaman; i++) {
            System.out.printf ("[%d] %s - %s (pinjam sebanyak : %d)\n", index_buku_pinjaman[i], Library.judul_buku[index_buku_pinjaman[i]], Library.penulis[index_buku_pinjaman[i]], Library.n_buku_total[index_buku_pinjaman[i]]-Library.n_buku[index_buku_pinjaman[i]]);
        }

        System.out.println("");

    }

}

public class Perpustakaan {

    enum Menu {
        BORROW,
        RETURN
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Menu pilihan;

        int choice = 0;
        User [] orang = new User [9999];

        for (int i = 0; i < orang.length; i++) {
            orang[i] = new User();
        }

        Library.Daftar_Buku();

        int index = -1, banyak_user = 0;
        String nama;
        int ada = 0, tim = 0;

        while (choice != 3) {

            if (tim == 0) {

                int status;

                scanner.nextLine();

                do {
                    System.out.print("Sudah punya akun (1 = yes, 0 = no) : ");
                    status = Integer.parseInt(scanner.nextLine());

                    if (status != 1 && status != 0) {
                        System.out.println ("Error : Input tidak sesuai");
                    }
                }
                while (status != 1 && status != 0);

                if (status == 1) {
                    System.out.print("Masukan username : ");
                    nama = scanner.nextLine();
                    //System.out.println(nama);

                    for (int i = 0; i < banyak_user; i++) {
                        //System.out.println(orang[i].nama);
                        if (nama.equals(orang[i].nama)) {
                            ada = 1;
                            index = i;
                            break;
                        }
                        else {
                            ada = 0;
                        }
                    }

                    if (ada == 1) {
                        System.out.println ("Akun ditemukan\n");
                        tim = 1;
                    }
                    else {
                        System.out.println ("Akun tidak ditemukan\n");
                        tim = 0;
                    }

                }
                else {
                    System.out.println("\n");

                    index++;
                    int t = 0;

                    if (banyak_user > 1) {

                        do {

                            System.out.print ("Buat nama mu : ");
                            orang[index].nama = scanner.next();
                            System.out.print ("Masukan alamat rumah mu : ");

                            int r = 0;
                            if (r == 0) {
                                scanner.nextLine ();
                            }
                            orang[index].alamat_rumah = scanner.nextLine();

                            for (int i = 0; i < banyak_user; i++) {
                                if (orang[index].nama.equals(orang[i].nama)) {
                                    t = 0;
                                    break;
                                }
                                else {
                                    t++;
                                }
                            }

                            if (t == 0) {
                                System.out.println ("Error : nama telah digunakan\n");
                            }

                        }
                        while (t == 0);
                    }
                    else {

                        System.out.print ("Buat nama mu : ");
                        orang[index].nama = scanner.next();
                        System.out.print ("Masukan alamat rumah mu : ");

                        int r = 0;
                        if (r == 0) {
                            scanner.nextLine ();
                        }
                        orang[index].alamat_rumah = scanner.nextLine();
                    }

                    orang[index].ID = 10000 + rand.nextInt(89999);
                    banyak_user++;
                    //System.out.println(banyak_user);
                    tim = 1;

                }
            }

            else {

                orang[index].Tampilkan();

                System.out.println("\n");
                System.out.println("1. Borrow a book");
                System.out.println("2. Return a book");
                System.out.println("3. Exit");

                do {
                    System.out.println("Enteran option:");
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 3) {
                        System.out.println ("Input tidak sesuai");
                    }
                }
                while (choice < 1 || choice > 3);

                if (choice == 1) {
                    pilihan = Menu.BORROW;
                }
                else if (choice == 2) {
                    pilihan = Menu.RETURN;
                }
                else {
                    break;
                }


                switch (pilihan) {

                    case BORROW:
                        Borrow (scanner, orang[index]);
                        System.out.println("\n");
                        break;
                    case RETURN:
                        Return (scanner, orang[index]);
                        System.out.println ("\n");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        System.out.println ("\n");
                        break;
                }

                int ganti_akun;

                System.out.print ("ganti akun (1 = ya, selain 1 = 0)? : ");
                ganti_akun = scanner.nextInt();

                if (ganti_akun == 1) {
                    tim = 0;
                }

            }

        }
    }

    private static void Display () {

        System.out.println ("\nIni dia daftara buku yang tersedia di perpustakaan ini\n");

        for (int i = 0; i < 10; i++) {
            if (Library.n_buku[i] <= 0) {
                continue;
            }
            System.out.printf ("[%d] %s - %s (ada : %d)\n", i, Library.judul_buku[i], Library.penulis[i], Library.n_buku[i]);
        }

        System.out.println ("");

    }

    private static void Borrow (Scanner input, User people) {

        int pilih_index;
        int n = -1;

        Display();

        do {
            System.out.print ("Pilih index buku : ");
            pilih_index = input.nextInt();

            if (pilih_index < 0 || pilih_index > 10) {
                System.out.println ("Input tidak sesuai");
            }
            if (Library.n_buku[pilih_index] > 0) {
                n++;
                people.index_buku_pinjaman[n] = pilih_index;
                people.n_pinjaman++;
                Library.n_buku[pilih_index] -= 1;
                System.out.println(Library.n_buku[pilih_index]);
            }
            else {
                System.out.println ("Stok buku habis");
            }
        }
        while (pilih_index < 0 || pilih_index > 10 || Library.n_buku[pilih_index] < 0);

        System.out.println ("Buku berhasil dipinjam");

    }

    private static void Return (Scanner input, User people) {

        int pilih_index;
        int tim = 0;

        people.Buku_Pinjaman();

        do {

            System.out.print ("Pilih index buku yang hendak dibalikan : ");
            pilih_index = input.nextInt();

            for (int i = 0; i < people.n_pinjaman; i++) {
                if (pilih_index == people.index_buku_pinjaman[i]) {
                    tim = 1;
                    Library.n_buku[pilih_index] += 1;
                    break;
                }
                else {
                    tim = 0;
                }
            }

            if (tim == 0) {
                System.out.println ("Buku tidak tersedia\n");
            }

        }
        while (tim == 0);

        System.out.println ("Buku berhasil dikembalikan\n");

    }



}


import java.util.Scanner;
import java.util.Random;

class Anak {

    String nama;
    int umur;
    String kelompok_bermain;
    String hari;

    private enum Hari {
        Senin,
        Selasa,
        Rabu,
        Kamis,
        Jumat,
        Sabtu,
        Minggu
    }

    public String Hari_kelas () {

        int day;
        int [] status = new int [7];

        Random rand = new Random ();
        Hari hari = Hari.Senin;

        day = 1 + rand.nextInt (7);

        if (day == 1) {
            status[0] += 1;
        }
        else if (day == 2) {
            status[1] += 1;
        }
        else if (day == 3) {
            status[2] += 1;
        }
        else if (day == 4) {
            status[3] += 1;
        }
        else if (day == 5) {
            status[4] += 1;
        }
        else if (day == 6) {
            status[5] += 1;
        }
        else {
            status[6] += 1;
        }

        for (int i = 0; i < status.length; i++) {

            if (status[i] > 10) {
                day++;

                if (day > 7) {
                    day = 0;
                }

                break;
            }

        }

        if (day == 1) {
            hari = Hari.Senin;
        }
        else if (day == 2) {
            hari = Hari.Selasa;
        }
        else if (day == 3) {
            hari = Hari.Rabu;
        }
        else if (day == 4) {
            hari = Hari.Kamis;
        }
        else if (day == 5) {
            hari = Hari.Jumat;
        }
        else if (day == 6) {
            hari = Hari.Sabtu;
        }
        else {
            hari = Hari.Minggu;
        }

        switch (hari) {

            case Senin:
                this.hari = "Senin";
                break;

            case Selasa:
                this.hari = "Selasa";
                break;

            case Rabu:
                this.hari = "Rabu";
                break;

            case Kamis:
                this.hari = "Kamis";
                break;

            case Jumat:
                this.hari = "Jumat";
                break;

            case Sabtu:
                this.hari = "Sabtu";
                break;

            case Minggu:
                this.hari = "Minggu";
                break;

        }

        return this.hari;

    }

    public void Tampil (int n) {

        if (n < 3) {
            kelompok_bermain = "Lion";
        }
        else if (n < 7) {
            kelompok_bermain = "Monkey";
        }
        else {
            kelompok_bermain = "Elephant";
        }

        System.out.println ("--------------------------");
        System.out.printf ("Nama anak : %S ", this.nama);
        System.out.printf ("\nUmur anak : %d tahun", this.umur);
        System.out.printf ("\nHari kelas : %S ", this.hari);
        System.out.printf ("\nKelompok bermain : %S ", this.kelompok_bermain);
        System.out.println ("\n--------------------------");

    }

}

public class Main {

    private enum Kategori {
        BAYI,
        BATITA,
        BALITA

    }

    public static void main (String[] args) {

        final int MAX = 70;

        Scanner input = new Scanner (System.in);

        Kategori status = Kategori.BAYI;
        Anak [] child = new Anak [MAX];

        int n = 0;
        int lanjut = 1;

        System.out.println ("\n\tDaftar Diri Siswa\n");

        while (n < MAX && lanjut == 1) {

            child[n] = new Anak ();

            System.out.print ("\nMasukan nama anak : ");
            child[n].nama = input.next ();

            do {
                System.out.printf ("Masukan umur %S : ", child[n].nama);
                child[n].umur = input.nextInt ();
            }
            while (child[n].umur < 0);

            // Mengkategorikan anak berdasarkan umur mereka

            if (child[n].umur >= 0 && child[n].umur <= 1) {
                status = Kategori.BAYI;
            }
            else if (child[n].umur >= 2 && child[n].umur <= 3) {
                status = Kategori.BATITA;
            }
            else if (child[n].umur >= 4 && child[n].umur <= 5) {
                status = Kategori.BALITA;
            }
            else {
                System.out.printf ("%S terlalu tua untuk ikut kelas\n\n", child[n].nama);
            }

            switch (status) {

                case BAYI :
                    System.out.printf ("Maaf %S belum boleh ikut kelas\n", child[n].nama);
                    break;

                case BATITA :
                    System.out.printf ("%S masuk ke kelas di lantai 1\n", child[n].nama);
                    break;

                case BALITA :
                    System.out.printf ("%S masuk ke kelas di lantai 2\n", child[n].nama);
                    break;

            }

            if (status != Kategori.BAYI) {

                child[n].Hari_kelas ();

                System.out.println ("");
                child[n].Tampil (n);
                System.out.println ("");

                n++;

            }

            System.out.print ("\nMau lanjut (no = 0, yes = 1) : ");
            lanjut = input.nextInt ();

        }

        System.out.println ("\n========================================\n");
        System.out.printf ("Ini dia daftar %d anak yang mendaftar\n", n);

        for (int i = 0; i < n; i++) {
            child[i].Tampil (i);
        }
        System.out.println ("\n========================================\n");

        System.out.println ("\nTerima kasih\n");

    }

}
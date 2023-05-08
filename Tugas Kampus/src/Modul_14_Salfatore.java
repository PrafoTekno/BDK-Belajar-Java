import java.util.*;

class Nilai {
    public double itung_mean (int a, int b, int c) {
        return (a+b+c)/3;
    }
}

class NilaiBobot extends Nilai {
    public double itung_mean2 (int a, int b, int c) {
        return ((a*0.5) + (b*0.3) + (c*0.2))/3;
    }
}

public class Modul_14_Salfatore {

    public static void main (String[] args) {

        Random rand = new Random();
        Scanner input = new Scanner (System.in);
        NilaiBobot val = new NilaiBobot ();

        int [][] nilai = new int [10][3];
        int pilih_murid, pilih_mean;
        double mean = 0;

        System.out.println ("\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                nilai[i][j] = 10+rand.nextInt(90);
            }
        }

        for (int i = 0; i < 10+1; i++) {
            if (i > 0) {
                System.out.printf ("Siswa ke %d : ", i);
                for (int j = 0; j < 3; j++) {
                    System.out.printf ("%d |\t", nilai[i-1][j]);
                }
                System.out.println("");
            }
            else {
                System.out.println ("\t\t  Tugas |  UTS |\tUAS");
            }
        }

        System.out.print ("\nPilih murid : ");
        pilih_murid = input.nextInt ();
        System.out.print ("Pilih jenis mean (1 = bobot, 2 = biasa) : ");
        pilih_mean = input.nextInt ();

        if (pilih_mean == 1) {
            for (int j = 0; j < 3; j++) {
                mean = val.itung_mean (nilai[pilih_murid][0], nilai[pilih_murid][1], nilai[pilih_murid][2]);
            }
            System.out.printf ("Nilai rata-rata bobot siswa %d adalah %.2f\n", pilih_murid, mean);
        }
        else {
            for (int j = 0; j < 3; j++) {
                mean = val.itung_mean2 (nilai[pilih_murid][0], nilai[pilih_murid][1], nilai[pilih_murid][2]);
            }
            System.out.printf ("Nilai rata-rata bobot siswa %d adalah %.2f\n", pilih_murid, mean);
        }

    }

}

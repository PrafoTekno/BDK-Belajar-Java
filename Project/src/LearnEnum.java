
import java.util.Scanner;

public class LearnEnum {

    private enum Kategori {
        Bayi,
        Balita,
        Batita;
    }

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);

        double umur = -1;
        Kategori status = Kategori.Bayi;

        while (umur < 0) {
            System.out.print ("\nMasukan umur anak (dalam bulan) : ");
            umur = input.nextDouble ();
        }

        if (umur <= 3) {
            status = Kategori.Bayi;
        }
        else if (umur >= 4 && umur <= 9) {
            status = Kategori.Batita;
        }
        else if (umur >= 10 && umur <= 13) {
            status = Kategori.Balita;
        }
        else {
           System.out.println ("\nSudah terlalu tua");
        }

        System.out.println ("\n");

        // Kondisi sekolah boleh atau tidak

        switch (status) {

            case Bayi :
                System.out.println ("Belum bisa sekolah\n");
                break;
            case Batita:
                System.out.println ("Sekolah lantai 1\n");
                break;
            case Balita:
                System.out.println ("Sekolah lantai 3\n");
                break;

        }

    }

}

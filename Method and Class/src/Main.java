
import java.util.Scanner;

class Data_Diri {

    int tahun_saat_ini = 2023;
    int umur;

    public void Tampilkan (String nama, int tahun_lahir) {

        umur = tahun_saat_ini - tahun_lahir;
        System.out.printf ("Halo %s, tahun ini kamu berumur %d tahun \\^.^/\n", nama, umur);

    }

}

public class Main {

    public static void main(String[] args) {

        Data_Diri orang = new Data_Diri ();
        Scanner input = new Scanner (System.in);

        System.out.println ("\n====== Biodata Singkat ======\n");

        int birth;
        String name;

        System.out.print ("Siapa nama mu : ");
        name = input.nextLine ();
        System.out.print ("Berapa tahun lahir mu : ");
        birth = input.nextInt ();

        // Menampilkan hasilnya
        orang.Tampilkan (name, birth);

    }

}
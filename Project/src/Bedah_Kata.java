import java.util.Scanner;

// Ambil class Kalimat di file "Google_Sederhana.java"

public class Bedah_Kata {

    public static void main(String[] args) {

        String text = "Wow Mobil mu keren banget";
        Kalimat kal = new Kalimat();

        //Kasuari.Artikel();
        String[] kata = kal.Bedah(text);

        System.out.println("\n" + text);

        System.out.println("\n");

        //Scanner input = new Scanner (System.in);

        for (int i = 0; i < kata.length; i++) {
            System.out.println(kata[i]);
        }

        System.out.println("\n");

        kal.text = text;
        System.out.println(kal.Cari_index("Mobil"));

        Kasuari.Artikel();

        for (int i = 0; i < 21; i++) {
            kal.text = Kasuari.jawaban[i];
            for (int j = 0; j < kata.length; j++) {
                System.out.printf("Index ke %d\n", kal.Cari_index(kata[i]));
                System.out.println("Itung kata : " + kal.itung_kata_sering_muncul);
                kal.Persentase_Kemunculan_Kata(kata[j]);
                //System.out.println ();
            }

            /*
            String nama = input.next();
        String kalimat = input.nextLine();

       System.out.println ("\n" + nama);
        System.out.println ("\n" + kalimat);
             */

        }

    }
}
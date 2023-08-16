
import java.util.Scanner;

class Quiz {

    final int MAX = 5;

    String [] kunci_jawaban = new String [MAX];

    int jawaban_benar = 0;

    public void Pertanyaan () {

        System.out.println ("\n1.\tArti kata “cat” dalam Bahasa Indonesia");
        System.out.println ("2.\tArti kata “bird” dalam Bahasa Indonesia");
        System.out.println ("3.\tArti kata “rabbit” dalam Bahasa Indonesia");
        System.out.println ("4.\tArti kata “sheep” dalam Bahasa Indonesia");
        System.out.println ("5.\tArti kata “cow” dalam Bahasa Indonesia\n");

    }

    public void Itung_Jawaban (String[] answer) {

        // Kunci jawaban

        kunci_jawaban[0] = "kucing";
        kunci_jawaban[1] = "burung";
        kunci_jawaban[2] = "kelinci";
        kunci_jawaban[3] = "domba";
        kunci_jawaban[4] = "sapi";

        for (int i = 0; i < kunci_jawaban.length; i++) {

            if (!answer[i].equals(kunci_jawaban[i])) {
                continue;
            }

            System.out.printf ("Jawaban no %d BENAR\n", i+1);
            jawaban_benar += 1;

        }

        System.out.printf ("\nJadi kamu benar menjawab %d soal dari %d soal yang ada\n", jawaban_benar, MAX);

    }

}

class Database {

    Quiz kuiz = new Quiz();
    String[] jawaban = new String[kuiz.MAX];

    public void Save (String[] jawab) {

        for (int i = 0; i < jawaban.length; i++) {
            jawaban[i] = jawab[i];
        }

    }

    public void Edit() {

        for (int i = 0; i < jawaban.length; i++) {
            jawaban[i] = "";
        }

    }

}

public class Pengerjaan_Quiz {

    public static void main (String[] args) {

        // Deklarasi class

        Scanner input = new Scanner (System.in);
        Quiz kuis = new Quiz ();
        Database data = new Database ();

        System.out.println ("\n========= Quiz Bahasa =========");

        String [] jawaban_user = new String [kuis.MAX];
        int status = 1;

        while (status != 2) {

            System.out.println ("\nSilahkan membaca 5 pertanyaan yang tersedia dengan teliti");
            kuis.Pertanyaan ();
            System.out.println ("Silahkan masukan 5 jawaban mu berturut-turut : \n");

            // Menulis jawaban dan disimpan di database

            for (int i = 0; i < kuis.MAX; i++) {
                System.out.printf ("%d. ", i+1);
                jawaban_user[i] = input.next ();
            }

            data.Save (jawaban_user);

            System.out.print ("Tekan 2 untuk submit, tekan selain 2 untuk edit: ");
            status = input.nextInt();

            if (status != 2) {
                 data.Edit();
            }

        }

        System.out.println ("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        kuis.Itung_Jawaban (data.jawaban);

        System.out.println ("\nTerima kasih sudah bermain \\^.^/\n");

    }

}

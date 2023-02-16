
import java.util.Scanner;

public class Riv {

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);
        Pertanyaan question = new Pertanyaan ();
        Jawaban answer = new Jawaban ();

        System.out.println ("\n======== Mari Kerjakan Quiz ========\n");

        int lanjut = 1;

        String jawaban_user1 = "";
        String jawaban_user2 = "";
        String jawaban_user3 = "";
        String jawaban_user4 = "";
        String jawaban_user5 = "";

        while (lanjut == 1 && lanjut != 2) {

            question.Soal();
            System.out.println ("Masukan 5 jawaban mu berturut-turut : \n");

            System.out.print ("1. ");
            jawaban_user1 = input.nextLine();
            System.out.print ("2. ");
            jawaban_user2 = input.nextLine();
            System.out.print ("3. ");
            jawaban_user3 = input.nextLine();
            System.out.print ("4. ");
            jawaban_user4 = input.nextLine();
            System.out.print ("5. ");
            jawaban_user5 = input.nextLine();

            answer.Save_data (jawaban_user1, jawaban_user2, jawaban_user3, jawaban_user4, jawaban_user5);

            System.out.print ("\nTekan 2 untuk submit jawaban, tekan selain 2 untuk edit jawaban : ");
            lanjut = input.nextInt();

            if (lanjut != 1) {
                answer.Edit_data();
            }

        }

        question.Itung_Jawaban (jawaban_user1, jawaban_user2, jawaban_user3, jawaban_user4, jawaban_user5);

    }

}

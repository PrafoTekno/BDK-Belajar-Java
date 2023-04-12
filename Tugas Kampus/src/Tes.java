import java.util.Scanner;
import java.util.Random;

public class Tes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int[][] cards = new int[4][5];
        int[][] flips = new int[4][5];
        int numPairs = 0;
        int numTries = 3;

        for (int i = 1; i <= 10; i++) {
            int row1, col1, row2, col2;
            do {
                row1 = rand.nextInt(4);
                col1 = rand.nextInt(5);
            } while (cards[row1][col1] != 0);
            cards[row1][col1] = i;

            do {
                row2 = rand.nextInt(4);
                col2 = rand.nextInt(5);
            } while (cards[row2][col2] != 0);
            cards[row2][col2] = i;
        }

// Tampilkan kartu di awal
        System.out.println("Ingat Angka Tersebut:");
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(cards[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("Tekan (Enter) Untuk Melanjutkan");
        input.nextLine();

        // Permainan
        while (numPairs < 10 && numTries > 0) {
            System.out.print("\033[H\033[2J"); //clear
            System.out.flush();

            System.out.println(">>>Baris Dan Kolom Di Mulai Dari 0 sampai 4<<<");
            System.out.println("Tiga Lgai Yang Tersisa : " + numTries);
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 5; col++) {
                    if (flips[row][col] == 1) {
                        System.out.print(cards[row][col] + " ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.print("Masukkan baris dan kolom tebakan pertama: ");
            int row1 = input.nextInt();
            int col1 = input.nextInt();
            System.out.print("Masukkan baris dan kolom tebakan Kedua : ");
            int row2 = input.nextInt();
            int col2 = input.nextInt();

            // Check if the guesses are valid
            if (row1 < 0 || row1 > 3 || col1 < 0 || col1 > 4 ||
                    row2 < 0 || row2 > 3 || col2 < 0 || col2 > 4 ||
                    (row1 == row2 && col1 == col2)) {
                System.out.println("Input Salah!");
                continue;
            }

            // Mengecek jawaban
            if (cards[row1][col1] == cards[row2][col2]) {
                flips[row1][col1] = 1;
                flips[row2][col2] = 1;
                numPairs++;
                System.out.println("Kamu Menemukan Pasangan !");
            } else {
                flips[row1][col1] = 1;
                flips[row2][col2] = 1;
                numTries--;
                System.out.println("Maaf, Coba lagi ");
            }
        }

        // Memunculkan Hasil
        if (numPairs == 10) {
            System.out.println("Selamat,Kamu Menang!");
        } else {
            System.out.println("Maaf, Kamun Kalah ");
        }
    }
}


import java.util.*;
class Mahasiswa {

    String nama ;
    String jurusan ;
    int nim ;

    public void Tampilkan (){
        System.out.println ("========================");
        System.out.printf("Nama : %s\n",nama);
        System.out.printf("Jurusan : %s\n",jurusan);
        System.out.printf("NIM : %d\n",nim);
        System.out.println ("========================\n");
    }

}

public class Pendaftaran_Murid_Baru {

    public static void main(String[] args) {

        System.out.println ("Selamat Datang di Universitas Abatucam\n") ;
        Scanner input = new Scanner (System.in);
        Random angka = new Random ();
        Mahasiswa [] siswa = new Mahasiswa [9999];

        for (int i = 0; i < siswa.length; i++) {
            siswa[i] = new Mahasiswa ();
        }

        int menu = 1, orang_ke = -1, n_orang = 0;
        int jurusan, biaya_masuk;
        String nama;
        int lulus;

        while (menu == 1) {

            input.nextLine();

            System.out.print("1.Daftar Baru , Ketik selain 1 untuk Exit : ") ;
            menu = Integer.parseInt(input.nextLine());

            if (menu == 1) {

                orang_ke++;

                int r = 0;

                do {

                    System.out.print("Silahkan Masukkan Nama Kamu : ") ;
                    nama = input.nextLine() ;
                    siswa[orang_ke].nama = nama;

                    for (int i = 0; i < n_orang; i++) {
                        if (siswa[orang_ke].nama.equals(siswa[i].nama)) {
                            r = 1;
                            break;
                        }
                        else {
                            r = 0;
                        }
                    }

                    if (r == 1) {
                        System.out.println ("\nNama ini sudah digunakan\n");
                    }

                }
                while (r == 1);

                do {
                    System.out.println("\n1.Electro \n2.Civil \n3.Biology") ;
                    System.out.print("Silahkan Memilih Jurusan yang anda inginkan : ") ;
                    jurusan = input.nextInt() ;
                    if (jurusan > 3 || jurusan < 1) {
                        System.out.println ("Input salah, silahkan masukan yang benar");
                    }
                }
                while (jurusan > 3 || jurusan < 1);

                if (jurusan == 1) {
                    siswa[orang_ke].jurusan = "Elektro";
                    biaya_masuk = 12000000;
                }
                else if (jurusan == 2) {
                    siswa[orang_ke].jurusan = "Sipil";
                    biaya_masuk = 12500000;
                }
                else {
                    siswa[orang_ke].jurusan = "Biologi";
                    biaya_masuk = 14000000;
                }

                int jalur;

                do {

                    input.nextLine();

                    System.out.print ("Pilih jalur masuk (1. test, 2. nilai) : ");
                    jalur = Integer.parseInt(input.nextLine());
                    if (jalur < 1 || jalur > 2) {
                        System.out.println ("Input salah, silahkan masukan yang benar");
                    }

                }
                while (jalur < 1 || jalur > 2);

                if (jalur == 1) {

                    int tes = Tes (jurusan, input);

                    if (tes >= 2) {
                        System.out.println ("\nSelamat kamu lulus\n");
                        lulus = 1;
                    }
                    else {
                        System.out.println ("\nMaaf kamu gagal\n");
                        lulus = 0;
                    }
                }
                else {
                    int nilai_MTK, nilai_BI, nilai_IPA, nilai_Inggris;
                    int nilai_total;

                    System.out.print ("Masukan nilai MTK : ");
                    nilai_MTK = input.nextInt();
                    System.out.print ("Masukan nilai BI : ");
                    nilai_BI = input.nextInt();
                    System.out.print ("Masukan nilai IPA : ");
                    nilai_IPA = input.nextInt();
                    System.out.print ("Masukan nilai Inggris : ");
                    nilai_Inggris = input.nextInt();

                    nilai_total = nilai_BI+nilai_IPA+nilai_Inggris+nilai_MTK;

                    if (nilai_total >= 270) {
                        System.out.println("Selamat kamu lulus");
                        lulus = 1;
                    }
                    else {
                        int lanjut;

                        input.nextLine();

                        System.out.println("Nilai mu tidak mencukupi");
                        System.out.print ("Ingin coba jalur tes? (1 = ya, bukan 1 = no) : ");
                        lanjut = Integer.parseInt(input.nextLine());
                        lulus = 0;

                        if (lanjut == 1) {

                            int tes = Tes (jurusan, input);

                            if (tes >= 2) {
                                System.out.println ("\nSelamat kamu lulus\n");
                                lulus = 1;
                            }
                            else {
                                System.out.println ("\nMaaf kamu gagal\n");
                                lulus = 0;
                            }

                        }
                    }

                }

                if (lulus == 1) {

                    int sudah_bayar;

                    do {
                        System.out.println("Silahkan melunasi pembayaran\n");
                        System.out.printf ("Sudah membayar Rp %d,00 (1 = ya, 0 = no) : ", biaya_masuk);
                        sudah_bayar = input.nextInt ();

                        if (sudah_bayar != 1 && sudah_bayar != 0) {
                            System.out.println ("Input salah, silahkan masukan yang benar");
                        }
                        if (sudah_bayar == 0) {
                            System.out.println ("Silahkan melengkapi pembayaran terlebih dahulu\n");
                        }
                    }
                    while (sudah_bayar != 1 || sudah_bayar == 0);

                    siswa[orang_ke].nim = 10000 + angka.nextInt (89999);

                    System.out.println ("\nIni dia kartu mahasiswa kamu\n");
                    siswa[orang_ke].Tampilkan();

                    n_orang++;

                }
            }

        }

    }

    private static int Tes (int tipe, Scanner input) {

        int benar = 0;
        String jawaban;

        System.out.println ("\nDalam menjawab, perhatikan EBI\n\n");

        if (tipe == 1) {
            System.out.println ("Siapa penemu lampu pertama kali?");
            jawaban = input.nextLine();

            if (jawaban.equals("Thomas Alva Edison")) {
                benar++;
            }
            System.out.println ("Tahun berapa lampu pertama kali ditemukan?");
            jawaban = input.nextLine();

            if (jawaban.equals("1879")) {
                benar++;
            }
            System.out.println ("Komponen yang digunakan untuk menghambat listrik adalah ");
            jawaban = input.nextLine();

            if (jawaban.equals("Resistor")) {
                benar++;
            }

        }
        else if (tipe == 2) {
            System.out.println ("Teknik yang mempelajaran tentang bagaimana merancang , membangun dan merenovasi adalah ?");
            jawaban = input.nextLine();

            if (jawaban.equals("Sipil")) {
                benar++;
            }
            System.out.println ("Kapan Institution of Civil Engineers di dirikan ?");
            jawaban = input.nextLine();

            if (jawaban.equals("1818")) {
                benar++;
            }
            System.out.println ("Siapakah Presiden pertama di Institution of Civil Engineers?");
            jawaban = input.nextLine();

            if (jawaban.equals("Thomas Telford")) {
                benar++;
            }
        }
        else {
            System.out.println ("Kajian tentang kehidupan dan organisme hidup adalah arti dari ?");
            jawaban = input.nextLine();

            if (jawaban.equals("Biologi")) {
                benar++;
            }
            System.out.println ("Bahasa belanda dari Biologi adalah ?");
            jawaban = input.nextLine();

            if (jawaban.equals("Biologie")) {
                benar++;
            }
            System.out.println ("Bios adalah bahasa Yunani yang memiliki arti ?");
            jawaban = input.nextLine();

            if (jawaban.equals("Kehidupan")) {
                benar++;
            }
        }

        return benar;

    }

}

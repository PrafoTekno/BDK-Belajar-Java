
import java.util.*;

/*

Buat Google versi Salfatore Yan Prafo (Kasuari by Prafo Tekno)

Konsep google :

1. Ada login/sign up
2. Bisa lihat history pencaharian
3. Untuk mesin pencaharian tentang elektro
4. Bisa kirim pesan ke akun lain (kayak GMail)
5. Terdapat forum (user bisa bertanya dan bisa menjawab pertanyaan user lain)
6. Untuk forum, bisa mendapatkan poin untuk achivement
7. Penentuan jawaban bener apa engga, itu dilihat dari seberapa membantunya jawaban itu, bagi si penanya
8. Ada algoritma pencaharian di beranda, kalao topik itu sering dibuka oleh user
9. User juga bisa buat kary tulisnya sendiri
10. Ada E banking juga

 */

import java.util.*;

class Kalimat {

    static String text;
    int itung_kata_sering_muncul = 0; //Untuk menghitung berapa kali kata tersebut muncul di dalam kalimat ini
    private int panjang_text;

    public String [] Bedah (String text) {

        char spasi = ' ';
        char [] karakter_text1 = text.toCharArray();
        int itung_kata = 1;

        for (int i = 0; i < karakter_text1.length; i++) {  //Cek ada berapa kata
            if (karakter_text1[i] == spasi) {
                itung_kata ++;
            }
        }

        String [] kata = new String [itung_kata];
        int start = 0;

        for (int i = 0; i < itung_kata; i++) {
            kata[i] = "";
        }

        for (int i = 0; i < itung_kata; i++) {
            for (int j = start; j < karakter_text1.length; j++) {
                if (karakter_text1[j] == spasi) {
                    start = j+1;
                    break;
                }
                kata[i] += karakter_text1[j];
            }
        }

        return kata;

    }

    public int Cari_index (String text) {

        panjang_text = this.text.length();  //Induk kata
        int panjang_text1 = text.length(); //Kata yang ingin dicari dari induk kata

        int index_nya = -1;
        int [] tampung_index = new int [panjang_text];
        int [] cek_index_saat_ini = new int [panjang_text];
        int s = 0, r, p = 0, index_awal = 0;

        char [] karakter_text = this.text.toCharArray();
        char [] karakter_text1 = text.toCharArray();

        for (int i = 0; i < panjang_text; i++) {
            //System.out.printf ("Karakter[%d] = %s\n", i, karakter_text[i]);

            if (p == 1) {  //Menentukan ganti index tampung ga
                r = 1;
            }
            else {
                r = 0;
                index_awal = 0;
            }

            for (int j = index_awal; j < panjang_text1; j++) {

                if (karakter_text1[j] == karakter_text[i]) {

                    if (r == 1) {
                        s = i;
                    }

                    cek_index_saat_ini[i]++;
                    //System.out.printf ("cek[%d] = %d\n", i, cek_index_saat_ini[i]);
                    tampung_index[s]++;
                    //System.out.printf ("tampung[%d] = %d\n", s, tampung_index[s]);
                    index_awal = j+1;

                }

            }

            for (int j = i+1; j < panjang_text; j++) {
                if (cek_index_saat_ini[i] == cek_index_saat_ini[j]) {
                    p = 1;
                    break;
                }
                else {
                    p = 0;
                }
            }

        }

        //System.out.println("\n");
        itung_kata_sering_muncul = 0;

        for (int i = 0; i < panjang_text; i++) {
            if (tampung_index[i] >= panjang_text1 || tampung_index[i] >= panjang_text1-1) {
                index_nya = i;
                itung_kata_sering_muncul++;
                //System.out.printf ("Itung kata [%d]: %d\n", i, itung_kata_sering_muncul);
            }
            //System.out.printf ("Tampung_index[%d] = %d\n", i, tampung_index[i]);
        }

        return index_nya;

    }

    public double Persentase_Kemunculan_Kata (String t) {

        System.out.printf ("Banyak kata sering muncul : %d \n", itung_kata_sering_muncul);
        Cari_index(t);
        double itung_kata = itung_kata_sering_muncul;
        return (itung_kata/panjang_text)*100;
        //System.out.println(itung_kata_sering_muncul/panjang_text*100);
    }

    public boolean Contain (CharSequence text1) {
        return Cari_index (text1.toString()) > -1;
    }

}

class Kasuari {

    static final int MAX = 9999;
    static int n_artikel = 21;
    static int index_awal = 21;
    static String [] jawaban = new String [MAX];
    static String [] judul = new String [MAX];

    public static void Artikel () {

        jawaban[0] = "Transistor adalah alat semikonduktor yang dipakai sebagai penguat, sebagai sirkuit pemutus dan penyambung arus, stabilisasi tegangan, dan modulasi sinyal. Transistor dapat berfungsi semacam kran listrik, di mana berdasarkan arus inputnya (BJT) atau tegangan inputnya (FET), memungkinkan pengaliran listrik yang sangat akurat dari sirkuit sumber listriknya.";
        jawaban[1] = "Transformasi Laplace atau alih ragam Laplace[1] adalah suatu teknik untuk menyederhanakan permasalahan dalam suatu sistem yang mengandung masukan dan keluaran, dengan melakukan transformasi dari suatu domain pengamatan ke domain pengamatan yang lain.";
        jawaban[2] = "Transistor sambungan dwikutub atau transistor pertemuan dwikutub (bahasa Inggris: Bipolar junction transistor atau disingkat BJT atau Bipolar transistor) adalah salah satu jenis dari transistor. Ini adalah peranti tiga-saluran yang terbuat dari bahan semikonduktor terkotori. Dinamai dwikutub karena operasinya menyertakan baik elektron maupun lubang elektron, berlawanan dengan transistor ekakutub seperti FET yang hanya menggunakan salah satu pembawa. Walaupun sebagian kecil dari arus transistor adalah pembawa mayoritas, hampir semua arus transistor adalah dikarenakan pembawa minoritas, sehingga BJT diklasifikasikan sebagai peranti pembawa-minoritas.";
        jawaban[3] = "Dalam matematika, teorema Green memberikan hubungan antara sebuah integral garis pada kurva tertutup sederhana C dan integral ganda pada bidang D yang dibatasi oleh C. Teorema ini mendapatkan namanya dari George Green [1] dan merupakan kasus khusus dua-dimensi dari teorema Stokes yang lebih umum.";
        jawaban[4] = "Dalam kalkulus vektor, dan lebih umum lagi geometri diferensial, teorema Stokes rampat (terkadang dieja teorema Stokes, dan juga disebut teorema Stokes–Cartan[1]) adalah pernyataan tentang integrasi dari bentuk diferensial pada manifold, yang menyederhanakan dan menggeneralisasi beberapa teorema dari kalkulus vektor. Teorema Stokes mengatakan bahwa integral dari suatu bentuk diferensial ω di atas batas dari beberapa berorientasi lipatan Ω sama dengan integral turunan luar dω di seluruh Ω, yaitu:";
        jawaban[5] = "Dalam matematika teorema divergensi, yang dikenal juga dengan sebutan teorema Gauss atau teorema Ostrogradsky memerikan hubungan antara aliran (fluks) medan vektor melalui permukaan dengan peri laku medan di dalam permukaan.";
        jawaban[6] = "Dalam matematika, teorema Pythagorean, juga dikenal sebagai teorema Pythagoras, adalah hubungan mendasar dalam geometri Euclidean di antara tiga sisi segitiga siku-siku. ";
        jawaban[7] = "Arus bolak-balik adalah arus listrik yang memiliki arah arus yang berubah-ubah secara bolak-balik. Sifat arus bolak-balik berbeda dengan arus searah yang arah arusnya tidak berubah-ubah terhadap waktu. Bentuk gelombang dari arus bolak-balik biasanya berbentuk gelombang sinusoida sehingga memungkinkan pengaliran energi secara efisien.";
        jawaban[8] = "Arus searah (bahasa Inggris: direct current) adalah arus listrik yang nilainya tidak berubah. Arah pengaliran arus listriknya hanya positif atau hanya negatif saja.[1] Arus searah didefinisikan sebagai arus listrik yang mempunyai nilai tetap atau konstan terhadap satuan waktu. Nilai ini ditinjau dari pengaliran arus listrik pada waktu yang berbeda dan akan selalu mendapatkan nilai yang sama.";
        jawaban[9] = "Transistor efek–medan (FET) adalah salah satu jenis transistor yang menggunakan medan listrik untuk mengendalikan konduktifitas suatu kanal dari jenis pembawa muatan tunggal dalam bahan semikonduktor. FET kadang-kadang disebut sebagai transistor ekakutub untuk membedakan operasi pembawa muatan tunggal yang dilakukannya dengan operasi dua pembawa muatan pada transistor dwikutub (BJT).";
        jawaban[10] = "Penguat operasional (bahasa Inggris: operational amplifier) atau yang biasa disebut op-amp merupakan suatu jenis penguat elektronika dengan sambatan (bahasa Inggris: coupling) arus searah yang memiliki bati (faktor penguatan atau dalam bahasa Inggris: gain) sangat besar dengan dua masukan dan satu keluaran.";
        jawaban[11] = "Arduino adalah pengendali mikro dengan papan tunggal yang berfungsi dalam proyek perangkat lunak sumber terbuka. Fungsi utama dari Arduion untuk memudahkan penggunaan elektronik dalam berbagai bidang. Arduino memiliki perangkat keras yang menggunakan prosesor Atmel AVR. ";
        jawaban[12] = "Python adalah bahasa pemrograman tujuan umum yang ditafsirkan, tingkat tinggi. Dibuat oleh Guido van Rossum dan pertama kali dirilis pada tahun 1991, filosofi desain Python menekankan keterbacaan kode dengan penggunaan spasi putih yang signifikan.";
        jawaban[13] = "Bahasa pemrograman Python pertama kali dikembangkan pada tahun 1991 oleh Guido van Rossum, seorang programmer Belanda. Hingga kini, Python telah berkembang pesat. Terbukti dari versi terbarunya, Python 3.10 yang dirilis 2021 lalu.";
        jawaban[14] = "Teknologi machine learning (ML) adalah mesin yang dikembangkan untuk bisa belajar dengan sendirinya tanpa arahan dari penggunanya. Pembelajaran mesin dikembangkan berdasarkan disiplin ilmu lainnya seperti statistika, matematika dan data mining sehingga mesin dapat belajar dengan menganalisa data tanpa perlu di program ulang atau diperintah.";
        jawaban[15] = "Deskripsi Gerbang logika atau gerbang logik adalah suatu entitas dalam elektronika dan matematika Boolean yang mengubah satu atau beberapa masukan logik menjadi sebuah sinyal keluaran logik";
        jawaban[16] = "Diterjemahkan dari bahasa Inggris-Filter high-pass adalah filter elektronik yang melewatkan sinyal dengan frekuensi lebih tinggi dari frekuensi cutoff tertentu dan meredam sinyal dengan frekuensi lebih rendah dari frekuensi cutoff.";
        jawaban[17] = "Tapis pelewat rendah atau tapis lolos rendah digunakan untuk meredam sinyal dengan frekuensi tinggi dan meneruskannya sebagai sinyal dengan frekuensi rendah.";
        jawaban[18] = "C++ adalah bahasa pemrograman komputer yang dibuat oleh Bjarne Stroustrup, yang merupakan perkembangan dari bahasa C dikembangkan di Bell Labs. Pada awal tahun 1970-an, bahasa itu merupakan peningkatan dari bahasa sebelumnya, yaitu B.";
        jawaban[19] = "Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995.";
        jawaban[20] = "Fluks magnetik, adalah ukuran atau jumlah medan magnet B yang melewati luas penampang tertentu, misalnya kumparan kawat. Satuan fluks magnetik dalam Satuan Internasional adalah weber.";

        judul[0] = "Apa itu transistor?";
        judul[1] = "Apa itu transformasi Laplace?";
        judul[2] = "Transistor adalah dwikutub";
        judul[3] = "Teorema Green";
        judul[4] = "Teorema Stokes";
        judul[5] = "Apa itu Teorema Divergensi?";
        judul[6] = "Apa itu Teorema Pythagoras?";
        judul[7] = "Apa itu arus AC?";
        judul[8] = "Apa itu arus DC?";
        judul[9] = "Apa itu FET?";
        judul[10] = "Ini dia Op-Amp?";
        judul[11] = "Apa itu Arduino?";
        judul[12] = "Bahasa pemrograman Python";
        judul[13] = "Sejarah bahasa Python";
        judul[14] = "Machine Learning, cikal bakal pembuatan AI";
        judul[15] = "Apa itu Gerbang Logika?";
        judul[16] = "High Pass Filter ";
        judul[17] = "Low Pass Filter";
        judul[18] = "Mengenal bahasa pemrograman C++";
        judul[19] = "Ini dia bahasa pemrograman Java";
        judul[20] = "Flux magnet dalam fisika";

    }

}

class Data_User {

    String username;
    String password;

    public void Tampilkan () {

        String pw = "*";
        String pager = "=";

        for (int s = 0; s < password.length()-1; s++) {
            pw += "*";
        }
        for (int r = 0; r < username.length()+22; r++) {
            pager += "=";
        }

        System.out.println ("\n\t" + pager);
        System.out.printf ("  \tUsername : %s@kmail.com\n", username);
        System.out.printf ("  \tPassword : %s\n", pw);
        System.out.println ("\t" + pager + "\n");

    }

}

public class kasuari {

    static String [][] riwayat_pencarian = new String [Kasuari.MAX][Kasuari.MAX];

    static int [] pencarian_ke = new int [Kasuari.MAX];

    static int index_pertanyaan = -1, n_pertanyaan = 0;

    static String [] pertanyaan = new String [Kasuari.MAX];
    static String [][] jawaban = new String [Kasuari.MAX][Kasuari.MAX];
    static int [] jawaban_ke = new int [Kasuari.MAX];

    enum Menu {BROWSER, TULIS, FORUM}

    public static void main (String[] args) {

        System.out.println ("\n");

        System.out.println ("\t\t\t0000          0000        0000        00000000    0000    0000        0000        00000000      0000" +
                "\n\t\t\t0000      0000           000000       000         0000    0000       000000       000     000   0000" +
                "\n\t\t\t0000  0000              00000000      000         0000    0000      00000000      000     000   0000" +
                "\n\t\t\t0000  0000             000    000     00000000    0000    0000     000    000     000  000      0000" +
                "\n\t\t\t0000      0000        000      000         000    000000000000    000      000    000   000     0000" +
                "\n\t\t\t0000          0000   000        000   00000000    000000000000   000        000   000    000    0000");

        System.out.println ("");

        Scanner input = new Scanner (System.in);
        Data_User [] orang = new Data_User [Kasuari.MAX];

        for (int i = 0; i < orang.length; i++) {
            orang[i] = new Data_User ();
        }

        int banyak_user = 0, cek_user = 0, n_sekarang = 0;
        int lanjut = 0;
        int menu1 = 0;

        int pilihan;
        String us, pw;

        while (menu1 != 4) {

            if (lanjut == 0) {

                if (banyak_user > 0) {

                    do {

                        System.out.print ("\nLogin (1) | SignUp (2) : ");
                        pilihan = input.nextInt();

                        if (pilihan != 1 && pilihan != 2) {
                            System.out.println ("Error 102 : Input tidak sesuai\n");
                        }

                    }
                    while (pilihan != 1 && pilihan != 2);

                }
                else {
                    pilihan = 2;
                }

                if (pilihan == 1) {

                    System.out.print ("Masukan username mu : ");
                    us = input.next ();
                    System.out.print ("Masukan password mu : ");
                    pw = input.next ();

                    for (int i = 0; i < banyak_user; i++) {

                        if (us.equals(orang[i].username) && pw.equals(orang[i].password)) {
                            cek_user = 0;
                            n_sekarang = i;
                            break;
                        }
                        else {
                            cek_user++;
                        }

                    }

                    if (cek_user > 0) {
                        System.out.println ("Error 204 : Akun tidak ditemukan\n");
                    }
                    else {
                        System.out.println ("Akun ditemukan\n");
                        lanjut = 1;
                    }

                }
                else {

                    System.out.println ("\n>>>>>>>>>>>>> Ayo buat akun <<<<<<<<<<<<<\n");

                    int s = 1;

                    int random_ga;

                    do {

                        input.nextLine();

                        do {
                            System.out.print ("Buat username mu (random = 1, costum = 2) : ");
                            random_ga = Integer.parseInt (input.nextLine());

                            if (random_ga != 1 && random_ga != 2) {
                                System.out.println ("Error 102 : Input tidak sesuai\n");
                            }
                        }
                        while (random_ga != 1 && random_ga != 2);

                        if (random_ga == 1) {
                            orang[banyak_user].username = Acak_username (orang);
                        }
                        else {
                            System.out.print ("\nMasukan username mu : ");
                            orang[banyak_user].username = input.nextLine();
                        }

                        System.out.print ("Buat password mu : ");
                        orang[banyak_user].password = input.nextLine();

                        for (int i = 0; i < banyak_user; i++) {
                            //System.out.println (orang[i].username + "   " + orang[i].password);
                            if (orang[banyak_user].username.equals(orang[i].username) || orang[banyak_user].password.equals(orang[i].password)) {
                                s = 0;
                                break;
                            }
                            else {
                                s = 1;
                            }
                        }

                        if (s == 0) {
                            System.out.println ("Error 203 : username atau password telah digunakan\n");
                        }

                    }
                    while (s == 0);

                    n_sekarang = banyak_user;

                    lanjut = 1;

                    System.out.println ("\n>>>>>>>>>>>>>>>>>>>>  <<<<<<<<<<<<<<<<<<<<\n");
                    banyak_user++;

                }

            }
            if (lanjut == 1) {

                int pilih_menu;
                Menu opsi;

                System.out.printf ("\n---- Selamat datang %s ----\n\n", orang[n_sekarang].username);

                System.out.println ("\t^^^^^^^^^^^^^");
                System.out.println ("\t 1. Browser");
                System.out.println ("\t 2. Tulis");
                System.out.println ("\t 3. Forum");
                System.out.println ("\t^^^^^^^^^^^^^\n");

                //System.out.println ("Silahkan klik enter");
                input.nextLine();

                do {
                    System.out.print ("Pilih menu : ");
                    pilih_menu = Integer.parseInt(input.nextLine());

                    if (pilih_menu < 1 || pilih_menu > 3) {
                        System.out.println ("Error 102 : Input tidak sesuai\n");
                    }
                }
                while (pilih_menu < 1 || pilih_menu > 3);

                if (pilih_menu == 1) {
                    opsi = Menu.BROWSER;
                }
                else if (pilih_menu == 2){
                    opsi = Menu.TULIS;
                }
                else {
                    opsi = Menu.FORUM;
                }

                switch (opsi) {

                    case BROWSER :
                        Browser (input, n_sekarang);
                        break;

                    case TULIS :
                        Tulis (input, n_sekarang);
                        break;

                    case FORUM :
                        Forum (input, n_sekarang);
                        break;

                }

                System.out.println ("\n##### Pilihan menu #####");
                System.out.println ("  1. Lanjut\n  2. Ganti akun\n  3. Liat history\n  4. Exit");

                do {
                    System.out.print ("Masukan pilihan mu : ");
                    menu1 = input.nextInt();

                    if (menu1 < 1 || menu1 > 4) {
                        System.out.println ("Error 102 : Input tidak sesuai\n");
                    }
                }
                while (menu1 < 1 || menu1 > 4);

                if (menu1 == 1) {
                    lanjut = 1;
                }
                else if (menu1 == 2) {
                    lanjut = 0;
                }
                else if (menu1 == 3){

                    orang[n_sekarang].Tampilkan();

                    System.out.println ("\n----- History Aktivitas -----\n");

                    for (int i = 0; i < pencarian_ke[n_sekarang]+1; i++) {

                        if (i < 1) {
                            continue;
                        }

                        System.out.println (riwayat_pencarian[n_sekarang][i]);
                        System.out.println ("");

                    }

                }

            }

        }

    }

    private static void Forum (Scanner input, int index_saat_ini) {

        int pilih = 1;

        //System.out.println ("\nSilahkan klik enter");
        input.nextLine();

        if (n_pertanyaan > 0) {

            for (int i = 0; i < n_pertanyaan; i++) {
                System.out.printf ("Pertanyaan [%d] : %s\n", i, pertanyaan[i]);
                for (int j = 0; j < jawaban_ke[i]+1; j++) {
                    if (j < 1) {
                        continue;
                    }
                    System.out.printf ("Jawaban [%d]: %s\n", j, jawaban[i][j]);
                }
                System.out.println ("");
            }

            do {
                System.out.print ("\nTulis pertanyaan (1), Jawab pertanyaan (2) : ");
                pilih = Integer.parseInt (input.nextLine());

                if (pilih != 1 && pilih != 2) {
                    System.out.println ("Error 102 : Input tidak sesuai\n");
                }

            }
            while (pilih != 1 && pilih != 2);
        }

        if (pilih == 1) {

            n_pertanyaan++;
            index_pertanyaan++;
            System.out.println ("\nTuliskan pertanyaan mu");
            pertanyaan[index_pertanyaan] = input.nextLine();

            pencarian_ke[index_saat_ini]++;
            riwayat_pencarian[index_saat_ini][pencarian_ke[index_saat_ini]] = "Bertanya : " + pertanyaan[index_pertanyaan];

        }
        else {

            int pilih_index;

            System.out.println ("");

            for (int i = 0; i < n_pertanyaan; i++) {
                System.out.printf ("[%d] %s\n", i,pertanyaan[i]);
            }

            input.nextLine();

            do {
                System.out.print ("Pilih pertanyaan yang ingin dijawab : ");
                pilih_index = Integer.parseInt(input.nextLine());

                if (pilih_index < 0 && pilih_index > n_pertanyaan) {
                    System.out.println ("Error 102 : Input tidak sesuai\n");
                }

            }
            while (pilih_index < 0 && pilih_index > n_pertanyaan);

            System.out.println ("\nTuliskan jawaban mu");
            jawaban_ke[pilih_index]++;
            jawaban[pilih_index][jawaban_ke[pilih_index]] = input.nextLine();

            pencarian_ke[index_saat_ini]++;
            riwayat_pencarian[index_saat_ini][pencarian_ke[index_saat_ini]] = "Menjawab pertanyaan " + pertanyaan[pilih_index] + "\n" + jawaban[pilih_index][jawaban_ke[pilih_index]];

        }

    }

    private static void Browser (Scanner input, int index_saat_ini) {

        Kalimat kalimat = new Kalimat ();
        String kata_kunci;
        int x = -1, n = 0;
        int [] index = new int [Kasuari.n_artikel];
        int [] kemunculan = new int [Kasuari.n_artikel];

        System.out.print ("\nApa yang ingin anda cari tahu : ");
        kata_kunci = input.nextLine ();

        Kasuari.Artikel ();
        System.out.println ("\n<<< Ini dia hasil pencariannya >>>\n");

        String [] kata = kalimat.Bedah (kata_kunci);

        //System.out.println ("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        for (int i = 0; i < Kasuari.n_artikel; i++) {
            kalimat.text = Kasuari.jawaban[i];

            for (int j = 0; j < kata.length; j++) {
                if (kalimat.Contain(kata[j]) == true) {
                    n++;
                    x++;
                    index[x] = i;
                    kemunculan[i] = kalimat.itung_kata_sering_muncul;
                }
            }
        }

        if (n < 1) {
            System.out.println ("\nErrror = 403 : Pencarian tidak ditemukan\n");
        }
        else {

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (index[i] == index[j]) {
                        index[i] = -1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (index[i] < 0) {
                    continue;
                }
                int tampung;

                for (int j = i+1; j < n; j++) {
                    if (kemunculan[i] < kemunculan[j]) {
                        tampung = index[j];
                        index[j] = index[i];
                        index[i] = tampung;
                    }
                }

                System.out.printf ("[%d] %s\n", index[i], Kasuari.judul[index[i]]);
            }

            int cek_input = 0;

            do {
                System.out.print ("\nPilih index judul artikel untuk melihat artikel : ");
                x = input.nextInt();

                for (int i = 0; i < n; i++) {
                    if (x == index[i]) {  //Jika ketemu
                        cek_input = 0;
                        break;
                    }
                    cek_input = 1;
                }

                if (cek_input == 1) {
                    System.out.println("Error 402 : Index tidak ditemukan\n");
                }
            }
            while (cek_input == 1);

            pencarian_ke[index_saat_ini]++;
            riwayat_pencarian[index_saat_ini][pencarian_ke[index_saat_ini]] = "Membuka artikel : " + Kasuari.jawaban[x];

            System.out.println ("\n" + Kasuari.jawaban[x]);

        }


    }

    private static void Tulis (Scanner input, int index_saat_ini) {

        Kalimat kalimat = new Kalimat();
        int n;
        int tes = 1;
        int tanya = 0;
        String judul, artikel;

        Kasuari.Artikel();

        input.nextLine();

        System.out.print ("Mau tulis berapa banyak artikel : ");
        n = Integer.parseInt(input.nextLine());

        System.out.println("");

        do {

            for (int i = Kasuari.index_awal; i < Kasuari.n_artikel+n; i++) { // Tulis semua judul yang hendak dibuat
                System.out.printf ("Masukan judul artikel [%d] : ", (i-Kasuari.index_awal)+1);

                judul = input.nextLine ();
                String [] kata = kalimat.Bedah (judul);

                for (int j = 0; j < Kasuari.n_artikel; j++) {  // Cek banyaknya artikel yang ada di database

                    kalimat.text = Kasuari.judul[j];
                    double tampung = 0;

                    for (int k = 0; k < kata.length; k++) {  //Cek judul bisa dipake atau tidak

                        tampung += kalimat.Persentase_Kemunculan_Kata(kata[k]);
                        //System.out.println (tampung);

                        if (tampung > 20) {
                            System.out.printf ("Plagiatmeter : %.2f > 20, judul ini tidak bisa digunakan\n", tampung);
                            tes = 1;
                            break;
                        }
                        else {
                            tes = 0;
                        }
                    }

                    if (tes == 1) {
                        break;
                    }

                    Kasuari.judul[i] = judul;

                }

            }

            input.nextLine();

            if (tes == 1) {
                System.out.print ("\nLanjut nulis (1 = yes, selain 1 = no) : ");
                tanya = Integer.parseInt(input.nextLine());
            }

        }
        while (tes == 1 && tanya == 1);

        System.out.println("");

        if (tanya != 1 && tes != 1) {

            do {
                for (int i = Kasuari.index_awal; i < Kasuari.n_artikel+n; i++) {
                    System.out.printf ("%s\n", Kasuari.judul[i]);

                    artikel = input.nextLine ();
                    String [] kata = kalimat.Bedah (artikel);

                    for (int j = 0; j < Kasuari.n_artikel; j++) {

                        kalimat.text = Kasuari.jawaban[j];
                        double tampung = 0;

                        for (int k = 0; k < kata.length; k++) { // Cek artikel

                            tampung += kalimat.Persentase_Kemunculan_Kata(kata[k]);
                            //System.out.printf ("[%d] %.2f\n", k, tampung);

                            if (tampung > 20) {
                                System.out.printf ("Plagiatmeter : %.2f > 20, artikel ini tidak bisa digunakan\n", tampung);
                                tes = 1;
                                //tampung = 0;
                                break;
                            }
                            else {
                                tes = 0;
                            }
                        }

                        if (tes == 1) {
                            break;
                        }

                        Kasuari.jawaban[i] = artikel;

                    }

                }

                input.nextLine();

                if (tes == 1) {
                    System.out.print ("\nLanjut nulis (1 = yes, selain 1 = no) : ");
                    tanya = Integer.parseInt (input.nextLine());
                }

            }
            while (tes == 1 && tanya == 1);

            if (tanya != 1 && tes != 1) {

                for (int i = Kasuari.index_awal; i < Kasuari.n_artikel+n; i++) {
                    pencarian_ke[index_saat_ini]++;
                    riwayat_pencarian[index_saat_ini][pencarian_ke[index_saat_ini]] = "Menulis artikel : " + Kasuari.jawaban[i];
                }

                Kasuari.index_awal = Kasuari.index_awal+n;
                Kasuari.n_artikel += n;

                //System.out.println (Kasuari.index_awal);
                //System.out.println (Kasuari.n_artikel);
            }

            System.out.println ("\n");

            /*
            for (int i = 0; i < Kasuari.n_artikel; i++) {
                System.out.println (Kasuari.judul[i]);
                System.out.println (Kasuari.jawaban[i]);
                System.out.println("\n");
            }

             */

        }

    }

    private static String Acak_username (Data_User [] orang) {

        Random rand = new Random ();

        int mengacak;
        String us = "";

        int tampung = 0;

        while (tampung == 0) {

            mengacak = 1000 + rand.nextInt (8999);
            us = Integer.toString (mengacak);

            for (int i = 0; i < orang.length; i++) {
                if (us.equals(orang[i].username)) {
                    tampung = 0;
                    break;
                }
                else {
                    tampung++;
                }
            }

        }

        return us;

    }

}
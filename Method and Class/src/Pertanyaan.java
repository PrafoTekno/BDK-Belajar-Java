

class Pertanyaan {

    String kunci_jawaban1, kunci_jawaban2, kunci_jawaban3, kunci_jawaban4, kunci_jawaban5;
    int jumlah_benar = 0;

    public void Soal () {

        System.out.println ("\n1.\tArti kata “cat” dalam Bahasa Indonesia");
        System.out.println ("2.\tArti kata “bird” dalam Bahasa Indonesia");
        System.out.println ("3.\tArti kata “rabbit” dalam Bahasa Indonesia");
        System.out.println ("4.\tArti kata “sheep” dalam Bahasa Indonesia");
        System.out.println ("5.\tArti kata “cow” dalam Bahasa Indonesia\n");

    }

    public void Itung_Jawaban (String a, String b, String c, String d, String e) {

        kunci_jawaban1 = "kucing";
        kunci_jawaban2 = "burung";
        kunci_jawaban3 = "kelinci";
        kunci_jawaban4 = "domba";
        kunci_jawaban5 = "sapi";

        if (a.equals(kunci_jawaban1)) {
            jumlah_benar += 1;
            System.out.println ("No 1 benar");
        }
        if (b.equals(kunci_jawaban2)) {
            jumlah_benar += 1;
            System.out.println ("No 2 benar");
        }
        if (c.equals(kunci_jawaban3)) {
            jumlah_benar += 1;
            System.out.println ("No 3 benar");
        }
        if (d.equals(kunci_jawaban4)) {
            jumlah_benar += 1;
            System.out.println ("No 4 benar");
        }
        if (e.equals(kunci_jawaban5)) {
            jumlah_benar += 1;
            System.out.println ("No 5 benar");
        }

        System.out.printf ("\nKamu benar menjawab %d dari 5 soal yang ada\n", jumlah_benar);

    }

}

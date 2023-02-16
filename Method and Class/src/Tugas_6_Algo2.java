
import java.util.Scanner;

class Belanjaan {

    int point;
    String nama;
    String PIN;

    Belanjaan (int point, String nama, String PIN) {

        this.point = point;
        this.nama = nama;
        this.PIN = PIN;

    }

    public void Setting_account () {

        Scanner input = new Scanner (System.in);

        System.out.print ("Buat nama ID : ");
        this.nama = input.nextLine ();
        System.out.print ("Buat PIN : ");
        this.PIN = input.nextLine ();

        

    }

}

public class Tugas_6_Algo2 {

    public static void main (String[] args) {

        Belanjaan costumer1 = new Belanjaan (10000000, "", "");
        Belanjaan costumer2 = new Belanjaan (750000, "", "");
        Belanjaan costumer3 = new Belanjaan (5000000,  "", "");

        System.out.println ("Selamat pagi");

    }

}


import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/*
Buat server main

Akan ditampilkan leaderboard (peringkatnya)
Konsep game adalah permainan kartu
 */

class Profile {

    String name;
    int PIN;
    int poin;
    String division;     //Eagles, Lion, Turtle, Rhino
    String Rank;         //Bronze, Silver, Gold, Platinum
    String specialist = "-";    //Spy, Strategist, Healer, Guardian

    public void Make (int num) {

        if (num >= 1 && num <= 4) {
            this.division = "Eagles";
        }
        else if (num >= 5 && num <= 8) {
            this.division = "Lion";
        }
        else if (num >= 9 && num <= 12) {
            this.division = "Turtle";
        }
        else  {
            this.division = "Rhino";
        }

    }

    public void Show () {

        if (this.poin > 10) {
            this.Rank = "Silver";
        }
        else if (this.poin > 30) {
            this.Rank = "Gold";
        }
        else if (this.poin > 50) {
            this.Rank = "Platinum";
        }
        else {
            this.Rank = "Bronze";
        }

        if (this.poin > 30) {

            if (this.division.equals("Eagles")) {
                this.specialist = "Spy";
            }
            else if (this.division.equals("Lion")) {
                this.specialist = "Strategist";
            }
            else if (this.division.equals("Turtle")) {
                this.specialist = "Healer";
            }
            else {
                this.specialist = "Guardian";
            }

        }

        System.out.println ("\n===============================");
        System.out.printf ("Name Ranger : %S\n", this.name);
        System.out.printf ("Division : %S\n", this.division);
        System.out.printf ("Rank : %S\n", this.Rank);
        System.out.printf ("Specialist : %S\n", this.specialist);
        System.out.printf ("Poin : %d\n", this.poin);
        System.out.println ("===============================\n");

    }

}

class Game {  //Untuk save dan load game bukan akun

    final int MAX = 99999;

    static int HP_user = 1500;
    static int HP_AI = 1500;

    int attack_user, deffence_user;
    int attack_AI, deffence_AI;
    static int no_card_user = -1;

    // Variable kartu
    static int [] index_array = new int [8];

    static String [] card = new String [8];
    private ArrayList<Integer> index = new ArrayList<Integer>(8);

    public void Shuffle () {

        HP_AI = 1500;
        HP_user = 1500;

        card[0] = "atk(200)";
        card[1] = "def(500)";
        card[2] = "atk(300)";
        card[3] = "+HP(100)";

        card[4] = "+HP(220)";
        card[5] = "def(200)";
        card[6] = "atk(700)";
        card[7] = "def(150)";

        for (int i = 0; i < 8; i++) {
            index.add (i);
        }

        //Random rand = new Random();
        Collections.shuffle (index);

        index_array = index.stream().mapToInt(Integer::intValue).toArray(); //convert list ke int array

    }

    public void GamePlay () {

        // Kartu AI

        int no_card_AI = (int)(Math.random() * (4)) + 4;  //Random 4 sampai 8
        System.out.printf ("\nAI card : [%d] %s",index_array[no_card_AI] ,card[index_array [no_card_AI]]);

        if (no_card_user == 0) {
            this.attack_user = 200;
        }
        else if (no_card_user == 1) {
            this.deffence_user = 500;
        }
        else if (no_card_user == 2) {
            this.attack_user = 300;
        }
        else if (no_card_user == 3) {
            this.HP_user += 100;
        }
        else if (no_card_user == 4) {
            this.HP_user += 220;
        }
        else if (no_card_user == 5) {
            this.deffence_user = 200;
        }
        else if (no_card_user == 6) {
            this.attack_user = 700;
        }
        else {
            this.deffence_user = 150;
        }

        // AI

        if (index_array[no_card_AI] == 0) {
            this.attack_AI = 200;
        }
        else if (index_array[no_card_AI] == 1) {
            this.deffence_AI = 500;
        }
        else if (index_array[no_card_AI] == 2) {
            this.attack_AI = 300;
        }
        else if (index_array[no_card_AI] == 3) {
            this.HP_AI += 100;
        }
        else if (index_array[no_card_AI] == 4) {
            this.HP_AI += 220;
        }
        else if (index_array[no_card_AI] == 5) {
            this.attack_AI = 200;
        }
        else if (index_array[no_card_AI] == 6) {
            this.attack_AI = 700;
        }
        else {
            this.deffence_AI = 150;
        }

    }

    public int Attack (int who) {

        int damage;

        if (who == 1) {     //User nyerang
            damage = this.attack_user - this.deffence_AI;

            if (damage < 0) {
                return 0;
            }
            else {
                return damage;
            }
        }
        else {          //AI nyerang
            damage = this.attack_AI - this.deffence_user;

            if (damage < 0) {
                return 0;
            }
            else {
                return damage;
            }
        }
    }


}

public class Main {

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);
        Game play = new Game ();
        Profile [] ranger = new Profile [play.MAX];

        for (int i = 0; i < ranger.length; i++) {
            ranger[i] = new Profile ();
        }

        String pw;
        int status = 0, PIN;
        String name = "";
        int n = 0, n1 = -1;
        int number_kuisoner = 0, tambah;
        int cek = -1;
        int menu = 0;

        System.out.println ("\nTo invinity and beyond");
        System.out.print ("~ ");
        pw = input.nextLine ();

        if (pw.equals("Buzz Lightyear") || pw.equals("buzz lightyear")) {
            System.out.println ("\n________Welcome Space Ranger________");

            while (menu != 3) {

                    while (status != 2 && status != 1) {

                        System.out.print ("\nNew member (1) | old member (2) : ");
                        status = input.nextInt ();

                        if (status != 1 && status != 2) {
                            System.out.print ("\nError : invalid input");
                        }

                    }

                    if (status == 1) {  //Buat akun

                        System.out.print ("\nInput your name : ");
                        name = input.next ();
                        System.out.print ("Make your PIN : ");
                        PIN = input.nextInt ();

                        for (int i = 0; i < 4; i++) {

                            if (i < 1) {
                                System.out.println("\nWhat do you like the most ");
                                System.out.print("1. Snipper, 2. Light Syber, 3. Dual Gun, 4. RPG : ");
                            }
                            else if (i < 2) {
                                System.out.println("What place is most familiar to you ");
                                System.out.print("1. Tower, 2. Basement, 3. Medbay, 4. Bunker : ");
                            }
                            else if (i < 3) {
                                System.out.println("What things you can operate ");
                                System.out.print("1. GPS, 2. Lavilator, 3. Medkit, 4. Mortir : ");
                            }
                            else {
                                System.out.println("What game you like the most");
                                System.out.print("1. Sight Training, 2. Chess, 3. Tic Tac Toe, 4. Zuma : ");
                            }

                            do {
                                tambah = input.nextInt();
                                if (tambah > 4) {
                                    System.out.println ("\nInput valid");
                                }

                            }
                            while (tambah > 4);

                            number_kuisoner = number_kuisoner + tambah;

                        }

                        ranger[n].name = name;
                        ranger[n].PIN = PIN;
                        ranger[n].Make (number_kuisoner);
                        ranger[n].Show();

                        number_kuisoner = 0;
                        n++;
                        n1++;

                    }
                    else {  //Load akun

                        while (true) {

                            System.out.print ("\nInput your name : ");
                            name = input.next ();
                            System.out.print ("Input your PIN : ");
                            PIN = input.nextInt ();

                            for (int i = 0; i < n; i++) {

                                if (name.equals(ranger[i].name) && PIN == ranger[i].PIN) {
                                    cek = i;
                                    break;
                                }

                            }

                            if (cek >= 0) {
                                ranger[cek].Show ();
                                break;
                            }
                            else {
                                System.out.println ("\nError : can't find the ranger's account!");
                            }
                            cek = -1;

                        }

                    }

                //Buat main

                play.Shuffle ();
                int card_no, loop = 0;
                int [] val_card = new int [4];

                while (play.HP_user > 0 && play.HP_AI > 0) {

                    System.out.println ("loop = " + loop);

                    // Menampilkan kartu user

                    System.out.print ("Your card ->> | ");
                    for (int y = 0; y < 4; y++) {
                        if (play.index_array[y] == play.no_card_user) {
                            val_card[y] = play.index_array[y];
                        }
                    }
                    /*
                    for (int y = 0; y < 4; y++) {
                        if (val_card[y] == play.index_array[y] && loop%3 != 0) {
                            continue;
                        }
                        System.out.printf (" [%d] %s |", play.index_array[y], play.card[play.index_array[y]]);
                    }
                     */

                    System.out.printf ("\nYour HP : %d", play.HP_user);
                    int data = 1;

                    do {

                        System.out.print ("\nChoose your card : ");
                        card_no = input.nextInt ();

                        for (int i = 0; i < 4; i++) {  //Ngecek  kartu yang dipilih
                            if (card_no != play.index_array[i]) {
                                data++;
                            }
                            else {
                                data = 0;
                                break;
                            }
                        }

                        if (data != 0) {
                            System.out.println ("Card no available\n");
                        }

                    }

                    while (data != 0);

                    play.no_card_user = card_no;

                    play.GamePlay ();

                    play.HP_AI -= play.Attack (1);
                    play.HP_user -= play.Attack (2);

                    System.out.printf ("\nAI HP : %d\n\n", play.HP_AI);
                    loop++;

                }

                if (play.HP_user > play.HP_AI) {
                    ranger[n1].poin += 5;
                    System.out.println ("You won");
                }
                else {
                    ranger[n1].poin += -2;
                    if (ranger[n1].poin < 0) {
                        ranger[n1].poin = 0;
                    }
                    System.out.println ("You lose");
                }

                System.out.println ("\n\n>>>>>>> Menu Selection <<<<<<<");
                System.out.println ("1. Leaderboard");
                System.out.println ("2. Play again");
                System.out.println ("3. Quit");
                System.out.print ("=> ");
                menu = input.nextInt ();

                if (menu == 1) {

                    //System.out.println (ranger[0].poin);

                    // Leaderboard
                    int val;

                    for (int i = 0; i < n; i++) {
                        for (int j = i+1; j < n; j++) {
                            if (ranger[i].poin < ranger[i].poin) {
                                val = i;
                                i = j;
                                j = val;
                            }
                        }
                        ranger[i].Show();
                    }

                }

                status = 0;

            }

        }
        else {
            System.out.println ("\nI think you are lost");
        }

    }

}
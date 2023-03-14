
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Tes2
{
    public static void main(String[] args) {

        String [] card = new String [8];
        ArrayList<Integer> index = new ArrayList<Integer>(8);

        card[0] = "atk(200)";
        card[1] = "def(500)";
        card[2] = "atk(300)";
        card[3] = "man(100)";

        card[4] = "+hp(120)";
        card[5] = "def(200)";
        card[6] = "atk(700)";
        card[7] = "def(150)";

        for (int i = 0; i < 8; i++) {
            index.add (i);
        }

        Random rand = new Random();

        Collections.shuffle (index, rand);  //Melakukan random tidak berduplicate

        int [] index_array = index.stream().mapToInt(Integer::intValue).toArray(); //convert list ke int array

        // Kartu user

        System.out.print ("Your card ->> | ");

        for (int y = 0; y < 4; y++) {
            System.out.printf (" [%d] %s |", index_array[y], card[index_array[y]]);
        }

        // Kartu AI

        int y = ThreadLocalRandom.current().nextInt(4, 7 + 1);
        System.out.println (y);

    }
}
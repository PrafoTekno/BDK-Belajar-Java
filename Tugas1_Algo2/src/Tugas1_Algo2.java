
// Punya Salfatore Yan Prafo

import java.util.Scanner;

public class Tugas1_Algo2 {

    public static void main (String[] args) {

        Scanner input = new Scanner (System.in);

        double suhu_celcius;
        double suhu_farenheit;
        double suhu_kelvin;

        System.out.print ("\nMasukan suhu ruangan dalam Celcius : ");
        suhu_celcius = input.nextDouble();

        suhu_farenheit = (9/5) * suhu_celcius + 32;
        suhu_kelvin = suhu_celcius + 273;

        System.out.printf ("\nSuhu ruangan itu adalah %f derajat F dan %f K!\n", suhu_farenheit, suhu_kelvin);

    }

}
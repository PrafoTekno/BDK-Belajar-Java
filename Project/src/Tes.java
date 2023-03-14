
import java.util.Scanner;
import java.lang.Math;

class Kalkulasi{

    public double Tegangan(double a, double b){
        return a*b;
    }

    public double Arus_Resistansi(double a, double b){
        return a/b;
    }

    public double AC_to_DC(double a){
        return a/Math.sqrt(2);
    }

    public double DC_to_AC(double a){
        return a*Math.sqrt(2);
    }

    public double r(double a, double b){
        return Math.sqrt(a*a + b*b);
    }

    public double sudut(double a, double b){
        return Math.atan(b/a);
    }

    public double cartesian(double a, double b){
        return a*Math.cos(b);
    }

    public double imajiner(double a, double b){
        return a*Math.sin(b);
    }
}

public class Tes
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kalkulasi rumus = new Kalkulasi();
        String x;
        int T = 1;
        while(T == 1){
            System.out.println("Ini adalah sebuah converter system untuk peminat elektronika");
            System.out.println("Apakah yang ingin anda konversi? (Silahkan pilih huruf)");
            System.out.println("a. Tegangan\nb. Arus\nc. Resistansi\nd. AC to DC\ne. DC to AC\nf. Cartesian to Polar\ng. Polar to cartesian");

            x = input.next();
            double Arus;
            double Resistansi;
            double Tegangan;
            double AC;
            double DC;
            double bilangan_imajiner;
            double bilangan_cartesian;
            double bilangan_r;
            double sudut;


            if(x.equals("a")){
                System.out.println("Untuk Tegangan anda harus memiliki nilai Arus dan Resistansi");
                System.out.println("Silahkan input nilai Arus");
                Arus = input.nextDouble();
                System.out.println("Silahkan input nilai Resistansi");
                Resistansi = input.nextDouble();
                System.out.printf("Nilai tegangan anda adalah = %.3f", rumus.Tegangan(Arus,Resistansi));
                System.out.println("\nApakah ada yang ingin di konvert lagi?\nJika iya maka tekan 1, jika tidak maka tekan 0");
                T = input.nextInt();
            }

            else if(x.equals("b")){
                System.out.println("Untuk Arus anda harus memiliki nilai Tegangan dan Resistansi");
                System.out.println("Silahkan input nilai Tegangan");
                Tegangan = input.nextDouble();
                System.out.println("Silahkan input nilai Resistansi");
                Resistansi = input.nextDouble();
                System.out.printf("Nilai tegangan anda adalah = %.3f", rumus.Arus_Resistansi(Tegangan,Resistansi));
                break;
            }

            else if(x.equals("c")){
                System.out.println("Untuk Resistansi anda harus memiliki nilai Tegangan dan Arus");
                System.out.println("Silahkan input nilai Tegangan");
                Tegangan = input.nextDouble();
                System.out.println("Silahkan input nilai Arus");
                Arus = input.nextDouble();
                System.out.printf("Nilai tegangan anda adalah = %.3f", rumus.Arus_Resistansi(Tegangan,Arus));
                break;
            }

            else if(x.equals("d")){
                System.out.println("Silahkan input nilai tegangan AC anda");
                AC = input.nextDouble();
                System.out.printf("Nilai tegangan DC anda adalah = %.3f", rumus.AC_to_DC(AC));
                break;
            }

            else if(x.equals("e")){
                System.out.println("Silahkan input nilai tegangan DC anda");
                DC = input.nextDouble();
                System.out.printf("Nilai tegangan AC anda adalah = %.3f", rumus.DC_to_AC(DC));
                break;
            }

            else if(x.equals("f")){
                System.out.println("Untuk mendapatkan nilai polar anda harus memiliki bilangan cartesian dan bilangan imajiner");
                System.out.println("Silahkan input bilangan cartesian");
                bilangan_cartesian = input.nextDouble();
                System.out.println("Silahkan input bilangan imajiner");
                bilangan_imajiner = input.nextDouble();
                System.out.printf("Nilai polar anda adalah = %.3f (sudut) %.3f ", rumus.r(bilangan_cartesian,bilangan_imajiner), rumus.sudut(bilangan_cartesian,bilangan_imajiner));
                break;
            }

            else if(x.equals("g")){
                System.out.println("Untuk mendapatkan nilai cartesian anda harus memiliki radius dan sudut");
                System.out.println("Silahkan input radius");
                bilangan_r = input.nextDouble();
                System.out.println("Silahkan input sudut");
                sudut = input.nextDouble();
                System.out.printf("Nilai polar anda adalah = %.3f + J(%.3f) ", rumus.cartesian(bilangan_r,sudut), rumus.imajiner(bilangan_r,sudut));
                break;
            }

            else {
                System.out.println("Mohon Masukkan input yang benar");
            }
        }

    }
}
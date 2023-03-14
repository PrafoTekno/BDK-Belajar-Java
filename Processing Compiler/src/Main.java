import processing.core.PApplet;

public class Main extends PApplet {

    public static PApplet processing;

    public static void main(String[] args) {
        PApplet.main ("Main", args);
        System.out.println("Hello world!");
    }

    public void draw () {
        line (5,5,50,50);
    }

}
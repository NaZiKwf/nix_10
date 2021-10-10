import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        int start = 9 * 60;
        int lesson = 45;
        int small = 5;
        int big = 15;
        int input;

        Scanner in = new Scanner(System.in);
        input = in.nextInt();
        int m = start + input * lesson;
        m += (input - 1) * small;
        m += (input - 1) / 2 * (big - small);
        System.out.println(m / 60 + " " + m % 60);
    }


}

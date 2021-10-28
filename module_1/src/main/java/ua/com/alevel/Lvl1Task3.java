package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lvl1Task3 {

    public static void main(String[] args) throws IOException {
        double[] arrfortask = Enter();
        double x1 = arrfortask[0],
                x2 = arrfortask[2],
                x3 = arrfortask[4];
        double y1 = arrfortask[1],
                y2 = arrfortask[3],
                y3 = arrfortask[5];
        double a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        double b = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));
        double c = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));

        if (a + b >= c && a + c >= b && b + c >= a) {
            double p = (a + b + c) / 2.0;
            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Squares: " + square);
        } else {

            System.out.println("There is no such triangle");
        }
    }

    public static double[] Enter() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String enter;
        System.out.println("Enter six coordinates for A, B, C (x1,y1,x2,y2,x3,y3)");
        double b;
        double[] arr = new double[6];
        for (int i = 0; i < 6; i++) {
            while (true) {
                enter = br.readLine();
                try {
                    b = Check(enter);
                } catch (Exception e) {
                    continue;
                }
                arr[i] = b;
                break;
            }

        }

        return arr;
    }

    public static double Check(String s) throws Exception {
        double t = 0;
        try {
            t = Double.parseDouble(s);
        } catch (Exception e) {
            System.out.println("Enter a double");
            throw new Exception();
        }
        return t;
    }

}

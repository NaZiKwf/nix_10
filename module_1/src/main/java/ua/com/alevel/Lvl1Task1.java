package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lvl1Task1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter numbers with space");
        int[] x;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String enter;
        while (true) {
            enter = br.readLine();
            String[] tok = enter.split(" ");
            x = new int[tok.length];
            if (Check(tok)) {
                int z;
                for (int i = 0; i < tok.length; i++) {
                    z = Integer.parseInt(tok[i]);
                    x[i] = z;
                }
                System.out.println(uniqueCount(x));
                break;
            }
        }
    }

    public static boolean Check(String[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                Integer.parseInt(array[i]);
            } catch (Exception e) {
                System.out.println("Enter numbers please");
                return false;
            }
        }
        return true;
    }

    public static int uniqueCount(int[] array) {

        int[] copy = new int[array.length];
        int res = 0;
        int countNum = 0;
        int count = 0;

        for (int i = 0; i < copy.length; i++) {
            copy[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (copy[i] == 0) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        copy[j] = 1;
                        count++;
                    }
                }
            }
            if (countNum < count) {
                countNum = count;
                res++;
            }

        }
        return res;
    }

}

package ua.com.alevel;

import java.util.Scanner;

public class SumOfNumbers {

    public void SumOfNumbers() {
        Scanner in = new Scanner(System.in);
        String str;
        int sum = 0;
        str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            try {
                sum += Integer.parseInt(str.substring(i, i + 1));

            } catch (Exception ignored) {
            }
        }
        System.out.println(sum);
    }
}

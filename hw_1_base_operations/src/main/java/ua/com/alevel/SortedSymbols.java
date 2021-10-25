package ua.com.alevel;

import java.util.Scanner;

public class SortedSymbols {

    public void SortedSymbols() {
        Scanner in = new Scanner(System.in);
        String str;
        str = in.nextLine();
        char[] arrC = str.toCharArray();
        int[] arrInt = new int[50];
        char[] arrChar = new char[50];
        int count = 0;
        boolean b;
        System.out.println(arrC.length);
        for (char c : arrC) {
            b = false;
            for (int j = 0; j < arrChar.length; j++) {
                if (arrChar[j] == c) {
                    arrInt[j]++;
                    b = true;
                    break;
                }
            }
            if (!b) {
                arrChar[count] = c;
                arrInt[count] = 1;
                count++;
            }
        }
        sort(arrInt, arrChar, count);

        for (int i = 0; i < count; i++) {
            System.out.print(arrChar[i] + "-" + arrInt[i] + " ");

        }
        System.out.print("\n");
    }

    public static void sort(int[] arrInt, char[] arrChar, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = count - 1; j > i; j--) {
                if (arrChar[j - 1] > arrChar[j]) {
                    char tmp = arrChar[j - 1];
                    arrChar[j - 1] = arrChar[j];
                    arrChar[j] = tmp;
                    int tmp2 = arrInt[j - 1];
                    arrInt[j - 1] = arrInt[j];
                    arrInt[j] = tmp2;
                }
            }
        }
    }
}

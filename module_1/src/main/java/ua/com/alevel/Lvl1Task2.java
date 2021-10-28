package ua.com.alevel;


import java.util.Scanner;

public class Lvl1Task2 {

    public static char startPos;
    public static int startNum;
    public static char finishPos;
    public static int finishNum;
    public static char[] array = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};


    public static void main(String[] args) {
        int num;
        char ch;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter letter(A-H) in one line and number(1-8) in next line for start position");
        for (; ; ) {

            ch = in.next().charAt(0);

            num = in.nextInt();
            if (Check(ch, num, true)) {
                break;
            }
        }
        System.out.println("Enter letter(A-H) in one line and number(1-8) in next line for start position");
        for (; ; ) {

            ch = in.next().charAt(0);

            num = in.nextInt();
            if (Check(ch, num, false)) {
                break;
            }
        }
        Logic();
    }

    public static boolean Logic() {
        int letterNum = 0;
        int letterNum1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == startPos) {
                letterNum = i;
            }
            if (array[i] == finishPos) {
                letterNum1 = i;
            }
        }
        if (letterNum + 2 == letterNum1 || letterNum - 2 == letterNum1) {
            if (startNum + 1 == finishNum || startNum - 1 == finishNum) {
                System.out.println("Possible move");
                return true;
            }

        }
        if (startNum + 2 == finishNum || startNum - 2 == finishNum) {
            if (letterNum + 1 == letterNum1 || letterNum - 1 == letterNum1) {
                System.out.println("Possible move");
                return true;
            }

        }
        System.out.println("This position is not correct");
        return false;
    }

    public static boolean Check(char l, int n, boolean start) {
        boolean b = false;

        for (int i = 0; i < array.length; i++) {
            if (l == array[i]) {
                b = true;
                if (start) {
                    startPos = l;
                } else {
                    finishPos = l;
                }
            }
        }
        if (!b) {
            System.out.println("Enter a letter from A-H");
            return false;
        }

        if (n > 0 && n < 9) {
            b = true;
            if (start) {
                startNum = n;
            } else {
                finishNum = n;
            }
        } else {
            b = false;
            System.out.println("Enter a number from 1-8");
        }
        return b;
    }
}


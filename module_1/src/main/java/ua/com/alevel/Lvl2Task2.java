package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lvl2Task2 {
    public static void main(String[] args) throws IOException {
        Tree Task5 = new Tree();
        Integer[] array=Enter();
        Task5.add(array);
        Task5.print();
        int depth=Task5.maxDepth();
        System.out.println("Max depth " + depth);

    }
    public static Integer[] Enter() throws IOException {
        System.out.println("Enter numbers with space");
        Integer[] x;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String enter;
        while (true) {
            enter = br.readLine();
            String[] tok = enter.split(" ");
            x = new Integer[tok.length];
            if (Check(tok)) {
                int z;
                for (int i = 0; i < tok.length; i++) {
                    z = Integer.parseInt(tok[i]);
                    x[i] = z;
                }
                return x;
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

}



package ua.com.alevel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Lvl2Task1 {

    public static void main(String[] args) {

        String[] a = {"[)", "[}", "(]", "(}", "{]", "{)"};
        String[] b = {")", "]", "}"};
        String[] c = {"(", "[", "{"};
        List<String> alist = Arrays.asList(a);
        List<String> blist = Arrays.asList(b);
        List<String> clist = Arrays.asList(c);
        System.out.println("Enter the brackets:");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean ch = true;
            String s = sc.nextLine();
            if (s.isEmpty()){
                System.out.println(true);
                continue;
            }else {
                if (blist.contains(s.substring(0, 1))|| clist.contains(s.substring(s.length() - 1))) {

                    System.out.println(false);
                    continue;
                }
                char[] chars = s.toCharArray();
                int x1 = 0,y1 = 0;
                int x2 = 0,y2 = 0;
                int x3 = 0,y3 = 0;
                for (char aChar : chars) {
                    if (aChar == '('){
                        y1++;
                    }
                    if (aChar==')'){
                        x1++;
                    }
                    if (aChar=='['){
                        y2++;
                    }
                    if (aChar==']'){
                        x2++;
                    }
                    if (aChar=='{'){
                        y3++;
                    }
                    if (aChar=='}'){
                        x3++;
                    }
                }
                if (y1!=x1||y2!=x2||y3!=x3){

                    System.out.println(false);
                    continue;
                } else {

                    String j;
                    for (int i = 0; i < s.length() - 1; i++) {
                        if (s.length() == 2) {
                            j = s;
                        } else {
                            if (i == s.length() - 2) {
                                j = s.substring(i);
                            } else {
                                j = s.substring(i, i + 2);
                            }
                        }
                        if (alist.contains(j)) {

                            ch = false;
                            break;
                        }
                    }
                }
            }
            System.out.println(b);
        }
    }
}

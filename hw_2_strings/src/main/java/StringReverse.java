
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        String firstInput = "Choose a variety of reverse:\n";
        String welcome = """
                (1)ReverseString;
                (2)ReverseSubstring;
                (3)ReverseByIndexes;\n""";


        String appear = "Choose a variety of reverse again or click on 0 for exit";
        System.out.print(firstInput + welcome);
        Scanner in = new Scanner(System.in);
        String text, subtext, event;
        String first, second;
        int a, b;
        while ((event = in.nextLine()) != null) {
            switch (event) {
                case "1" -> {
                    System.out.print("Type your text: ");
                    text = in.nextLine();
                    firstSimpleReverse(text);
                }
                case "2" -> {
                    System.out.print("Type your text: ");
                    text = in.nextLine();
                    System.out.print("Type your subtext: ");
                    subtext = in.nextLine();
                    secondReverseSubstring(text,subtext);
                }
                case "3" -> {
                    System.out.print("Type your text: ");
                    text = in.nextLine();
                    System.out.print("Type firstIndex: ");
                    a = in.nextInt();
                    System.out.print("Type lastIndex: ");
                    b = in.nextInt();
                    thirdReverseString(text,a,b);
                }

                case "0" -> System.exit(0);
            }
        }
    }

    public static void firstSimpleReverse(String str) {

        StringBuilder t = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            t.append(str.charAt(i));
        }
        t.toString();
        System.out.println(t);
    }

    public static void secondReverseSubstring(String a, String b) {

        int temp = 0;
        int indexSub = 0;
        indexSub = a.indexOf(b);
        StringBuilder t2 = new StringBuilder();

        while (temp < a.length()) {
            if (temp == indexSub) {
                for (int i = b.length() - 1; i >= 0; i--) {
                    t2.append(b.charAt(i));
                }
                temp += b.length();

            } else {
                t2.append(a.charAt(temp));
                temp++;

            }

        }
        t2.toString();
        System.out.println(t2);
    }

    public static void thirdReverseString(String strfIndex, int fIndex, int lIndex) {
        int temp1 = 0;
        StringBuilder t2 = new StringBuilder();

        while (temp1 < strfIndex.length()) {
            if (temp1 == fIndex) {
                int StringLong = 0;
                for (int i = lIndex - 1; i >= fIndex; i--) {
                    t2.append(strfIndex.charAt(i));
                    StringLong++;

                }
                temp1 += StringLong;

            } else {
                t2.append(strfIndex.charAt(temp1));
                temp1++;

            }

        }
        t2.toString();
        System.out.println(t2);


    }

}

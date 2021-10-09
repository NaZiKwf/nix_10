import java.util.Scanner;
public class Ex2
{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter");
        String str;
        str=in.nextLine();
        char[]arrC =str.toCharArray();
        int[] arrInt=new int[50];
        char[] arrChar=new char[50];
        int count=0;
        System.out.println(arrC.length);

        for(int i=0;i<arrC.length;i++){
            for(int j=0;j<arrChar.length;j++){
                if(arrC[i]==arrChar[j]){
                    arrInt[j]++;

                }

                else{
                    arrChar[count]=arrC[i];
                    arrInt[count]=1;
                    count++;
                    break;
                }
            }

        }


        for(int i=0;i<count;i++){
            System.out.print(arrChar[i]+"-"+arrInt[i]+" ");

        }

    }



}

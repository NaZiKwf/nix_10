import java.util.Scanner;

public class Ex1
{
    public static void main(String[] args){

        Ex1();
    }
    public static void Ex1() {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter");
        String str;
        int sum=0;
        str= in.nextLine();
        for(int i=0;i<str.length();i++){
            try{
                sum+=Integer.parseInt(str.substring(i,i+1));

            }catch (Exception ignored){}
        }

        System.out.println(sum);

    }
    public static void Ex2(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter");
        String str;
        int sum=0;
        str=in.nextLine();
        for(int i=0;i<str.length();i++){

        }



    }

}


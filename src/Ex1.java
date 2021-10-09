import java.util.Scanner;

public class Ex1
{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter");
        int sum=0;

        while(true){
            if(in.hasNextLine()){
                in.nextLine();
                while(true) {
                    int temp;

                    try{
                        temp = in.nextInt();
                        sum+=temp;
                    System.out.println("YA ZDES`");
                    }
                    catch (Exception e){
                        break;
                    }

                }
                break;
            }

        }

        System.out.println(sum);
    }
}

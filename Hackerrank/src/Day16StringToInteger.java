import java.util.Scanner;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day16StringToInteger {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        try{
            Integer i = Integer.parseInt(s);
            System.out.println(i);
        }catch(NumberFormatException e){
            System.out.println("Bad String");
        }
    }
}

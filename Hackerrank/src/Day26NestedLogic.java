import java.util.Scanner;

/**
 * Created by Arvin on 11-Apr-17.
 */
public class Day26NestedLogic {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int da, ma, ya, de, me, ye;
        da = sc.nextInt();
        ma = sc.nextInt();
        ya = sc.nextInt();
        de = sc.nextInt();
        me = sc.nextInt();
        ye = sc.nextInt();

        if(ya > ye){
            System.out.println("10000");
        }
        else if(ma > me){
            System.out.println(500 * (ma-me));
        }
        else if(da > de){
            System.out.println(15 * (da-de));
        }
        else{
            System.out.println(0);
        }
    }
}

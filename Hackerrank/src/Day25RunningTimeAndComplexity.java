import java.util.Scanner;

/**
 * Created by Arvin on 11-Apr-17.
 */
public class Day25RunningTimeAndComplexity {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        while(numTest-- > 0){
            int number = sc.nextInt();
            System.out.println((isPrime(number))? "Prime" : "Not prime" );
        }
    }

    static boolean isPrime(int number){
        if(number == 1)
            return false;
        for (double i = 2; i <= Math.sqrt((double) number); i++) {
            if((double) number % i == 0){
                // System.out.println(i);
                return false;
            }
        }
        return true;
    }
}

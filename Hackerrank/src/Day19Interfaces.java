import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day19Interfaces {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        AdvCalculator c = new AdvCalculator();
        int sum = c.divisorSum(i);
        System.out.println("I implemented: " + c.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }
}

interface AdvancedArithmetic{
    int divisorSum(int n);
}

class AdvCalculator implements AdvancedArithmetic{
    @Override
    public int divisorSum(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if(n % i == 0)
                result.add(i);
        }
        int sum = 0;
        for(int i : result){
            sum += i;
        }
        return sum;
    }
}

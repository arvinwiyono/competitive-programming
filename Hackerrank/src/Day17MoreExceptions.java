import java.util.Scanner;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day17MoreExceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Calculator c = new Calculator();
        while (t-- > 0) {
            int n, p;
            n = sc.nextInt();
            p = sc.nextInt();
            try {
                int ans = c.power(n, p);
                System.out.println(ans);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Calculator {

    int power(int n, int p) throws Exception {
        if (n >= 0 && p >= 0) {
            return (int) Math.pow(n, p);
        } else {
            throw new Exception("n and p should be non-negative");
        }
    }
}
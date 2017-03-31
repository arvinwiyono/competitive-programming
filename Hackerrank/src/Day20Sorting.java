import java.util.Scanner;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day20Sorting {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int sum = bubbleSort(a);
        System.out.println("Array is sorted in " + sum + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);
    }

    static int bubbleSort(int [] a){
        int totalSwap = 0;
        for (int i = 0; i < a.length; i++) {
            int tempSwap = 0;
            for (int j = 0; j < a.length-1; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    tempSwap++;
                }
            }
            totalSwap += tempSwap;
            if(tempSwap == 0)
                break;
        }
        return totalSwap;
    }
}

import java.util.Scanner;
import datastructure.LinkedList;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day15LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }
        list.display();
    }
}

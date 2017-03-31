import datastructure.LinkedList;

import java.util.Scanner;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day24MoreLinkedLists {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        while(n-- > 0){
            list.insert(sc.nextInt());
        }
        list.display();
        list.removeDuplicates();
        System.out.println("After removing duplicates:");
        list.display();
    }
}

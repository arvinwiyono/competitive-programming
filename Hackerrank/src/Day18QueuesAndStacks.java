import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day18QueuesAndStacks {
    Queue<Character> q = new LinkedList<Character>();
    Stack<Character> s = new Stack<Character>();

    void pushCharacter(Character c){
        s.push(c);
    }

    void enqueueCharacter(Character c){
        q.offer(c);
    }

    Character popCharacter(){
        return s.pop();
    }

    Character dequeueCharacter(){
        return q.poll();
    }


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char [] chars = s.toCharArray();
        Day18QueuesAndStacks solution = new Day18QueuesAndStacks();

        for(char c : chars){
            solution.enqueueCharacter(c);
            solution.pushCharacter(c);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < (chars.length/2); i++) {
            char c1 = solution.dequeueCharacter();
            char c2 = solution.popCharacter();
            if(c1 != c2){
                isPalindrome = false;
                break;
            }
        }

        System.out.println("The word, " + s + ", is " +  (isPalindrome ? "a palindrome." : "not a palindrome."));
    }
}

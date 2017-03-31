import java.util.Scanner;

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

    static class LinkedList<T> {
        Node<T> head;

        public LinkedList() {
            head = null;
        }

        void insert(T value) {
            // update head reference
            head = insert(head, value);
        }

        Node insert(Node head, T value) {
            Node current = head;
            if (current == null) {
                current = new Node(value);
            } else {
                current.next = insert(current.next, value);
            }
            return current;
        }

        void display() {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

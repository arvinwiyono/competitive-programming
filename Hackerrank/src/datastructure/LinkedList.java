package datastructure;

public class LinkedList<T> {
    public Node<T> head;

    public LinkedList() {
        head = null;
    }

    public void insert(T value) {
        // update head reference
        head = insert(head, value);
    }

    public void removeDuplicates(){
        head = removeduplicates(head);
    }

    private Node removeduplicates(Node head){
        Node current = head;
        Node nextnext;
        if(current == null)
            return current;

        while(current.next != null){
            if(current.data == current.next.data){
                nextnext = current.next.next;
                current.next = nextnext;
            }else{
                current = current.next;
            }
        }
        return head;
    }

    private Node insert(Node head, T value) {
        Node current = head;
        if (current == null) {
            current = new Node(value);
        } else {
            current.next = insert(current.next, value);
        }
        return current;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
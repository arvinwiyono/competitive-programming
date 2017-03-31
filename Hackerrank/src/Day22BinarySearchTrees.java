import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day22BinarySearchTrees {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node treeRoot = null;
        BinarySearchTree binTree = new BinarySearchTree();

        while(n-- > 0){
            treeRoot = binTree.insert(treeRoot, sc.nextInt());
        }

        binTree.printInorder(treeRoot);
        System.out.println(binTree.getHeight(treeRoot));
        System.out.println("Level Order:");
        binTree.levelOrder(treeRoot);
        System.out.println("");
        System.out.println("Stack Order:");
        binTree.stackOrder(treeRoot);
    }
}

class BinarySearchTree{
    Node insert(Node root, int value){
        Node current = root;
        if(current == null){
            current = new Node(value);
        }else{
            if(value <= current.data){
                current.left = insert(current.left, value);
            }else{
                current.right = insert(current.right, value);
            }
        }
        return current;
    }

    void printInorder(Node root){
        if(root != null){
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    void levelOrder(Node root){
        Queue<Node> q = new LinkedList<Node>();
        String out = "";
        if(root != null){
            q.offer(root);
            while(!q.isEmpty()){
                Node current = q.poll();
                out += current.data + " ";
                if(current.left!= null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }
        System.out.println(out.trim());
    }

    void stackOrder(Node root){
        Stack<Node> s = new Stack<Node>();
        String out = "";
        if(root != null){
            s.push(root);
            while(!s.isEmpty()){
                Node current = s.pop();
                out += current.data + " ";
                if(current.left!= null){
                    s.push(current.left);
                }
                if(current.right != null){
                    s.push(current.right);
                }
            }
        }
        System.out.println(out.trim());
    }

    int getHeight(Node root){
        Node current = root;
        if(current == null){
            return -1;
        }else{
            return 1 + Math.max(getHeight(current.left), getHeight(current.right));
        }
    }
}

class Node{
    public Node left, right;
    public int data;

    public Node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}
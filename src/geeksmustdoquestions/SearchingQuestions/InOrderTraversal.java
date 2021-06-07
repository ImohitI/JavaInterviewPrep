package geeksmustdoquestions.SearchingQuestions;

import java.util.ArrayList;

public class InOrderTraversal {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node (3);
        head.right = new Node(2);
        inOrder(head);
    }
    static ArrayList<Integer> inOrder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }
    static void inOrderTraversal(Node root , ArrayList<Integer> list){
        if (root == null)
            return;

        inOrderTraversal(root.left , list);
        list.add(root.data);
        inOrderTraversal(root.right , list);
    }
}
class Node {
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }
}
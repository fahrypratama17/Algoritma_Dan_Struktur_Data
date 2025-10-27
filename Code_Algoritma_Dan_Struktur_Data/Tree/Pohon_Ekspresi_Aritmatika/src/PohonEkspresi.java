import java.util.Scanner;

public class PohonEkspresi {
     static class Node {
         String value;
         Node left, right;

         Node(String value) {
             this.value = value;
         }
     }

     static class Stack {
         Node[] arr = new Node[100];
         int top = -1;

         void push(Node n) {
             arr[++top] = n;
         }

         Node pop() {
             return arr[top--];
         }

         Node peek() {
             return arr[top];
         }
     }

     static Node buildTree(String[] postfix){
         Stack s = new Stack();

         for (int i = 0; i < postfix.length; i++){
             String token = postfix[i];

             Node node = new Node(token);
             if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
                 s.push(node);
             } else {
                 node.right = s.pop();
                 node.left = s.pop();
                 s.push(node);
             }
         }
         return s.peek();
     }

     static int eval(Node root){
        if (root.left == null && root.right == null){
            return Integer.parseInt(root.value);
        }
        int left = eval(root.left);
        int right = eval(root.right);

        if (root.value.equals("+")) return left + right;
        if (root.value.equals("-")) return left - right;
        if (root.value.equals("*")) return left * right;
        if (root.value.equals("/")) return left / right;

        return 0;
     }

    public static void main(String[] args) {
        String[] postfix = {"3", "4", "+", "2", "*", "7", "/"};
        Node root = buildTree(postfix);
        System.out.println("Hasil: " + eval(root));
    }
}
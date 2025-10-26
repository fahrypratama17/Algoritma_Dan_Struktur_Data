import java.util.Random;

class Node{
    int data;
    Node nodeKiri;
    Node nodeKanan;

    public Node(int dt){
        data = dt;
        nodeKiri = nodeKanan = null;
    }

    public void sisipDt(int dtSisip ){
        if (dtSisip < data){
            if (nodeKiri == null)
                nodeKiri = new Node( dtSisip );
            else nodeKiri.sisipDt( dtSisip );
        }
        else if(dtSisip > data){
            if (nodeKanan == null )
                nodeKanan = new Node(dtSisip);
            else nodeKanan.sisipDt(dtSisip);
        }
    }
}

public class Tree{
    private Node root;

    public Tree() {
        root = null;
    }

    public void sisipDtNode(int dtSisip){
        if (root == null)
            root = new Node(dtSisip);
        else
            root.sisipDt(dtSisip);
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(Node node){
        if(node == null) return;

        System.out.printf("%d ", node.data );
        preorder(node.nodeKiri);
        preorder(node.nodeKanan);
    }

    public void inorderTraversal(){
        inorder(root);
    }

    private void inorder(Node node){
        if (node == null) return;
        inorder(node.nodeKiri);
        System.out.printf("%d ", node.data );
        inorder( node.nodeKanan );
    }

    public void postorderTraversal(){
        postorder( root );
    }

    private void postorder(Node node){
        if (node == null) return;
        postorder(node.nodeKiri);
        postorder(node.nodeKanan);
        System.out.printf("%d ", node.data );
    }

    public int hitungNode() {
        return hitungNodeRekursif(root);
    }

    private int hitungNodeRekursif(Node node) {
        if (node == null)
            return 0;
        return 1 + hitungNodeRekursif(node.nodeKiri) + hitungNodeRekursif(node.nodeKanan);
    }

    public int hitungDaun() {
        return hitungDaunRekursif(root);
    }

    private int hitungDaunRekursif(Node node) {
        if (node == null)
            return 0;
        if (node.nodeKiri == null && node.nodeKanan == null)
            return 1;
        return hitungDaunRekursif(node.nodeKiri) + hitungDaunRekursif(node.nodeKanan);
    }

    public int hitungTinggi() {
        return hitungTinggiRekursif(root);
    }

    private int hitungTinggiRekursif(Node node) {
        if (node == null)
            return 0;
        int tinggiKiri = hitungTinggiRekursif(node.nodeKiri);
        int tinggiKanan = hitungTinggiRekursif(node.nodeKanan);
        return Math.max(tinggiKiri, tinggiKanan) + 1;
    }

    public int hitungLevel() {
        return hitungTinggi() - 1;
    }

    public static void main(String[] args) {
        Tree Tree = new Tree();
        int nilai;
        Random randomNumber = new Random();
        System.out.println("sisip nilai data berikut : ");

        // sisip Dt 10 bilangan acak dari 0-99 ke dalam tree
        for ( int i = 1; i <= 10; i++ ) {
            nilai = randomNumber.nextInt(100);
            System.out.print(nilai + " " );
            Tree.sisipDtNode(nilai);
        }

        System.out.println ("\n\nPreorder traversal");
        Tree.preorderTraversal();
        System.out.println ("\n\nInorder traversal");
        Tree.inorderTraversal();
        System.out.println ("\n\nPostorder traversal");
        Tree.postorderTraversal();
        System.out.println("\n\nJumlah node: " + Tree.hitungNode());
        System.out.println("\nJumlah daun: " + Tree.hitungDaun());
        System.out.println("\nTinggi pohon: " + Tree.hitungTinggi());
        System.out.println("\nJumlah level: " + Tree.hitungLevel());
    }
}
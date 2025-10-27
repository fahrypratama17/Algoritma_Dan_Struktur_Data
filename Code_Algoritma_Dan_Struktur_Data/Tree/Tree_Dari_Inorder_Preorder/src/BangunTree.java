public class BangunTree {
    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    static int preIndex = 0;

    static Node build(char[] inoder, char[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(preorder[preIndex++]);
        if (start == end) return node;

        int inIndex = -1;

        for (int i = start; i <= end; i++) {
            if (inoder[i] == node.data) {
                inIndex = i;
                break;
            }
        }

        node.left = build(inoder, preorder, start, inIndex - 1);
        node.right = build(inoder, preorder, inIndex + 1, end);
        return node;
    }

    static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};
        Node root = build(inorder, preorder, 0, inorder.length - 1);
        System.out.print("Postorder: ");
        postOrder(root);
    }
}
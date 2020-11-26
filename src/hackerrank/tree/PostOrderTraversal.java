package hackerrank.tree;

public class PostOrderTraversal {

    public static void main(String args[]){
        Node root = new Node(1);
        insert(root, 2);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 4);
        postOrder(root);  // 4 3 6 5 2 1
    }

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    static Node insert(Node root, int data){
        if(root == null){
            return new  Node(data);
        }else{
            Node cur;
            // insert to the right
            if(data > root.data){
                cur = insert(root.right, data);
                root.right = cur;
            }
            // insert to the left
            else {
                cur = insert(root.left, data);
                root.left = cur;
            }
        }
        return root;
    }

    private static void postOrder(Node root) {
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

}

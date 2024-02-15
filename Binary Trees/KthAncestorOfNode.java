public class KthAncestorOfNode {

    static class Node{
        int data;
        Node right;
        Node left;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{

        public int KthAncestorOfNode(Node root, int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int l = KthAncestorOfNode(root.left, n, k);
            int r = KthAncestorOfNode(root.right, n, k);

            if(l == -1 && r == -1){
                return -1;
            }

            int max = Math.max(l, r);
            if(max + 1 == k){
                System.out.print(root.data);
            }
            return max + 1;
        }
    }
    public static void main(String[] args) {
         /*               1

         *            /      \
         *           3        2
         * 
         *         /   \    /   \
         *        7     6  5     4 
         */
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        tree.KthAncestorOfNode(root, 7, 1);
    }
}
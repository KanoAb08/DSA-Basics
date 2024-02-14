public class KthLevelOfBinaryTree {
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

    public static class BinaryTree{
        public void KthLevel(Node root,int level,int k){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data + " ");
            }
            KthLevel(root.left, level + 1, k);
            KthLevel(root.right, level + 1, k);
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
        tree.KthLevel(root,1, 2);
    }
}

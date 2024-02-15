public class TransformToSumTree {
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

        public int TransformToSumTree(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = TransformToSumTree(root.left);
            int rightSum = TransformToSumTree(root.right);

            int data = root.data;
            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;
            root.data = leftSum + rightSum + newLeft + newRight;
            
            return data;
        }

        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
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
        System.out.println(tree.TransformToSumTree(root));
       tree.preOrder(root);
    }
}

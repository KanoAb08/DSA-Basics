
public class MinimumDistanceBetweenTwoNodes {

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

        public Node lca(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }

            Node leftLca = lca(root.left, n1, n2);
            Node rightLca = lca(root.right, n1, n2);

            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }

            return root;
        }

        public int lcaDistance(Node root, int n){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int l = lcaDistance(root.left, n);
            int r = lcaDistance(root.right, n);

            if(l == -1 && r ==-1){
                return -1;
            }else if(l == -1){
                return r + 1;
            }else{
                return l + 1;
            }
        }

        public int MinimumDistanceBetweenTwoNodes(Node root, int n1, int n2){
            Node lca = lca(root, n1, n2);

            int dist1 = lcaDistance(lca, n1); 
            int dist2 = lcaDistance(lca, n2); 

            return dist1 + dist2;

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
        System.out.println(tree.MinimumDistanceBetweenTwoNodes(root, 7, 4));
    }
}

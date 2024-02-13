
public class DiameterOfTree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    public static class BinaryTree{

        public int treeHeight(Node root){
            if(root == null){
                return 0;
            }
            int lh = treeHeight(root.left);
            int rh = treeHeight(root.right);
            return Math.max(lh, rh) + 1;
        }
        //----> Approach 1 to find Diameter of a tree
        //----> Time Complexity = O(n^2)
        public int treeDiameter(Node root){

            if(root == null){
                return 0;
            }

            int leftDiameter = treeDiameter(root.left); 
            int rightDiameter = treeDiameter(root.right); 
            int leftHeight = treeHeight(root.left); 
            int rightHeight = treeHeight(root.right); 
            int selfDiameter = leftHeight + rightHeight + 1;

            return Math.max(Math.max(rightDiameter, leftDiameter), selfDiameter);
        }


        static class Info{
            int diameter;
            int height;
            public Info(int d,int h){
                this.diameter = d;
                this.height = h;
            }
        }
        //----> Approach 1 to find Diameter of a tree
        //----> Time Complexity = O(n)
        public Info treeDiameter2(Node root){

            if(root == null){
                Info info = new Info(0, 0);
                return info;
            }

            Info left = treeDiameter2(root.left);
            Info right = treeDiameter2(root.right);
            int d = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);
            int h = Math.max(left.height, right.height) + 1;
            Info self = new Info(d, h);

            return self;

        }
    }

    
    public static void main(String[] args) {
        
        /*                1

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
        
        System.out.println("Diameter of Tree is : " + tree.treeDiameter2(root).diameter);
        System.out.println("Height of Tree is : " + tree.treeDiameter2(root).height);
    }
}

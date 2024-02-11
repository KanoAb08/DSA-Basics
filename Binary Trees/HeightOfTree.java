public class HeightOfTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        public Node buildTree(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public int treeHeight(Node root){
            
            if(root == null){
                return 0;
            }
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;

        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        /*           1
         *         /   \
         *        2     3
         *       / \   / \ 
         *      4   5 6   7
         */
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        System.out.println("Height Of Tree in terms of Nodes : " + tree.treeHeight(root));
        System.out.println("Height Of Tree in terms of Edges : " + (tree.treeHeight(root)-1));
    }
}

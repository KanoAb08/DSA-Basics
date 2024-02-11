public class SumOfNodesInTree {
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

        public int nodesSum(Node root){
            
            if(root == null){
                return 0;
            }
            int leftCount = nodesSum(root.left);
            int rightCount = nodesSum(root.right);
            return leftCount + rightCount + root.data;

        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,7,-1,-1};
        /*           1
         *         /   \
         *        2     3
         *       / \     \ 
         *      4   5     7
         */
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        System.out.println("Sum Of Nodes : " + tree.nodesSum(root));
    }
}

public class CountOfNodesInTree{
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

        public int nodesCount(Node root){
            
            if(root == null){
                return 0;
            }
            int leftCount = nodesCount(root.left);
            int rightCount = nodesCount(root.right);
            return leftCount + rightCount + 1;

        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        /*           1
         *         /   \
         *        2     3
         *       / \ 
         *      4   5
         */
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        System.out.println("Count Of Nodes : " + tree.nodesCount(root));
    }
}
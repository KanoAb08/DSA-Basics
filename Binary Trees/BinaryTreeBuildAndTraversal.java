public class BinaryTreeBuildAndTraversal {
    
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

        static int index = -1;

        //----> Building Preorder Tree
        //----> Time Complexity: O(n) 
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

        //----> Doing Preorder Traversal and printing it
        //----> Time Complexity: O(n) 
        public void preorderTraversal(Node root){

            if(root == null){
                return;
            }

            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        tree.preorderTraversal(root);
        
    }

}

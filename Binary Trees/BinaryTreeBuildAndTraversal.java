import java.util.LinkedList;
import java.util.Queue;

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

        //----> Doing Inorder Traversal and printing it
        //----> Time Complexity: O(n) 
        public void inorderTraversal(Node root){

            if(root == null){
                return;
            }

            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

        //----> Doing Postorder Traversal and printing it
        //----> Time Complexity: O(n) 
        public void postorderTraversal(Node root){

            if(root == null){
                return;
            }

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        //----> Doing Levelorder Traversal and printing it
        //----> Time Complexity: O(n)
        public void levelorderTraversal(Node root){

            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(currNode);
                    }
                }else{
                    System.out.print(currNode.data);
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
            
        }

    }
    public static void main(String[] args) {

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root of tree : " + root.data);
        System.out.println();

        System.out.print("Preorder Traversal : " );
        tree.preorderTraversal(root);
        
        System.out.println();
        System.out.println();
        
        System.out.print("Inorder Traversal : ");
        tree.inorderTraversal(root);
        
        System.out.println();
        System.out.println();
        
        System.out.print("Postorder Traversal : ");
        tree.postorderTraversal(root);

        System.out.println();
        System.out.println();
        System.out.println("Level Order Traversal : ");
        tree.levelorderTraversal(root);
    }

}

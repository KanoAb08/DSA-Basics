import java.util.*;
public class LowestCommonAncestor {
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

        public boolean getPath(Node root,int n1, ArrayList<Node> path){
            if(root == null){
                return false;
            }

            path.add(root);

            if(root.data == n1){
                return true;
            }
            
            boolean foundLeft = getPath(root.left, n1, path);
            boolean foundRight = getPath(root.right, n1, path);

            if(!(foundLeft || foundRight)){
                path.remove(path.size() - 1);
            }
            return foundLeft || foundRight;
        }

        public Node lca(Node root,int n1,int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i = 0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            return path1.get(i-1);
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
        System.out.println(tree.lca(root,6, 4).data);
        
    }
}

import java.util.*;

public class TopViewOfTree {
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

        public class Info{
            Node node;
            int horizontalDistance;
            public Info(Node node,int horizontalDistance){
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }

       public void isTopView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.horizontalDistance)){
                    map.put(curr.horizontalDistance, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.horizontalDistance - 1));
                    min = Math.min(min,curr.horizontalDistance - 1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.horizontalDistance + 1));
                    max = Math.max(max,curr.horizontalDistance + 1);
                }
            }
        }
        System.out.print("Top View of Tree is : ");
        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }

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

        tree.isTopView(root);
    }
}

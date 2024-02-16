public class SearchInBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }
        if(root.data < val){
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        } 
        return search(root.right, key);
    }
    
    public static void main(String[] args) {
        int[] values = {7,4,5,2,1,3,6,9,8,10};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = insert(root,values[i]);
        }

        if(search(root, 11)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
        
    }
}

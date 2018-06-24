//Idea is mainly about detatching nodes right node and make it left child's left and left child's right should be parent node
public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode prevRight = null;
        
        while(curr != null){
            next = curr.left;
            curr.left = prevRight;
            prevRight = curr.right;
            curr.right = prev;            

            prev = curr;
            curr = next;        
        }
        
        return prev;
        
    }
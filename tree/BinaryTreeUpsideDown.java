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

//Idea is again to rotate the tree right side and make sure right child becomes left of left child and root becomes right child
public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode nRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return nRoot;
    }    
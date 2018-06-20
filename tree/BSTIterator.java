//Idea here is to create a inorder traversal stack and when next is called, 
//return top element and keep right children in stack
//Time complexity : O(h) Space complexity O(h)
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if(root != null){
            TreeNode p = root;
            while(p != null){
                stack.push(p);
                p = p.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode curr = stack.pop();
        int val = curr.val;
        TreeNode p = curr.right;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        return val;
    }
}
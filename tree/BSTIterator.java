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


//If time complexity of next and hasNext should be O(1), then we need to precompute the inorder like below
//but we are defying the concept of iterator itself
public class BSTIterator {
    Queue<Integer> q1;

    public BSTIterator(TreeNode root) {
        q1 = new LinkedList<>();
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q1.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return q1.poll();
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        q1.add(root.val);
        inorder(root.right);
    }
}


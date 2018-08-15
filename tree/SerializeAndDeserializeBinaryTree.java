//here we are trying to create a serialized string using "(" and ")"
//    1
//   / \
//  2   3
//     / \
//    4   5
//for a tree like this, we will serialize as 1(2(null)(null))(3(4(null)(null))(5)(null)(null))

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) sb.append("null");
        else {
            sb.append(root.val).append("(").append(serialize(root.left)).append(")").append("(").append(serialize(root.right)).append(")");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        return util(data, 0, data.length()-1);
    }
    
    private TreeNode util(String data, int start, int end){
        int i = start;
        while(i <= end && data.charAt(i) != '(') i++;
        String val = data.substring(start, i);
        if(val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        int j = i+1, count = 1;
        while(j <= end && count != 0){
            if(data.charAt(j) == '(') count++;
            else if(data.charAt(j) == ')') count--;
            j++;
        }
        root.left = util(data, i+1, j-2);
        root.right = util(data, j+1, end-1);
        return root;
    }
}

//This is similar approach where we do DFS to construct the serialized string of the tree in a preorder fashion
//and use the dequeue method to construct the tree from the string
//time compelxity: O(n) for both serialize and deserialization
public class Codec {

    public String serialize(TreeNode root){
        return serializeUtil(root);
    }

    private String serializeUtil(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null) sb.append("X").append(",");
        else {
            sb.append(root.val).append(",").append(serializeUtil(root.left)).append(serializeUtil(root.right));
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        String[] arr = data.split(",");
        Deque<String> deque = new LinkedList<>();
        for(String curr: arr){
            deque.add(curr);
        }

        return deserializeUtil(deque);
    }

    private TreeNode deserializeUtil(Deque<String> deque){
        String val = deque.poll();
        if(val.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeUtil(deque);
        root.right = deserializeUtil(deque);
        return root;
    }
}


//Lets write the iterative version of the above solution
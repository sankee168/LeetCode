//Have two queues and keep swapping when you see q1 is empty
public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new ArrayList<>();
    if(root == null) return list;
    Queue<Node> q1 = new LinkedList<>();
    Queue<Node> q2 = new LinkedList<>();
    List<Integer> level = new ArrayList<>();
    q1.add(root);
    while(!q1.isEmpty()){
        Node curr = q1.poll();
        level.add(curr.val);
        List<Node> children = curr.children;
        for(Node child: children) {
            if(child != null) q2.add(child);
        }
        if(q1.isEmpty()){
            list.add(level);
            level = new ArrayList<>();
            q1 = q2;
            q2 = new LinkedList<>();
        }
    }
    return list;
}
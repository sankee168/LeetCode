//We can use priority queue to sort the k element in the window
//every time there is a new element we have to add the existing and remove the previous
//Time complexity: O(n) + O(klogk)
//Space complexity: O(k)
public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int n = nums.length;
    int[] res = new int[n-k+1];
    if(k == 0 || nums.length == 0) return nums;
    for(int i = 0; i < k; i++){
        pq.offer(nums[i]);
    }
    res[0] = pq.peek();
    int i = 1;
    for(int j = k; j < n; j++){            
        pq.remove(nums[i-1]);
        pq.offer(nums[j]);
        res[i++] = pq.peek();
    }        
    return res;
}

//We can use a deque to do this in O(n)
//We keep checking the elements which are out of window and remove them
//Next step is to check from the last if any number is less than current one. if so delete them as they are not necessary
public int[] maxSlidingWindow(int[] nums, int k) {
    if(k == 0 || nums.length == 0) return nums;
    int n = nums.length;
    int[] res = new int[n-k+1];
    Deque<Integer> dq = new ArrayDeque<>();
    for(int i = 0; i < n; i++){

        while(!dq.isEmpty() && dq.peek() <= (i-k)){
            dq.poll();
        }

        while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
            dq.pollLast();
        }

        dq.offer(i);
        if(i >= k-1){
            res[i-k+1] = nums[dq.peek()];
        }
    }
    return res;
}


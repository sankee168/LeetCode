//Here we keep track of distance between two consequtive 1's by left and right pointer
//and we can place a person in the middle of those ones to maximize to distance
//and we need to handle corner cases
//Time complexity: O(n)
public int maxDistToClosest(int[] seats) {
        int left = -1, right = -1, maxDistance = Integer.MIN_VALUE, position = -1;
        int n = seats.length;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                left = right;
                right = i;
                int pos = (left+right)/2;
                int curDis = Math.min(right-pos, pos-left);
                if(left == -1){
                    curDis = right;
                }
                if(maxDistance < curDis){
                    maxDistance = curDis;
                }
            }
        }
        if(seats[n-1] != 1 && maxDistance < (n-1-right)){
            maxDistance = n-1-right;
        }
        
        return maxDistance;
    }
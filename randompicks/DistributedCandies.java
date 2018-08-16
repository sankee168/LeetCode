//To distibute candies we need to find the unique type of candies in the array
//and get min of n/2 and that
//time compelxity: O(n)
//space complexity: O(n)
public int distributeCandies(int[] candies) {
    int n = candies.length;
    Set<Integer> set = new HashSet<>();
    for(int candy: candies){
        set.add(candy);
    }        
    return Math.min(n/2, set.size());
}
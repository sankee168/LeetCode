//Here we check the number of odd frequency characters, if frequency is even, we can easily split them on either side
//if frequency is odd, then only one odd element can be picked else we have cut down the odd count
//Time complexity: O(n)
//Space compelxity: O(1)
public int longestPalindrome(String s) {
    int len = 0, oddCount = 0;
    int[] count = new int[256];
    for(int i = 0; i < s.length(); i++){
        count[s.charAt(i)]++;
    }        
    for(int curr: count){
        if(curr%2 == 0){
            len += curr;
        }else{
            if(oddCount != 1){
                len += curr;
                oddCount = 1;
            }else{
                len += curr-1;
            }
        }
    }
    return len;
}
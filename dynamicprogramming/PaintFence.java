//This requires bit of paper work and examples. 
//We need to count possibilities when adding ith fence. Divide the problem into two. when last two fences has same color and different color
//If last two fence has same color, only possibility is to pick different color
//If last two fences has different color, current fence can take same color or different color
//Time complexity: O(n)
//Space complexity: O(1)
public int numWays(int n, int k) {
	if(n == 0) return 0;
	if(n == 1) return k;
	int differentColors = k*(k-1);
	int sameColors = k;
	for(int i = 2; i < n; i++){
		int temp = differentColors;
		differentColors = (differentColors+sameColors)*(k-1);
		sameColors = temp;
	}
	return sameColors + differentColors;
}
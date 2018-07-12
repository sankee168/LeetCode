//Idea here is simple. How do we calculate the are between two lines. It is min(h1, h2)*width. 
//Have two pointers, one at start and other at end. there is a change that area is max when height of two lines are maximum. 
//So keep moving inwards from end in search of biggest line. 
//Time complexity: O(n)
//Space complexity: O(1)
public int maxArea(int[] height) {
	int l = 0;
	int r = height.length-1;
	int max = 0;
	while(l < r){
		max = Math.max(max, Math.min(height[l],height[r])*(r-l));
		if(height[l] < height[r]){
			l++;
		}else r--;
	}
	return max;
}
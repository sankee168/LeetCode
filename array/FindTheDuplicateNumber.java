//This is similar to finding intersection point of cycle in linked list. 
//Time complexity: O(n)
//Space complexity: O(1)
//have two pointers, where one goes fast and one goes slow. whenever they meet that determines the loop exists. 
//Now to find the start of the loop have pointer to previous index and one from start. 
public int findDuplicate(int[] nums) {
	int slow = 0;
	int fast = 0;
	do{
		slow = nums[slow];
		fast = nums[nums[fast]];
	}while(slow != fast);

	int p1 = 0;
	int p2 = slow;
	while(p1 != p2){
		p1 = nums[p1];
		p2 = nums[p2];
	}

	return p1;
}
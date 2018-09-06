//Given problem is we have to find the next largest element in nums2
//for this we need know at what index first number is in
//So we keep a map for that so that we can start right from that index
//Time complexity: O(mn)
//Space complexity: O(m+n) where m is the length of nums1 and n is the length of nusm2
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < nums2.length; i++){
		map.put(nums2[i], i);
	}

	int[] res = new int[nums1.length];
	for(int i = 0; i < nums1.length; i++){
		int k = map.get(nums1[i]);
		for(; k < nums2.length; k++){
			if(nums2[k] > nums1[i]){
				res[i] = nums2[k];
				break;
			}
		}
		if(k == nums2.length) res[i] = -1;

	}
	return res;
}

//Idea here is to use stack. iterate over nums2.
//whenever we see a greater number than stack elements, we keep that entry in the map
//Time complexity: O(m+n);
//Space complexity: O(m+n)
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	Map<Integer, Integer> map = new HashMap<>();
	Stack<Integer> stack = new Stack<>();
	for(int currNumber : nums2){
		while(!stack.isEmpty() && currNumber > stack.peek()){
			int smallerNumber = stack.pop();
			map.put(smallerNumber, currNumber);
		}
		stack.push(currNumber);
	}
	int[] res = new int[num1.length];
	for(int i = 0; i < nums1.length; i++){
		res[i] = map.getOrDefault(nums1[i], -1);
	}

	return res;
}
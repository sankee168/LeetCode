//Idea here is to write a custom comparator to check each digit by digit
//Time complexity: O(nlogn)
//Space complexity: O(n)
public String largestNumber(int[] nums) {
    String[] arr = new String[nums.length];
    for(int i = 0; i < nums.length; i++){
        arr[i] = Integer.toString(nums[i]);
    }
    Arrays.sort(arr, new NumberComparator());
	StringBuilder sb = new StringBuilder();
	
    if(arr[0].equals("0")) return "0";
    for(int i = 0; i < nums.length; i++){
        sb.append(arr[i]);
    }
	return sb.toString();
}

class NumberComparator implements Comparator<String> {
	public int compare(String a, String b){
		return (b+a).compareTo(a+b);
	}
}
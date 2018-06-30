//Time complexity: O(n)
//Space complexity: O(n) worst case to create the new return array
public int[] plusOne(int[] digits) {
	int carry = 0;
	for(int i = digits.length-1; i >=0; i--){
		int temp = digits[i] + carry;
		if(temp == 10){
			digits[i] = 0;
			carry = 1;
		}else{
			digits[i] = temp;
			carry = 0;
		}
	}

	if(carry == 1){
		int[] arr = new int[digits.length+1];
		arr[0] = 1;
		for(int i = 0; i < digits.length; i++){
			arr[i+1] = digits[i];
		}
		return arr;
	}

	return digits;

}
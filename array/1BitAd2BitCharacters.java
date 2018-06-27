//Time complexity: O(n)
//Space complexity: O(1)
public boolean isOneBitCharacter(int[] bits) {
	boolean ans = false;
	for(int i = 0; i< bits.length; i++){
		if(bits[i] ==1){
			i++; ans = false;
		}else{
			ans = true;
		}
	}
	return ans;
}
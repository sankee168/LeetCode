//Space complexity : O(1)
//Time complexity : O(n)
public boolean canPlaceFlowers(int[] flowerbed, int n) {
	if(n == 0) return true;
	for(int i = 0; i < flowerbed.length; i++){
		int temp = flowerbed[i];
		if(i != 0){
			temp |= flowerbed[i-1];
		}
		if(i != flowerbed.length-1){
			temp |= flowerbed[i+1];
		}

		if(temp != 1){
			flowerbed[i] = 1;
			n--;
			if(n == 0) return true;
		}
	}
	return false;
}